package br.ufc.mdcc.pargo.safe.framework;

import br.ufc.mdcc.pargo.safe.exception.HPCStormException;
import br.ufc.mdcc.pargo.safe.grammar.SAFeSWLArchParser;
import br.ufc.mdcc.pargo.safe.grammar.SAFeSWLFlowParser;
import br.ufc.mdcc.pargo.safe.grammar.SAFeSWLValidator;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchAction;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchComponent;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchMain;
import br.ufc.mdcc.pargo.safe.grammar.flow.SAFeOrchestrationWorkflow;
import br.ufc.mdcc.pargo.safe.util.SAFeConsoleLogger;

public class HPCStormWorkflowEngine {
	
	private HPCStormSAFeSWL safeSWL;
	private SAFeSWLArchParser archParser;
	private SAFeSWLFlowParser flowParser;
	private SAFeSWLValidator safeSWLValidator;
	
	
	private ArchMain archMain;
	private SAFeOrchestrationWorkflow flowMain; 
	
	public HPCStormWorkflowEngine() {
		
		this.safeSWLValidator = new SAFeSWLValidator();
		SAFeConsoleLogger.write("Validator created.");
		this.flowParser = new SAFeSWLFlowParser();
		SAFeConsoleLogger.write("Flow Parser created.");
		this.archParser = new SAFeSWLArchParser();
		SAFeConsoleLogger.write("Arch Parser created.");
		
	}
	
	public void setSafeSWL(HPCStormSAFeSWL safeSWL){
		this.safeSWL = safeSWL;
		SAFeConsoleLogger.write("SAFeSWL receveid on Engine.");
		
	}
	
	public ArchMain getArchMain() {
		return archMain;
	}

	public void setFlowMain(SAFeOrchestrationWorkflow flowMain) {
		this.flowMain = flowMain;
	}

	/**
	 * The magic begins here...
	 * @throws HPCStormException
	 */
	public void run() throws HPCStormException{
		
		if(this.safeSWL!=null){
			
			//check arch code
			boolean archResult = this.safeSWLValidator.validateXMLArchitecture(safeSWL.getArchFileName());
			if(!archResult) throw new HPCStormException("EXCEPTION: INVALID ARCHITECTURE FILE");
			//check flow code
			boolean flowResult =  this.safeSWLValidator.validateXMLOrchestration(safeSWL.getFlowFileName());
			if(!flowResult) throw new HPCStormException("EXCEPTION: INVALID ORQUESTRATION FILE");
			SAFeConsoleLogger.write("SAFESWL Validated!");
			
			//generating architecture object..
			SAFeConsoleLogger.write("Running Architecture");
			this.archParser.readArchXML(safeSWL.getArchFileName());
			this.archMain = this.archParser.getArchitectureMain();
			System.out.println(this.archMain);
			
			SAFeConsoleLogger.write("Running Orquestration");
			this.flowParser.readFlowXML(safeSWL.getFlowFileName());
			this.flowMain = this.flowParser.getSafeOrchestrationWorkflow();
			System.out.println(this.flowMain);
			this.flowMain.run();
			
		}
		
	}
	
	public ArchComponent getArchComponentByID(Integer id){
		return this.archMain.getArchComponentByID(id);
	}
	
	public ArchAction getArchActionId(Integer id){
		return this.archMain.getArchActionBy(id);
	}
	
}


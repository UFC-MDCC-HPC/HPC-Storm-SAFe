package br.ufc.mdcc.pargo.safe.workflow;

import br.ufc.mdcc.pargo.safe.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.grammar.ISAFeSWLArcherParser;
import br.ufc.mdcc.pargo.safe.grammar.ISAFeSWLFlowParser;
import br.ufc.mdcc.pargo.safe.grammar.SAFeSWLArchParser;
import br.ufc.mdcc.pargo.safe.grammar.SAFeSWLFlowParser;
import br.ufc.mdcc.pargo.safe.grammar.test.ArchitectureLanguageTest;
import br.ufc.mdcc.pargo.safe.port.HShelfPort;
import br.ufc.mdcc.pargo.safe.port.dflt.HShelfGoWorkflowPortImpl;
import br.ufc.mdcc.pargo.safe.port.dflt.HShelfSAFeSWLPort;
import br.ufc.mdcc.pargo.safe.port.dflt.HShelfSAFeSWLPortImpl;
import br.ufc.mdcc.pargo.safe.services.IHShelfService;
import br.ufc.mdcc.pargo.safe.util.HShelfConsoleLogger;

public class HShelfWorkflow extends HShelfComponent {

	private HShelfPort safeSWL;
	private HShelfPort safeGo;
	
	public HShelfWorkflow(String name) {
		HShelfConsoleLogger.write("Creating HShelfWorkflow");
		this.setName(name);
	}

	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
	}
	
	public void initialize(){
		try {
			safeSWL = new HShelfSAFeSWLPortImpl();
			safeSWL.setName("safeswl-port");
			services.addProvidesPort(safeSWL);
			
			safeGo = new HShelfGoWorkflowPortImpl();
			((HShelfGoWorkflowPortImpl)safeGo).workflow = this;
			safeGo.setName("go-workflow");
			services.addProvidesPort(safeGo);
			
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
	public void run(){
		System.out.println();
		System.out.println();
		
		ISAFeSWLArcherParser archParser = new SAFeSWLArchParser(((HShelfSAFeSWLPort)safeSWL).getSAFeSWLArchFilePath());
		ISAFeSWLFlowParser flowParser = new SAFeSWLFlowParser(((HShelfSAFeSWLPort)safeSWL).getSAFeSWLFlowFilePath());
		flowParser.setISAFeSWLArcherParser(archParser);
		flowParser.run();
	}

}

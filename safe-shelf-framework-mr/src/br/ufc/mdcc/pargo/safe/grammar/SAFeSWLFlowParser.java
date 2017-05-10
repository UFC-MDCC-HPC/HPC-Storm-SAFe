package br.ufc.mdcc.pargo.safe.grammar;

import br.ufc.mdcc.pargo.safe.grammar.flow.SAFeOrchestrationWorkflow;
import br.ufc.mdcc.pargo.safe.v6.impl.SAFeWorkflow;

/**
 * From this class, I create the SAFeOrchestrationWorkflow object via XML file.
 * @author jefferson
 *
 */
public class SAFeSWLFlowParser implements ISAFeSWLFlowParser{

	private SAFeOrchestrationWorkflow safeOrchestrationWorkflow;
	
	
	public SAFeSWLFlowParser(String fileName) {
		this.readFlowXML(fileName);
	}
	
	public void readFlowXML(String fileName){
		this.safeOrchestrationWorkflow = new SAFeOrchestrationWorkflow(fileName);	
	}

	@Override
	public SAFeOrchestrationWorkflow getWorkflow() {
		return safeOrchestrationWorkflow;
	}

	@Override
	public void setISAFeSWLArcherParser(ISAFeSWLArcherParser sAFeSWLArcherParser) {
		this.safeOrchestrationWorkflow.setISAFeSWLArcherParser(sAFeSWLArcherParser);
	}

	@Override
	public void run() {
		this.safeOrchestrationWorkflow.run();
	}

	@Override
	public void setWorkflow(SAFeWorkflow workflowFacade) {
		this.safeOrchestrationWorkflow.setWorkflow(workflowFacade);
		
	}
	
	
}

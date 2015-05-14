package br.ufc.mdcc.pargo.safe.grammar;

import br.ufc.mdcc.pargo.safe.grammar.flow.SAFeOrchestrationWorkflow;

/**
 * From this class, I create the SAFeOrchestrationWorkflow object via XML file.
 * @author jefferson
 *
 */
public class SAFeSWLFlowParser {

	private SAFeOrchestrationWorkflow safeOrchestrationWorkflow;
	
	public void readFlowXML(String fileName){
		this.safeOrchestrationWorkflow = new SAFeOrchestrationWorkflow(fileName);	
	}

	public SAFeOrchestrationWorkflow getSafeOrchestrationWorkflow() {
		return safeOrchestrationWorkflow;
	}
	
	
}

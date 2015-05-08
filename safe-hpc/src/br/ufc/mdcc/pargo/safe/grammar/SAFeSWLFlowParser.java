package br.ufc.mdcc.pargo.safe.grammar;

import br.ufc.mdcc.pargo.safe.grammar.flow.SAFeOrchestrationWorkflow;

/**
 * From this class, I create the SAFeOrchestrationWorkflow object via XML file.
 * @author jefferson
 *
 */
public class SAFeSWLFlowParser {

	private SAFeOrchestrationWorkflow safeOrchestrationWorkflow;
	private SAFeSWLValidator safeSWLValidator;
	
	public SAFeSWLFlowParser() {
		this.safeSWLValidator = new SAFeSWLValidator();
	}
	
	public SAFeSWLFlowParser(String fileName){
		this.safeSWLValidator = new SAFeSWLValidator();
		//validate XML with XSD before parsing.
		if(this.safeSWLValidator.validateXMLOrchestration(fileName)){
			//parsing, generates the SAFeOrchestrationWorkflow object.
			this.safeOrchestrationWorkflow = new SAFeOrchestrationWorkflow(fileName);
		}
	}

	public SAFeOrchestrationWorkflow getSafeOrchestrationWorkflow() {
		return safeOrchestrationWorkflow;
	}
	
	
}

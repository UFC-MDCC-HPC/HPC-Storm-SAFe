package br.ufc.mdcc.pargo.safe.test;

import br.ufc.mdcc.pargo.safe.grammar.SAFeSWLFlowParser;
import br.ufc.mdcc.pargo.safe.util.SAFeConstants;
 

public class WorkflowLanguageTest {
	
	public static void testParser(){
		
		
		String fileName = SAFeConstants.FLOW_FILE_TEST;
		
		SAFeSWLFlowParser parser = new SAFeSWLFlowParser();
		parser.readFlowXML(fileName);
		
		System.out.println(parser.getSafeOrchestrationWorkflow());
		
		parser.getSafeOrchestrationWorkflow().run();
		
	}

	public static void main(String[] args) {
		WorkflowLanguageTest.testParser();
		 
	}
}

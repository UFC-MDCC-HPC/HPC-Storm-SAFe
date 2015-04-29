package br.ufc.mdcc.pargo.safe.test;

import br.ufc.mdcc.pargo.safe.grammar.SAFeSWLFlowParser;
 

public class WorkflowLanguageTest {
	
	public static void testParser(){
		
		String fileName = "src/br/ufc/mdcc/pargo/safe/grammar/flow_01_example.xml";
		
		SAFeSWLFlowParser parser = new SAFeSWLFlowParser(fileName);
		
		System.out.println(parser.getSafeOrchestrationWorkflow());
		
		parser.getSafeOrchestrationWorkflow().run();
		
	}

	public static void main(String[] args) {
		WorkflowLanguageTest.testParser();
		 
	}
}

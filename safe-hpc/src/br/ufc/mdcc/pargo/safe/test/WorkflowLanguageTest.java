package br.ufc.mdcc.pargo.safe.test;

import br.ufc.mdcc.pargo.safe.grammar.flow.FlowMain;

public class WorkflowLanguageTest {
	
	public static void testParser(){
		
		String fileName = "src/br/ufc/mdcc/pargo/safe/grammar/flow_01_example.xml";
		FlowMain flowMain = new FlowMain();
		flowMain.parseWorkflow(fileName);
		//System.out.println(flowMain.getWorkflow());
		
	}

	public static void main(String[] args) {
		WorkflowLanguageTest.testParser();
	}
}
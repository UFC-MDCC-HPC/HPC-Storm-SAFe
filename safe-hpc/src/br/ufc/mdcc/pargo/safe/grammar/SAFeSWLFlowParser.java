package br.ufc.mdcc.pargo.safe.grammar;

import br.ufc.mdcc.pargo.safe.grammar.flow.FlowMain;

public class SAFeSWLFlowParser {

	private FlowMain flowMain;
	
	public SAFeSWLFlowParser(){
		this.flowMain = new FlowMain();
	}
	
	public void readFlowXML(String fileName){
		this.flowMain.parseWorkflow(fileName);
	}
}

package br.ufc.mdcc.pargo.safe.grammar.flow.visitor;

import br.ufc.mdcc.pargo.safe.grammar.flow.SAFeOrchestrationElement;

public class LogicInvokeOper implements ISAFeElementLogic{

	@Override
	public void logic(SAFeOrchestrationElement element) {
		for(SAFeOrchestrationElement child:element.getChildren())
			child.run();
		
	}
}

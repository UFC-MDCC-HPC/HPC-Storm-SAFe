package br.ufc.mdcc.pargo.safe.grammar.flow.visitor.logic;

import br.ufc.mdcc.pargo.safe.grammar.flow.SAFeOrchestrationElement;
import br.ufc.mdcc.pargo.safe.grammar.flow.visitor.ISAFeElementLogic;

public class LogicChoiceOper implements ISAFeElementLogic{

	@Override
	public void logic(SAFeOrchestrationElement element) {
		for(int i=element.getChildren().size()-1;i>=0;i--){
			SAFeOrchestrationElement child = element.getChildren().get(i);
			child.run();
		}
		
	}

}

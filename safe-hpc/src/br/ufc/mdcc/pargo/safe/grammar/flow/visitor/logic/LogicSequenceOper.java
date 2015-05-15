package br.ufc.mdcc.pargo.safe.grammar.flow.visitor.logic;

import br.ufc.mdcc.pargo.safe.grammar.flow.SAFeOrchestrationElement;
import br.ufc.mdcc.pargo.safe.grammar.flow.visitor.ISAFeElementLogic;
import br.ufc.mdcc.pargo.safe.util.SAFeConsoleLogger;

public class LogicSequenceOper implements ISAFeElementLogic{

	@Override
	public void logic(SAFeOrchestrationElement element) {
		SAFeConsoleLogger.write("STARTING SEQUENCE TASKS");
		for(int i=element.getChildren().size()-1;i>=0;i--){
			SAFeOrchestrationElement child = element.getChildren().get(i);
			child.run();
		}
		SAFeConsoleLogger.write("ENDED SEQUENCE TASKS");
		
	}

}

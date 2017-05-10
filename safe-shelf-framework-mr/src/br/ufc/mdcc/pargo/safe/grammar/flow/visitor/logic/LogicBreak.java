package br.ufc.mdcc.pargo.safe.grammar.flow.visitor.logic;

import br.ufc.mdcc.pargo.safe.framework.util.SAFeConsoleLogger;
import br.ufc.mdcc.pargo.safe.grammar.flow.SAFeOrchestrationElement;
import br.ufc.mdcc.pargo.safe.grammar.flow.SAFeOrchestrationOperation;
import br.ufc.mdcc.pargo.safe.grammar.flow.visitor.AbstractSAFeElementLogic;

public class LogicBreak extends AbstractSAFeElementLogic{

	@Override
	public void logic(SAFeOrchestrationElement element) {
		element.setLogicClass(this);
		SAFeConsoleLogger.write("STARTING BREAK TASKS");
		searchParent(element.getParent());
		SAFeConsoleLogger.write("ENDED BREAK TASKS");
		
	}
	
	private void searchParent(SAFeOrchestrationElement element){
		element.getLogicClass().setBreak(true);
		if(element.getOperation() == SAFeOrchestrationOperation.ITERATE){
			return;
		}
		searchParent(element.getParent());
	}

}

package br.ufc.mdcc.pargo.safe.grammar.flow.visitor.logic;

import br.ufc.mdcc.pargo.safe.grammar.flow.SAFeOrchestrationElement;
import br.ufc.mdcc.pargo.safe.grammar.flow.SAFeOrchestrationOperation;
import br.ufc.mdcc.pargo.safe.grammar.flow.visitor.AbstractSAFeElementLogic;
import br.ufc.mdcc.pargo.safe.grammar.util.SAFeConsoleLogger;

public class LogicSkip extends AbstractSAFeElementLogic{

	@Override
	public void logic(SAFeOrchestrationElement element) {
		element.setLogicClass(this);
		SAFeConsoleLogger.write("STARTING SKIP TASKS");
		//searchParent(element);
		SAFeConsoleLogger.write("ENDED SKIP TASKS");
		
	}

	private void searchParent(SAFeOrchestrationElement element){
		element.getLogicClass().setContinue(true);
		if(element.getOperation() == SAFeOrchestrationOperation.ITERATE){
			return;
		}
		searchParent(element.getParent());
	}
}

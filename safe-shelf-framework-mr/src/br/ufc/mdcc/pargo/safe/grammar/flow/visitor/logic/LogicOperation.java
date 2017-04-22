package br.ufc.mdcc.pargo.safe.grammar.flow.visitor.logic;

import br.ufc.mdcc.pargo.safe.grammar.flow.SAFeOrchestrationElement;
import br.ufc.mdcc.pargo.safe.grammar.flow.visitor.AbstractSAFeElementLogic;
import br.ufc.mdcc.pargo.safe.grammar.util.SAFeConsoleLogger;

public class LogicOperation extends AbstractSAFeElementLogic {

	@Override
	public void logic(SAFeOrchestrationElement element) {
		SAFeConsoleLogger.write("STARTING OPERATION TASKS");
		 
		SAFeConsoleLogger.write("ENDED OPERATION TASKS");
	}

}

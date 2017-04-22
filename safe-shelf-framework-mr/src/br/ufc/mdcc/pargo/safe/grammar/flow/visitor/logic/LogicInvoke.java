package br.ufc.mdcc.pargo.safe.grammar.flow.visitor.logic;

import br.ufc.mdcc.pargo.safe.grammar.flow.SAFeOrchestrationElement;
import br.ufc.mdcc.pargo.safe.grammar.flow.visitor.AbstractSAFeElementLogic;
import br.ufc.mdcc.pargo.safe.grammar.util.SAFeConsoleLogger;

/**
 * 
 * @author jefferson
 *
 */
public class LogicInvoke extends AbstractSAFeElementLogic {

	@Override
	public void logic(SAFeOrchestrationElement element) {

		SAFeConsoleLogger.write("STARTING INVOKE TASKS");
		 
		SAFeConsoleLogger.write("ENDED INVOKE TASKS");
	}
	
}

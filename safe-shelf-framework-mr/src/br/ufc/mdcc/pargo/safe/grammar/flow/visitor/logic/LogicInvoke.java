package br.ufc.mdcc.pargo.safe.grammar.flow.visitor.logic;

import br.ufc.mdcc.pargo.safe.grammar.flow.SAFeOrchestrationElement;
import br.ufc.mdcc.pargo.safe.grammar.flow.SAFeSWLOperationPrimitiveInvokeActionType;
import br.ufc.mdcc.pargo.safe.grammar.flow.visitor.AbstractSAFeElementLogic;
import br.ufc.mdcc.pargo.safe.grammar.util.SAFeConsoleLogger;

/**
 * 
 * @author jefferson
 *
 */
public class LogicInvoke extends AbstractSAFeElementLogic {

	String action;
	String idPort;
	@Override
	public void logic(SAFeOrchestrationElement element) {
		element.setLogicClass(this);
		SAFeConsoleLogger.write("STARTING INVOKE TASKS");
		
		if(element.getElement() instanceof SAFeSWLOperationPrimitiveInvokeActionType){
			SAFeSWLOperationPrimitiveInvokeActionType sopit = (SAFeSWLOperationPrimitiveInvokeActionType)element.getElement();
			action = sopit.getAction();
			idPort = sopit.getIdPort();
			//System.out.println("action: " + action + " id_port: "+idPort);
		}
		SAFeConsoleLogger.write("ENDED INVOKE TASKS");
	}
	
	
}

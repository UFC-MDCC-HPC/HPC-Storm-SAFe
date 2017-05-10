package br.ufc.mdcc.pargo.safe.grammar.flow.visitor.logic;

import br.ufc.mdcc.pargo.safe.grammar.flow.SAFeOrchestrationElement;
import br.ufc.mdcc.pargo.safe.grammar.flow.SAFeSWLOperationPrimitiveInvokeActionType;
import br.ufc.mdcc.pargo.safe.grammar.flow.visitor.AbstractSAFeElementLogic;
import br.ufc.mdcc.pargo.safe.framework.util.SAFeConsoleLogger;

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
			
			this.workflow.invoke(idPort,action);
			
		}
		SAFeConsoleLogger.write("ENDED INVOKE TASKS");
	}
	
	
}

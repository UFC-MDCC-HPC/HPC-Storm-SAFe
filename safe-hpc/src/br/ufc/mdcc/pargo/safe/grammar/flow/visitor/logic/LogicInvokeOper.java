package br.ufc.mdcc.pargo.safe.grammar.flow.visitor.logic;

import br.ufc.mdcc.pargo.safe.grammar.flow.SAFeOrchestrationElement;
import br.ufc.mdcc.pargo.safe.grammar.flow.XMLSAFeAction;
import br.ufc.mdcc.pargo.safe.grammar.flow.visitor.ISAFeElementLogic;

public class LogicInvokeOper implements ISAFeElementLogic{

	@Override
	public void logic(SAFeOrchestrationElement element) {
		
		XMLSAFeAction action  = (XMLSAFeAction)element.getElement();
		String  action_id = null;
		String action_oper = null;
		
		action_id = action.getId();
		action_oper = action.getAction().value();
		
		System.out.println("\taction_id: " + action_id);
		System.out.println("\taction_oper: " + action_oper);
	}
}

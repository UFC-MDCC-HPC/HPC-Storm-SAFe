package br.ufc.mdcc.pargo.safe.grammar.flow.visitor.logic;

import br.ufc.mdcc.pargo.safe.grammar.flow.SAFeOrchestrationElement;
import br.ufc.mdcc.pargo.safe.grammar.flow.XMLSAFeAction;
import br.ufc.mdcc.pargo.safe.grammar.flow.XMLSAFePrimOper;
import br.ufc.mdcc.pargo.safe.grammar.flow.visitor.ISAFeElementLogic;

public class LogicWaitOper implements ISAFeElementLogic{

	@Override
	public void logic(SAFeOrchestrationElement element) {
		String handle_id = null;
		String  action_id = null;
		String action_oper = null;
		
		if(element.getElement() instanceof XMLSAFePrimOper){
			XMLSAFePrimOper wait_oper = (XMLSAFePrimOper)element.getElement();
			handle_id = wait_oper.getHandleId();
		}
		
		
		for(int i=element.getChildren().size()-1;i>=0;i--){
			SAFeOrchestrationElement child = element.getChildren().get(i);
			if(child.getElement() instanceof XMLSAFeAction){
				XMLSAFeAction safe_action = (XMLSAFeAction)child.getElement();
				action_id = safe_action.getId();
				action_oper = safe_action.getAction().value();
			}
		}
			
		System.out.println("\thandle_id: " + handle_id);
		System.out.println("\taction_id: " + action_id);
		System.out.println("\taction_oper: " + action_oper);
		
	}
}


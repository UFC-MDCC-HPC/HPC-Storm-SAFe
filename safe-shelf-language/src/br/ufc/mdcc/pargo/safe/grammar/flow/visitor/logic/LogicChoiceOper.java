package br.ufc.mdcc.pargo.safe.grammar.flow.visitor.logic;

import br.ufc.mdcc.pargo.safe.grammar.flow.ChoiceOperComplexType;
import br.ufc.mdcc.pargo.safe.grammar.flow.ChoiceOperComplexType.Select;
import br.ufc.mdcc.pargo.safe.grammar.flow.SAFeOrchestrationElement;
import br.ufc.mdcc.pargo.safe.grammar.flow.visitor.AbstractSAFeElementLogic;

public class LogicChoiceOper extends AbstractSAFeElementLogic{

	@Override
	public void logic(SAFeOrchestrationElement element) {
		
		ChoiceOperComplexType choice_oper = (ChoiceOperComplexType)element.getElement();
		String chosen = choice_oper.getChosen();
		
		for(int i=element.getChildren().size()-1;i>=0;i--){
			SAFeOrchestrationElement select = element.getChildren().get(i);
			Select select_oper = (Select)select.getElement();
			String action_id = select_oper.getActionId();
			//navegar no select
			if(action_id.equalsIgnoreCase(chosen))
				for(SAFeOrchestrationElement child:select.getChildren()){
					child.run();
				}
		}
		
	}

}

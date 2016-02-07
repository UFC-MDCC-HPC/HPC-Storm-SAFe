package br.ufc.mdcc.pargo.safe.grammar.flow.visitor.logic;

import br.ufc.mdcc.pargo.safe.grammar.arch.ArchAction;
import br.ufc.mdcc.pargo.safe.grammar.flow.ChoiceOperComplexType.Select;
import br.ufc.mdcc.pargo.safe.grammar.flow.SAFeOrchestrationElement;
import br.ufc.mdcc.pargo.safe.grammar.flow.XMLSAFeAction;
import br.ufc.mdcc.pargo.safe.grammar.flow.visitor.AbstractSAFeElementLogic;
import br.ufc.mdcc.pargo.safe.grammar.util.SAFeConsoleLogger;

public class LogicChoiceOper extends AbstractSAFeElementLogic{

	@Override
	public void logic(SAFeOrchestrationElement element) {
		
		SAFeConsoleLogger.write("ENTER CHOICE");
		for(int i=element.getChildren().size()-1;i>=0;i--){
			SAFeOrchestrationElement select = element.getChildren().get(i);
			Select select_oper = (Select)select.getElement();
			//System.out.println(select_oper.getActionId());
			ArchAction archAction = this.sAFeSWLArcherParser
					.getArchActionId(Integer.parseInt(select_oper.getActionId()));
			SAFeConsoleLogger.write("invoking action: " + archAction.getName()
					+ "; from port: " + archAction.getParent().getName());
			if (this.workflowFacade != null) {
				Boolean  res = (Boolean)this.workflowFacade.compute(archAction.getName(), archAction
						.getParent().getName());
				System.out.println(":"+res);
				if(res.booleanValue()==true){
					for(int j=select.getChildren().size()-1;j>=0;j--){
						XMLSAFeAction action = (XMLSAFeAction)select.getChildren().get(j).getElement();
						//System.out.println("-->"+action.getId());
						ArchAction archActionChild = this.sAFeSWLArcherParser
								.getArchActionId(Integer.parseInt(action.getId()));
						SAFeConsoleLogger.write("--->invoking action: " + archActionChild.getName()
								+ "; from port: " + archActionChild.getParent().getName());
						this.workflowFacade.compute(archActionChild.getName(), archActionChild
								.getParent().getName());
					}
					break;
				}//IF
			}
			
		}
		SAFeConsoleLogger.write("EXITING CHOICE");
		
		//ChoiceOperComplexType choice_oper = (ChoiceOperComplexType)element.getElement();
		
		/*String chosen = choice_oper.getChosen();
		
		for(int i=element.getChildren().size()-1;i>=0;i--){
			SAFeOrchestrationElement select = element.getChildren().get(i);
			Select select_oper = (Select)select.getElement();
			String action_id = select_oper.getActionId();
			//navegar no select
			if(action_id.equalsIgnoreCase(chosen))
				for(SAFeOrchestrationElement child:select.getChildren()){
					child.run();
				}
		}*/
		
	}

}

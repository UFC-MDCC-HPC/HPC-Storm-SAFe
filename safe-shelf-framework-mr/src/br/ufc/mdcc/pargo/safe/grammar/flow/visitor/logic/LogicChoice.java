package br.ufc.mdcc.pargo.safe.grammar.flow.visitor.logic;

import br.ufc.mdcc.pargo.safe.grammar.flow.SAFeOrchestrationElement;
import br.ufc.mdcc.pargo.safe.grammar.flow.visitor.AbstractSAFeElementLogic;
import br.ufc.mdcc.pargo.safe.grammar.util.SAFeConsoleLogger;

public class LogicChoice extends AbstractSAFeElementLogic{

	@Override
	public void logic(SAFeOrchestrationElement element) {
		element.setLogicClass(this);
		SAFeConsoleLogger.write("STARTING CHOICE TASKS");
		outer:
		for(int i=element.getChildren().size()-1;i>=0;i--){
			SAFeOrchestrationElement child = element.getChildren().get(i);
			child.run();
			if(breakv){
				breakv = false;
				break outer;
			}
			
			if(continuev){
				break outer;
			}
		}
		SAFeConsoleLogger.write("ENDED CHOICE TASKS");
		/*
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
				IHShelfActionFuture actionFuture = null;
				 
				actionFuture = this.workflowFacade.computeActionFuture(archAction.getName(), archAction
						.getParent().getName());
				
				Boolean  res = actionFuture.test(); //(Boolean)this.workflowFacade.compute(archAction.getName(), archAction
						//.getParent().getName());
				//System.out.println(":"+res);
				if(res.booleanValue()==true){
					for(int j=select.getChildren().size()-1;j>=0;j--){
						//System.out.println("TESTE:" + select.getChildren().get(j).getElement().getOperName());
						
						
						if(select.getChildren().get(j).getOperation().equals(SAFeOrchestrationOperation.BREAKOPER)){
							String myLabel = select.getChildren().get(j).getElement().getBaseLabel();
							if(myLabel!=null && myLabel!=""){
								this.addVariable(myLabel, true);
								return;
							}
							
						}
						
						
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
		SAFeConsoleLogger.write("EXITING CHOICE");*/
		
		
		
	}

}

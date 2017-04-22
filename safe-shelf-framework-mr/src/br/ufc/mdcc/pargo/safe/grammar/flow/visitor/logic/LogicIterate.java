package br.ufc.mdcc.pargo.safe.grammar.flow.visitor.logic;

import br.ufc.mdcc.pargo.safe.grammar.flow.SAFeOrchestrationElement;
import br.ufc.mdcc.pargo.safe.grammar.flow.visitor.AbstractSAFeElementLogic;
import br.ufc.mdcc.pargo.safe.grammar.util.SAFeConsoleLogger;

public class LogicIterate extends AbstractSAFeElementLogic {

	@Override
	public void logic(SAFeOrchestrationElement element) {
		SAFeConsoleLogger.write("STARTING ITERATE TASKS");
		for(int i=element.getChildren().size()-1;i>=0;i--){
			SAFeOrchestrationElement child = element.getChildren().get(i);
			child.run();
		}
		SAFeConsoleLogger.write("ENDED ITERATE TASKS");
		/*int max = 0;
		String myLabel = null;

		if (element.getElement() instanceof IterateOper) {
			IterateOper iterate_oper = (IterateOper) element.getElement();
			// every children must run MAX
			max = iterate_oper.getMax();
			myLabel = iterate_oper.getIterLabel();
		}
		
		if(max==-1)
			max = 100000;
		
		SAFeConsoleLogger.write("BEGIN ITERATOR MAX="+max);
		
		children:
		for (int i = 0; i < max; i++){
			// inside children
			
			if(myLabel!=null && myLabel!=""){
				Boolean bool = (Boolean)this.getVariable(myLabel);
				if(bool !=null && bool==true){
					break children;
				}
			}
			
			
			for (int j = element.getChildren().size() - 1; j >= 0; j--) {
				
				SAFeOrchestrationElement child = element.getChildren().get(j);
				if(child.getOperation().equals(SAFeOrchestrationOperation.BREAKOPER)){
					break children;
				}else if(child.getOperation().equals(SAFeOrchestrationOperation.CONTINUEOPER)){
					continue children;
				}
				
				child.run();
			}
		}
		SAFeConsoleLogger.write("END ITERATOR MAX="+max);
		*/
	}
}

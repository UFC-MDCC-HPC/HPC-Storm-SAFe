package br.ufc.mdcc.pargo.safe.grammar.flow.visitor.logic;

import br.ufc.mdcc.pargo.safe.grammar.flow.SAFeOrchestrationElement;
import br.ufc.mdcc.pargo.safe.grammar.flow.visitor.AbstractSAFeElementLogic;
import br.ufc.mdcc.pargo.safe.framework.util.SAFeConsoleLogger;

public class LogicIterate extends AbstractSAFeElementLogic {

	

	@Override
	public void logic(SAFeOrchestrationElement element) {
		element.setLogicClass(this);
		SAFeConsoleLogger.write("STARTING ITERATE TASKS");
		
		outer:
		while(true){
			for(int i=element.getChildren().size()-1;i>=0;i--){
				SAFeOrchestrationElement child = element.getChildren().get(i);
				child.run();
			
				if(breakv){
					breakv = false;
					break outer;
				}
				
				if(continuev){
					continue outer;
				}
			}
		}
		
	
		SAFeConsoleLogger.write("ENDED ITERATE TASKS");
	}
	
	
}

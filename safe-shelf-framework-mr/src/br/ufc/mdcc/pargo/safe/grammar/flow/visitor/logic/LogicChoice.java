package br.ufc.mdcc.pargo.safe.grammar.flow.visitor.logic;

import br.ufc.mdcc.pargo.safe.grammar.flow.SAFeOrchestrationElement;
import br.ufc.mdcc.pargo.safe.grammar.flow.visitor.AbstractSAFeElementLogic;
import br.ufc.mdcc.pargo.safe.framework.util.SAFeConsoleLogger;

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
	}

}

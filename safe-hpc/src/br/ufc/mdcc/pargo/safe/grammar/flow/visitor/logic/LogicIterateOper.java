package br.ufc.mdcc.pargo.safe.grammar.flow.visitor.logic;

import br.ufc.mdcc.pargo.safe.grammar.flow.SAFeOrchestrationElement;
import br.ufc.mdcc.pargo.safe.grammar.flow.XMLSAFeOperation.IterateOper;
import br.ufc.mdcc.pargo.safe.grammar.flow.visitor.ISAFeElementLogic;

public class LogicIterateOper implements ISAFeElementLogic {

	@Override
	public void logic(SAFeOrchestrationElement element) {

		int max = -1;

		if (element.getElement() instanceof IterateOper) {
			IterateOper iterate_oper = (IterateOper) element.getElement();
			// every children must run MAX
			max = iterate_oper.getMax();
		}

		
		
		for (int i = 0; i < max; i++)
			// inside children
			for (int j = element.getChildren().size() - 1; j >= 0; j--) {
				SAFeOrchestrationElement child = element.getChildren().get(j);
				child.run();
			}

	}
}

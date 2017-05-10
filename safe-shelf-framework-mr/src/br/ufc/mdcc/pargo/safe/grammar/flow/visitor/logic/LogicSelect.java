package br.ufc.mdcc.pargo.safe.grammar.flow.visitor.logic;

import br.ufc.mdcc.pargo.safe.grammar.flow.SAFeOrchestrationElement;
import br.ufc.mdcc.pargo.safe.grammar.flow.SAFeSWLSelectionGuardType;
import br.ufc.mdcc.pargo.safe.grammar.flow.visitor.AbstractSAFeElementLogic;
import br.ufc.mdcc.pargo.safe.v6.ISAFeActionFuture;
import br.ufc.mdcc.pargo.safe.v6.impl.SAFeActionFuture;
import br.ufc.mdcc.pargo.safe.framework.util.SAFeConsoleLogger;

public class LogicSelect extends AbstractSAFeElementLogic {

	String action;
	String idPort;

	@Override
	public void logic(SAFeOrchestrationElement element) {
		element.setLogicClass(this);
		SAFeConsoleLogger.write("STARTING SELECT TASKS");
		ISAFeActionFuture actionFuture = new SAFeActionFuture();
		if (element.getElement() instanceof SAFeSWLSelectionGuardType) {
			SAFeSWLSelectionGuardType ssgt = (SAFeSWLSelectionGuardType) element
					.getElement();
			action = ssgt.getAction();
			idPort = ssgt.getIdPort();
			this.workflow.invoke(idPort, action, actionFuture);
		}

		if (actionFuture.getValue() != 0) {
			outer: for (int i = element.getChildren().size() - 1; i >= 0; i--) {
				SAFeOrchestrationElement child = element.getChildren().get(i);
				child.run();
				if (breakv) {
					breakv = false;
					break outer;
				}

				if (continuev) {
					break outer;
				}
			}
		}

		SAFeConsoleLogger.write("ENDED SELECT TASKS");

	}

}

package br.ufc.mdcc.pargo.safe.grammar.flow.visitor.logic;

import br.ufc.mdcc.pargo.safe.grammar.arch.ArchAction;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchComponent;
import br.ufc.mdcc.pargo.safe.grammar.flow.SAFeOrchestrationElement;
import br.ufc.mdcc.pargo.safe.grammar.flow.XMLSAFeAction;
import br.ufc.mdcc.pargo.safe.grammar.flow.XMLSAFePrimOper;
import br.ufc.mdcc.pargo.safe.grammar.flow.visitor.AbstractSAFeElementLogic;
import br.ufc.mdcc.pargo.safe.grammar.util.SAFeConsoleLogger;

/**
 * Implements the logic for WAIT operation.
 * [wait]
 *  |
 *  |---handle_id(?)---|--resolve [comp_id]
 *  				   |--instantiate [comp_id]
 *  				   |--compute [action_id]
 *  
 * @author jefferson
 *
 */
public class LogicWaitOper extends AbstractSAFeElementLogic {

	@Override
	public void logic(SAFeOrchestrationElement element) {
		String handle_id = null;
		String subject_id = null; // action_id or component_id
		String action_oper = null;

		if (element.getElement() instanceof XMLSAFePrimOper) {
			XMLSAFePrimOper wait_oper = (XMLSAFePrimOper) element.getElement();
			handle_id = wait_oper.getHandleId();
		}

		for (int i = element.getChildren().size() - 1; i >= 0; i--) {
			SAFeOrchestrationElement child = element.getChildren().get(i);
			if (child.getElement() instanceof XMLSAFeAction) {
				XMLSAFeAction safe_action = (XMLSAFeAction) child.getElement();
				subject_id = safe_action.getId();
				action_oper = safe_action.getAction().value();
			}
		}

		if (action_oper.equals("resolve")) {
			this.resolveOper(subject_id);
		} else if (action_oper.equals("instantiate")) {
			this.instatiateOper(subject_id);
		} else if (action_oper.equals("compute")) {
			this.computeOper(subject_id);
		}

	}

	private void instatiateOper(String compId) {

		ArchComponent archComponent = this.sAFeSWLArcherParser.getArchComponentByID(
						Integer.parseInt(compId));
		SAFeConsoleLogger.write("ACTION: " + archComponent);
	}

	private void resolveOper(String compId) {

		ArchComponent archComponent = this.sAFeSWLArcherParser.getArchComponentByID(
						Integer.parseInt(compId));
		SAFeConsoleLogger.write("ACTION: " + archComponent);

	}

	private void computeOper(String actionId) {
		ArchAction archAction = this.sAFeSWLArcherParser.getArchActionId(Integer.parseInt(actionId));
		SAFeConsoleLogger.write("ACTION: " + archAction);
	}
}

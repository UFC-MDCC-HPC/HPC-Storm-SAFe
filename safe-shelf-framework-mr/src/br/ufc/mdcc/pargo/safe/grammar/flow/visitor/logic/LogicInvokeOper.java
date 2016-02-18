package br.ufc.mdcc.pargo.safe.grammar.flow.visitor.logic;

import br.ufc.mdcc.pargo.safe.grammar.arch.ArchAction;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchComponent;
import br.ufc.mdcc.pargo.safe.grammar.flow.SAFeOrchestrationElement;
import br.ufc.mdcc.pargo.safe.grammar.flow.XMLSAFeAction;
import br.ufc.mdcc.pargo.safe.grammar.flow.visitor.AbstractSAFeElementLogic;
import br.ufc.mdcc.pargo.safe.grammar.util.SAFeConsoleLogger;

/**
 * Implements the logic for ACTIVATE/INVOKE operation. [activate/invoke] |
 * |------------------|--resolve [comp_id] |--instantiate [comp_id] |--compute
 * [action_id]
 * 
 * @author jefferson
 *
 */
public class LogicInvokeOper extends AbstractSAFeElementLogic {

	@Override
	public void logic(SAFeOrchestrationElement element) {

		XMLSAFeAction action = (XMLSAFeAction) element.getElement();

		String subject_id = null; // action_id or component_id
		String action_oper = null;

		subject_id = action.getId();
		action_oper = action.getAction().value();

		if (action_oper.equals("resolve")) {
			this.resolveOper(subject_id);
		} else if (action_oper.equals("instantiate")) {
			this.instatiateOper(subject_id);
		} else if (action_oper.equals("compute")) {
			this.computeOper(subject_id);
		} else if (action_oper.equals("deploy")) {
			this.deployOper(subject_id);
		} else if (action_oper.equals("connect")) {
			this.connect(subject_id);
		}
	}

	private void connect(String compId) {
		
		if (this.workflowFacade != null)
			this.workflowFacade.connect(compId);
	}

	private void instatiateOper(String compId) {

		ArchComponent archComponent = this.sAFeSWLArcherParser
				.getArchComponentByID(Integer.parseInt(compId));
		SAFeConsoleLogger.write("invoke instantiate => archComponent: ["
				+ archComponent.getId() + "]" + archComponent.getName());
		if (this.workflowFacade != null)
			this.workflowFacade.instantiate(compId);
	}

	private void resolveOper(String compId) {
		ArchComponent archComponent = this.sAFeSWLArcherParser
				.getArchComponentByID(Integer.parseInt(compId));
		SAFeConsoleLogger.write("invoke resolve => archComponent: ["
				+ archComponent.getId() + "]" + archComponent.getName());
		if (this.workflowFacade != null)
			this.workflowFacade.resolve(compId); // TEM
																		// QUE
																		// MUDAR
																		// ISSO
																		// AQUI.
	}

	private void computeOper(String actionId) {

		ArchAction archAction = this.sAFeSWLArcherParser
				.getArchActionId(Integer.parseInt(actionId));
		SAFeConsoleLogger.write("invoking action: " + archAction.getName()
				+ "; from port: " + archAction.getParent().getName());
		if (this.workflowFacade != null) {
			this.workflowFacade.compute(archAction.getName(), archAction
					.getParent().getName());
		}

	}

	private void deployOper(String compId) {
		ArchComponent archComponent = this.sAFeSWLArcherParser
				.getArchComponentByID(Integer.parseInt(compId));
		SAFeConsoleLogger.write("invoke deploy => archComponent: ["
				+ archComponent.getId() + "]" + archComponent.getName());
		if (this.workflowFacade != null)
			this.workflowFacade.deploy(compId);
	}
}

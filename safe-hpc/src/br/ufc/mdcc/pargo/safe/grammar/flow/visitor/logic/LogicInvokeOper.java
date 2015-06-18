package br.ufc.mdcc.pargo.safe.grammar.flow.visitor.logic;

import br.ufc.mdcc.pargo.safe.framework.HPCStormObjectRepository;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchAction;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchComponent;
import br.ufc.mdcc.pargo.safe.grammar.flow.SAFeOrchestrationElement;
import br.ufc.mdcc.pargo.safe.grammar.flow.XMLSAFeAction;
import br.ufc.mdcc.pargo.safe.grammar.flow.visitor.AbstractSAFeElementLogic;

/**
 * Implements the logic for ACTIVATE/INVOKE operation.
 * [activate/invoke]
 *  |
 *  |------------------|--resolve [comp_id]
 *  				   |--instantiate [comp_id]
 *  				   |--compute [action_id]
 *  
 * @author jefferson
 *
 */
public class LogicInvokeOper extends AbstractSAFeElementLogic{

	@Override
	public void logic(SAFeOrchestrationElement element) {
		
		XMLSAFeAction action  = (XMLSAFeAction)element.getElement();
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
		}
	}
	
	private void instatiateOper(String compId) {

		ArchComponent archComponent = HPCStormObjectRepository
				.getWorkflowEngine().getArchComponentByID(
						Integer.parseInt(compId));
		System.out.println("ACTION: " + archComponent);
	}

	private void resolveOper(String compId) {

		ArchComponent archComponent = HPCStormObjectRepository
				.getWorkflowEngine().getArchComponentByID(
						Integer.parseInt(compId));
		System.out.println("ACTION: " + archComponent);

	}

	private void computeOper(String actionId) {
		ArchAction archAction = HPCStormObjectRepository.getWorkflowEngine()
				.getArchActionId(Integer.parseInt(actionId));
		System.out.println("ACTION: " + archAction);
	}
}

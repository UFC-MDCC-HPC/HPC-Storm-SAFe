package br.ufc.mdcc.pargo.safe.grammar.flow.visitor.logic;

import br.ufc.mdcc.pargo.safe.framework.HPCStormObjectRepository;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchAction;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchComponent;
import br.ufc.mdcc.pargo.safe.grammar.flow.SAFeOrchestrationElement;
import br.ufc.mdcc.pargo.safe.grammar.flow.XMLSAFeAction;
import br.ufc.mdcc.pargo.safe.grammar.flow.XMLSAFePrimOper;
import br.ufc.mdcc.pargo.safe.grammar.flow.visitor.AbstractSAFeElementLogic;

/**
 * Implements the logic for START operation.
 * [start]
 *  |
 *  |---handle_id(?)---|--resolve [comp_id]
 *  				   |--instantiate [comp_id]
 *  				   |--compute [action_id]
 *  
 * @author jefferson
 *
 */
public class LogicStartOper extends AbstractSAFeElementLogic{
	
	@Override
	public void logic(SAFeOrchestrationElement element) {
		
		String handle_id = null;
		String  subject_id = null; //action_id or component_id
		String action_oper = null;
		
		if(element.getElement() instanceof XMLSAFePrimOper){
			XMLSAFePrimOper start_oper = (XMLSAFePrimOper)element.getElement();
			handle_id = start_oper.getHandleId();
		}
		
		
		for(int i=element.getChildren().size()-1;i>=0;i--){
			SAFeOrchestrationElement child = element.getChildren().get(i);
			if(child.getElement() instanceof XMLSAFeAction){
				XMLSAFeAction safe_action = (XMLSAFeAction)child.getElement();
				subject_id = safe_action.getId();
				action_oper = safe_action.getAction().value();
			}
		}
		
		if(action_oper.equals("resolve")){
			this.resolveOper(subject_id);
		}else if(action_oper.equals("instantiate")){
			this.instatiateOper(subject_id);
		}else if(action_oper.equals("compute")){
			this.computeOper(subject_id);
		}
		
	}
	
	private void instatiateOper(String compId){
		
		ArchComponent archComponent = HPCStormObjectRepository.getWorkflowEngine().getArchComponentByID(Integer.parseInt(compId));
		System.out.println("ACTION: " +archComponent);
	}
	
	private void resolveOper(String compId){
		
		ArchComponent archComponent = HPCStormObjectRepository.getWorkflowEngine().getArchComponentByID(Integer.parseInt(compId));
		System.out.println("ACTION: " +archComponent);

	}
	
	private void computeOper(String actionId){
		ArchAction archAction = HPCStormObjectRepository.getWorkflowEngine().getArchActionId(Integer.parseInt(actionId));
		System.out.println("ACTION: " + archAction);
	}

}

package br.ufc.mdcc.pargo.safe.grammar.flow.visitor.logic;

import java.util.ArrayList;
import java.util.List;

import br.ufc.mdcc.pargo.safe.framework.workflow.HShelfArgValueType;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchAction;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchComponent;
import br.ufc.mdcc.pargo.safe.grammar.flow.ArgType;
import br.ufc.mdcc.pargo.safe.grammar.flow.SAFeOrchestrationElement;
import br.ufc.mdcc.pargo.safe.grammar.flow.XMLSAFeAction;
import br.ufc.mdcc.pargo.safe.grammar.flow.visitor.AbstractSAFeElementLogic;
import br.ufc.mdcc.pargo.safe.grammar.util.SAFeConsoleLogger;

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
			List<ArgType> args = null;
			args = action.getArg();
			this.computeOper(subject_id,args);
		}else if(action_oper.equals("deploy")){
			this.deployOper(subject_id);
		}
	}
	
	private void instatiateOper(String compId) {

		ArchComponent archComponent = this.sAFeSWLArcherParser.getArchComponentByID(
						Integer.parseInt(compId));
		SAFeConsoleLogger.write("invoke instantiate => archComponent: ["+archComponent.getId()+"]" + archComponent.getName());
		if(this.workflowFacade!=null)
			this.workflowFacade.instantiate(compId);
	}

	private void resolveOper(String compId) {
		ArchComponent archComponent = this.sAFeSWLArcherParser.getArchComponentByID(
						Integer.parseInt(compId));
		SAFeConsoleLogger.write("invoke resolve => archComponent: ["+archComponent.getId()+"]" + archComponent.getName());
		if(this.workflowFacade!=null)
			this.workflowFacade.resolve("teste.contract.xml", compId);
	}

	private void computeOper(String actionId, List<ArgType> args) {
		
		List<HShelfArgValueType> argsValueTypeList = null;
		if(args!=null && args.size()>0){
			argsValueTypeList = new ArrayList<HShelfArgValueType>();
			for(ArgType argType:args){
				String type = argType.getType().name();
				String value = argType.getValue();
				HShelfArgValueType argValueType = new HShelfArgValueType(value, type);
				argsValueTypeList.add(argValueType);
			}
		}
		
		ArchAction archAction = this.sAFeSWLArcherParser.getArchActionId(Integer.parseInt(actionId));
		SAFeConsoleLogger.write("invoking action: " + archAction.getName()+"; from port: "+archAction.getParent().getName());
		if(this.workflowFacade!=null){
			this.workflowFacade.compute(archAction.getName(), archAction.getParent().getName(), argsValueTypeList);
		}
		
	}
	
	private void deployOper(String compId){
		ArchComponent archComponent = this.sAFeSWLArcherParser.getArchComponentByID(
				Integer.parseInt(compId));
		SAFeConsoleLogger.write("invoke deploy => archComponent: ["+archComponent.getId()+"]" + archComponent.getName());
		if(this.workflowFacade!=null)
			this.workflowFacade.deploy(compId);
	}
}

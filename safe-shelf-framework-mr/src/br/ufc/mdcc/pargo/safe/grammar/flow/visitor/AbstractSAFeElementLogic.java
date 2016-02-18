package br.ufc.mdcc.pargo.safe.grammar.flow.visitor;

import java.util.HashMap;
import java.util.Map;

import br.ufc.mdcc.pargo.safe.framework.workflow.HShelfWorkflowFacade;
import br.ufc.mdcc.pargo.safe.grammar.ISAFeSWLArcherParser;
import br.ufc.mdcc.pargo.safe.grammar.flow.SAFeOrchestrationElement;

public abstract class AbstractSAFeElementLogic {

	private static final Map<String, Object> variables =  new HashMap<String, Object>();
	protected ISAFeSWLArcherParser sAFeSWLArcherParser;
	protected HShelfWorkflowFacade workflowFacade;
	
	public void setISAFeSWLArcherParser(ISAFeSWLArcherParser sAFeSWLArcherParser){
		this.sAFeSWLArcherParser = sAFeSWLArcherParser;
	}
	
	public void setHShelfWorkflowFacade(HShelfWorkflowFacade workflowFacade){
		this.workflowFacade = workflowFacade;
	}
	
	public AbstractSAFeElementLogic() {
		
	}
	
	public abstract void logic(SAFeOrchestrationElement element);
	 
	public void addVariable(String name, Object value){
		AbstractSAFeElementLogic.variables.put(name, value);
	}
	
	public Object getVariable(String name){
		return AbstractSAFeElementLogic.variables.get(name);
	}
}

package br.ufc.mdcc.pargo.safe.grammar.flow.visitor;

import java.util.HashMap;
import java.util.Map;

import br.ufc.mdcc.pargo.safe.framework.workflow.HShelfWorkflowFacade;
import br.ufc.mdcc.pargo.safe.grammar.ISAFeSWLArcherParser;
import br.ufc.mdcc.pargo.safe.grammar.flow.SAFeOrchestrationElement;

public abstract class AbstractSAFeElementLogic {

	private Map<String, Object> variables;
	protected ISAFeSWLArcherParser sAFeSWLArcherParser;
	protected HShelfWorkflowFacade workflowFacade;
	
	public void setISAFeSWLArcherParser(ISAFeSWLArcherParser sAFeSWLArcherParser){
		this.sAFeSWLArcherParser = sAFeSWLArcherParser;
	}
	
	public void setHShelfWorkflowFacade(HShelfWorkflowFacade workflowFacade){
		this.workflowFacade = workflowFacade;
	}
	
	public AbstractSAFeElementLogic() {
		this.variables = new HashMap<String, Object>();
	}
	
	public abstract void logic(SAFeOrchestrationElement element);
	 
	public void addVariable(String name, Object value){
		this.variables.put(name, value);
	}
	
	public Object getVariable(String name){
		return this.variables.get(name);
	}
}

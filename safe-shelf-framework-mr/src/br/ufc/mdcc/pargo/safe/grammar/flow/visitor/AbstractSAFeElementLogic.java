package br.ufc.mdcc.pargo.safe.grammar.flow.visitor;

import br.ufc.mdcc.pargo.safe.framework.workflow.HShelfWorkflowFacade;
import br.ufc.mdcc.pargo.safe.grammar.ISAFeSWLArcherParser;
import br.ufc.mdcc.pargo.safe.grammar.flow.SAFeOrchestrationElement;

public abstract class AbstractSAFeElementLogic {

	protected ISAFeSWLArcherParser sAFeSWLArcherParser;
	protected HShelfWorkflowFacade workflowFacade;
	protected boolean breakv = false;
	protected boolean continuev = false;
	
	public void setISAFeSWLArcherParser(ISAFeSWLArcherParser sAFeSWLArcherParser){
		this.sAFeSWLArcherParser = sAFeSWLArcherParser;
	}
	
	public void setHShelfWorkflowFacade(HShelfWorkflowFacade workflowFacade){
		this.workflowFacade = workflowFacade;
	}
	
	public AbstractSAFeElementLogic() {
		
	}
	
	public abstract void logic(SAFeOrchestrationElement element);
	
	public void setBreak(boolean breakv){
		this.breakv = breakv;
	}
	
	public void setContinue(boolean continuev){
		this.continuev = continuev;
	}
	 
}

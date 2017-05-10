package br.ufc.mdcc.pargo.safe.grammar.flow.visitor;

import br.ufc.mdcc.pargo.safe.grammar.ISAFeSWLArcherParser;
import br.ufc.mdcc.pargo.safe.grammar.flow.SAFeOrchestrationElement;
import br.ufc.mdcc.pargo.safe.v6.impl.SAFeWorkflow;

public abstract class AbstractSAFeElementLogic {

	protected ISAFeSWLArcherParser sAFeSWLArcherParser;
	protected SAFeWorkflow workflow;
	protected boolean breakv = false;
	protected boolean continuev = false;

	public AbstractSAFeElementLogic() {

	}

	public void setISAFeSWLArcherParser(ISAFeSWLArcherParser sAFeSWLArcherParser) {
		this.sAFeSWLArcherParser = sAFeSWLArcherParser;
	}

	public void setHShelfWorkflowFacade(SAFeWorkflow workflow) {
		this.workflow = workflow;
	}

	public abstract void logic(SAFeOrchestrationElement element);

	public void setBreak(boolean breakv) {
		this.breakv = breakv;
	}

	public void setContinue(boolean continuev) {
		this.continuev = continuev;
	}

}

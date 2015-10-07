package br.ufc.mdcc.pargo.safe.grammar;

import br.ufc.mdcc.pargo.safe.grammar.flow.SAFeOrchestrationWorkflow;
//import br.ufc.mdcc.pargo.safe.workflow.HShelfWorkflowFacade;

public interface ISAFeSWLFlowParser {

	public SAFeOrchestrationWorkflow getWorkflow();
	public void setISAFeSWLArcherParser(ISAFeSWLArcherParser sAFeSWLArcherParser);
	//public void setHShelfWorkflowFacade(HShelfWorkflowFacade workflowFacade);
	public void run();
}

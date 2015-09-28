package br.ufc.mdcc.pargo.safe.grammar;

import br.ufc.mdcc.pargo.safe.grammar.flow.SAFeOrchestrationWorkflow;

public interface ISAFeSWLFlowParser {

	public SAFeOrchestrationWorkflow getWorkflow();
	public void setISAFeSWLArcherParser(ISAFeSWLArcherParser sAFeSWLArcherParser);
	public void run();
}

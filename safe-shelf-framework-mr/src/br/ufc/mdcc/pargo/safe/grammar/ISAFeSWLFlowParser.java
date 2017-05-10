package br.ufc.mdcc.pargo.safe.grammar;

import br.ufc.mdcc.pargo.safe.grammar.flow.SAFeOrchestrationWorkflow;
import br.ufc.mdcc.pargo.safe.v6.impl.SAFeWorkflow;

public interface ISAFeSWLFlowParser {

	public SAFeOrchestrationWorkflow getWorkflow();
	public void setISAFeSWLArcherParser(ISAFeSWLArcherParser sAFeSWLArcherParser);
	public void setWorkflow(SAFeWorkflow workflow);
	public void run();
}

package br.ufc.mdcc.pargo.safe.grammar.flow.visitor;

import br.ufc.mdcc.pargo.safe.grammar.ISAFeSWLArcherParser;
import br.ufc.mdcc.pargo.safe.grammar.flow.SAFeOrchestrationElement;

public interface ISAFeVisitor {

	public void visit(SAFeOrchestrationElement element);
	public void setISAFeSWLArcherParser(ISAFeSWLArcherParser sAFeSWLArcherParser);
}

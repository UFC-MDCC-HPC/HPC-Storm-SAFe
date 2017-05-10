package br.ufc.mdcc.pargo.safe.v6;

public interface ISAFeTaskPort extends ISAFePort{

	void invoke(String actionId);
	void invoke(String actionId, ISAFeActionFuture actionFuture);
}

package br.ufc.mdcc.pargo.safe.port;

public abstract class HPCStormTaskPortUses<In> implements
		IHPCStormTaskPort<In>, IHPCStormUses<In> {

	protected Class<In> type;
	protected In in;

	public HPCStormTaskPortUses(Class<In> type) {
		this.type = type;
	}
}

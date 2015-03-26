package br.ufc.mdcc.pargo.safe.port;

public abstract class HPCStormTaskPortUses<In> implements
		IHPCStormTaskPort<In>, IHPCStormUses<In> {

	protected final Class<In> type;

	public HPCStormTaskPortUses(Class<In> type) {
		this.type = type;
	}
}

package br.ufc.mdcc.pargo.safe.port;

public abstract class HPCStormEnvPortUses<In> implements IHPCStormEnvPort<In>,
		IHPCStormUses<In> {

	protected final Class<In> type;
	protected In in;

	public HPCStormEnvPortUses(Class<In> type) {
		this.type = type;
	}
}

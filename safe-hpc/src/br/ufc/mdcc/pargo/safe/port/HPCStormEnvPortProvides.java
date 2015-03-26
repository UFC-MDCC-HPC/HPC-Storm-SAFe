package br.ufc.mdcc.pargo.safe.port;

public abstract class HPCStormEnvPortProvides<Out> implements
		IHPCStormEnvPort<Out>, IHPCStormProvides<Out> {

	protected final Class<Out> type;

	public HPCStormEnvPortProvides(Class<Out> type) {
		this.type = type;
	}
}

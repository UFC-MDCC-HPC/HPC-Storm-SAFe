package br.ufc.mdcc.pargo.safe.port;

public abstract class HPCStormTaskProvides<Out> implements
		IHPCStormTaskPort<Out>, IHPCStormProvides<Out> {

	protected final Class<Out> type;

	public HPCStormTaskProvides(Class<Out> type) {
		this.type = type;
	}
}

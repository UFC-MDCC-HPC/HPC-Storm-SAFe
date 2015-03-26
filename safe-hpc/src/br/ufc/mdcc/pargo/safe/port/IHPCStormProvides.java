package br.ufc.mdcc.pargo.safe.port;

public interface IHPCStormProvides<Out> extends IHPCStormPort<Out>{

	public Out getOut();
}

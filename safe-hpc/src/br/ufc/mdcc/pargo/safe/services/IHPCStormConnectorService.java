package br.ufc.mdcc.pargo.safe.services;

import java.lang.reflect.Method;

import br.ufc.mdcc.pargo.safe.port.IHPCStormPort;

public interface IHPCStormConnectorService{

	public void connect(IHPCStormPort uses, Method mUses, IHPCStormPort provides, Method mProvides);

}

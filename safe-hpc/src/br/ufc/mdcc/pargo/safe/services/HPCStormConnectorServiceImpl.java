package br.ufc.mdcc.pargo.safe.services;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import br.ufc.mdcc.pargo.safe.port.IHPCStormPort;
import br.ufc.mdcc.pargo.safe.port.annotations.MethodUsesProvidesConnection;

public class HPCStormConnectorServiceImpl implements IHPCStormConnectorService{

	private List<MethodUsesProvidesConnection> connections;
	
	public HPCStormConnectorServiceImpl() {
		this.connections = new ArrayList<MethodUsesProvidesConnection>();
	}
	
	public void connect(IHPCStormPort uses, Method mUses, IHPCStormPort provides, Method mProvides){
		MethodUsesProvidesConnection mupc = new MethodUsesProvidesConnection
				(uses, mUses, provides, mProvides);
		this.connections.add(mupc);
	}
}

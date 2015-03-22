package br.ufc.mdcc.pargo.safe.services;

import java.util.ArrayList;
import java.util.List;

import br.ufc.mdcc.pargo.safe.port.IHPCStormPort;
import br.ufc.mdcc.pargo.safe.port.annotations.MethodUsesProvidesConnection;

public class HPCStormBuilderService {

	private List<MethodUsesProvidesConnection> connections;
	
	public HPCStormBuilderService() {
		this.connections = new ArrayList<MethodUsesProvidesConnection>();
	}
	
	public void connect(IHPCStormPort uses, IHPCStormPort provides){
		
	}
}

package br.ufc.mdcc.pargo.safe.services;

import java.util.ArrayList;
import java.util.List;

import br.ufc.mdcc.pargo.safe.port.IHPCStormPort;

public class HPCStormBuilderService {

	private List<HPCStormConnection> connections;
	
	public HPCStormBuilderService() {
		this.connections = new ArrayList<HPCStormConnection>();
	}
	
	public void connect(IHPCStormPort uses, IHPCStormPort provides){
		
	}
}

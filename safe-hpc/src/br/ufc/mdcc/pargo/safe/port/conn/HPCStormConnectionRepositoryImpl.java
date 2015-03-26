package br.ufc.mdcc.pargo.safe.port.conn;

import java.util.HashMap;
import java.util.Map;

import br.ufc.mdcc.pargo.safe.exception.HPCStormException;
import br.ufc.mdcc.pargo.safe.port.IHPCStormProvides;
import br.ufc.mdcc.pargo.safe.port.IHPCStormUses;

public class HPCStormConnectionRepositoryImpl implements IHPCStormConnectionRepository{

	private Map<String,UsesProvidesConnection> connections;
	
	public HPCStormConnectionRepositoryImpl() {
		this.connections = new HashMap<String,UsesProvidesConnection>();
	}
	
	public String createConnection(IHPCStormUses<Object> uses, IHPCStormProvides<Object> provides) throws HPCStormException
	{ 
		
		UsesProvidesConnection mupc = new UsesProvidesConnection
				(uses, provides);
		if(this.connections.get(mupc.getId()) != null) 
			throw new HPCStormException("Ports and Methods already connected.");
		
		this.connections.put(mupc.getId(),mupc);
		
		return mupc.getId();
	}
	
	public UsesProvidesConnection getConnection(String id){
		return this.connections.get(id);
	}
	
	
}

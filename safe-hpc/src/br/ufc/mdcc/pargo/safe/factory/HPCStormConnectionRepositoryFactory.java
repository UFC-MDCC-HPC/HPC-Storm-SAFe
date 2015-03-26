package br.ufc.mdcc.pargo.safe.factory;

import br.ufc.mdcc.pargo.safe.port.conn.HPCStormConnectionRepositoryImpl;
import br.ufc.mdcc.pargo.safe.port.conn.IHPCStormConnectionRepository;

public class HPCStormConnectionRepositoryFactory {

	private static IHPCStormConnectionRepository ics;
	
	public static IHPCStormConnectionRepository getHPCStormConnectorService(){
		if(ics==null) {
			ics = new HPCStormConnectionRepositoryImpl();
		}
		return ics;
	}
	
}

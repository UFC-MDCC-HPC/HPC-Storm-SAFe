package br.ufc.mdcc.pargo.safe.factory;

import br.ufc.mdcc.pargo.safe.services.HPCStormConnectorServiceImpl;
import br.ufc.mdcc.pargo.safe.services.IHPCStormConnectorService;

public class HPCStormConnectorServicesFactory {

	private static IHPCStormConnectorService ics;
	
	public static IHPCStormConnectorService getHPCStormConnectorService(){
		if(ics==null) {
			ics = new HPCStormConnectorServiceImpl();
		}
		return ics;
	}
	
}

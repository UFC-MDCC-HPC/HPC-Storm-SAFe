package br.ufc.mdcc.pargo.safe.factory;

import br.ufc.mdcc.pargo.safe.service.HPCStormServicesImpl;
import br.ufc.mdcc.pargo.safe.service.IHPCStormServices;


public class HPCStormServicesFactory {

	private static IHPCStormServices applicationServices;
	
	public static IHPCStormServices createApplicationServices(){
		if(applicationServices == null)
			applicationServices = new HPCStormServicesImpl();
		return applicationServices;
	}
	
}

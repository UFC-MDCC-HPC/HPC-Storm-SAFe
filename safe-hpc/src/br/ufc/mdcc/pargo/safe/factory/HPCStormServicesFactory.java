package br.ufc.mdcc.pargo.safe.factory;

import br.ufc.mdcc.pargo.safe.services.HPCStormServicesImpl;
import br.ufc.mdcc.pargo.safe.services.IHPCStormServices;


public class HPCStormServicesFactory {

	private static IHPCStormServices applicationServices;
	
	public static IHPCStormServices createApplicationServices(){
		if(applicationServices == null)
			applicationServices = new HPCStormServicesImpl();
		return applicationServices;
	}
	
}

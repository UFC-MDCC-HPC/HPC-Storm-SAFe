package br.ufc.mdcc.pargo.safe.factory;

import br.ufc.mdcc.pargo.safe.application.HPCStormServicesImpl;
import br.ufc.mdcc.pargo.safe.application.IHPCStormServices;


public class HPCStormServicesFactory {

	private static IHPCStormServices applicationServices;
	
	public static IHPCStormServices createApplicationServices(){
		if(applicationServices == null)
			applicationServices = new HPCStormServicesImpl();
		return applicationServices;
	}
	
}

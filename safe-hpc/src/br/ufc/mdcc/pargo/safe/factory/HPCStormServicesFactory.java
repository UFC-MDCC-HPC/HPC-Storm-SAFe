package br.ufc.mdcc.pargo.safe.factory;

import br.ufc.mdcc.pargo.safe.application.HPCStormAplicationServicesImpl;
import br.ufc.mdcc.pargo.safe.application.IHPCStormApplicationServices;
import br.ufc.mdcc.pargo.safe.framework.IHPCStormServices;

public class HPCStormServicesFactory {

	private static IHPCStormApplicationServices applicationServices;
	private static IHPCStormServices services;
	
	public static IHPCStormApplicationServices createApplicationServices(){
		if(applicationServices == null)
			applicationServices = new HPCStormAplicationServicesImpl();
		return applicationServices;
	}
	
}

package br.ufc.mdcc.pargo.safe.factory;

import br.ufc.mdcc.pargo.safe.service.HPCStormServicesImpl;
import br.ufc.mdcc.pargo.safe.service.IHPCStormServices;


public class HPCStormServicesFactory {

	//private static IHPCStormServices applicationServices = null; 
	private static int port = 7888;
	private static final String host = "http://localhost"; 
	/**
	 * Creates a new Services object
	 * @return a new Services objetc
	 */
	public static IHPCStormServices createApplicationServices(){
		/*if(applicationServices == null)
			applicationServices = new HPCStormServicesImpl();
		return applicationServices;*/
		
		return new HPCStormServicesImpl(host,port+=1000);
		
	}
	
}

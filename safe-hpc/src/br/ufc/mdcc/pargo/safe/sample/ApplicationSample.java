package br.ufc.mdcc.pargo.safe.sample;

import br.ufc.mdcc.pargo.safe.application.HPCStormApplication;
import br.ufc.mdcc.pargo.safe.port.predef.SAFeSWLProvidesPort;
import br.ufc.mdcc.pargo.safe.service.IHPCStormServices;

/**
 * Just a sample application.
 * @author jefferson
 *
 */
public class ApplicationSample extends HPCStormApplication{

	
	
	public ApplicationSample() {
		super();
	}
	
	@Override
	public void setServices(IHPCStormServices services) {
		this.services = services;
		/**COLOCAR PORTAS PRÉ-DEFINIDAS*/
		if(services!=null){
			this.safeFeSWLPort = new SAFeSWLProvidesPort();
			this.services.registerProvidesPort(this.safeFeSWLPort);
		}
	}
	
}

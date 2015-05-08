package br.ufc.mdcc.pargo.safe.sample;

import br.ufc.mdcc.pargo.safe.application.HPCStormApplication;
import br.ufc.mdcc.pargo.safe.service.IHPCStormServices;

/**
 * Just a sample application.
 * @author jefferson
 *
 */
public class ApplicationSample extends HPCStormApplication{

	private IHPCStormServices services;
	
	public ApplicationSample() {
		super();
	}
	
	@Override
	public void setServices(IHPCStormServices services) {
		this.services = services;
		/**COLOCAR PORTAS PRÉ-DEFINIDAS*/
	}

	public static void main(String[] args) {
		
		HPCStormApplication app = new ApplicationSample();
		app.run();
	}
	
}

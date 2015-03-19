package br.ufc.mdcc.pargo.safe.sample;

import br.ufc.mdcc.pargo.safe.application.HPCStormApplicationFramework;
import br.ufc.mdcc.pargo.safe.port.predefined.ApplicationPredefinedPortImpl;
import br.ufc.mdcc.pargo.safe.services.IHPCStormServices;
import br.ufc.mdcc.pargo.safe.util.SAFeConsoleLogger;

/**
 * A Sample application. 
 * @author jefferson
 *
 */
public class ApplicationSample extends HPCStormApplicationFramework{

	private IHPCStormServices services;
	
	public ApplicationSample() {
		this.applicationPredefinedPort = new ApplicationPredefinedPortImpl("pre-def-provides");
	}
	
	@Override
	public void setServices(IHPCStormServices services) {
		this.services = services;
		SAFeConsoleLogger.write("Registering predef application port.");
		this.services.setProvidesPort(this.applicationPredefinedPort);
	}

	public static void main(String[] args) {
		
		new ApplicationSample().run();
	}
	
}

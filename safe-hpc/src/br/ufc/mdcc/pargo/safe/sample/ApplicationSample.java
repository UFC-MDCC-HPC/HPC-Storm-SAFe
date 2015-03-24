package br.ufc.mdcc.pargo.safe.sample;

import br.ufc.mdcc.pargo.safe.application.HPCStormApplicationFramework;
import br.ufc.mdcc.pargo.safe.port.predefined.environment.impl.ApplicationPredefinedPortProvidesImpl;
import br.ufc.mdcc.pargo.safe.services.IHPCStormServices;
import br.ufc.mdcc.pargo.safe.util.SAFeConsoleLogger;

/**
 * Just a sample application.
 * @author jefferson
 *
 */
public class ApplicationSample extends HPCStormApplicationFramework{

	private IHPCStormServices services;
	
	
	public ApplicationSample() {
		//this is a simple pre-def port. Real users must specialize this class. 
		this.applicationPredefinedPortProvides = new ApplicationPredefinedPortProvidesImpl();
	}
	
	@Override
	public void setServices(IHPCStormServices services) {
		this.services = services;
		SAFeConsoleLogger.write("Registering predef application port.");
		this.services.setProvidesPort(this.applicationPredefinedPortProvides);
		this.services.setProvidesPort(this.applicationPredefinedPortUses);
	}

	public static void main(String[] args) {
		
		new ApplicationSample().run();
	}
	
}

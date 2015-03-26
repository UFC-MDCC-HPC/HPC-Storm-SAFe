package br.ufc.mdcc.pargo.safe.sample;

import br.ufc.mdcc.pargo.safe.application.HPCStormApplicationFramework;
import br.ufc.mdcc.pargo.safe.framework.HPCStormSAFeSWL;
import br.ufc.mdcc.pargo.safe.port.predefined.env.SAFeSWLProvidesPort;
import br.ufc.mdcc.pargo.safe.service.IHPCStormServices;
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
		this.saFeSWLProvidesPort = new SAFeSWLProvidesPort<HPCStormSAFeSWL>(HPCStormSAFeSWL.class);
		this.saFeSWLProvidesPort.setComponent(this);
	}
	
	@Override
	public void setServices(IHPCStormServices services) {
		this.services = services;
		SAFeConsoleLogger.write("Registering predef application port.");
		this.services.setProvidesPort(saFeSWLProvidesPort);
	}

	public static void main(String[] args) {
		
		new ApplicationSample().run();
	}

	@Override
	public HPCStormSAFeSWL createSAFeSWL() {
		return new HPCStormSAFeSWL();
	}
	
}

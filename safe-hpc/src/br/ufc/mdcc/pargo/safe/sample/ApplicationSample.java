package br.ufc.mdcc.pargo.safe.sample;

import br.ufc.mdcc.pargo.safe.application.HPCStormApplicationFramework;
import br.ufc.mdcc.pargo.safe.application.IHPCStormApplicationServices;

public class ApplicationSample extends HPCStormApplicationFramework{

	IHPCStormApplicationServices services;
	
	@Override
	public void setServices(IHPCStormApplicationServices services) {
		this.services = services;
	}

	public static void main(String[] args) {
		
		new ApplicationSample().run();
	}
	
}

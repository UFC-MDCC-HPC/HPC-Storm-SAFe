package br.ufc.mdcc.pargo.safe.sample;

import br.ufc.mdcc.pargo.safe.application.HPCStormApplicationFramework;
import br.ufc.mdcc.pargo.safe.application.IHPCStormServices;

public class ApplicationSample extends HPCStormApplicationFramework{

	IHPCStormServices services;
	
	@Override
	public void setServices(IHPCStormServices services) {
		this.services = services;
	}

	public static void main(String[] args) {
		
		new ApplicationSample().run();
	}
	
}

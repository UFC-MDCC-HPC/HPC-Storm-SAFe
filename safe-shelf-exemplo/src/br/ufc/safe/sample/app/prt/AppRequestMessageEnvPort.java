package br.ufc.safe.sample.app.prt;

import br.ufc.mdcc.pargo.safe.framework.port.HShelfProvidesPort;
import br.ufc.safe.sample.app.ApplicationSample;

public class AppRequestMessageEnvPort extends HShelfProvidesPort {

	
	public void requestMessage(){
		((ApplicationSample)this.getParentComponent()).requestMessage();	
	}
}

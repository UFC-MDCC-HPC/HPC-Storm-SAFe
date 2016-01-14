package br.ufc.safe.sample.app.prt;

import br.ufc.mdcc.pargo.safe.framework.port.HShelfProvidesPort;
import br.ufc.safe.sample.app.ApplicationSample;

public class AppReturnMessageEnvPort extends HShelfProvidesPort{
	
	public void returnMessage(String message){
		((ApplicationSample)this.getParentComponent()).returnMessage(message);
	}
}

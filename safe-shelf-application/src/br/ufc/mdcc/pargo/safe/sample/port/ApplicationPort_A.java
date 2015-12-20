package br.ufc.mdcc.pargo.safe.sample.port;

import br.ufc.mdcc.pargo.safe.framework.port.HShelfProvidesPort;
import br.ufc.mdcc.pargo.safe.sample.application.ClientServerApplication;

public class ApplicationPort_A extends HShelfProvidesPort{


	
	public void requestMessage(){
		ClientServerApplication application = (ClientServerApplication)this.getParentComponent();
		application.requestMessage();
	}
	public void sendMessage(String message){
		ClientServerApplication application = (ClientServerApplication)this.getParentComponent();
		application.sendMessage(message);
	}
}

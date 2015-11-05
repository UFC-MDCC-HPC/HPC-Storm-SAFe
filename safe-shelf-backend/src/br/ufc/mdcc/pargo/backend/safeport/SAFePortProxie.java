package br.ufc.mdcc.pargo.backend.safeport;

import br.ufc.mdcc.pargo.backend.safeport.stubs.ClientServerApplicationServiceImplService;
import br.ufc.mdcc.pargo.backend.safeport.stubs.IClientServerApplicationService;

public class SAFePortProxie {

	public void requestMessage(){
		ClientServerApplicationServiceImplService service = new ClientServerApplicationServiceImplService();
		IClientServerApplicationService port = service.getClientServerApplicationServiceImplPort();
		port.requestMessage();
	}
	
	public void sendMessage(String message){
		ClientServerApplicationServiceImplService service = new ClientServerApplicationServiceImplService();
		IClientServerApplicationService port = service.getClientServerApplicationServiceImplPort();
		port.sendMessage(message);
	}
}

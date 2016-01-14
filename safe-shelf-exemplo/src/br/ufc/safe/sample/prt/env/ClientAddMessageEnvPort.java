package br.ufc.safe.sample.prt.env;

import br.ufc.mdcc.pargo.safe.framework.port.HShelfProvidesPort;
import br.ufc.safe.sample.stubs.client.env.ClientServiceEnvService;
import br.ufc.safe.sample.stubs.client.env.IClientServiceEnv;

public class ClientAddMessageEnvPort extends HShelfProvidesPort{

	public void addMessage(String message){
		ClientServiceEnvService service = new ClientServiceEnvService();
		IClientServiceEnv port = service.getClientServiceEnvPort();
		port.addMessage(message);
	}
}

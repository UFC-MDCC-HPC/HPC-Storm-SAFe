package br.ufc.mdcc.pargo.safe.backend.pc.client;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface="br.ufc.mdcc.pargo.safe.backend.pc.client.ServiceIClientEnv")
public class ServiceClientEnvImpl implements ServiceIClientEnv{

	private IClientProducer client;
	
	public ServiceClientEnvImpl(IClientProducer client) {
		this.client = client;
	}
	
	@Override
	@WebMethod
	public void sendMsg(String msg) {
		this.client.sendMsg(msg);
	}

}

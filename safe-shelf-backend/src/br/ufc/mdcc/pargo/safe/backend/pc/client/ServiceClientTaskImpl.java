package br.ufc.mdcc.pargo.safe.backend.pc.client;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface="br.ufc.mdcc.pargo.safe.backend.pc.client.ServiceIClientTask")
public class ServiceClientTaskImpl implements ServiceIClientTask{

	private IClientProducer client;
	
	public ServiceClientTaskImpl(IClientProducer client) {
		this.client = client;
	}
	
	@Override
	@WebMethod
	public void setServerPort(Integer port) {
		client.setServerPort(port);
		
	}

	@Override
	@WebMethod
	public void initialize() {
		client.initialize();
	}

}

package br.ufc.mdcc.pargo.backend.client.port.tsk;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.ufc.mdcc.pargo.backend.client.IClientBackend;

@WebService(endpointInterface="br.ufc.mdcc.pargo.backend.client.port.tsk.IServiceClientTask")
public class ServiceClientTaskImpl implements IServiceClientTask{

	private IClientBackend client;
	
	public ServiceClientTaskImpl(IClientBackend client) {
		this.client = client;
	}
	
	@Override
	@WebMethod
	public void connect() {
		this.client.connect();
	}

	@Override
	@WebMethod
	public void post() {
		this.client.requestMessage();
	}

	

	

}

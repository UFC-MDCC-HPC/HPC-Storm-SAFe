package br.ufc.mdcc.pargo.backend.client.port.env;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.ufc.mdcc.pargo.backend.client.IClientBackend;

@WebService(endpointInterface="br.ufc.mdcc.pargo.backend.client.port.env.IServiceClientEnv")
public class ServiceClientEnvImpl implements IServiceClientEnv{

	private IClientBackend client;
	
	public ServiceClientEnvImpl(IClientBackend client) {
		this.client = client;
	}
	
	@Override
	@WebMethod
	public void setServerPort(Integer port) {
		this.client.setServerPort(port);
	}

	@Override
	public void addMesssageToBuffer(String message) {
		this.client.addMesssageToBuffer(message);
		
	}
 
}

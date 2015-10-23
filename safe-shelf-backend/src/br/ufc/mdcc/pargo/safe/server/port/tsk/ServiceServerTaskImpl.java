package br.ufc.mdcc.pargo.safe.server.port.tsk;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.ufc.mdcc.pargo.safe.server.IServerBackend;

@WebService(endpointInterface="br.ufc.mdcc.pargo.safe.server.port.tsk.IServiceServerTask")
public class ServiceServerTaskImpl implements IServiceServerTask{

	private IServerBackend server;
	
	public ServiceServerTaskImpl(IServerBackend server) {
		this.server = server;
	}
	
	@Override
	@WebMethod
	public void connect() {
		this.server.connect();
		
	}

	
}

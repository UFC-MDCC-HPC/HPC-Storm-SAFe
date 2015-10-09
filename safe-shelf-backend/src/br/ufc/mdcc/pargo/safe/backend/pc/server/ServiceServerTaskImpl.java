package br.ufc.mdcc.pargo.safe.backend.pc.server;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface="br.ufc.mdcc.pargo.safe.backend.pc.server.ServiceIServerTask")
public class ServiceServerTaskImpl implements ServiceIServerTask{

	private IServerConsumer server;
	
	public ServiceServerTaskImpl(IServerConsumer server) {
		this.server = server;
	}
	
	@Override
	@WebMethod
	public void setPort(Integer port) {
		this.server.setPort(port);
	}

	@Override
	@WebMethod
	public void initialize() {
		this.server.initialize();
	}

}

package br.ufc.mdcc.pargo.safe.backend.pc.server;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface="br.ufc.mdcc.pargo.safe.backend.pc.server.ServiceIServerEnv")
public class ServiceServerEnvImpl implements ServiceIServerEnv{

	private IServerConsumer server;
	
	public ServiceServerEnvImpl(IServerConsumer server) {
		this.server = server;
	}
	
	@Override
	@WebMethod
	public String getMsg() {
		 return this.server.getMsg();
	}

}

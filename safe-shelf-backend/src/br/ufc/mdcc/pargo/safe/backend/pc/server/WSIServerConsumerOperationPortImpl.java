package br.ufc.mdcc.pargo.safe.backend.pc.server;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface="br.ufc.mdcc.pargo.safe.backend.pc.server.WSIServerConsumerOperationPort")
public class WSIServerConsumerOperationPortImpl implements WSIServerConsumerOperationPort{

	IServerConsumer server;
	
	public WSIServerConsumerOperationPortImpl(IServerConsumer server) {
		this.server = server;
	}

	@Override
	@WebMethod
	public void setPort(Integer port) {
		this.server.setPort(port);
		
	}

	@Override
	@WebMethod
	public String getMsg() {
		return this.server.getMsg();
	}
}

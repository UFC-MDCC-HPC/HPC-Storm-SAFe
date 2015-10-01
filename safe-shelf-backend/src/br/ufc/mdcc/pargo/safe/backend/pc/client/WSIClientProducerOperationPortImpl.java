package br.ufc.mdcc.pargo.safe.backend.pc.client;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface="br.ufc.mdcc.pargo.safe.backend.pc.client.WSIClientProducerOperationPort")
public class WSIClientProducerOperationPortImpl implements WSIClientProducerOperationPort{

	private IClientProducer client;
	
	public WSIClientProducerOperationPortImpl(IClientProducer client) {
		this.client = client;
	}
	
	@Override
	@WebMethod
	public void setServerPort(Integer port) {
		this.client.setServerPort(port);
		
	}

	@Override
	@WebMethod
	public void sendMsg(String msg) {
		this.client.sendMsg(msg);
		
	}

}

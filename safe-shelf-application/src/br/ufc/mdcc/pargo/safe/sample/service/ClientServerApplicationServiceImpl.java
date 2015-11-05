package br.ufc.mdcc.pargo.safe.sample.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.ufc.mdcc.pargo.safe.sample.port.ClientServerApplicationPort;

@WebService(endpointInterface="br.ufc.mdcc.pargo.safe.sample.service.IClientServerApplicationService")
public class ClientServerApplicationServiceImpl implements IClientServerApplicationService{

	private ClientServerApplicationPort appPort;
	
	public void setApplicationPort(ClientServerApplicationPort appPort){
		this.appPort = appPort;
	}
	
	@Override
	@WebMethod
	public void requestMessage() {
		this.appPort.requestMessage();
	}

	@Override
	@WebMethod
	public void sendMessage(String message) {
		this.appPort.sendMessage(message);	
	}

}

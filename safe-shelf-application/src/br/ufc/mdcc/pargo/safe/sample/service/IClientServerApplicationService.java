package br.ufc.mdcc.pargo.safe.sample.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.ufc.mdcc.pargo.safe.sample.port.ClientServerApplicationPort;

@WebService
public interface IClientServerApplicationService {

	public void setApplicationPort(ClientServerApplicationPort appPort);
	@WebMethod
	public void requestMessage();
	@WebMethod
	public void sendMessage(String message);
}

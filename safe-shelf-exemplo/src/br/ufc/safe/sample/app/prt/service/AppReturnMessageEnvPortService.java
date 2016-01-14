package br.ufc.safe.sample.app.prt.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.ufc.safe.sample.app.prt.AppReturnMessageEnvPort;

@WebService(endpointInterface="br.ufc.safe.sample.app.prt.service.IAppReturnMessageEnvPortService")
public class AppReturnMessageEnvPortService implements IAppReturnMessageEnvPortService{

	private AppReturnMessageEnvPort appReturnMessageEnvPort;
	
	public AppReturnMessageEnvPortService(AppReturnMessageEnvPort appReturnMessageEnvPort) {
		this.appReturnMessageEnvPort = appReturnMessageEnvPort;
	}
	
	@Override
	@WebMethod
	public void returnMessage(String message) {
		this.appReturnMessageEnvPort.returnMessage(message);
		
	}

}

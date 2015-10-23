package br.ufc.mdcc.pargo.backend.client.port.env;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IServiceClientEnv {
	
	@WebMethod
	public void setServerPort(Integer port);
	@WebMethod
	public void addMesssageToBuffer(String message);
	
	public void requestMessage();
}

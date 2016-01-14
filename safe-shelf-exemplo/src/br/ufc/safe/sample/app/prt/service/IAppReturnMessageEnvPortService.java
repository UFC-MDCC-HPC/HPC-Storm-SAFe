package br.ufc.safe.sample.app.prt.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IAppReturnMessageEnvPortService {

	@WebMethod
	public void returnMessage(String message);
}

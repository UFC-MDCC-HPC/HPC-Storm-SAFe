package br.ufc.safe.sample.app.prt.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IAppRequestMessageEnvPortService {

	@WebMethod
	public void requestMessage();
}

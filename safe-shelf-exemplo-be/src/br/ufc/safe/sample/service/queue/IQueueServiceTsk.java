package br.ufc.safe.sample.service.queue;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IQueueServiceTsk {

	@WebMethod
	public void go();
}

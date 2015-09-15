package br.ufc.mdcc.pargo.safe.application.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IHPCStormApplicationServer {

	@WebMethod
	public void setSAFeSWLArchSource(String source, String fileName);
	@WebMethod
	public void setSAFeSWLFlowSource(String source, String fileName);
	@WebMethod
	public void run();
}
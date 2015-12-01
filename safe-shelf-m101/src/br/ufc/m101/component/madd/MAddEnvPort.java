package br.ufc.m101.component.madd;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface MAddEnvPort {

	@WebMethod
	public void setParams(String params);
}

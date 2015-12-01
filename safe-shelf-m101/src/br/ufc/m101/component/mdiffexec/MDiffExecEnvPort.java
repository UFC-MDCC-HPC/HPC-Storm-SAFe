package br.ufc.m101.component.mdiffexec;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface MDiffExecEnvPort {

	@WebMethod
	public void setParams(String params);
}

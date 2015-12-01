package br.ufc.m101.component.mprojexec;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface MProjExecEnvPort {

	@WebMethod
	public void setParams(String params);
}

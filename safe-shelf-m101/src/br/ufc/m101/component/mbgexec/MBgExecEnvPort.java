package br.ufc.m101.component.mbgexec;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface MBgExecEnvPort {

	@WebMethod
	public void setParams(String params);
}

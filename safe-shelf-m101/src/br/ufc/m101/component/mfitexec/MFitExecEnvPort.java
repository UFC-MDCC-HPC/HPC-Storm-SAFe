package br.ufc.m101.component.mfitexec;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface MFitExecEnvPort {

	@WebMethod
	public void setParams(String params);
}

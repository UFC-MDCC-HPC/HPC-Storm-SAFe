package br.ufc.m101.component.mbgmodel;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface MBgModelEnvPort {

	@WebMethod
	public void setParams(String params);
}

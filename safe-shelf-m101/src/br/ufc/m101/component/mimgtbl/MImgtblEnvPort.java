package br.ufc.m101.component.mimgtbl;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface MImgtblEnvPort {

	@WebMethod
	public void setParams(String params);
}

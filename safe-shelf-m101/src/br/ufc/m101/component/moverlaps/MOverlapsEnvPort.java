package br.ufc.m101.component.moverlaps;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface MOverlapsEnvPort {

	@WebMethod
	public void setParams(String params);
}

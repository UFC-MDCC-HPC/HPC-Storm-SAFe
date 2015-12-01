package br.ufc.m101.component.mprojexec;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface MProjExecTskPort {

	@WebMethod
	public void go();
}

package br.ufc.m101.component.mdiffexec;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface MDiffExecTskPort {

	@WebMethod
	public void go();
}

package br.ufc.m101.component.mfitexec;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface MFitExecTskPort {

	@WebMethod
	public void go();
}

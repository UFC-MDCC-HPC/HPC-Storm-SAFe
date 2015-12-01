package br.ufc.m101.component.mprojexec;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "br.ufc.m101.component.mprojexec.MProjExecTskPort")
public class MProjExecPortImpl implements MProjExecTskPort {

	private MProjExec mProjExec;
	
	public void setMProjExec(MProjExec mProjExec){
		this.mProjExec = mProjExec;
	}

	@WebMethod
	public void go() {
		this.mProjExec.go();
	}
}

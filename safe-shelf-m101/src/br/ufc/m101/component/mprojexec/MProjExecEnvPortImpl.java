package br.ufc.m101.component.mprojexec;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface="br.ufc.m101.component.mprojexec.MProjExecEnvPort")
public class MProjExecEnvPortImpl implements MProjExecEnvPort{

	private MProjExec mProjExec;
	
	public void setMProjExec(MProjExec mProjExec){
		this.mProjExec = mProjExec;
	}
	
	@WebMethod
	public void setParams(String params){
		this.mProjExec.setParams(params);
	}
}

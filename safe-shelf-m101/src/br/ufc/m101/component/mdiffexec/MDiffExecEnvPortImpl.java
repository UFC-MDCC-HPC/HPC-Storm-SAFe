package br.ufc.m101.component.mdiffexec;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface="br.ufc.m101.component.mdiffexec.MDiffExecEnvPort")
public class MDiffExecEnvPortImpl implements MDiffExecEnvPort{

	private MDiffExec mDiffExec;
	
	public void setMDiffExec(MDiffExec mDiffExec){
		this.mDiffExec = mDiffExec;
	}
	
	@WebMethod
	public void setParams(String params){
		this.mDiffExec.setParams(params);
	}
}

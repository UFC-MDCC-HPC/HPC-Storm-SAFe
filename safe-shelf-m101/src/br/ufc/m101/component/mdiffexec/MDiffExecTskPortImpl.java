package br.ufc.m101.component.mdiffexec;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface="br.ufc.m101.component.mdiffexec.MDiffExecTskPort")
public class MDiffExecTskPortImpl implements MDiffExecTskPort{

private MDiffExec mDiffExec;
	
	public void setMDiffExec(MDiffExec mDiffExec){
		this.mDiffExec = mDiffExec;
	}
	
	@WebMethod
	public void go(){
		this.mDiffExec.go();
	}
}

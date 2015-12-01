package br.ufc.m101.component.mfitexec;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface="br.ufc.m101.component.mfitexec.MFitExecEnvPort")
public class MFitExecEnvPortImpl implements MFitExecEnvPort{

	private MFitExec mFitExec;
	
	public void setMFitExec(MFitExec mFitExec){
		this.mFitExec = mFitExec;
	}
	
	@WebMethod
	public void setParams(String params){
		this.mFitExec.setParams(params);
	}
}

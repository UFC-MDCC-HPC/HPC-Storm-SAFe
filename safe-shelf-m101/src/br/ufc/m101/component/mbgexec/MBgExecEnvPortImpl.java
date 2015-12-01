package br.ufc.m101.component.mbgexec;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface="br.ufc.m101.component.mbgexec.MBgExecEnvPort")
public class MBgExecEnvPortImpl implements MBgExecEnvPort{

	private MBgExec mBgExec;
	
	public void setMBgExec(MBgExec mBgExec){
		this.mBgExec = mBgExec;
	}
	
	@WebMethod
	public void setParams(String params){
		this.mBgExec.setParams(params);
	}
}

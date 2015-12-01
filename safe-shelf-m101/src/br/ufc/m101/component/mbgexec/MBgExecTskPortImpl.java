package br.ufc.m101.component.mbgexec;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "br.ufc.m101.component.mbgexec.MBgExecTskPortImpl")
public class MBgExecTskPortImpl implements MBgExecTskPort{

	private MBgExec mBgExec;

	public void setMBgExec(MBgExec mBgExec) {
		this.mBgExec = mBgExec;
	}

	@WebMethod
	public void go() {
		this.mBgExec.go();
	}
}

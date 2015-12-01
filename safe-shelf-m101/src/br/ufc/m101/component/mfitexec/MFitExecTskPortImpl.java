package br.ufc.m101.component.mfitexec;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "br.ufc.m101.component.mfitexec.MFitExecTskPort")
public class MFitExecTskPortImpl implements MFitExecTskPort {

	private MFitExec mFitExec;

	public void setMFitExec(MFitExec mFitExec) {
		this.mFitExec = mFitExec;
	}

	@WebMethod
	public void go() {
		this.mFitExec.go();
	}
}

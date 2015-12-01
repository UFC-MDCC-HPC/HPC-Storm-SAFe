package br.ufc.m101.component.mfitexec;

import javax.xml.ws.Endpoint;

public class MFitExecStartPorts {

	public void start(){
		MFitExec mFitExec = new MFitExec();
		
		MFitExecEnvPort mFitExecEnvPort = new MFitExecEnvPortImpl();
		((MFitExecEnvPortImpl)mFitExecEnvPort).setMFitExec(mFitExec);
		String urlEnv = "http://localhost:11408/mfitexec-env";
		
		MFitExecTskPort mFitExecTskPort = new MFitExecTskPortImpl();
		((MFitExecTskPortImpl)mFitExecTskPort).setMFitExec(mFitExec);
		String urlTsk = "http://localhost:11409/mfitexec-tsk";
		
		Endpoint.publish(urlEnv, mFitExecEnvPort);
		System.out.println(urlEnv);
		Endpoint.publish(urlTsk, mFitExecTskPort);
		System.out.println(urlTsk);
	}
	
	public static void main(String[] args) {
		new MFitExecStartPorts().start();
	}
}

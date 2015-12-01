package br.ufc.m101.component.mdiffexec;

import javax.xml.ws.Endpoint;

public class MDiffExecStartPorts {

	public void start(){
		MDiffExec mDiffExec = new MDiffExec();
		
		MDiffExecEnvPort mDiffExecEnvPort = new MDiffExecEnvPortImpl();
		((MDiffExecEnvPortImpl)mDiffExecEnvPort).setMDiffExec(mDiffExec);
		String urlEnv = "http://localhost:11406/mdiffexec-env";
		
		MDiffExecTskPort mDiffExecTskPort = new MDiffExecTskPortImpl();
		((MDiffExecTskPortImpl)mDiffExecTskPort).setMDiffExec(mDiffExec);
		String urlTsk = "http://localhost:11407/mdiffexec-tsk";
		
		Endpoint.publish(urlEnv, mDiffExecEnvPort);
		System.out.println(urlEnv);
		Endpoint.publish(urlTsk, mDiffExecTskPort);
		System.out.println(urlTsk);
	}
	
	public static void main(String[] args) {
		new MDiffExecStartPorts().start();
	}
}

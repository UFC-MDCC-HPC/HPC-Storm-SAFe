package br.ufc.m101.component.mprojexec;

import javax.xml.ws.Endpoint;

public class MProjExecStartPorts {

	public void start(){
		MProjExec mprojexec = new MProjExec();
		
		MProjExecEnvPort mProjExecEnvPort = new MProjExecEnvPortImpl();
		((MProjExecEnvPortImpl)mProjExecEnvPort).setMProjExec(mprojexec);
		String urlEnv = "http://localhost:11416/mprojexec-env";
		
		MProjExecTskPort mProjExecTskPort = new MProjExecPortImpl();
		((MProjExecPortImpl)mProjExecTskPort).setMProjExec(mprojexec);
		String urlTsk = "http://localhost:11417/mprojexec-tsk";
		
		Endpoint.publish(urlEnv, mProjExecEnvPort);
		System.out.println(urlEnv);
		Endpoint.publish(urlTsk, mProjExecTskPort);
		System.out.println(urlTsk);
	}
	
	public static void main(String[] args) {
		new MProjExecStartPorts().start();
	}
}

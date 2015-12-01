package br.ufc.m101.component.mbgexec;

import javax.xml.ws.Endpoint;

public class MBgExecStartPorts {

	public void start(){
		MBgExec mBgExec = new MBgExec();
		
		MBgExecEnvPort mBgExecEnvPort = new MBgExecEnvPortImpl();
		((MBgExecEnvPortImpl)mBgExecEnvPort).setMBgExec(mBgExec);
		String urlEnv = "http://localhost:11402/mbgexec-env";
		
		MBgExecTskPort mBgExecTskPort = new MBgExecTskPortImpl();
		((MBgExecTskPortImpl)mBgExecTskPort).setMBgExec(mBgExec);
		String urlTsk = "http://localhost:11403/mbgexec-tsk";
		
		Endpoint.publish(urlEnv, mBgExecEnvPort);
		System.out.println(urlEnv);
		Endpoint.publish(urlTsk, mBgExecTskPort);
		System.out.println(urlTsk);
	}
	
	public static void main(String[] args) {
		new MBgExecStartPorts().start();
	}
}

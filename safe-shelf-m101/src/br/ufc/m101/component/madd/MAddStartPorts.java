package br.ufc.m101.component.madd;

import javax.xml.ws.Endpoint;

public class MAddStartPorts {

	public void start(){
		MAdd mAdd = new MAdd();
		MAddEnvPort mAddEnvPort = new MAddEnvPortImpl();
		((MAddEnvPortImpl)mAddEnvPort).setMAdd(mAdd);
		String urlEnv = "http://localhost:11400/madd-env";
		
		MAddTskPort mAddTskPort = new MAddTskPortImpl();
		((MAddTskPortImpl)mAddTskPort).setMAdd(mAdd);
		String urlTsk = "http://localhost:11401/madd-tsk";
		
		Endpoint.publish(urlEnv, mAddEnvPort);
		System.out.println(urlEnv);
		Endpoint.publish(urlTsk, mAddTskPort);
		System.out.println(urlTsk);
	}
	
	public static void main(String[] args) {
		new MAddStartPorts().start();
	}
}

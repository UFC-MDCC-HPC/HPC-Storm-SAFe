package br.ufc.m101.component.mimgtbl;

import javax.xml.ws.Endpoint;

public class MImgtblStartPorts {

	public void start(){
		MImgtbl mImgtbl = new MImgtbl();
		
		MImgtblEnvPort mImgtblEnvPort = new MImgtblEnvPortImpl();
		((MImgtblEnvPortImpl)mImgtblEnvPort).setMImgtbl(mImgtbl);
		String urlEnv = "http://localhost:11410/mimgtbl-env";
		
		MImgtblTskPort mImgtblTskPort = new MImgtblTskPortImpl();
		((MImgtblTskPortImpl)mImgtblTskPort).setMImgtbl(mImgtbl);
		String urlTsk = "http://localhost:11411/mimgtbl-tsk";
		
		Endpoint.publish(urlEnv, mImgtblEnvPort);
		System.out.println(urlEnv);
		Endpoint.publish(urlTsk, mImgtblTskPort);
		System.out.println(urlTsk);
	}
	
	public static void main(String[] args) {
		new MImgtblStartPorts().start();
	}
}

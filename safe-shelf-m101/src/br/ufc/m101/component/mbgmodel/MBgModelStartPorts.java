package br.ufc.m101.component.mbgmodel;

import javax.xml.ws.Endpoint;

public class MBgModelStartPorts {

	public void start(){
		MBgModel mBgModel = new MBgModel();
		
		MBgModelEnvPort mBgModelEnvPort = new MBgModelEnvPortImpl();
		((MBgModelEnvPortImpl)mBgModelEnvPort).setMBgModel(mBgModel);
		String urlEnv = "http://localhost:11404/mbgmodel-env";
		
		MBgModelTskPort mBgModelTskPort = new MBgModelTskPortImpl();
		((MBgModelTskPortImpl)mBgModelTskPort).setMBgModel(mBgModel);
		String urlTsk = "http://localhost:11405/mbgmodel-tsk";
		
		Endpoint.publish(urlEnv, mBgModelEnvPort);
		System.out.println(urlEnv);
		Endpoint.publish(urlTsk, mBgModelTskPort);
		System.out.println(urlTsk);
	}
	
	public static void main(String[] args) {
		new MBgModelStartPorts().start();
	}
}

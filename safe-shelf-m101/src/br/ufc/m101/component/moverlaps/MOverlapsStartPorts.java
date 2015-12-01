package br.ufc.m101.component.moverlaps;

import javax.xml.ws.Endpoint;

public class MOverlapsStartPorts {

	public void start(){
		MOverlaps mOverlaps = new MOverlaps();
		
		MOverlapsEnvPort mOverlapsEnvPort = new MOverlapsEnvPortImpl();
		((MOverlapsEnvPortImpl)mOverlapsEnvPort).setMOverlaps(mOverlaps);
		String urlEnv = "http://localhost:11414/moverlaps-env";
		
		MOverlapsTskPort mOverlapsTskPort = new MOverlapsTskPortImpl();
		((MOverlapsTskPortImpl)mOverlapsTskPort).setMOverlaps(mOverlaps);
		String urlTsk = "http://localhost:11415/moverlaps-tsk";
		
		Endpoint.publish(urlEnv, mOverlapsEnvPort);
		System.out.println(urlEnv);
		Endpoint.publish(urlTsk, mOverlapsTskPort);
		System.out.println(urlTsk);
	}
	
	public static void main(String[] args) {
		new MOverlapsStartPorts().start();
	}
}

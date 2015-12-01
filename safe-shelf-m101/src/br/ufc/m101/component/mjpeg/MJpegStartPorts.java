package br.ufc.m101.component.mjpeg;

import javax.xml.ws.Endpoint;

public class MJpegStartPorts {

	public void start(){
		MJpeg mJpeg = new MJpeg();
		
		MJpegEnvPort mJpegEnvPort = new MJpegEnvPortImpl();
		((MJpegEnvPortImpl)mJpegEnvPort).setMJpeg(mJpeg);
		String urlEnv = "http://localhost:11412/mjpeg-env";
		
		MJpegTskPort mJpegTskPort = new MJpegTskPortImpl();
		((MJpegTskPortImpl)mJpegTskPort).setMJpeg(mJpeg);
		String urlTsk = "http://localhost:11413/mjpeg-tsk";
		
		Endpoint.publish(urlEnv, mJpegEnvPort);
		System.out.println(urlEnv);
		Endpoint.publish(urlTsk, mJpegTskPort);
		System.out.println(urlTsk);
	}
	
	public static void main(String[] args) {
		new MJpegStartPorts().start();
	}
}

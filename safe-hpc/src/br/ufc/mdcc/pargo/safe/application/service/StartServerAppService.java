package br.ufc.mdcc.pargo.safe.application.service;

import javax.xml.ws.Endpoint;

public class StartServerAppService {

	public static void main(String[] args) {
		IHPCStormApplicationServer server = new HPCStormApplicationServerImpl();
		String url = "http://localhost:10100/appserver-ws";
		Endpoint.publish(url, server);
		System.out.println("App server is up in: "+url);
	}
}

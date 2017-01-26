package br.ufc.mdcc.pargo.safe.framework.fcore.server;

import javax.xml.ws.Endpoint;

public class CorePublisher {

	public static void main(String[] args) {
		
		final String url = "http://localhost:8888/core";
		System.out.println("Core is up and running at: "+url);
		Endpoint.publish(url, new ShelfCoreImpl());
	}
}

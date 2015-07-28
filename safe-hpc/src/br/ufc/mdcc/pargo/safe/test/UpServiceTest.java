package br.ufc.mdcc.pargo.safe.test;

import javax.xml.ws.Endpoint;

import br.ufc.mdcc.pargo.safe.port.IHPCStormEnvProvidesPort;
import br.ufc.mdcc.pargo.safe.port.predef.SAFeSWLProvidesPort;

public class UpServiceTest {

	public static void main(String[] args) {
		IHPCStormEnvProvidesPort service = new SAFeSWLProvidesPort();
		
		int port = 8888;
		String host = "http://localhost";
		
		final String url = host+":"+port+"/"+service.getName();
		Endpoint.publish(url, service);
		System.out.println(url);
	}
}

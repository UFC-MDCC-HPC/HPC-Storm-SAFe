package br.ufc.mdcc.pargo.safe.backend.pc.client;

import javax.xml.ws.Endpoint;

public class StartClientProducerWS {

	public static void main(String[] args) {
		IClientProducer client = new ClientProducer();
		
		String urlGo = "http://localhost:10004/client-go";
		String urlOperations = "http://localhost:10005/client-operation";
		
		WSIClientProducerGoPort go = new WSIClientProducerGoPortImpl(client);
		WSIClientProducerOperationPort operation = new WSIClientProducerOperationPortImpl(client);
		
		Endpoint.publish(urlGo, go);
		Endpoint.publish(urlOperations, operation);
		System.out.println(urlGo);
		System.out.println(urlOperations);
	}
}

package br.ufc.mdcc.pargo.safe.backend.pc.server;

import javax.xml.ws.Endpoint;

public class StartServerConsumerWS {

	public static void main(String[] args) {
		IServerConsumer server = new ServerConsumer();
		
		String urlGo = "http://localhost:10002/server-go";
		String urlOperations = "http://localhost:10003/server-operation";
		
		WSIServerConsumerGoPort goPortWS = new WSIServerConsumerGoPortImpl(server);
		WSIServerConsumerOperationPort operationPort = new WSIServerConsumerOperationPortImpl(server);
		Endpoint.publish(urlGo, goPortWS);
		Endpoint.publish(urlOperations, operationPort);
		System.out.println(urlGo);
		System.out.println(urlOperations);
	}
}

package br.ufc.mdcc.pargo.safe.backend.pc.client;

import javax.xml.ws.Endpoint;

public class StartClientProducerWS {

	public static void main(String[] args) {
		IClientProducer client = new ClientProducer();
		
		String urlTask = "http://localhost:10004/client-task";
		String urlEnv = "http://localhost:10005/client-env";
		
		ServiceIClientEnv env = new ServiceClientEnvImpl(client);
		ServiceIClientTask task = new ServiceClientTaskImpl(client);
		
		Endpoint.publish(urlTask, task);
		Endpoint.publish(urlEnv, env);
		System.out.println(urlTask);
		System.out.println(urlEnv);
	}
}

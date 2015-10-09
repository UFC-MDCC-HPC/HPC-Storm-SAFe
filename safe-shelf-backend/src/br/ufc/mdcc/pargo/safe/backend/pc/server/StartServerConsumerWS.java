package br.ufc.mdcc.pargo.safe.backend.pc.server;

import javax.xml.ws.Endpoint;

public class StartServerConsumerWS {

	public static void main(String[] args) {
		IServerConsumer server = new ServerConsumer();
		
		String urlTask = "http://localhost:10002/server-task";
		String urlEnv = "http://localhost:10003/server-env";
		
		ServiceIServerTask task = new ServiceServerTaskImpl(server);
		ServiceIServerEnv env = new ServiceServerEnvImpl(server);
		
		
		Endpoint.publish(urlTask, task);
		Endpoint.publish(urlEnv, env);
		System.out.println(urlTask);
		System.out.println(urlEnv);
	}
}

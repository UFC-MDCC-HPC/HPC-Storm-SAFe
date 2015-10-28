package br.ufc.mdcc.pargo.backend.client.port;

import javax.xml.ws.Endpoint;

import br.ufc.mdcc.pargo.backend.client.ClientBackend;
import br.ufc.mdcc.pargo.backend.client.IClientBackend;
import br.ufc.mdcc.pargo.backend.client.port.env.IServiceClientEnv;
import br.ufc.mdcc.pargo.backend.client.port.env.ServiceClientEnvImpl;
import br.ufc.mdcc.pargo.backend.client.port.tsk.IServiceClientTask;
import br.ufc.mdcc.pargo.backend.client.port.tsk.ServiceClientTaskImpl;

public class StartClientPorts {

	public StartClientPorts() {
		IClientBackend client = new ClientBackend(null);
		
		String urlTask = "http://localhost:10004/client-task";
		String urlEnv = "http://localhost:10005/client-env";
		
		IServiceClientEnv env = new ServiceClientEnvImpl(client);
		IServiceClientTask tsk = new ServiceClientTaskImpl(client);
		
		Endpoint.publish(urlTask, tsk);
		Endpoint.publish(urlEnv, env);
		System.out.println(urlTask);
		System.out.println(urlEnv);
	}
	
	public static void main(String[] args) {
		new StartClientPorts();
	}
}

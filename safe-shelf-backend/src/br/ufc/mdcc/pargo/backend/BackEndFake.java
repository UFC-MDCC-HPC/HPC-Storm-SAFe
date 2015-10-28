package br.ufc.mdcc.pargo.backend;

import javax.xml.ws.Endpoint;

import br.ufc.mdcc.pargo.backend.client.ClientBackend;
import br.ufc.mdcc.pargo.backend.client.IClientBackend;
import br.ufc.mdcc.pargo.backend.client.port.env.IServiceClientEnv;
import br.ufc.mdcc.pargo.backend.client.port.env.ServiceClientEnvImpl;
import br.ufc.mdcc.pargo.backend.client.port.tsk.IServiceClientTask;
import br.ufc.mdcc.pargo.backend.client.port.tsk.ServiceClientTaskImpl;
import br.ufc.mdcc.pargo.backend.connector.TCPBinding;
import br.ufc.mdcc.pargo.safe.server.IServerBackend;
import br.ufc.mdcc.pargo.safe.server.ServerBackend;
import br.ufc.mdcc.pargo.safe.server.port.env.IServiceServerEnv;
import br.ufc.mdcc.pargo.safe.server.port.env.ServiceServerEnvImpl;
import br.ufc.mdcc.pargo.safe.server.port.tsk.IServiceServerTask;
import br.ufc.mdcc.pargo.safe.server.port.tsk.ServiceServerTaskImpl;

public class BackEndFake {

	public void startAll(){
		TCPBinding tcpBindingC = new TCPBinding();
		TCPBinding tcpBindingS = new TCPBinding();
		this.startClientPorts(tcpBindingC);
		this.startServerPorts(tcpBindingS);
	}
	
	public void startClientPorts(TCPBinding tcpBinding) {
		IClientBackend client = new ClientBackend(tcpBinding);
		
		String urlTask = "http://localhost:10004/client-task";
		String urlEnv = "http://localhost:10005/client-env";
		
		IServiceClientEnv env = new ServiceClientEnvImpl(client);
		IServiceClientTask tsk = new ServiceClientTaskImpl(client);
		
		Endpoint.publish(urlTask, tsk);
		Endpoint.publish(urlEnv, env);
		System.out.println(urlTask);
		System.out.println(urlEnv);
	}
	
	public void startServerPorts(TCPBinding tcpBinding) {
		IServerBackend server = new ServerBackend(tcpBinding);
		tcpBinding.register_for_incoming_messages(server);
		
		String urlTask = "http://localhost:10002/server-task";
		String urlEnv = "http://localhost:10003/server-env";
		
		
		
		IServiceServerEnv env = new ServiceServerEnvImpl(server);
		IServiceServerTask tsk = new ServiceServerTaskImpl(server);
		
		Endpoint.publish(urlTask, tsk);
		Endpoint.publish(urlEnv, env);
		System.out.println(urlTask);
		System.out.println(urlEnv);
	}
	
	public static void main(String[] args) {
		new BackEndFake().startAll();
	}
}

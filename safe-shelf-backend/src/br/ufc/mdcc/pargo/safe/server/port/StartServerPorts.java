package br.ufc.mdcc.pargo.safe.server.port;

import javax.xml.ws.Endpoint;

import br.ufc.mdcc.pargo.safe.server.IServerBackend;
import br.ufc.mdcc.pargo.safe.server.ServerBackend;
import br.ufc.mdcc.pargo.safe.server.port.env.IServiceServerEnv;
import br.ufc.mdcc.pargo.safe.server.port.env.ServiceServerEnvImpl;
import br.ufc.mdcc.pargo.safe.server.port.tsk.IServiceServerTask;
import br.ufc.mdcc.pargo.safe.server.port.tsk.ServiceServerTaskImpl;

public class StartServerPorts {
	
	public StartServerPorts() {
		IServerBackend server = new ServerBackend();
		
		String urlTask = "http://localhost:10002/server-task";
		String urlEnv = "http://localhost:10003/server-env";
		
		
		
		IServiceServerEnv env = new ServiceServerEnvImpl(server);
		IServiceServerTask tsk = new ServiceServerTaskImpl(server);
		
		((ServerBackend)server).setEnv(env);
		((ServerBackend)server).setTsk(tsk);
		
		Endpoint.publish(urlTask, tsk);
		Endpoint.publish(urlEnv, env);
		System.out.println(urlTask);
		System.out.println(urlEnv);
	}

	public static void main(String[] args) {
		new StartServerPorts();
	}
}

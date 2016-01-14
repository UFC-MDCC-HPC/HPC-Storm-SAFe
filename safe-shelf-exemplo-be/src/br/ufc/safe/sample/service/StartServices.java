package br.ufc.safe.sample.service;

import javax.xml.ws.Endpoint;

import br.ufc.safe.sample.cmp.ClientBE;
import br.ufc.safe.sample.cmp.QueueBE;
import br.ufc.safe.sample.cmp.ServerBE;
import br.ufc.safe.sample.service.client.ClientServiceEnv;
import br.ufc.safe.sample.service.client.ClientServiceTsk;
import br.ufc.safe.sample.service.client.IClientServiceEnv;
import br.ufc.safe.sample.service.client.IClientServiceTsk;
import br.ufc.safe.sample.service.queue.IQueueServiceTsk;
import br.ufc.safe.sample.service.queue.QueueServiceTsk;
import br.ufc.safe.sample.service.server.IServerServiceTsk;
import br.ufc.safe.sample.service.server.ServerServiceTsk;

public class StartServices {

	public static void main(String[] args) {
		String clientEnv = "http://localhost:10004/client-env";
		String clientTsk = "http://localhost:10005/client-task";
		
		String queueTsk = "http://localhost:10006/queue-task";
		
		String serverTsk = "http://localhost:10007/server-task";
		
		QueueBE queueBE = new QueueBE();
		ClientBE clientBE = new ClientBE(queueBE);
		ServerBE serverBE = new ServerBE(queueBE);
		
		IClientServiceEnv cenv = new ClientServiceEnv(clientBE);
		IClientServiceTsk ctsk = new ClientServiceTsk(clientBE);
		IQueueServiceTsk qtsk = new QueueServiceTsk(queueBE);
		IServerServiceTsk stsk = new ServerServiceTsk(serverBE);
		
		Endpoint.publish(clientEnv, cenv);
		Endpoint.publish(clientTsk, ctsk);
		Endpoint.publish(queueTsk, qtsk);
		Endpoint.publish(serverTsk, stsk);
		
		System.out.println(clientEnv);
		System.out.println(clientTsk);
		System.out.println(queueTsk);
		System.out.println(serverTsk);
		
	}
}

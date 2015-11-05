package br.ufc.mdcc.pargo.safe.sample.test;

import br.ufc.mdcc.pargo.safe.sample.application.proxies.ClientEnvPortProxie;
import br.ufc.mdcc.pargo.safe.sample.application.proxies.ClientTaskPortProxie;
import br.ufc.mdcc.pargo.safe.sample.application.proxies.ServerEnvPortProxie;
import br.ufc.mdcc.pargo.safe.sample.application.proxies.ServerTaskPortProxie;

public class WebServiceTest {

	public static void main(String[] args) {
		ClientEnvPortProxie clientEnv = new ClientEnvPortProxie();
		ClientTaskPortProxie clientTask = new ClientTaskPortProxie();
		
		ServerEnvPortProxie serverEnv = new ServerEnvPortProxie();
		ServerTaskPortProxie serverTask = new ServerTaskPortProxie();
		
		System.out.println("Connect Client...");
		clientTask.connect();
		System.out.println("Connect Server");
		serverTask.connect();
		System.out.println("Set Server port");
		serverEnv.setPort(10100);
		System.out.println("Set Client port");
		clientEnv.setServerPort(10100);
		
		System.out.println("Set Client port");
	}
}

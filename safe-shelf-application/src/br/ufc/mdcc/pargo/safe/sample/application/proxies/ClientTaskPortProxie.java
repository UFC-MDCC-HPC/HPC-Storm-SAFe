package br.ufc.mdcc.pargo.safe.sample.application.proxies;

import java.net.MalformedURLException;
import java.net.URL;

import br.ufc.mdcc.pargo.safe.framework.port.HShelfPort;
import br.ufc.mdcc.pargo.safe.framework.session.HShelfSession;
import br.ufc.mdcc.pargo.safe.sample.stubs.client.task.IServiceClientTask;
import br.ufc.mdcc.pargo.safe.sample.stubs.client.task.ServiceClientTaskImplService;

public class ClientTaskPortProxie extends HShelfPort {

	private URL wsdl_url = null;

	public ClientTaskPortProxie() {

		try {
			wsdl_url = new URL(HShelfSession.getValue(this.getName()));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void connect() {
		ServiceClientTaskImplService service = new ServiceClientTaskImplService(wsdl_url);
		IServiceClientTask port = service.getServiceClientTaskImplPort();
		port.connect();
	}

	public void post() {
		ServiceClientTaskImplService service = new ServiceClientTaskImplService(wsdl_url);
		IServiceClientTask port = service.getServiceClientTaskImplPort();
		port.post();
	}

}

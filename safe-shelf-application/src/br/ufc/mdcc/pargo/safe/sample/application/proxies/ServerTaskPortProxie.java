package br.ufc.mdcc.pargo.safe.sample.application.proxies;

import java.net.MalformedURLException;
import java.net.URL;

import br.ufc.mdcc.pargo.safe.framework.port.HShelfPort;
import br.ufc.mdcc.pargo.safe.framework.session.HShelfSession;
import br.ufc.mdcc.pargo.safe.sample.stubs.server.task.IServiceServerTask;
import br.ufc.mdcc.pargo.safe.sample.stubs.server.task.ServiceServerTaskImplService;

public class ServerTaskPortProxie extends HShelfPort{
	
	private URL wsdl_url = null;

	public ServerTaskPortProxie() {

		try {
			wsdl_url = new URL(HShelfSession.getValue(this.getName()));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void connect(){
		ServiceServerTaskImplService service = new ServiceServerTaskImplService(wsdl_url);
		IServiceServerTask port = service.getServiceServerTaskImplPort();
		port.connect();
	}
 
}

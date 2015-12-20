package br.ufc.mdcc.pargo.safe.sample.application.proxies;

import java.net.MalformedURLException;
import java.net.URL;

import br.ufc.mdcc.pargo.safe.framework.port.HShelfTaskPort;
import br.ufc.mdcc.pargo.safe.framework.session.HShelfSession;
import br.ufc.mdcc.pargo.safe.sample.stubs.server.task.IServiceServerTask;
import br.ufc.mdcc.pargo.safe.sample.stubs.server.task.ServiceServerTaskImplService;

public class ServerTaskPortProxie extends HShelfTaskPort{
	
	public void connect(){
		ServiceServerTaskImplService service = new ServiceServerTaskImplService(this.createURL());
		IServiceServerTask port = service.getServiceServerTaskImplPort();
		port.connect();
	}
	
	private URL createURL(){
		URL wsdl_url = null;
		try {
			wsdl_url = new URL(HShelfSession.getValue(this.getName()));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wsdl_url;
	}
 
}

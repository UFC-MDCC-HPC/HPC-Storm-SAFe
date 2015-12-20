package br.ufc.mdcc.pargo.safe.sample.application.proxies;

import java.net.MalformedURLException;
import java.net.URL;

import br.ufc.mdcc.pargo.safe.framework.port.HShelfProvidesPort;
import br.ufc.mdcc.pargo.safe.framework.session.HShelfSession;
import br.ufc.mdcc.pargo.safe.sample.stubs.server.env.IServiceServerEnv;
import br.ufc.mdcc.pargo.safe.sample.stubs.server.env.ServiceServerEnvImplService;

public class ServerEnvPortProxie extends HShelfProvidesPort{
	
	
	public void setPort(Integer port){
		ServiceServerEnvImplService service = new ServiceServerEnvImplService(this.createURL());
		IServiceServerEnv portWS = service.getServiceServerEnvImplPort();
		portWS.setPort(port);
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

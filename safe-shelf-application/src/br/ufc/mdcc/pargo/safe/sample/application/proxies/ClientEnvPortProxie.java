package br.ufc.mdcc.pargo.safe.sample.application.proxies;

import java.net.MalformedURLException;
import java.net.URL;

import br.ufc.mdcc.pargo.safe.framework.port.HShelfPort;
import br.ufc.mdcc.pargo.safe.framework.session.HShelfSession;
import br.ufc.mdcc.pargo.safe.sample.stubs.client.env.IServiceClientEnv;
import br.ufc.mdcc.pargo.safe.sample.stubs.client.env.ServiceClientEnvImplService;

public class ClientEnvPortProxie extends HShelfPort{

	private URL wsdl_url = null;
	
	public ClientEnvPortProxie() {
		
		try {
			wsdl_url = new URL(HShelfSession.getValue(this.getName()));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setServerPort(Integer port){
		
		ServiceClientEnvImplService service = new ServiceClientEnvImplService(wsdl_url);
		IServiceClientEnv portWS = service.getServiceClientEnvImplPort();
		portWS.setServerPort(port);
	}
	
	public void addMesssageToBuffer(String message){
		ServiceClientEnvImplService service = new ServiceClientEnvImplService(wsdl_url);
		IServiceClientEnv portWS = service.getServiceClientEnvImplPort();
		portWS.addMesssageToBuffer(message);
	}
	 
	
}

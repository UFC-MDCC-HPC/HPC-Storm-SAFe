package br.ufc.mdcc.pargo.safe.server.port.env;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.ufc.mdcc.pargo.backend.app.stubs.ApplicationEnvPortImplService;
import br.ufc.mdcc.pargo.backend.app.stubs.IApplicationEnvPort;
import br.ufc.mdcc.pargo.safe.server.IServerBackend;

@WebService(endpointInterface="br.ufc.mdcc.pargo.safe.server.port.env.IServiceServerEnv")
public class ServiceServerEnvImpl implements IServiceServerEnv{

	private IServerBackend server;
	
	public ServiceServerEnvImpl(IServerBackend server) {
		this.server = server;
	}
	
	@Override
	@WebMethod
	public void setPort(Integer port) {
		this.server.setPort(port);
	}

	@Override
	public void sendMessageToApplication(String message) {
		ApplicationEnvPortImplService service = new ApplicationEnvPortImplService();
		IApplicationEnvPort port = service.getApplicationEnvPortImplPort();
		port.receiveMessage(message);
		
	}

	

}

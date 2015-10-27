package br.ufc.mdcc.pargo.backend.app.port;

import br.ufc.mdcc.pargo.backend.app.stubs.ApplicationEnvPortImplService;
import br.ufc.mdcc.pargo.backend.app.stubs.IApplicationEnvPort;

public class AppEnvPortImpl implements IAppEnvPort{

	@Override
	public void requestMessage() {
		ApplicationEnvPortImplService service = new ApplicationEnvPortImplService();
		IApplicationEnvPort port = service.getApplicationEnvPortImplPort();
		port.requestMessage();
	}

	@Override
	public void receiveMessage(String msg) {
		ApplicationEnvPortImplService service = new ApplicationEnvPortImplService();
		IApplicationEnvPort port = service.getApplicationEnvPortImplPort();
		port.receiveMessage(msg);
	}

}

package br.ufc.safe.sample.service.server;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.ufc.safe.sample.cmp.ServerBE;

@WebService
public class ServerServiceTsk implements IServerServiceTsk{

	private ServerBE serverBE;

	public ServerServiceTsk(ServerBE serverBE) {
		this.serverBE = serverBE;
	}
	
	@Override
	@WebMethod
	public void get() {
		this.serverBE.get();
	}

	@Override
	@WebMethod
	public void request() {
		this.serverBE.request();
		
	}

}

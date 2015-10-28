package br.ufc.mdcc.pargo.safe.server;

import br.ufc.mdcc.pargo.backend.connector.ITCPBindingServerListener;

public interface IServerBackend extends ITCPBindingServerListener {
	
	public void setPort(Integer port);
	public void connect();
	
}

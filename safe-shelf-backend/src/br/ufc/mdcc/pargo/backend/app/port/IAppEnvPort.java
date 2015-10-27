package br.ufc.mdcc.pargo.backend.app.port;

public interface IAppEnvPort {

	public void requestMessage();
	public void receiveMessage(String msg);
}

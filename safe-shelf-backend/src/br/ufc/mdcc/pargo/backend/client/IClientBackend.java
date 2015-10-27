package br.ufc.mdcc.pargo.backend.client;


public interface IClientBackend {
	
	public void addMesssageToBuffer(String message);
	public void setServerPort(Integer port);
	public void connect();
	public void requestMessage();

}

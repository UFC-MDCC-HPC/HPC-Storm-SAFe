package br.ufc.mdcc.pargo.safe.backend.pc.client;

public interface IClientProducer {

	public void setServerPort(Integer port);
	public void sendMsg(String msg);
	public void initialize();
	
}

package br.ufc.mdcc.pargo.safe.backend.pc.server;

public interface IServerConsumer {

	public void setPort(Integer port);
	public String getMsg();
	public void initialize();
	public void receive();
}

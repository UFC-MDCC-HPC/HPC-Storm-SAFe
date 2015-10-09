package br.ufc.mdcc.pargo.safe.backend.pc.server;

public interface IServerConsumer {

	//task
	public void setPort(Integer port);
	public void initialize();
	
	//env
	public String getMsg();
	
	
	//local
	public void receive();
}

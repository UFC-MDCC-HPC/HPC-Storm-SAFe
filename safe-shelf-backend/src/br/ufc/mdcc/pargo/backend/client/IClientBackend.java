package br.ufc.mdcc.pargo.backend.client;

import br.ufc.mdcc.pargo.backend.client.port.env.IServiceClientEnv;
import br.ufc.mdcc.pargo.backend.client.port.tsk.IServiceClientTask;

public interface IClientBackend {
	
	public void addMesssageToBuffer(String message);
	public void setServerPort(Integer port);
	public void connect();
	
	public IServiceClientEnv getEnv();
	public IServiceClientTask getTsk();
	public void setEnv(IServiceClientEnv env);
	public void setTsk(IServiceClientTask tsk);
}

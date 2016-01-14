package br.ufc.safe.sample.cmp;

import br.ufc.safe.sample.stubs.app_1.AppReturnMessageEnvPortServiceService;
import br.ufc.safe.sample.stubs.app_1.IAppReturnMessageEnvPortService;

public class ServerBE {

	private QueueBE queue;
	private String message;
	
	public ServerBE(QueueBE queue) {
		this.queue = queue;
	}
	
	//uses
	public void returnMessage(String message){
		//TO APPLICATION WEB SERVICE
		AppReturnMessageEnvPortServiceService service = new AppReturnMessageEnvPortServiceService();
		IAppReturnMessageEnvPortService port = service.getAppReturnMessageEnvPortServicePort();
		port.returnMessage(message);
	}
	
	public String fetch(){
		return this.queue.fetch(); 
	}
	
	//task
	public void get(){
		this.message = this.fetch();
	}
	
	public void request(){
		message = "ALTERED : "+ message;
		this.returnMessage(this.message);
	}
}

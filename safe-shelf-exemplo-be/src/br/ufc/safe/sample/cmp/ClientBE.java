package br.ufc.safe.sample.cmp;

import br.ufc.safe.sample.stubs.app_0.AppRequestMessageEnvPortServiceService;
import br.ufc.safe.sample.stubs.app_0.IAppRequestMessageEnvPortService;


public class ClientBE {
	
	private QueueBE queue;
	String message;
	
	public ClientBE(QueueBE queue){
		this.queue = queue;
	}

	//uses
	public void deposit(String message){
		this.queue.deposit(message);
	}
	
	public void requestMessage(){
		//TO APPLICATION WEB SERVICE
		AppRequestMessageEnvPortServiceService service = new AppRequestMessageEnvPortServiceService();
		IAppRequestMessageEnvPortService port = service.getAppRequestMessageEnvPortServicePort();
		port.requestMessage();
	}
	//provides
	public void addMessage(String message){
		this.message = message;
	}
	//task
	public void post(){
		this.requestMessage();
	}
	
	public void send(){
		if(message!=null)
			this.deposit(message);
	}
}

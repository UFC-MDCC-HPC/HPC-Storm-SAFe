package br.ufc.mdcc.pargo.safe.sample.pc;

import br.ufc.mdcc.pargo.safe.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.services.IHShelfService;

public class ShelfServerConsumer extends HShelfComponent{

	 
	
	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
		
	}

	public void initialize(){
		final ShelfConsumerProducerPort port = new ShelfConsumerProducerPort();
		port.setName("server-consumer");
		
		
		try {
			this.services.addProvidesPort(port);
			
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		
		
		Thread t = new Thread(){
			public void run() {
				String msg = "";
				while(!msg.equals("bye")){
					System.out.println("SERVER IS WAITING...");
					msg = port.read();
					System.out.println("SERVER SAYS:" + msg);
				}
				System.out.println("SERVER ENDED.");
			};
		};
		
		t.start();
		
	}
}

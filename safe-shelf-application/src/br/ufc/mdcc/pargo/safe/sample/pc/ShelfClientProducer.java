package br.ufc.mdcc.pargo.safe.sample.pc;

import java.util.Scanner;

import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;

public class ShelfClientProducer extends HShelfComponent{

	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
		
	}
	
	public void initialize(){
		ShelfPortGoClientProducer go = new ShelfPortGoClientProducer();
		go.setName("go-producer");
		go.client = this;
		try {
			this.services.setProvidesPort(go);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run(){
		try {
			ShelfConsumerProducerPort server = 
					(ShelfConsumerProducerPort)this.services.getProvidesPort("server-consumer");
			Scanner scan = new Scanner(System.in);
			String msg = "";
			do{
				msg = scan.nextLine();
				server.write(msg);
			}while(!msg.equals("bye"));
			
			scan.close();
			
			 
			
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

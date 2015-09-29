package br.ufc.mdcc.pargo.safe.sample.cca;

import br.ufc.mdcc.pargo.safe.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.services.IHShelfService;

public class ShelfServerComponent extends HShelfComponent{

	
	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
		
	}

	public void initialize(){
		final ShelfHelloServerPort port = new ShelfHelloServerPort();
		port.setName("hello-server");
		try {
			this.services.setProvidesPort(port);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Thread t = new Thread(){
			public void run() {
			  while(true){
				  try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("SERVER SAYS: " + port.getMsg());  
			  }
				
			};
		};
		t.start();
	}
	
	 

}

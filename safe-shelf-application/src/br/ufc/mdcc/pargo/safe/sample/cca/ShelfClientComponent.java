package br.ufc.mdcc.pargo.safe.sample.cca;

import br.ufc.mdcc.pargo.safe.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.port.HShelfPort;
import br.ufc.mdcc.pargo.safe.services.IHShelfService;

public class ShelfClientComponent extends HShelfComponent{

	
	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
	}
	
	public void initialize(){
		ShelfPortGoClient go = new ShelfPortGoClient();
		go.setName("go-client");
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
			HShelfPort port = services.getProvidesPort("hello-server");
			if(port!=null){
				ShelfHelloServerPort impl = (ShelfHelloServerPort)port;
				impl.setMsg("Olá");
			}
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

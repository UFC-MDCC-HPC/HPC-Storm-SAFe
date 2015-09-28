package br.ufc.mdcc.pargo.safe.workflow;

import br.ufc.mdcc.pargo.safe.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.port.HShelfPort;
import br.ufc.mdcc.pargo.safe.port.dflt.safeswl.HShelfSAFeSWLPortImpl;
import br.ufc.mdcc.pargo.safe.services.IHShelfService;
import br.ufc.mdcc.pargo.safe.util.HShelfConsoleLogger;

public class HShelfWorkflow extends HShelfComponent {

	public HShelfWorkflow(String name) {
		HShelfConsoleLogger.write("Creating HShelfWorkflow");
		this.setName(name);
	}

	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
	}
	
	public void initialize(){
		try {
			HShelfPort safeSWL = new HShelfSAFeSWLPortImpl();
			safeSWL.setName("safeswl-port");
			services.addProvidesPort(safeSWL);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*Thread t = new Thread(){
			@Override
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				try {
					HShelfPort safeSWL = new HShelfSAFeSWLPortImpl();
					safeSWL.setName("safeswl-port");
					services.addProvidesPort(safeSWL);
				} catch (HShelfException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		};
		t.start();*/
		
		
		 
	}

}

package br.ufc.mapreduce.stubs;

import br.ufc.mapreduce.stubs.ports.env.MRStubProvidesPort;
import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfTaskPort;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;

public class CombinerSTUB extends HShelfComponent{

	private HShelfTaskPort taskChunk;
	 

	
	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
		
		this.taskChunk = new HShelfTaskPort();
		this.taskChunk.setName("combiner-task-chunk");
		
		try {
			this.services.registerTaskPort(taskChunk);
			MRStubProvidesPort provides = new MRStubProvidesPort();provides.setName("port-A-combiner-provides");
			this.services.setProvidesPort(provides);
			this.services.registerUsesPort("cluster_A-combiner-uses", null);
			this.services.registerUsesPort("port-B-combiner-uses", null);
			
			
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Thread t = new Thread(){
			public void run() {
				try {
					Thread.sleep(2000);
					MRStubProvidesPort combiner = (MRStubProvidesPort)services.getConnectedProvidesPort("port-B-combiner-uses");
					combiner.invoke("STUB-TESTE-COMBINER " + combiner.getName());
				} catch (HShelfException | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			};
			
		};
		
		t.start();
	}

}

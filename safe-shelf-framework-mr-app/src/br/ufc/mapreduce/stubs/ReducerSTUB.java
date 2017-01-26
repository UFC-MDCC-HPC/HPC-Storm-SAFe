package br.ufc.mapreduce.stubs;

import br.ufc.mapreduce.stubs.ports.env.MRStubProvidesPort;
import br.ufc.mapreduce.stubs.ports.tsk.MRStubTaskPort;
import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;

public class ReducerSTUB extends HShelfComponent{

	private MRStubTaskPort taskChunk;
	
	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
		
		this.taskChunk = new MRStubTaskPort();
		this.taskChunk.setName("reducer-task-chunk");
		try {
			this.services.registerTaskPort(taskChunk);
			MRStubProvidesPort provides = new MRStubProvidesPort();provides.setName("port-A-reducer-provides");
			this.services.setProvidesPort(provides);
			this.services.registerUsesPort("port-B-reducer-uses", null);
			this.services.registerUsesPort("cluster_A-reducer-uses", null);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Thread t = new Thread(){
			public void run() {
				try {
					Thread.sleep(2000);
					MRStubProvidesPort reducer = (MRStubProvidesPort)services.getConnectedProvidesPort("port-B-reducer-uses");
					reducer.invoke("STUB-TESTE-REDUCER " + reducer.getName());
				} catch (HShelfException | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			};
			
		};
		
		t.start();
		
	}

}
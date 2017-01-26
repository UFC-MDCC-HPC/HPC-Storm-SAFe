package br.ufc.mapreduce.stubs;

import br.ufc.mapreduce.stubs.ports.env.MRStubProvidesPort;
import br.ufc.mapreduce.stubs.ports.tsk.MRStubTaskPort;
import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;

public class ShufflerSTUB extends HShelfComponent{

	private MRStubTaskPort taskChunk;

	@Override
	public void setServices(IHShelfService services) {
		this.services = services;

		this.taskChunk = new MRStubTaskPort();
		this.taskChunk.setName("shuffler-task-chunk");
		
		try {
			this.services.registerTaskPort(taskChunk);
			MRStubProvidesPort provides = new MRStubProvidesPort();provides.setName("port-A-shuffler-provides");
			this.services.setProvidesPort(provides);
			this.services.registerUsesPort("port-B-shuffler-uses", null);
			this.services.registerUsesPort("cluster_A-shuffler-uses", null);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Thread t = new Thread(){
			public void run() {
				try {
					Thread.sleep(2000);
					MRStubProvidesPort shuffler = (MRStubProvidesPort)services.getConnectedProvidesPort("port-B-shuffler-uses");
					shuffler.invoke("STUB-TESTE-SHUFFLER " + shuffler.getName());
				} catch (HShelfException | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			};
			
		};
		
		t.start();

	}
}

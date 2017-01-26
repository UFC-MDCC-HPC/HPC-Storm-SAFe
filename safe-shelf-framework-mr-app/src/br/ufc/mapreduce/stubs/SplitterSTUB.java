package br.ufc.mapreduce.stubs;

import br.ufc.mapreduce.stubs.ports.env.MRStubProvidesPort;
import br.ufc.mapreduce.stubs.ports.tsk.MRStubTaskPort;
import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;

public class SplitterSTUB extends HShelfComponent{
	
	private MRStubTaskPort taskChunk;
	private MRStubTaskPort taskSourceSink;
	
	@Override
	public void setServices(IHShelfService services) {
		this.services = services;

		this.taskChunk = new MRStubTaskPort();
		this.taskChunk.setName("splitter-task-chunk");
		
		this.taskSourceSink = new MRStubTaskPort();
		this.taskSourceSink.setName("splitter-task-ss");
		
		try {
			this.services.registerTaskPort(taskChunk);
			this.services.registerTaskPort(taskSourceSink);
			MRStubProvidesPort provides = new MRStubProvidesPort();provides.setName("port-A-splitter-provides");
			this.services.setProvidesPort(provides);
			this.services.registerUsesPort("port-B-splitter-uses", null);
			this.services.registerUsesPort("cluster_A-splitter-uses", null);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Thread t = new Thread(){
			public void run() {
				try {
					Thread.sleep(2000);
					MRStubProvidesPort splitter = (MRStubProvidesPort)services.getConnectedProvidesPort("port-B-splitter-uses");
					splitter.invoke("STUB-TESTE-SPLITTER " + splitter.getName());
				} catch (HShelfException | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			};
			
		};
		
		t.start();

	}

}

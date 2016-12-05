package br.ufc.mapreduce.stubs;

import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfTaskPort;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;

public class SplitterSTUB extends HShelfComponent{
	
	private HShelfTaskPort taskChunk;
	private HShelfTaskPort taskSourceSink;
	
	@Override
	public void setServices(IHShelfService services) {
		this.services = services;

		this.taskChunk = new HShelfTaskPort();
		this.taskChunk.setName("splitter-task-chunk");
		
		this.taskSourceSink = new HShelfTaskPort();
		this.taskSourceSink.setName("splitter-task-ss");
		
		try {
			this.services.registerTaskPort(taskChunk);
			this.services.registerTaskPort(taskSourceSink);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
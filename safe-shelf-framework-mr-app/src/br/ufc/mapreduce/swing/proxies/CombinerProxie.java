package br.ufc.mapreduce.swing.proxies;

import br.ufc.mapreduce.ports.env.MRPort;
import br.ufc.mapreduce.ports.tsk.TaskChunk;
import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfUsesPort;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;

public class CombinerProxie extends HShelfComponent implements MRAdapter{

	private MRPort providesPort;
	private HShelfUsesPort usesPort;
	
	private String chunk_in = "";
	private String chunk_out = "";
	
	private TaskChunk taskChunk;
	private boolean ready;
	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
	
		
		try {
			providesPort = new MRPort();
			providesPort.setName("combiner-provides");
			this.services.setProvidesPort(providesPort);
			taskChunk = new TaskChunk(this);
			taskChunk.setName("combiner-task-chunk");
			this.services.registerTaskPort(taskChunk);
			this.services.registerUsesPort("combiner-uses", "?");
			
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void read_source() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean terminate() {
		return false;
		
	}

	@Override
	public void write_sink() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read_chunk() {
		try {
			usesPort = ((HShelfUsesPort)this.services.getPort("combiner-uses"));
			//this.chunk_in = ((MRPort)usesPort.getProvidesPort()).getChunk();
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void perform() {
		try {
			Thread.sleep(2000);
			this.chunk_out = "COMBINER-OUT: "+chunk_in;
			this.chunk_in = "";
			this.ready = true;
			this.providesPort.setChunk(chunk_out);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean chunk_ready() {
		 if(this.ready){
			 ready= false;
			 return true;
		 }
		 
		 return false;
		 
	}

}

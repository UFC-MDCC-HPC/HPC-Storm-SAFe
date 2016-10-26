package br.ufc.mapreduce.proxies;

import br.ufc.mapreduce.ports.env.MRPort;
import br.ufc.mapreduce.ports.tsk.TaskChunk;
import br.ufc.mapreduce.ports.tsk.TaskSourceSink;
import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfUsesPort;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;

public class SplitterProxie extends HShelfComponent implements MRAdapter{

	private int counter = 0;
	private MRPort providesPort;
	private HShelfUsesPort usesPortSource;
	private HShelfUsesPort usesPortSink;
	private HShelfUsesPort usesPort;
	private boolean ready = false;
	
	private String chunk_in = "";
	private String chunk_out = "";
	private String total = "";
	
	private TaskChunk taskChunk;
	private TaskSourceSink taskSourceSink;
	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
	
		
		try {
			providesPort = new MRPort();
			providesPort.setName("splitter-provides");
			this.services.setProvidesPort(providesPort);
			
			taskChunk = new TaskChunk(this);
			taskChunk.setName("splitter-task-chunk");
			this.services.registerTaskPort(taskChunk);
			
			taskSourceSink = new TaskSourceSink(this);
			taskSourceSink.setName("splitter-task-ss");
			this.services.registerTaskPort(taskSourceSink);
			
			this.services.registerUsesPort("splitter-uses", "?");
			this.services.registerUsesPort("splitter-uses-source", "?");
			this.services.registerUsesPort("splitter-uses-sink", "?");
			
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void read_source() {
		try {
			usesPortSource = ((HShelfUsesPort)this.services.getPort("splitter-uses-source"));
			//this.chunk_in = ((MRPort)usesPortSource.getProvidesPort()).getChunk();
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean terminate() {
		if(counter>=3)
			return true;
		return false;
		
	}

	@Override
	public void write_sink() {
		try {
			usesPortSink = ((HShelfUsesPort)this.services.getPort("splitter-uses-sink"));
			System.out.println("TOTAL="+total);
			//((MRPort)usesPortSink.getProvidesPort()).setChunk(total);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void read_chunk() {
		try {
			usesPort = ((HShelfUsesPort)this.services.getPort("splitter-uses"));
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
			this.chunk_out = "SPLITTER-OUT: "+chunk_in;
			this.chunk_in = "";
			this.total+=chunk_out;
			this.counter++;
			this.ready = true;
			if(this.counter>=3){
				this.providesPort.setChunk("");
				this.ready = false;
			}
				
			else
				this.providesPort.setChunk(chunk_out);
			System.out.println("SPLITTER COUNTER: "+counter);
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

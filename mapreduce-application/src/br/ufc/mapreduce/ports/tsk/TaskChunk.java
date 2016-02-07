package br.ufc.mapreduce.ports.tsk;

import br.ufc.mapreduce.proxies.MRAdapter;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfTaskPort;

public class TaskChunk extends HShelfTaskPort{
	
	private MRAdapter mr;
	public TaskChunk(MRAdapter mr){
		this.mr = mr;
	}
	
	public void read_chunk(){
		this.mr.read_chunk();
	}
	public void perform(){
		this.mr.perform();
	}
	public boolean chunk_ready(){
		return this.mr.chunk_ready();
	}
	
}

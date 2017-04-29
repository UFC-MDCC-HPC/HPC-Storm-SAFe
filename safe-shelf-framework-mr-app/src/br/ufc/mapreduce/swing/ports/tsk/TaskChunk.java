package br.ufc.mapreduce.swing.ports.tsk;

import br.ufc.mapreduce.swing.proxies.MRAdapter;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfActionPort;

public class TaskChunk extends HShelfActionPort{
	
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

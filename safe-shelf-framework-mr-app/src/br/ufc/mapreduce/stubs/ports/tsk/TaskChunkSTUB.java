package br.ufc.mapreduce.stubs.ports.tsk;

import br.ufc.mdcc.pargo.safe.framework.port.HShelfTaskPort;

public class TaskChunkSTUB extends HShelfTaskPort{
	
	
	public void read_chunk(){
		System.out.println(this.getName()+"-read_chunk");
	}
	
	public void perform(){
		System.out.println(this.getName()+"-BEGIN perform");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.getName()+"-END perform");
	}
	
	public boolean chunk_ready(){
		System.out.println(this.getName()+"-chunk_ready");
		return true;
	}
	

}

package br.ufc.mdcc.pargo.safe.sample.pc;

import java.util.concurrent.Semaphore;

import br.ufc.mdcc.pargo.safe.port.HShelfPort;

public class ShelfConsumerProducerPort extends HShelfPort{

	private Semaphore semaphore = new Semaphore(0) ;
	private String msg;
	
	public void write(String msg){
		this.msg = msg;
		this.semaphore.release();
	}
	
	public String read(){
		try {
			this.semaphore.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.msg;
	}
}

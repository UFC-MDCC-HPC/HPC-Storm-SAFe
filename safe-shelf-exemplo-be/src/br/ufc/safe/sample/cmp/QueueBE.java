package br.ufc.safe.sample.cmp;

import java.util.LinkedList;
import java.util.Queue;

public class QueueBE {

	private Queue<String> clientFacet;
	private Queue<String> serverFacet;
	
	public QueueBE() {
		this.clientFacet = new LinkedList<String>();
		this.serverFacet = new LinkedList<String>();
	}
	
	//provides
	public void deposit(String message){
		this.clientFacet.add(message);
	}
	
	public String fetch(){
		return this.serverFacet.remove();
	}
	
	//task
	public void go(){
		String message = this.clientFacet.remove();
		this.serverFacet.add(message);
	}
}

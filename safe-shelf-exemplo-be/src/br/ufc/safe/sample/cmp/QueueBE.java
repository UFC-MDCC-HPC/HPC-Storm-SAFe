package br.ufc.safe.sample.cmp;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class QueueBE {

	private Queue<String> clientFacet;
	private Queue<String> serverFacet;

	private Semaphore semaphore;

	public QueueBE() {
		this.clientFacet = new LinkedList<String>();
		this.serverFacet = new LinkedList<String>();
		this.semaphore = new Semaphore(0);
	}

	// provides
	public void deposit(String message) {
		this.clientFacet.add(message);
		this.semaphore.release();
	}

	public String fetch() {
		return this.serverFacet.remove();
	}

	// task
	public void go() {

		Thread t = new Thread() {
			public void run() {

				while (true) {
					try {
						semaphore.acquire();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String message = clientFacet.remove();
					serverFacet.add(message);
				}
			}
		};

		t.start();

	}
}

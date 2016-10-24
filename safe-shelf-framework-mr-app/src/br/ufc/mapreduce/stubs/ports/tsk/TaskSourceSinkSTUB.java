package br.ufc.mapreduce.stubs.ports.tsk;

import br.ufc.mdcc.pargo.safe.framework.port.HShelfTaskPort;

public class TaskSourceSinkSTUB extends HShelfTaskPort{

	public void read_source(){
		System.out.println(this.getName()+"-read_source");
	}
	public boolean terminate(){
		System.out.println(this.getName()+"-terminate");
		return true;
	}
	public void write_sink(){
		System.out.println(this.getName()+"-write_sink");
	}
}

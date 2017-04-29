package br.ufc.mapreduce.swing.ports.tsk;

import br.ufc.mapreduce.swing.proxies.MRAdapter;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfActionPort;

public class TaskSourceSink extends HShelfActionPort{

	private MRAdapter mr;
	public TaskSourceSink(MRAdapter mr){
		this.mr = mr;
	}
	
	public void read_source(){
		this.mr.read_source();
	}
	public boolean terminate(){
		return this.mr.terminate();
	}
	public void write_sink(){
		this.mr.write_sink();
	}
}

package br.ufc.mapreduce.proxies;

public interface MRAdapter {

	public void read_source();
	public boolean terminate();
	public void write_sink();
	
	public void read_chunk();
	public void perform();
	public boolean chunk_ready();
}

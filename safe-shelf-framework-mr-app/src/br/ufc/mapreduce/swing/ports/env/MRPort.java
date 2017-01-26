package br.ufc.mapreduce.swing.ports.env;

import br.ufc.mdcc.pargo.safe.framework.port.HShelfProvidesPort;

public class MRPort extends HShelfProvidesPort{

	private String chunk;

	public String getChunk() {
		return chunk;
	}

	public void setChunk(String chunk) {
		this.chunk = chunk;
	}
	
}

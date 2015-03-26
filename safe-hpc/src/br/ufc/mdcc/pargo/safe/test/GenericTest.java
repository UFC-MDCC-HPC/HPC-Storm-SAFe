package br.ufc.mdcc.pargo.safe.test;

import br.ufc.mdcc.pargo.safe.framework.HPCStormSAFeSWL;

public class GenericTest<T extends HPCStormSAFeSWL> {

	private T data;
	
	public void foo(){
		data.getArchFileName();
	}
}

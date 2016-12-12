package br.ufc.mapreduce.stubs.ports.env;

import br.ufc.mdcc.pargo.safe.framework.port.HShelfProvidesPort;

public class MRStubProvidesPort extends HShelfProvidesPort{

	public Object invoke(Object in){
		System.out.println(in.toString());
		return null;
	}
}

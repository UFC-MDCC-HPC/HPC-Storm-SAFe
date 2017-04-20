package br.ufc.mapreduce.stubs.ports.env;

import br.ufc.mdcc.pargo.safe.framework.port.HShelfProvidesPort;

//chamadas ao jar
public class MRStubProvidesPort extends HShelfProvidesPort{

	public Object invoke(Object in){
		System.out.println(in.toString());
		return null;
	}
	
	public void foo(String ip){
		//jar.foo(ip);
	}
}

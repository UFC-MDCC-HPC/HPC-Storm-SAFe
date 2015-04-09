package br.ufc.mdcc.pargo.safe.test;

import br.ufc.mdcc.pargo.safe.framework.HPCStormSAFeSWL;

public class GenericTest<T> {

	private T data;
	
	public void setData(T in){
		this.data = in;
	}
	
	public void foo2(){
		System.out.println(data.getClass());
	}
	
	public static void main(String[] args) {
		GenericTest<HPCStormSAFeSWL> g = new GenericTest<HPCStormSAFeSWL>();
		g.setData(new HPCStormSAFeSWL());
		g.foo2();
	}
}


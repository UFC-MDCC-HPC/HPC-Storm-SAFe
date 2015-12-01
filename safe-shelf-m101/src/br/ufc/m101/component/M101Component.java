package br.ufc.m101.component;

public abstract class M101Component {

	protected String params; 
	
	public void setParams(String params){
		this.params = params;
	}
	
	public abstract void go();
}

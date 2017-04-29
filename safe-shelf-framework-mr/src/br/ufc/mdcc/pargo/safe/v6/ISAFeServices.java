package br.ufc.mdcc.pargo.safe.v6;

public interface ISAFeServices {

	public void registerUsesPort(String portName);
	public void unregisterUsesPort(String portName);
	public void addProvidesPort(ISAFePort port);
	public void removeProvidesPort(String portName);
	
	public void registerActionPort(String portName); //uses
	public void unregisterActionPort(String portName); //uses
	public void addActionPort(ISAFePort port); //provides
	public void removeActionPort(String portName); //provides
	
}

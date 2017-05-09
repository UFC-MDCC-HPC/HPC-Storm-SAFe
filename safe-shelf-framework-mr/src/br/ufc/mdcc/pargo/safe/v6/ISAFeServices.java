package br.ufc.mdcc.pargo.safe.v6;

import java.util.List;

public interface ISAFeServices {

	public void registerUsesPort(String portId);
	public void unregisterUsesPort(String portId);
	public void addProvidesPort(ISAFePort port);
	public void removeProvidesPort(String portId);
	
	public void registerActionPort(String portId); //uses
	public void unregisterActionPort(String portId); //uses
	public void addActionPort(ISAFePort port); //provides
	public void removeActionPort(String portId); //provides
	
	public List<String> getUsesPortIds();
	public List<ISAFePort> getProvidesPorts();
	public List<String> getActionPortIdsRegistered();
	public List<ISAFePort> getActionPorts();
	 
	
}

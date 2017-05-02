package br.ufc.mdcc.pargo.safe.v6.impl;

import java.util.ArrayList;
import java.util.List;

import br.ufc.mdcc.pargo.safe.v6.ISAFePort;
import br.ufc.mdcc.pargo.safe.v6.ISAFeServices;

public class SAFeServices implements ISAFeServices{

	public List<String> usesPort;
	public List<ISAFePort> providesPort;
	public List<String> masterActionPorts; //workflow
	public List<ISAFePort> slaveActionPorts; //solution components
	
	public SAFeServices() {
		this.usesPort = new ArrayList<String>();
		this.providesPort = new ArrayList<ISAFePort>();
		this.masterActionPorts = new ArrayList<String>();
		this.slaveActionPorts = new ArrayList<ISAFePort>();
	}
	
	@Override
	public void registerUsesPort(String portId) {
		this.usesPort.add(portId);
	}

	@Override
	public void unregisterUsesPort(String portId) {
		this.usesPort.remove(portId);
		
	}

	@Override
	public void addProvidesPort(ISAFePort port) {
		this.providesPort.add(port);
	}

	@Override
	public void removeProvidesPort(String portId) {
		int i = 0;
		for(ISAFePort port:this.providesPort){
			if(port.getId().equals(portId)){
				break;
			}
			i++;
		}
		this.providesPort.remove(i);
	}

	@Override
	public void registerActionPort(String portId) {
		this.masterActionPorts.add(portId);
	}

	@Override
	public void unregisterActionPort(String portId) {
		this.masterActionPorts.remove(portId);
	}

	@Override
	public void addActionPort(ISAFePort port) {
		this.slaveActionPorts.add(port);
	}

	@Override
	public void removeActionPort(String portId) {
		int i = 0;
		for(ISAFePort action:this.slaveActionPorts){
			if(action.getId().equals(portId)){
				break;
			}
			i++;
		}
		this.slaveActionPorts.remove(i);
	}

	@Override
	public List<String> getUsesPortIds() {
		return this.usesPort;
	}

	@Override
	public List<ISAFePort> getProvidesPorts() {
		return this.providesPort;
	}

	@Override
	public List<String> getActionPortIdsRegistered() {
		return this.masterActionPorts;
	}

	@Override
	public List<ISAFePort> getActionPorts() {
		return this.slaveActionPorts;
	}
	
	

}

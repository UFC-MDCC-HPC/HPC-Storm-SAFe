package br.ufc.montage.model;

import java.util.ArrayList;
import java.util.List;

public class MontageComponent extends MontageModel{

	private List<MontageEnvPort> envPorts;
	private List<MontageTskPort> tskPorts;
	 
	
	public MontageComponent() {
		this.envPorts = new ArrayList<MontageEnvPort>();
		this.tskPorts = new ArrayList<MontageTskPort>();
	}
	
	public void addEnvPort(MontageEnvPort envPort){
		this.envPorts.add(envPort);
	}
	
	public void addTskPort(MontageTskPort tskPort){
		this.tskPorts.add(tskPort);
	}

	public List<MontageEnvPort> getEnvPorts() {
		return envPorts;
	}

	public List<MontageTskPort> getTskPorts() {
		return tskPorts;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof MontageComponent))
			return false;
		
		MontageComponent ref = (MontageComponent)obj;
		if(ref.getName().equals(this.getName()))
			return true;
		return false;
		
	}
	
}

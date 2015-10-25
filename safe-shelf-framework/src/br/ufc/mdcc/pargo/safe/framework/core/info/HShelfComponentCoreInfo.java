package br.ufc.mdcc.pargo.safe.framework.core.info;

import java.util.ArrayList;
import java.util.List;

public class HShelfComponentCoreInfo {

	private String ID;
	private String name;
	
	//resolve info
	private String candidates;
	//deploy info
	private String deployedID;
	//instantiate info
	private List<HShelfPortCoreInfo> ports;
	
	public HShelfComponentCoreInfo() {
		this.ports = new ArrayList<HShelfPortCoreInfo>();
	}
	
	public String getId() {
		return ID;
	}
	public void setId(String ID) {
		this.ID = ID;
	}
	public String getCandidates() {
		return candidates;
	}
	public void setCandidates(String candidates) {
		this.candidates = candidates;
	}
	 
	public String getDeployedID() {
		return deployedID;
	}
	public void setDeployedID(String deployedID) {
		this.deployedID = deployedID;
	}
	
	public void addPortInfor(HShelfPortCoreInfo portInfo){
		this.ports.add(portInfo);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HShelfPortCoreInfo getPortInfoByName(String portName){
		for(HShelfPortCoreInfo portInfo:this.ports){
			if(portInfo.equals(portName))
				return portInfo;
		}
		return null;
	}
	
	public List<HShelfPortCoreInfo> getPorts() {
		return ports;
	}

	public String toString(){
		String str = "";
		str = "name="+this.name+",id="+this.ID;
		for(HShelfPortCoreInfo port:this.ports){
			str+="\n\t"+port;
		}
		return str;
	}
}

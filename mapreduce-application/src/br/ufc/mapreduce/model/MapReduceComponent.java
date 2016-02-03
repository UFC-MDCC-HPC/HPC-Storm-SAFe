package br.ufc.mapreduce.model;

import java.util.ArrayList;
import java.util.List;

public class MapReduceComponent extends MapReduceModel{

	public static final String APPLICATION_KIND="APPLICATION";
	public static final String WORKFLOW_KIND="WORKFLOW";
	public static final String COMPUTATION_KIND="COMPUTATION";
	public static final String REPOSITORY_KIND="REPOSITORY";
	
	private List<MapReduceEnvPort> envPorts;
	private List<MapReduceTskPort> tskPorts;
	private String kind;
	
	public MapReduceComponent() {
		this.envPorts = new ArrayList<MapReduceEnvPort>();
		this.tskPorts = new ArrayList<MapReduceTskPort>();
	}
	
	public void addEnvPort(MapReduceEnvPort envPort){
		this.envPorts.add(envPort);
	}
	
	public void addTskPort(MapReduceTskPort tskPort){
		this.tskPorts.add(tskPort);
	}

	public List<MapReduceEnvPort> getEnvPorts() {
		return envPorts;
	}

	public List<MapReduceTskPort> getTskPorts() {
		return tskPorts;
	}
	
	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof MapReduceComponent))
			return false;
		
		MapReduceComponent ref = (MapReduceComponent)obj;
		if(ref.getName().equals(this.getName()))
			return true;
		return false;
		
	}
	
}

package br.ufc.mapreduce.swing.model;

import java.util.ArrayList;
import java.util.List;

public class MapReduceTskPort extends MapReduceModel{
	
	private List<MapReduceAction> actions;
	
	public MapReduceTskPort() {
		this.actions = new ArrayList<MapReduceAction>();
	}
	
	public void addAction(MapReduceAction action){
		this.actions.add(action);
	}
	
	public List<MapReduceAction> getActions(){
		return this.actions;
	}

}

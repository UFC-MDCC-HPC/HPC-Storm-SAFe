package br.ufc.mapreduce.swing.workflow;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.ufc.mapreduce.swing.model.MapReduceComponent;

public class MapReduceAct implements Serializable{
	
	private List<MapReduceComponent> components;
	private Integer position;
	
	public MapReduceAct() {
		this.components = new ArrayList<MapReduceComponent>();
	}
	
	public void addComponent(MapReduceComponent component){
		this.components.add(component);
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}
	
	public List<MapReduceComponent> listComponents(){
		return this.components;
	}
}

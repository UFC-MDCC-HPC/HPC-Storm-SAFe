package br.ufc.mapreduce.dao;

import java.util.List;

import br.ufc.mapreduce.model.MapReduceComponent;
import br.ufc.mapreduce.model.MapReduceEnvPort;
import br.ufc.mapreduce.model.MapReduceTskPort;
import br.ufc.mapreduce.util.MapReduceXML;

public class MapReduceComponentDAO {

	
	
	public List<MapReduceComponent> listComponents(){
		List<MapReduceComponent> components;
		components = MapReduceXML.parseXMLWorkflow("src/components_mr.xml");
		return components;
	}
	
	public void addComponent(MapReduceComponent component){
		List<MapReduceComponent> components = this.listComponents();
		components.add(component);
	}
	
	public MapReduceComponent getComponentByName(String name){
		List<MapReduceComponent> components = this.listComponents();
		for(MapReduceComponent c:components){
			if(c.getName().equals(name)) return c;
		}
		return null;
	}
	
	public MapReduceEnvPort getEnvPortByName(String name){
		List<MapReduceComponent> components = this.listComponents();
		for(MapReduceComponent c:components){
			for(MapReduceEnvPort e: c.getEnvPorts()){
				if(e.getName().equals(name)) return e;
			}
		}
		return null;
	}
	
	public MapReduceTskPort getTskPortByName(String name){
		List<MapReduceComponent> components = this.listComponents();
		for(MapReduceComponent c:components){
			for(MapReduceTskPort t: c.getTskPorts()){
				if(t.getName().equals(name)) return t;
			}
		}
		return null;
	}
}

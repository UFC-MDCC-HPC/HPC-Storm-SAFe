package br.ufc.mapreduce.swing.model;

import java.io.Serializable;

public class MapReduceModel implements Serializable{

	private String name;
	private int id;
	private int id_component;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_component() {
		return id_component;
	}
	public void setId_component(int id_component) {
		this.id_component = id_component;
	}
	
	
}

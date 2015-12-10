package br.ufc.montage.dao;

import java.util.List;

import br.ufc.montage.model.MontageComponent;
import br.ufc.montage.model.MontageEnvPort;
import br.ufc.montage.model.MontageTskPort;
import br.ufc.montage.util.MontageXML;

public class MontageComponentDAO {

	private List<MontageComponent> components;
	
	public MontageComponentDAO() {
		this.components = MontageXML.parseXMLWorkflow("src/components.xml");
	}
	
	public List<MontageComponent> listComponents(){
		return this.components;
	}
	
	public void addComponent(MontageComponent component){
		this.components.add(component);
	}
	
	public MontageComponent getComponentByName(String name){
		
		for(MontageComponent c:this.components){
			if(c.getName().equals(name)) return c;
		}
		return null;
	}
	
	public MontageEnvPort getEnvPortByName(String name){
		for(MontageComponent c:this.components){
			for(MontageEnvPort e: c.getEnvPorts()){
				if(e.getName().equals(name)) return e;
			}
		}
		return null;
	}
	
	public MontageTskPort getTskPortByName(String name){
		for(MontageComponent c:this.components){
			for(MontageTskPort t: c.getTskPorts()){
				if(t.getName().equals(name)) return t;
			}
		}
		return null;
	}
}

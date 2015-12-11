package br.ufc.montage.dao;

import java.util.List;

import br.ufc.montage.model.MontageComponent;
import br.ufc.montage.model.MontageEnvPort;
import br.ufc.montage.model.MontageTskPort;
import br.ufc.montage.util.MontageXML;

public class MontageComponentDAO {

	
	
	public List<MontageComponent> listComponents(){
		List<MontageComponent> components;
		components = MontageXML.parseXMLWorkflow("src/components.xml");
		return components;
	}
	
	public void addComponent(MontageComponent component){
		List<MontageComponent> components = this.listComponents();
		components.add(component);
	}
	
	public MontageComponent getComponentByName(String name){
		List<MontageComponent> components = this.listComponents();
		for(MontageComponent c:components){
			if(c.getName().equals(name)) return c;
		}
		return null;
	}
	
	public MontageEnvPort getEnvPortByName(String name){
		List<MontageComponent> components = this.listComponents();
		for(MontageComponent c:components){
			for(MontageEnvPort e: c.getEnvPorts()){
				if(e.getName().equals(name)) return e;
			}
		}
		return null;
	}
	
	public MontageTskPort getTskPortByName(String name){
		List<MontageComponent> components = this.listComponents();
		for(MontageComponent c:components){
			for(MontageTskPort t: c.getTskPorts()){
				if(t.getName().equals(name)) return t;
			}
		}
		return null;
	}
}

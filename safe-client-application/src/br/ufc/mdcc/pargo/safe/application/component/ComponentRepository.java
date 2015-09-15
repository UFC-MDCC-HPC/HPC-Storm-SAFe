package br.ufc.mdcc.pargo.safe.application.component;

import java.util.ArrayList;
import java.util.List;

public class ComponentRepository {

	private List<MontageComponent> components = new ArrayList<MontageComponent>(); 
	
	public void addComponent(MontageComponent mc){
		this.components.add(mc);
	}
	
	public List<MontageComponent> getComponents(){
		return this.components;
	}
	
	public MontageComponent getComponent(MontageComponent mc){
		int index = this.components.indexOf(mc);
		if(index>=0)
			return this.components.get(index);
		return null;
	}
}

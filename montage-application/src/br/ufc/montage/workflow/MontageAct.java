package br.ufc.montage.workflow;

import java.util.ArrayList;
import java.util.List;

import br.ufc.montage.model.MontageComponent;

public class MontageAct {
	
	private List<MontageComponent> components;
	private Integer position;
	
	public MontageAct() {
		this.components = new ArrayList<MontageComponent>();
	}
	
	public void addComponent(MontageComponent component){
		this.components.add(component);
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}
	
	public List<MontageComponent> listComponents(){
		return this.components;
	}
}

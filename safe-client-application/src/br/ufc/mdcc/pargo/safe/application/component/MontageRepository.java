package br.ufc.mdcc.pargo.safe.application.component;

import java.util.ArrayList;
import java.util.List;

public class MontageRepository {

	private List<MontageComponent> components = new ArrayList<MontageComponent>();
	private List<MontageApplication> applications = new ArrayList<MontageApplication>();
	
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
	
	public void addApplication(MontageApplication mapp){
		this.applications.add(mapp);
	}
	
	public List<MontageApplication> getApplications(){
		return this.applications;
	}
	
	public MontageApplication getApplication(MontageApplication mapp){
		int index = this.applications.indexOf(mapp);
		if(index>=0)
			return this.applications.get(index);
		return null;
	}
}

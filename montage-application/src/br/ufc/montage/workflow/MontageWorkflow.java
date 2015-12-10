package br.ufc.montage.workflow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import br.ufc.montage.model.MontageComponent;
import br.ufc.montage.model.MontageEnvConnection;
import br.ufc.montage.model.MontageTskConnection;

public class MontageWorkflow {

	
	private Map<Integer, MontageAct> acts;
	private List<MontageComponent> components;
	private List<MontageEnvConnection> envConns;
	private List<MontageTskConnection> tskConns;
	
	
	public MontageWorkflow() {
		this.acts = new HashMap<Integer, MontageAct>();
		this.components = new ArrayList<MontageComponent>();
		this.envConns = new ArrayList<MontageEnvConnection>();
		this.tskConns = new ArrayList<MontageTskConnection>();
	}
	
	public void addComponentToAct(MontageComponent component, Integer position){
		MontageAct act = this.acts.get(position);
		if(act==null){
			act = new MontageAct();
			act.addComponent(component);
			act.setPosition(position);
			this.acts.put(position, act);
		}else{
			act.addComponent(component);
		}
		
		int index = this.components.indexOf(component);
		if(index<0)
			this.components.add(component);
	}
	
	public List<MontageAct> listActs(){
		Iterator<MontageAct> actsI = this.acts.values().iterator();
		List<MontageAct> actsList = new ArrayList<MontageAct>();
		while(actsI.hasNext()){
			actsList.add(actsI.next());
		}
		return actsList;
	}

	public List<MontageComponent> listComponents(){
		return this.components;
	}
	
	public void addEnvConn(MontageEnvConnection env){
		this.envConns.add(env);
	}
	
	public void addTskConn(MontageTskConnection tsk){
		this.tskConns.add(tsk);
	}
	
}

package br.ufc.montage.workflow;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import br.ufc.montage.model.MontageComponent;

public class MontageWorkflow implements Serializable{

	
	private Map<Integer, MontageAct> acts;
	private Map<Integer, List<MontageEnvConnection>> envConnPosMap;
	private Map<Integer, List<MontageTskConnection>> tskConnPosMap;
	private List<MontageComponent> components;
	private List<MontageEnvConnection> envConns;
	private List<MontageTskConnection> tskConns;
	
	
	public MontageWorkflow() {
		this.acts = new HashMap<Integer, MontageAct>();
		this.envConnPosMap = new HashMap<Integer, List<MontageEnvConnection>>();
		this.tskConnPosMap = new HashMap<Integer, List<MontageTskConnection>>();
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
	
	public void addEnvConn(MontageEnvConnection env, Integer actPosition){
		
		if (this.envConns.indexOf(env)>=0)
			return;
		
		this.envConns.add(env);
		List<MontageEnvConnection> ref = this.envConnPosMap.get(actPosition);
		if(ref==null){
			ref = new ArrayList<MontageEnvConnection>();
			ref.add(env);
			this.envConnPosMap.put(actPosition, ref);
		}else{
			ref.add(env);
		}
	}
	
	public void addTskConn(MontageTskConnection tsk, Integer actPosition){
		if(this.tskConns.indexOf(tsk)>=0)
			return;
		
		this.tskConns.add(tsk);
		List<MontageTskConnection> ref = this.tskConnPosMap.get(actPosition);
		if(ref==null){
			ref = new ArrayList<MontageTskConnection>();
			ref.add(tsk);
			this.tskConnPosMap.put(actPosition, ref);
		}else{
			ref.add(tsk);
		}
	}
	
	public List<MontageEnvConnection> listMontageEnvConnectionsByActPosition(Integer actPosition){
		return this.envConnPosMap.get(actPosition);
	}
	
	public List<MontageTskConnection> listMontageTskConnectionsByActPosition(Integer actPosition){
		return this.tskConnPosMap.get(actPosition);
	}
	
}

package br.ufc.mapreduce.workflow;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import br.ufc.mapreduce.model.MapReduceComponent;

public class MapReduceWorkflow implements Serializable {

	private Map<Integer, MapReduceAct> acts;
	private Map<Integer, List<MapReduceEnvConnection>> envConnPosMap;
	private Map<Integer, List<MapReduceTskConnection>> tskConnPosMap;
	private List<MapReduceComponent> components;
	private List<MapReduceEnvConnection> envConns;
	private List<MapReduceTskConnection> tskConns;

	public MapReduceWorkflow() {
		this.acts = new HashMap<Integer, MapReduceAct>();
		this.envConnPosMap = new HashMap<Integer, List<MapReduceEnvConnection>>();
		this.tskConnPosMap = new HashMap<Integer, List<MapReduceTskConnection>>();
		this.components = new ArrayList<MapReduceComponent>();
		this.envConns = new ArrayList<MapReduceEnvConnection>();
		this.tskConns = new ArrayList<MapReduceTskConnection>();
	}

	public void addComponentToAct(MapReduceComponent component, Integer position) {
		MapReduceAct act = this.acts.get(position);
		if (act == null) {
			act = new MapReduceAct();
			act.addComponent(component);
			act.setPosition(position);
			this.acts.put(position, act);
		} else {
			act.addComponent(component);
		}

		int index = this.components.indexOf(component);
		if (index < 0)
			this.components.add(component);
	}

	public List<MapReduceAct> listActs() {
		Iterator<MapReduceAct> actsI = this.acts.values().iterator();
		List<MapReduceAct> actsList = new ArrayList<MapReduceAct>();
		while (actsI.hasNext()) {
			actsList.add(actsI.next());
		}
		return actsList;
	}

	public List<MapReduceComponent> listComponents() {
		return this.components;
	}

	public void addEnvConn(MapReduceEnvConnection env, Integer actPosition) {

		if (this.envConns.indexOf(env) >= 0)
			return;

		this.envConns.add(env);
		List<MapReduceEnvConnection> ref = this.envConnPosMap.get(actPosition);
		if (ref == null) {
			ref = new ArrayList<MapReduceEnvConnection>();
			ref.add(env);
			this.envConnPosMap.put(actPosition, ref);
		} else {
			ref.add(env);
		}
	}

	public void addTskConn(MapReduceTskConnection tsk, Integer actPosition) {
		if (this.tskConns.indexOf(tsk) >= 0)
			return;

		this.tskConns.add(tsk);
		List<MapReduceTskConnection> ref = this.tskConnPosMap.get(actPosition);
		if (ref == null) {
			ref = new ArrayList<MapReduceTskConnection>();
			ref.add(tsk);
			this.tskConnPosMap.put(actPosition, ref);
		} else {
			ref.add(tsk);
		}
	}

	public List<MapReduceEnvConnection> listMontageEnvConnectionsByActPosition(
			Integer actPosition) {
		return this.envConnPosMap.get(actPosition);
	}

	public List<MapReduceTskConnection> listMontageTskConnectionsByActPosition(
			Integer actPosition) {
		return this.tskConnPosMap.get(actPosition);
	}

	public void deleteConnections(Integer actPosition, String compName) {

		List<MapReduceEnvConnection> envConns = this
				.listMontageEnvConnectionsByActPosition(actPosition);
		if (envConns != null) {
			List<MapReduceEnvConnection> indexes = new ArrayList<MapReduceEnvConnection>();
			
			for (MapReduceEnvConnection env : envConns) {
				if (env.getUsesCompName().equals(compName)) {
					indexes.add(env);
				}
			}
			
			for (MapReduceEnvConnection env : indexes) {
				envConns.remove(env);
			}
			
			
		}

		List<MapReduceTskConnection> tskConns = this
				.listMontageTskConnectionsByActPosition(actPosition);
		if (tskConns != null) {
			List<MapReduceTskConnection> indexes = new ArrayList<MapReduceTskConnection>();
			
			for (MapReduceTskConnection tsk : tskConns) {
				if (tsk.getComponentAName().equals(compName)) {
					indexes.add(tsk);
				}
			
			}
			for (MapReduceTskConnection tsk : indexes) {
				tskConns.remove(tsk);
			}
		}
	}
}

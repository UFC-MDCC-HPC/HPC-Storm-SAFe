package br.ufc.mdcc.pargo.safe.services;

import java.util.HashMap;
import java.util.Map;

import br.ufc.mdcc.pargo.safe.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.HShelfFramework;
import br.ufc.mdcc.pargo.safe.port.HShelfProvidesPort;
import br.ufc.mdcc.pargo.safe.port.HShelfUsesPort;

public class HShelfServiceImpl implements IHShelfService{

	private HShelfFramework framework;
	private HShelfComponent component;
	private Map<String, HShelfProvidesPort> providesPortMap;
	private Map<String, HShelfUsesPort> usesPortMap;
	
	public HShelfServiceImpl() {
		this.providesPortMap = new HashMap<String, HShelfProvidesPort>();
		this.usesPortMap = new HashMap<String, HShelfUsesPort>();
	}
	
	@Override
	public void initialize(HShelfFramework framework, HShelfComponent component) {
		this.framework = framework;
		this.component = component;
	}

	@Override
	public HShelfProvidesPort getProvidesPort(String name) {
		
		return this.providesPortMap.get(name);
		
	}

	@Override
	public void setProvidesPort(HShelfProvidesPort port) {
		this.providesPortMap.put(port.getName(), port);
		this.framework.addProvidesPort(port);
	}

	@Override
	public void registerUsesPort(HShelfUsesPort port) {
		this.usesPortMap.put(port.getName(), port);
		this.framework.addUsesPort(port);
	}

	

}

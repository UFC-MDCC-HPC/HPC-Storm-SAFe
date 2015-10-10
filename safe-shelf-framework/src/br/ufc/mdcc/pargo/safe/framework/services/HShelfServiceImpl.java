package br.ufc.mdcc.pargo.safe.framework.services;

import java.util.HashMap;
import java.util.Map;

import br.ufc.mdcc.pargo.safe.framework.HShelfFramework;
import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfProvidesPortNotFoundException;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfTaskPortNotFoundException;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfPort;
import br.ufc.mdcc.pargo.safe.framework.util.HShelfConsoleLogger;

public class HShelfServiceImpl implements IHShelfService{

	private HShelfFramework framework;
	private HShelfComponent component;
	private Map<String, HShelfPort> providesPortMap;
	private Map<String, HShelfPort> usesPortBidingMap;
	
	private Map<String, HShelfPort> taskPortMap;
	private Map<String, HShelfPort> taskPortBidingMap;
	
	public HShelfServiceImpl() {
		HShelfConsoleLogger.write("Creating HShelfServiceImpl");
		this.providesPortMap = new HashMap<String, HShelfPort>();
		this.usesPortBidingMap = new HashMap<String, HShelfPort>();
		this.taskPortMap = new HashMap<String, HShelfPort>();
		this.taskPortBidingMap = new HashMap<String, HShelfPort>();
	}
	
	@Override
	public void initialize(HShelfFramework framework, HShelfComponent component) {
		this.framework = framework;
		this.component = component;
	}

	@Override
	public HShelfPort getProvidesPort(String name) throws HShelfProvidesPortNotFoundException{
		
		HShelfPort providesImpl = this.framework.getProvidesPort(name);
		if(providesImpl !=null){
			this.usesPortBidingMap.put(name, providesImpl);
			return providesImpl;
		}else{
			throw new HShelfProvidesPortNotFoundException();
		}
		
	}

	@Override
	public void setProvidesPort(HShelfPort port) {
		this.providesPortMap.put(port.getName(), port);
		this.framework.addProvidesPort(port);
		port.setParentComponent(component);
	}

	@Override
	public HShelfPort getTaskPort(String name) throws HShelfException {
		HShelfPort taskImpl = this.framework.getTaskPort(name);
		if(taskImpl !=null){
			this.taskPortBidingMap.put(name, taskImpl);
			return taskImpl;
		}else{
			throw new HShelfTaskPortNotFoundException();
		}
	}

	@Override
	public void setTaskPort(HShelfPort port) throws HShelfException {
		this.taskPortMap.put(port.getName(), port);
		this.framework.addTaskPort(port);
		port.setParentComponent(component);
	}
	
}

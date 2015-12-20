package br.ufc.mdcc.pargo.safe.framework.services;

import java.util.HashMap;
import java.util.Map;

import br.ufc.mdcc.pargo.safe.framework.HShelfFramework;
import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfProvidesPortNotFoundException;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfTaskPortNotFoundException;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfProvidesPort;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfTaskPort;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfUsesPort;
import br.ufc.mdcc.pargo.safe.framework.util.HShelfConsoleLogger;

public class HShelfServiceImpl implements IHShelfService{

	private HShelfFramework framework;
	private HShelfComponent component;
	private Map<String, HShelfProvidesPort> providesPortMap;
	private Map<String, HShelfUsesPort> usesPortMap;
	private Map<String, HShelfUsesPort> usesPortBidingMap;
	
	private Map<String, HShelfTaskPort> taskPortMap;
	private Map<String, HShelfTaskPort> taskPortBidingMap;
	
	public HShelfServiceImpl() {
		HShelfConsoleLogger.write("Creating HShelfServiceImpl");
		this.providesPortMap = new HashMap<String, HShelfProvidesPort>();
		this.usesPortMap = new HashMap<String, HShelfUsesPort>();
		this.usesPortBidingMap = new HashMap<String, HShelfUsesPort>();
		this.taskPortMap = new HashMap<String, HShelfTaskPort>();
		this.taskPortBidingMap = new HashMap<String, HShelfTaskPort>();
	}
	
	@Override
	public void initialize(HShelfFramework framework, HShelfComponent component) {
		this.framework = framework;
		this.component = component;
	}

	//thats strange
	@Override
	public HShelfUsesPort getProvidesPort(String usesPortName) throws HShelfProvidesPortNotFoundException{
		
		HShelfUsesPort usesImpl = this.framework.getProvidesPort(usesPortName);
		if(usesImpl !=null){
			this.usesPortBidingMap.put(usesPortName, usesImpl);
			return usesImpl;
		}else{
			throw new HShelfProvidesPortNotFoundException();
		}
		
	}

	@Override
	public void setProvidesPort(HShelfProvidesPort port) {
		this.providesPortMap.put(port.getName(), port);
		this.framework.addProvidesPort(port);
		port.setParentComponent(component);
	}

	@Override
	public HShelfTaskPort getTaskPort(String name) throws HShelfException {
		HShelfTaskPort taskImpl = this.framework.getTaskPort(name);
		if(taskImpl !=null){
			this.taskPortBidingMap.put(name, taskImpl);
			return taskImpl;
		}else{
			throw new HShelfTaskPortNotFoundException();
		}
	}

	@Override
	public void setTaskPort(HShelfTaskPort port) throws HShelfException {
		this.taskPortMap.put(port.getName(), port);
		this.framework.addTaskPort(port);
		port.setParentComponent(component);
	}

	@Override
	public void registerUsesPort(HShelfUsesPort port) throws HShelfException {
		this.framework.registerUsesPort(port);
		this.usesPortMap.put(port.getName(),port);
	}
	
}

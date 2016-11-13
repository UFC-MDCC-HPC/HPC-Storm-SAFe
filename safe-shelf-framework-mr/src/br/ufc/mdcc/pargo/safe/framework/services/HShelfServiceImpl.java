package br.ufc.mdcc.pargo.safe.framework.services;

import java.util.HashMap;
import java.util.Map;

import br.ufc.mdcc.pargo.safe.framework.HShelfFramework;
import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfTaskPortNotFoundException;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfPort;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfProvidesPort;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfTaskPort;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfUsesPort;
import br.ufc.mdcc.pargo.safe.framework.util.HShelfConsoleLogger;

public class HShelfServiceImpl implements IHShelfService{

	private HShelfFramework framework;
	private HShelfComponent component;
	private Map<String, HShelfProvidesPort> providesPortMap;
	private Map<String, HShelfUsesPort> usesPortMap; 
	private Map<String, HShelfTaskPort> taskPortMap;
	
	
	public HShelfServiceImpl() {
		
		this.providesPortMap = new HashMap<String, HShelfProvidesPort>();
		this.usesPortMap = new HashMap<String, HShelfUsesPort>();
		this.taskPortMap = new HashMap<String, HShelfTaskPort>();
	}
	
	@Override
	public void initialize(HShelfFramework framework, HShelfComponent component) {
		this.framework = framework;
		this.component = component;
		HShelfConsoleLogger.write("Initializing HShelfServiceImpl for "+this.component.getName());
	}

	@Override
	public void setProvidesPort(HShelfProvidesPort port) {
		this.providesPortMap.put(port.getName(), port);
		this.framework.addProvidesPort(port);
		port.setParentComponent(component);
	}
	
	@Override
	public void registerUsesPort(String name, String type) throws HShelfException {
		
		HShelfUsesPort usesPort = new HShelfUsesPort();
		usesPort.setName(name);
		usesPort.setType(type);
		this.framework.registerUsesPort(usesPort);
		this.usesPortMap.put(name, usesPort);
		
		
	}
	
	@Override
	public void registerTaskPort(HShelfTaskPort port) throws HShelfException {
		this.taskPortMap.put(port.getName(), port);
		this.framework.addTaskPort(port);
		port.setParentComponent(component);
	}

	
	//@Override
	public HShelfPort getPort(String portName) throws HShelfException{
		
		return this.framework.getPort(portName);
		
		
		
	}
	
	public HShelfProvidesPort getConnectedProvidesPort(String usesPortName) throws HShelfException{
		String providesName = this.framework.getEnvConnections().get(usesPortName);
		

		if(providesName!=null){
			HShelfProvidesPort providesPort =  this.framework.getProvidesPortMap().get(providesName);
			return providesPort;
		}
		return null;
	}

	
	@Override
	public HShelfPort getTaskPort(String name) throws HShelfException {
		HShelfTaskPort taskImpl = this.framework.getTaskPort(name);
		if(taskImpl !=null){
			return taskImpl;
		}else{
			throw new HShelfTaskPortNotFoundException();
		}
	}

	@Override
	public void waitPort(String name) {
		this.framework.waitPort(name);
		
	}

	@Override
	public boolean testPort(String name) {
		return this.framework.testPort(name);
	}

	public void clear(){
		this.providesPortMap.clear();
		this.usesPortMap.clear();
		this.taskPortMap.clear();
	}
	
}

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
import br.ufc.mdcc.pargo.safe.framework.workflow.HShelfWorkflow;

public class HShelfServiceImpl implements IHShelfService{

	private HShelfFramework framework;
	private HShelfComponent component;
	private Map<String, HShelfProvidesPort> providesPortMap;
	private Map<String, HShelfUsesPort> usesPortMap; 
	private Map<String, HShelfTaskPort> taskPortMap;
	
	
	public HShelfServiceImpl() {
		HShelfConsoleLogger.write("Creating HShelfServiceImpl");
		this.providesPortMap = new HashMap<String, HShelfProvidesPort>();
		this.usesPortMap = new HashMap<String, HShelfUsesPort>();
		//this.usesPortBidingMap = new HashMap<String, HShelfUsesPort>();
		this.taskPortMap = new HashMap<String, HShelfTaskPort>();
		//this.taskPortBidingMap = new HashMap<String, HShelfTaskPort>();
	}
	
	@Override
	public void initialize(HShelfFramework framework, HShelfComponent component) {
		this.framework = framework;
		this.component = component;
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
		
		//default connections
		/*if (name.equals(HShelfWorkflow.SAFE_WORKFLOW_SWL_PORT)
				|| name.equals(HShelfWorkflow.SAFE_WORKFLOW_GO_PORT)
				|| name.equals(HShelfWorkflow.SAFE_WORKFLOW_EVENT_PORT)){
			
			this.framework.connect(name, name);
			
		}*/
	}
	
	@Override
	public void registerTaskPort(HShelfTaskPort port) throws HShelfException {
		this.taskPortMap.put(port.getName(), port);
		this.framework.addTaskPort(port);
		port.setParentComponent(component);
	}

	
	//@Override
	public HShelfPort getPort(String usesPortName) throws HShelfException{
		
		HShelfUsesPort usesImpl = this.framework.getPort(usesPortName);
		if(usesImpl !=null){ 
			return usesImpl;
		}else{
			throw new HShelfException();
		}
		
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

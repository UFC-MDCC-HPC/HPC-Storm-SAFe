package br.ufc.mdcc.pargo.safe.framework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;

import br.ufc.mdcc.pargo.safe.framework.application.HShelfApplication;
import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.core.HShelfCoreComponent;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfBuilderService;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfPort;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfProvidesPort;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfSelectionPort;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfTaskPort;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfUsesPort;
import br.ufc.mdcc.pargo.safe.framework.port.IHShelfPortTypes;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfLifeCyclePort;
import br.ufc.mdcc.pargo.safe.framework.services.HShelfServiceImpl;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.mdcc.pargo.safe.framework.util.HShelfConsoleLogger;
import br.ufc.mdcc.pargo.safe.framework.workflow.HShelfWorkflow;

public class HShelfFramework extends HShelfBuilderService {

	private Map<String, HShelfProvidesPort> providesPortMap;
	private Map<String, HShelfUsesPort> usesPortMap;
	private Map<String, HShelfTaskPort> taskPortMap;
	private Map<String, HShelfComponent> componentMap;
	private Map<String, Semaphore> semaphoreUses;
	private Map<String, String> envConnections;
	private HShelfWorkflow workflow;

	//private HShelfWorkflow workflow;
	private HShelfApplication application;


	// private ISAFeSWLArcherParser archParser;

	public HShelfFramework() {
		HShelfConsoleLogger.write("Creating HShelfFramework");
		this.providesPortMap = new HashMap<String, HShelfProvidesPort>();
		this.usesPortMap = new HashMap<String, HShelfUsesPort>();
		this.componentMap = new HashMap<String, HShelfComponent>();
		this.taskPortMap = new HashMap<String, HShelfTaskPort>();
		this.semaphoreUses = new HashMap<String, Semaphore>();
		this.envConnections = new HashMap<String, String>();
		
	}

	public void initialize(HShelfApplication application) {
		this.application = application;

		

		// application
		IHShelfService serviceApp = new HShelfServiceImpl();
		serviceApp.initialize(this, this.application);
		
		//default ports
		try {
			serviceApp.registerUsesPort(HShelfWorkflow.SAFE_WORKFLOW_SWL_PORT,IHShelfPortTypes.DEFAULT);
			serviceApp.registerUsesPort(HShelfWorkflow.SAFE_WORKFLOW_GO_PORT,IHShelfPortTypes.DEFAULT);
			this.connect(HShelfWorkflow.SAFE_WORKFLOW_SWL_PORT, HShelfWorkflow.SAFE_WORKFLOW_SWL_PORT);
			this.connect(HShelfWorkflow.SAFE_WORKFLOW_GO_PORT, HShelfWorkflow.SAFE_WORKFLOW_GO_PORT);
		} catch (HShelfException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		//selection port
		HShelfSelectionPort selectionPort = new HShelfSelectionPort(this.application);
		selectionPort.setName(HShelfApplication.SELECTION_PORT_PRV);
		try {
			serviceApp.setProvidesPort(selectionPort);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.application.setServices(serviceApp);

		// adding
		this.addComponent(this.application);
		
		//Core Component
		HShelfCoreComponent coreComponent = new HShelfCoreComponent();
		coreComponent.setName("core-component");
		IHShelfService serviceImpl = new HShelfServiceImpl();
		serviceImpl.initialize(this, coreComponent);
		coreComponent.setServices(serviceImpl);
		this.addComponent(coreComponent);
		

	}

	@Override
	public HShelfComponent createComponent(String name, String className) {
		HShelfComponent component = null;
		try {
			component = (HShelfComponent) Class.forName(className)
					.newInstance();
			component.setName(name);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return component;
	}

	@Override
	public HShelfComponent getComponent(String name) {
		return this.componentMap.get(name);
	}

	@Override
	public List<HShelfComponent> getComponents() {
		List<HShelfComponent> list = new ArrayList<HShelfComponent>();
		for (HShelfComponent component : this.componentMap.values())
			list.add(component);
		return list;
	}

	@Override
	public List<HShelfProvidesPort> getProvidesPortList() {
		List<HShelfProvidesPort> list = new ArrayList<HShelfProvidesPort>();
		for (HShelfProvidesPort port : this.providesPortMap.values())
			list.add(port);
		return list;
	}

	@Override
	public List<HShelfUsesPort> getUsesPortList() {
		List<HShelfUsesPort> list = new ArrayList<HShelfUsesPort>();
		for (HShelfUsesPort port : this.usesPortMap.values())
			list.add(port);
		return list;
	}

	@Override
	public List<HShelfTaskPort> getTaskPortList() {
		List<HShelfTaskPort> list = new ArrayList<HShelfTaskPort>();
		for (HShelfTaskPort port : this.taskPortMap.values())
			list.add(port);
		return list;
	}

	public void addComponent(HShelfComponent component) {

		this.componentMap.put(component.getName(), component);
		if (!component.hasServices()) {
			IHShelfService serviceImpl = new HShelfServiceImpl();
			serviceImpl.initialize(this, component);
			/*LifeCyclePort*/
			HShelfLifeCyclePort lcPort = new HShelfLifeCyclePort(component);
			lcPort.setName(component.getLifeCyclePortName());
			try {
				serviceImpl.registerTaskPort(lcPort);
			} catch (HShelfException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*Selection*/
			try {
				serviceImpl.registerUsesPort(component.getSelectionPortName(),"DEFAULT");
				this.connect(component.getSelectionPortName(), HShelfApplication.SELECTION_PORT_PRV);
			} catch (HShelfException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			/*Workflow*/
			try {
				serviceImpl.registerUsesPort(component.getWorkflowServicesPortName(),"DEFAULT");
				this.connect(component.getWorkflowServicesPortName(), HShelfCoreComponent.WORKFLOW_SERVICES_PRV);
			} catch (HShelfException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			component.setServices(serviceImpl);
		}

		HShelfConsoleLogger
				.write("Component " + component.getName() + " added");
	}

	public void addProvidesPort(HShelfProvidesPort port) {
		
		this.providesPortMap.put(port.getName(), port);

	}

	 
	public HShelfPort getPort(String portName) {
		
		if(this.usesPortMap.containsKey(portName))
			return this.usesPortMap.get(portName);
		
		
		if(this.providesPortMap.containsKey(portName))
			return this.providesPortMap.get(portName);
		
		return null;
	}

	public void addTaskPort(HShelfTaskPort port) {
		//System.out.println("ADDING: " + port.getName());
		this.taskPortMap.put(port.getName(), port);

	}

	public HShelfTaskPort getTaskPort(String name) {
		return this.taskPortMap.get(name);
	}

	 
	
	public Map<String, String> getEnvConnections() {
		return envConnections;
	}

	public Map<String, HShelfProvidesPort> getProvidesPortMap() {
		return providesPortMap;
	}

	public Map<String, HShelfUsesPort> getUsesPortMap() {
		return usesPortMap;
	}

	@Override
	public void connect(String usesPortName, String providesPortName) {

		if (usesPortName.startsWith(HShelfWorkflow.SAFE_WORKFLOW_SWL_PORT)
				|| usesPortName.startsWith(HShelfWorkflow.SAFE_WORKFLOW_GO_PORT)
				|| usesPortName.startsWith(HShelfWorkflow.SAFE_WORKFLOW_EVENT_PORT)) {
			
			
			
			Semaphore s = this.semaphoreUses.get(usesPortName);
			if(s!=null) s.release();
			
			
		}

		
		HShelfPort uses = this.usesPortMap.get(usesPortName);
		if (uses != null && uses instanceof HShelfUsesPort) {
			
			
			//HShelfConsoleLogger.write(usesPortName+"<->"+providesPortName);
			
			Semaphore s = this.semaphoreUses.get(usesPortName);
			if(s!=null) s.release();
		}
		
		this.envConnections.put(usesPortName,providesPortName);
	}

	public void registerUsesPort(HShelfUsesPort port) {
		this.usesPortMap.put(port.getName(), port);
	}

	public void waitPort(String name) {
		HShelfUsesPort uses = this.usesPortMap.get(name);
		if(uses==null) return; // throw exception here!
		
		if(this.envConnections.get(name)!=null) return;
		
		Semaphore s = this.semaphoreUses.get(name);
		if(s==null){
			s = new Semaphore(0);
			this.semaphoreUses.put(name, s);
		}
		
		try {
			s.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean testPort(String name) {
		HShelfUsesPort uses = this.usesPortMap.get(name);
		if(uses==null) return false;
		return this.envConnections.get(name)!=null;
	}

	
	public void connectPartners(String taskA, String taskB) {
		
		HShelfTaskPort taskPortA = this.getTaskPort(taskA);
		if(taskPortA!=null && !taskPortA.isConnected()){
			HShelfTaskPort taskPortB = this.getTaskPort(taskB);
			taskPortA.setPartner(taskPortB);
			taskPortB.setPartner(taskPortA);
		}
		
	}
	
	public void clear(){
		
		this.providesPortMap.clear();
		this.usesPortMap.clear();
		this.taskPortMap.clear();
		this.componentMap.clear();
		this.componentMap.clear();
		 
		 
	}

	@Override
	public void createWorkflow() {
		
		IHShelfService serviceWf = new HShelfServiceImpl();
		this.workflow = new HShelfWorkflow(this.application.getName()
				+ "-worflow", this);
		serviceWf.initialize(this,workflow);
		
		try {
			serviceWf.registerUsesPort(HShelfCoreComponent.WORKFLOW_SERVICES_USE,"DEFAULT");
			this.connect(HShelfCoreComponent.WORKFLOW_SERVICES_USE, HShelfCoreComponent.WORKFLOW_SERVICES_PRV);
		} catch (HShelfException e) {
			
			e.printStackTrace();
		}
		workflow.setServices(serviceWf);
		
	}

}
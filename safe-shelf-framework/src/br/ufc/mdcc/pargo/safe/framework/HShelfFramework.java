package br.ufc.mdcc.pargo.safe.framework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;

import br.ufc.mdcc.pargo.safe.framework.application.HShelfApplication;
import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfBuilderService;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfPort;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfProvidesPort;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfTaskPort;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfUsesPort;
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
	private List<HShelfWorkflow> workflows;

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
		this.workflows = new ArrayList<HShelfWorkflow>();
	}

	public void initialize(HShelfApplication application) {
		this.application = application;

		// workflow
		/*this.workflow = new HShelfWorkflow(this.application.getName()
				+ "-worflow", this);
		IHShelfService serviceWf = new HShelfServiceImpl();
		serviceWf.initialize(this, this.workflow);
		this.workflow.setServices(serviceWf);*/

		// application
		IHShelfService serviceApp = new HShelfServiceImpl();
		serviceApp.initialize(this, this.application);
		this.application.setServices(serviceApp);

		// adding
		//this.addComponent(this.workflow);
		this.addComponent(this.application);

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
			component.setServices(serviceImpl);
		}

		HShelfConsoleLogger
				.write("Component " + component.getName() + " added");
	}

	public void addProvidesPort(HShelfProvidesPort port) {
		// System.out.println("ADDING PROVIDES PORT: " + port.getName());
		this.providesPortMap.put(port.getName(), port);

	}

	// strange...CONNECT
	// getPort
	public HShelfUsesPort getPort(String usesPortName) {
		// name é o nome da porta usuário
		// buscar quem está ligado nessa porta usuária
		// via mapa criado a partir da descricao arquitetural
		// retornas a porta usuária conectada com a porta provedora...
		// this.connect(usesPortName);
		return this.usesPortMap.get(usesPortName);
	}

	public void addTaskPort(HShelfTaskPort port) {
		System.out.println("ADDING: " + port.getName());
		this.taskPortMap.put(port.getName(), port);

	}

	public HShelfTaskPort getTaskPort(String name) {
		return this.taskPortMap.get(name);
	}

	// workflow repassa
	/*
	 * public void setArchParser(ISAFeSWLArcherParser archParser) {
	 * this.archParser = archParser; }
	 */

	@Override
	public void connect(String usesPortName, String providesPortName) {

		if (usesPortName.startsWith(HShelfWorkflow.SAFE_WORKFLOW_SWL_PORT)
				|| usesPortName.startsWith(HShelfWorkflow.SAFE_WORKFLOW_GO_PORT)
				|| usesPortName.startsWith(HShelfWorkflow.SAFE_WORKFLOW_EVENT_PORT)) {
			HShelfProvidesPort providesPort = (HShelfProvidesPort) this.providesPortMap
					.get(usesPortName);
			HShelfPort port = this.usesPortMap.get(usesPortName);
			HShelfUsesPort usesPort = (HShelfUsesPort) port;
			usesPort.setProvidesPort(providesPort);
			
			
			Semaphore s = this.semaphoreUses.get(usesPortName);
			if(s!=null) s.release();
			
			return;
		}

		
		HShelfPort uses = this.usesPortMap.get(usesPortName);
		if (uses != null && uses instanceof HShelfUsesPort) {
			HShelfUsesPort usesPort = (HShelfUsesPort) uses;
	
			HShelfProvidesPort providesPort = (HShelfProvidesPort) this.providesPortMap
					.get(providesPortName);
			usesPort.setProvidesPort(providesPort);
			Semaphore s = this.semaphoreUses.get(usesPortName);
			if(s!=null) s.release();
		}
		

	}

	public void registerUsesPort(HShelfUsesPort port) {
		this.usesPortMap.put(port.getName(), port);
	}

	public void waitPort(String name) {
		HShelfUsesPort uses = this.usesPortMap.get(name);
		if(uses==null) return; // throw exception here!
		
		if(uses.isConnected()) return;
		
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
		return uses.isConnected();
	}

	@Override
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
		HShelfWorkflow workflow = new HShelfWorkflow(this.application.getName()
				+ "-worflow", this);
		IHShelfService serviceWf = new HShelfServiceImpl();
		serviceWf.initialize(this,workflow);
		workflow.setServices(serviceWf);
		//this.addComponent(this.workflow);
		this.workflows.add(workflow);
		
	}

}

package br.ufc.mdcc.pargo.safe.framework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.ufc.mdcc.pargo.safe.framework.application.HShelfApplication;
import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfBuilderService;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfPort;
import br.ufc.mdcc.pargo.safe.framework.services.HShelfServiceImpl;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.mdcc.pargo.safe.framework.util.HShelfConsoleLogger;
import br.ufc.mdcc.pargo.safe.framework.workflow.HShelfWorkflow;

public class HShelfFramework extends HShelfBuilderService{

	
	private Map<String,HShelfPort> providesPortMap;
	private Map<String,HShelfPort> taskPortMap;
	private Map<String,HShelfComponent> componentMap;
	
	private HShelfWorkflow workflow;
	private HShelfApplication application;
	
	
	public HShelfFramework() {
		HShelfConsoleLogger.write("Creating HShelfFramework");
		this.providesPortMap = new HashMap<String,HShelfPort>();
		this.componentMap = new HashMap<String,HShelfComponent>();
		this.taskPortMap = new HashMap<String, HShelfPort>();
	}
	
	public void initialize(HShelfApplication application){
		this.application = application;
		
		//workflow
		this.workflow = new HShelfWorkflow(this.application.getName()+"-worflow",this);
		IHShelfService serviceWf = new HShelfServiceImpl();
		serviceWf.initialize(this, this.workflow);
		this.workflow.setServices(serviceWf);
		
		//application
		IHShelfService serviceApp = new HShelfServiceImpl();
		serviceApp.initialize(this, this.application);
		this.application.setServices(serviceApp);
		
		//adding
		this.addComponent(this.workflow);
		this.addComponent(this.application);
		
	}
	
	@Override
	public HShelfComponent createComponent(String name, String className) {
		HShelfComponent component = null;
		try {
			component = (HShelfComponent)Class.forName(className).newInstance();
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
		for(HShelfComponent component:this.componentMap.values())
			list.add(component);
		return list;
	}

	@Override
	public List<HShelfPort> getProvidesPortList() {
		List<HShelfPort> list = new ArrayList<HShelfPort>();
		for(HShelfPort port:this.providesPortMap.values())
			list.add(port);
		return list;
	}

	@Override
	public List<HShelfPort> getTaskPortList() {
		List<HShelfPort> list = new ArrayList<HShelfPort>();
		for(HShelfPort port:this.taskPortMap.values())
			list.add(port);
		return list;
	} 

	public void addComponent(HShelfComponent component){
		
		this.componentMap.put(component.getName(),component);
		if(!component.hasServices()){
			IHShelfService serviceImpl = new HShelfServiceImpl();
			serviceImpl.initialize(this, component); 
			component.setServices(serviceImpl);
		}
		
		HShelfConsoleLogger.write("Component "+component.getName()+" added");
	}
	
	public void addProvidesPort(HShelfPort port){
		System.out.println("ADDING: " + port.getName());
		this.providesPortMap.put(port.getName(),port);
		
	}
	
	public HShelfPort getProvidesPort(String name){
		
		return this.providesPortMap.get(name);
	}
	
	public void addTaskPort(HShelfPort port){
		System.out.println("ADDING: " + port.getName());
		this.taskPortMap.put(port.getName(),port);
		
	}
	
	public HShelfPort getTaskPort(String name){
		return this.taskPortMap.get(name);
	}

	
}

package br.ufc.mdcc.pargo.safe.services;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

import br.ufc.mdcc.pargo.safe.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.HShelfFramework;
import br.ufc.mdcc.pargo.safe.port.HShelfPort;
import br.ufc.mdcc.pargo.safe.util.HShelfConsoleLogger;

public class HShelfServiceImpl implements IHShelfService{

	private HShelfFramework framework;
	private HShelfComponent component;
	private Map<String, HShelfPort> providesPortMap;
	private Map<String, HShelfPort> usesPortMap;
	private Map<String, Semaphore> providesSemaphore;
	
	public HShelfServiceImpl() {
		HShelfConsoleLogger.write("Creating HShelfServiceImpl");
		this.providesPortMap = new HashMap<String, HShelfPort>();
		this.usesPortMap = new HashMap<String, HShelfPort>();
		this.providesSemaphore = new HashMap<String, Semaphore>();
	}
	
	@Override
	public void initialize(HShelfFramework framework, HShelfComponent component) {
		this.framework = framework;
		this.component = component;
	}

	@Override
	public HShelfPort getProvidesPort(String name) {
		
		HShelfPort providesImpl = this.framework.getProvidesPort(name);
		if(providesImpl !=null){
			this.usesPortMap.put(name, providesImpl);
			return providesImpl;
		}else{
			Semaphore semaphore = new Semaphore(0);
			this.providesSemaphore.put(name, semaphore);
			try {
				semaphore.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		providesImpl = this.framework.getProvidesPort(name);
		this.usesPortMap.put(name, providesImpl);
		return providesImpl;
		
	}

	@Override
	public void addProvidesPort(HShelfPort port) {
		this.providesPortMap.put(port.getName(), port);
		this.framework.addProvidesPort(port);
		port.setParentComponent(component);
	}

	@Override
	public boolean notifySemaphoreRelease(String name){
		Semaphore semaphore = this.providesSemaphore.get(name);
		if(semaphore!=null){
			semaphore.release();
			return true;
		}
		return false;
			
	}
	

}

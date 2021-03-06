package br.ufc.mdcc.pargo.safe.framework.application;

import br.ufc.mdcc.pargo.safe.framework.HShelfFramework;
import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.util.HShelfConsoleLogger;

public abstract class HShelfApplication extends HShelfComponent{
	
	private HShelfFramework framework;
	
	
	public HShelfApplication(String name) {
		HShelfConsoleLogger.write("Creating HShelfApplication");
		this.setName(name);
		this.initialize();
	}
	
	public void initialize(){
		this.framework = new HShelfFramework();
		this.framework.initialize(this);
	}
	
	public HShelfFramework getFramework(){
		return this.framework;
	}
	
}

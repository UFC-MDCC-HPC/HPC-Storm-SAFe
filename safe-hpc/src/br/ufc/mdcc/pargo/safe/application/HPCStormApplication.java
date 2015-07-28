package br.ufc.mdcc.pargo.safe.application;

import br.ufc.mdcc.pargo.safe.component.IHPCStormComponent;
import br.ufc.mdcc.pargo.safe.factory.HPCStormFrameworkFactory;
import br.ufc.mdcc.pargo.safe.framework.IHPCStormFramework;
import br.ufc.mdcc.pargo.safe.port.IHPCStormEnvProvidesPort;
import br.ufc.mdcc.pargo.safe.service.IHPCStormServices;
import br.ufc.mdcc.pargo.safe.util.SAFeConsoleLogger;


/**
 * This interface represents the application at client-side. A provider must
 * implement this abstract class and 
 * @author jefferson
 *
 */
public abstract class HPCStormApplication implements IHPCStormComponent{
	
	private IHPCStormFramework framework = null;
	//services object
	protected IHPCStormServices services;	
	//pre def port
	protected IHPCStormEnvProvidesPort safeFeSWLPort; //ACHO QUE DEVEM SER DEFINIDAS NA CLASSE MÃE
	
	
	public HPCStormApplication() {
		SAFeConsoleLogger.write("Application created.");
		this.init();
	}
	
	protected void init(){
		
		//creating the framework for this application
		this.framework = HPCStormFrameworkFactory.getFramework();
		SAFeConsoleLogger.write("Framework created.");
		//setting the framework application parent. 
		this.framework.setApplicationComponent(this);
	}
	
	public void run(){
		//starts the framework
		Thread frameworkThread = new Thread(this.framework);
		frameworkThread.start();
	}
	
	
	public abstract void setServices(IHPCStormServices services);
	
	
}

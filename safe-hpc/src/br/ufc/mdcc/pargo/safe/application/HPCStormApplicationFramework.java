package br.ufc.mdcc.pargo.safe.application;

import br.ufc.mdcc.pargo.safe.factory.HPCStormFrameworkFactory;
import br.ufc.mdcc.pargo.safe.framework.HPCStormFramework;
import br.ufc.mdcc.pargo.safe.util.SAFeConsoleLogger;


/**
 * This interface represents the application at client-side. A provider must
 * implement this abstract class and 
 * @author jefferson
 *
 */
public abstract class HPCStormApplicationFramework {
	
	private HPCStormFramework framework = null;
	
	public HPCStormApplicationFramework() {
		SAFeConsoleLogger.write("Application created.");
		//createing the framework for this application
		this.framework = HPCStormFrameworkFactory.getFramework();
		//setting the framework application parent. 
		this.framework.setApplicationComponent(this);
		//starts the framework
		this.framework.start();
	}
	
	/**
	 * The services object is created by the framework and then assigned to the application.
	 * It is a singleton object shared by the other SAFe entities.
	 * @param services
	 */
	public abstract void setServices(IHPCStormApplicationServices services);
	
}

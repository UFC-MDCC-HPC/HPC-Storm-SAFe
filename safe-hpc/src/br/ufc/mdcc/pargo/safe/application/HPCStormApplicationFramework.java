package br.ufc.mdcc.pargo.safe.application;

import br.ufc.mdcc.pargo.safe.factory.HPCStormFrameworkFactory;
import br.ufc.mdcc.pargo.safe.framework.HPCStormFramework;


/**
 * This interface represents the application at client-side. A provider must
 * implement this abstract class and 
 * @author jefferson
 *
 */
public abstract class HPCStormApplicationFramework {
	
	private HPCStormFramework framework = null;
	
	public HPCStormApplicationFramework() {
		this.framework = HPCStormFrameworkFactory.getFramework();
		this.framework.setApplicationComponent(this);
	}
	
	public abstract void setServices(IHPCStormApplicationServices services);
	
}

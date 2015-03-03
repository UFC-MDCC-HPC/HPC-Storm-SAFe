package br.ufc.mdcc.pargo.safe.factory;

import br.ufc.mdcc.pargo.safe.framework.HPCStormFramework;

public class HPCStormFrameworkFactory {
	
	private static HPCStormFramework framework = null;
	
	public static HPCStormFramework getFramework(){
		if(framework!=null)
			return framework;
		
		framework = new HPCStormFramework();
		return framework;
	}

}

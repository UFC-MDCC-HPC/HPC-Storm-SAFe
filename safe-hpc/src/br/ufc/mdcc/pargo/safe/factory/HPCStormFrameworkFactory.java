package br.ufc.mdcc.pargo.safe.factory;

import br.ufc.mdcc.pargo.safe.framework.HPCStormFramework;
import br.ufc.mdcc.pargo.safe.framework.IHPCStormFramework;

public class HPCStormFrameworkFactory {
	
	private static IHPCStormFramework framework = null;
	
	public static IHPCStormFramework getFramework(){
		if(framework!=null)
			return framework;
		
		framework = new HPCStormFramework();
		return framework;
	}

}

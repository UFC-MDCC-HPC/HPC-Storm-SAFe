package br.ufc.mdcc.pargo.safe.framework;

import br.ufc.mdcc.pargo.safe.application.HPCStormApplication;

public interface IHPCStormFramework extends Runnable{

	public void setApplicationComponent(HPCStormApplication applicationComponent);
	
}

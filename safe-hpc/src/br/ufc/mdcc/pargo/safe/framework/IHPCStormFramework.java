package br.ufc.mdcc.pargo.safe.framework;

import br.ufc.mdcc.pargo.safe.application.HPCStormApplicationFramework;

public interface IHPCStormFramework extends Runnable{

	public void setApplicationComponent(HPCStormApplicationFramework applicationComponent);
}

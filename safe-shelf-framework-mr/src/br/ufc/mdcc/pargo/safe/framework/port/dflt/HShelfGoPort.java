package br.ufc.mdcc.pargo.safe.framework.port.dflt;

import br.ufc.mdcc.pargo.safe.framework.port.HShelfProvidesPort;

public abstract class HShelfGoPort extends HShelfProvidesPort{

	public abstract void go();
	public abstract void loadArchitectureFile();
	public abstract void loadWorkflowFile();
}

package br.ufc.mdcc.pargo.safe.sample.application;

import br.ufc.mdcc.pargo.safe.framework.port.HShelfUsesPort;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfGoWorkflowPortImpl;

public class ClientServerUsesWFGo extends HShelfUsesPort{

	public void loadArchitectureFile(){
		((HShelfGoWorkflowPortImpl)this.providesPort).loadArchitectureFile();
	}
	
	public void loadWorkflowFile(){
		((HShelfGoWorkflowPortImpl)this.providesPort).loadWorkflowFile();
	}
	
	public void go() {
		((HShelfGoWorkflowPortImpl)this.providesPort).go();
	}
}

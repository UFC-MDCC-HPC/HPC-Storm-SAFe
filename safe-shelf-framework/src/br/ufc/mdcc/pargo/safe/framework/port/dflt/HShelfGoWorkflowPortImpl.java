package br.ufc.mdcc.pargo.safe.framework.port.dflt;

import br.ufc.mdcc.pargo.safe.framework.workflow.HShelfWorkflow;

public class HShelfGoWorkflowPortImpl extends HShelfGoPort{

	public HShelfWorkflow workflow;
	
	@Override
	public void go() {
		workflow.run();
	}

}

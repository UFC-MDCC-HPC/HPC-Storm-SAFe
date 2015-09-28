package br.ufc.mdcc.pargo.safe.port.dflt;

import br.ufc.mdcc.pargo.safe.workflow.HShelfWorkflow;

public class HShelfGoWorkflowPortImpl extends HShelfGoPort{

	public HShelfWorkflow workflow;
	
	@Override
	public void go() {
		workflow.run();
	}

}

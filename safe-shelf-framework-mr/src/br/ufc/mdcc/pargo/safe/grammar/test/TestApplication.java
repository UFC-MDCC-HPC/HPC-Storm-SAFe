package br.ufc.mdcc.pargo.safe.grammar.test;

import br.ufc.mdcc.pargo.safe.framework.application.HShelfApplication;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.port.IHShelfPortTypes;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.mdcc.pargo.safe.framework.workflow.HShelfWorkflow;

public class TestApplication extends HShelfApplication {

	public TestApplication(String name) {
		super(name);
		this.getFramework().createWorkflow();
	}

	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
		try {
			this.services.registerUsesPort(
					HShelfWorkflow.SAFE_WORKFLOW_SWL_PORT,
					IHShelfPortTypes.DEFAULT);
			this.services.registerUsesPort(
					HShelfWorkflow.SAFE_WORKFLOW_GO_PORT,
					IHShelfPortTypes.DEFAULT);

		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() throws HShelfException {
		if (this.services != null) {

			/*this.getFramework().connect(HShelfWorkflow.SAFE_WORKFLOW_SWL_PORT,
					HShelfWorkflow.SAFE_WORKFLOW_SWL_PORT);
			this.services.getConnectedProvidesPort(usesPortName)
			HShelfSAFeSWLPort safeSWLPort = (HShelfSAFeSWLPort) ((HShelfUsesPort) this.services
					.getPort(HShelfWorkflow.SAFE_WORKFLOW_SWL_PORT))
					.getProvidesPort();
			String archFile = "/home/jefferson/Git/HPC-Storm-SAFe/safe-shelf-framework/src/br/ufc/mdcc/pargo/safe/grammar/xml/tutorial-arch.xml";
			String flowFile = "/home/jefferson/Git/HPC-Storm-SAFe/safe-shelf-framework/src/br/ufc/mdcc/pargo/safe/grammar/xml/tutorial-flow.xml";
			safeSWLPort.setSAFeSWLArchFilePath(archFile);
			safeSWLPort.setSAFeSWLFlowFilePath(flowFile);

			this.getFramework().connect(HShelfWorkflow.SAFE_WORKFLOW_GO_PORT,
					HShelfWorkflow.SAFE_WORKFLOW_GO_PORT);
			HShelfGoWorkflowPortImpl goWorkflowPort = (HShelfGoWorkflowPortImpl) ((HShelfUsesPort) this.services
					.getPort(HShelfWorkflow.SAFE_WORKFLOW_GO_PORT))
					.getProvidesPort();
			goWorkflowPort.loadArchitectureFile();
			goWorkflowPort.loadWorkflowFile();

			goWorkflowPort.go();*/
		}
	}
	
	public static void main(String[] args) {
		TestApplication app = new TestApplication("test");
		try {
			app.run();
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

package br.ufc.mapreduce.app;

import br.ufc.mdcc.pargo.safe.framework.application.HShelfApplication;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.port.IHShelfPortTypes;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfGoWorkflowPortImpl;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfSAFeSWLPort;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.mdcc.pargo.safe.framework.workflow.HShelfWorkflow;

public class MRApplicationNovo extends HShelfApplication{

	 
	public MRApplicationNovo(String name) {
		super(name);
		this.getFramework().createWorkflow();
	}

	 
	
	@Override
	public void setServices(IHShelfService services) {
		
		this.services = services;
		
		try {
			this.services.registerUsesPort(HShelfWorkflow.SAFE_WORKFLOW_SWL_PORT+1,IHShelfPortTypes.DEFAULT);
			this.services.registerUsesPort(HShelfWorkflow.SAFE_WORKFLOW_GO_PORT+1,IHShelfPortTypes.DEFAULT);
			
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void run() throws HShelfException{
		if(this.services!=null){
			
			this.getFramework().connect(HShelfWorkflow.SAFE_WORKFLOW_SWL_PORT+1, HShelfWorkflow.SAFE_WORKFLOW_SWL_PORT+1);
			HShelfSAFeSWLPort safeSWLPort = (HShelfSAFeSWLPort)this.services.getConnectedProvidesPort(HShelfWorkflow.SAFE_WORKFLOW_SWL_PORT+1);
			String archFile = "/home/jefferson/git/HPC-Storm-SAFe/safe-shelf-framework-mr-app/src/xml/mr-arch-stub.xml";
			String flowFile = "/home/jefferson/git/HPC-Storm-SAFe/safe-shelf-framework-mr-app/src/xml/mr-flow-stub.xml";
			safeSWLPort.setSAFeSWLArchFilePath(archFile);
			safeSWLPort.setSAFeSWLFlowFilePath(flowFile);
			
			this.getFramework().connect(HShelfWorkflow.SAFE_WORKFLOW_GO_PORT+1, HShelfWorkflow.SAFE_WORKFLOW_GO_PORT+1);
			HShelfGoWorkflowPortImpl goWorkflowPort = (HShelfGoWorkflowPortImpl)this.services.getConnectedProvidesPort(HShelfWorkflow.SAFE_WORKFLOW_GO_PORT+1);
			goWorkflowPort.loadArchitectureFile();
			goWorkflowPort.loadWorkflowFile();
			
			goWorkflowPort.go();
		}
		
		
	}
	
	public static void main(String[] args) {
		MRApplicationNovo mr = new MRApplicationNovo("mr-application-novo");
		try {
			mr.run();
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

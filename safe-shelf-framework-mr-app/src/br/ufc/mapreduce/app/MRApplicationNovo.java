package br.ufc.mapreduce.app;

import java.util.List;

import br.ufc.mdcc.pargo.safe.framework.application.HShelfApplication;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.port.IHShelfPortTypes;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfGoWorkflowPortImpl;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfSAFeSWLPort;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.mdcc.pargo.safe.framework.util.HShelfConsoleLogger;
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
			this.services.registerUsesPort(HShelfWorkflow.SAFE_WORKFLOW_SWL_PORT,IHShelfPortTypes.DEFAULT);
			this.services.registerUsesPort(HShelfWorkflow.SAFE_WORKFLOW_GO_PORT,IHShelfPortTypes.DEFAULT);
			
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void run() throws HShelfException{
		if(this.services!=null){
			
			this.getFramework().connect(HShelfWorkflow.SAFE_WORKFLOW_SWL_PORT, HShelfWorkflow.SAFE_WORKFLOW_SWL_PORT);
			HShelfSAFeSWLPort safeSWLPort = (HShelfSAFeSWLPort)this.services.getConnectedProvidesPort(HShelfWorkflow.SAFE_WORKFLOW_SWL_PORT);
			String archFile = "/home/jefferson/git/HPC-Storm-SAFe/safe-shelf-framework-mr-app/src/xml/mr-arch-stub.xml";
			String flowFile = "/home/jefferson/git/HPC-Storm-SAFe/safe-shelf-framework-mr-app/src/xml/mr-flow-stub.xml";
			safeSWLPort.setSAFeSWLArchFilePath(archFile);
			safeSWLPort.setSAFeSWLFlowFilePath(flowFile);
			
			this.getFramework().connect(HShelfWorkflow.SAFE_WORKFLOW_GO_PORT, HShelfWorkflow.SAFE_WORKFLOW_GO_PORT);
			HShelfGoWorkflowPortImpl goWorkflowPort = (HShelfGoWorkflowPortImpl)this.services.getConnectedProvidesPort(HShelfWorkflow.SAFE_WORKFLOW_GO_PORT);
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



	@Override
	public Object selection(Object objects) {
		HShelfConsoleLogger.write("CALLING SELECTION METHOD - APPLICATION SIDE");
		return objects;
	}



	
}

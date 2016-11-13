package br.ufc.mapreduce.app;

import br.ufc.mdcc.pargo.safe.framework.application.HShelfApplication;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfGoPort;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfSAFeSWLPort;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.mdcc.pargo.safe.framework.util.HShelfConsoleLogger;
import br.ufc.mdcc.pargo.safe.framework.workflow.HShelfWorkflow;

public class MRApplicationNovo extends HShelfApplication{

	private HShelfSAFeSWLPort safeSWLPort;
	private HShelfGoPort goPort;
	 
	public MRApplicationNovo(String name) {
		super(name);
		//a aplicação que cria o workflow
		this.getFramework().createWorkflow();
	}

	 
	
	@Override
	public void setServices(IHShelfService services) {
		
		this.services = services;
		
		try {
			
			
			this.safeSWLPort = (HShelfSAFeSWLPort)this.services.getConnectedProvidesPort(HShelfWorkflow.SAFE_WORKFLOW_SWL_PORT);
			this.goPort = (HShelfGoPort)this.services.getConnectedProvidesPort(HShelfWorkflow.SAFE_WORKFLOW_GO_PORT);
			
			
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void run() throws HShelfException{
		if(this.services!=null){
			
			
			this.safeSWLPort = (HShelfSAFeSWLPort)this.services.getConnectedProvidesPort(HShelfWorkflow.SAFE_WORKFLOW_SWL_PORT);
			String archFile = "/home/jefferson/git/HPC-Storm-SAFe/safe-shelf-framework-mr-app/src/xml/mr-arch-stub.xml";
			String flowFile = "/home/jefferson/git/HPC-Storm-SAFe/safe-shelf-framework-mr-app/src/xml/mr-flow-stub.xml";
			this.safeSWLPort.setSAFeSWLArchFilePath(archFile);
			this.safeSWLPort.setSAFeSWLFlowFilePath(flowFile);
			
			
			this.goPort = (HShelfGoPort)this.services.getConnectedProvidesPort(HShelfWorkflow.SAFE_WORKFLOW_GO_PORT);
			this.goPort.loadArchitectureFile();
			this.goPort.loadWorkflowFile();
			
			this.goPort.go();
		}
		
		
	}
	
	@Override
	public Object selection(Object objects) {
		HShelfConsoleLogger.write("CALLING SELECTION METHOD - APPLICATION SIDE");
		return objects;
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

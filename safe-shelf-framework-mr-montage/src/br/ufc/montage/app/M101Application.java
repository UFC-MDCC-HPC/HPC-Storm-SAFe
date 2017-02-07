package br.ufc.montage.app;

import br.ufc.mdcc.pargo.safe.framework.application.HShelfApplication;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfGoPort;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfSAFeSWLPort;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.mdcc.pargo.safe.framework.workflow.HShelfWorkflow;

public class M101Application extends HShelfApplication{

	private HShelfSAFeSWLPort safeSWLPort;
	private HShelfGoPort goPort;
	
	public M101Application(String name) {
		super(name);
		this.getFramework().createWorkflow();
	}

	@Override
	public Object selection(Object objects) {
		// TODO Auto-generated method stub
		return objects;
	}

	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
		
	}
	
	public void run() throws HShelfException{
		//loading files 
		//Essa parte na verdade deveria ser montada por alguma GUI. As classes STUB devem ser geradas automaticamente a partir do 
		//XML arquitetural.
		this.safeSWLPort = (HShelfSAFeSWLPort)this.services.getConnectedProvidesPort(HShelfWorkflow.SAFE_WORKFLOW_SWL_PORT);
		String archFile = "/home/jefferson/git/HPC-Storm-SAFe/safe-shelf-framework-mr-montage/src/xml/m101-arch.xml";
		String flowFile = "/home/jefferson/git/HPC-Storm-SAFe/safe-shelf-framework-mr-montage/src/xml/m101-flow.xml";
		this.safeSWLPort.setSAFeSWLArchFilePath(archFile);
		this.safeSWLPort.setSAFeSWLFlowFilePath(flowFile);
		
		//GO PORT
		this.goPort = (HShelfGoPort)this.services.getConnectedProvidesPort(HShelfWorkflow.SAFE_WORKFLOW_GO_PORT);
		this.goPort.loadArchitectureFile(); //as classes poderiam ser geradas nesse momento...
		this.goPort.loadWorkflowFile();
		
		//REGISTER USES PORTS (APPLICATION SIDE)
	 
		this.services.registerUsesPort("jpg-uses-app", null);
		this.services.registerUsesPort("rawdir-uses-app", null);
		this.services.registerUsesPort("projdir-uses-app", null);
		this.services.registerUsesPort("diffdir-uses-app", null);
		this.services.registerUsesPort("corrdir-uses-app", null);
		this.services.registerUsesPort("mimgtbl-uses-app", null);
		this.services.registerUsesPort("mprojecexec-uses-app", null);
		this.services.registerUsesPort("madd-uses-app", null);
		this.services.registerUsesPort("mbgmodel-uses-app", null);
		this.services.registerUsesPort("mbgexec-uses-app", null);
		this.services.registerUsesPort("mdiffexec-uses-app", null);
		this.services.registerUsesPort("mfitexec-uses-app", null);
		this.services.registerUsesPort("moverlaps-uses-app", null);
		this.services.registerUsesPort("tmpl-hdr-prov", null);
		
		//REGISTER PROVIDES PORTS (APPLICATION SIDE)
		//NONE
		
		//CONNECTING ENV PORTS (OBRIGATÓRIO)
		this.getFramework().connectAllEnvironmentPorts();
		
		//RUN WORKFLOW
		Thread t = new Thread(){
			public void run() {
				goPort.go();
			};
		};
		t.start();

	}
	
	public static void main(String[] args) {
		M101Application m101 = new M101Application("M101");
		try {
			m101.run();
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

package br.ufc.montage.app;

import java.util.GregorianCalendar;

import br.ufc.mdcc.pargo.safe.framework.application.HShelfApplication;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfUsesPort;
import br.ufc.mdcc.pargo.safe.framework.port.IHShelfPortTypes;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfGoWorkflowPortImpl;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfSAFeSWLPort;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.mdcc.pargo.safe.framework.workflow.HShelfWorkflow;
import br.ufc.montage.ports.env.HdrPortProvides;

public class PleiadesApplicationFull extends HShelfApplication{

	public PleiadesApplicationFull(String name) {
		super(name);
		
		this.getFramework().createWorkflow();
		this.getFramework().createWorkflow();
		this.getFramework().createWorkflow();
		this.getFramework().createWorkflow();
		
	}

	@Override
	public void setServices(IHShelfService services) {
		
		this.services = services;
		
		try {
			this.services.registerUsesPort(HShelfWorkflow.SAFE_WORKFLOW_SWL_PORT+1,IHShelfPortTypes.DEFAULT);
			this.services.registerUsesPort(HShelfWorkflow.SAFE_WORKFLOW_GO_PORT+1,IHShelfPortTypes.DEFAULT);
			
			this.services.registerUsesPort(HShelfWorkflow.SAFE_WORKFLOW_SWL_PORT+2,IHShelfPortTypes.DEFAULT);
			this.services.registerUsesPort(HShelfWorkflow.SAFE_WORKFLOW_GO_PORT+2,IHShelfPortTypes.DEFAULT);
			
			this.services.registerUsesPort(HShelfWorkflow.SAFE_WORKFLOW_SWL_PORT+3,IHShelfPortTypes.DEFAULT);
			this.services.registerUsesPort(HShelfWorkflow.SAFE_WORKFLOW_GO_PORT+3,IHShelfPortTypes.DEFAULT);
			
			this.services.registerUsesPort(HShelfWorkflow.SAFE_WORKFLOW_SWL_PORT+4,IHShelfPortTypes.DEFAULT);
			this.services.registerUsesPort(HShelfWorkflow.SAFE_WORKFLOW_GO_PORT+4,IHShelfPortTypes.DEFAULT);
			
			
			
			HdrPortProvides hdrPortProvides = new HdrPortProvides();
			hdrPortProvides.setValue("pleiades.hdr");
			hdrPortProvides.setName("tmpl-hdr-prov");
			this.services.setProvidesPort(hdrPortProvides);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void runA() throws HShelfException{
		if(this.services!=null){
			
			this.getFramework().connect(HShelfWorkflow.SAFE_WORKFLOW_SWL_PORT+1, HShelfWorkflow.SAFE_WORKFLOW_SWL_PORT+1);
			HShelfSAFeSWLPort safeSWLPort = (HShelfSAFeSWLPort)((HShelfUsesPort)this.services.getPort(HShelfWorkflow.SAFE_WORKFLOW_SWL_PORT+1)).getProvidesPort();
			String archFile = "/home/jefferson/Git/HPC-Storm-SAFe/montage-application/src/br/ufc/montage/xml/pleiades-arch-A.xml";
			String flowFile = "/home/jefferson/Git/HPC-Storm-SAFe/montage-application/src/br/ufc/montage/xml/pleiades-flow-A.xml";
			safeSWLPort.setSAFeSWLArchFilePath(archFile);
			safeSWLPort.setSAFeSWLFlowFilePath(flowFile);
			
			this.getFramework().connect(HShelfWorkflow.SAFE_WORKFLOW_GO_PORT+1, HShelfWorkflow.SAFE_WORKFLOW_GO_PORT+1);
			HShelfGoWorkflowPortImpl goWorkflowPort = (HShelfGoWorkflowPortImpl)((HShelfUsesPort)this.services.getPort(HShelfWorkflow.SAFE_WORKFLOW_GO_PORT+1)).getProvidesPort();
			goWorkflowPort.loadArchitectureFile();
			goWorkflowPort.loadWorkflowFile();
			
			goWorkflowPort.go();
		}
		
		
	}
	
	public void runB() throws HShelfException{
		if(this.services!=null){
			
			this.getFramework().connect(HShelfWorkflow.SAFE_WORKFLOW_SWL_PORT+2, HShelfWorkflow.SAFE_WORKFLOW_SWL_PORT+2);
			HShelfSAFeSWLPort safeSWLPort = (HShelfSAFeSWLPort)((HShelfUsesPort)this.services.getPort(HShelfWorkflow.SAFE_WORKFLOW_SWL_PORT+2)).getProvidesPort();
			String archFile = "/home/jefferson/Git/HPC-Storm-SAFe/montage-application/src/br/ufc/montage/xml/pleiades-arch-B.xml";
			String flowFile = "/home/jefferson/Git/HPC-Storm-SAFe/montage-application/src/br/ufc/montage/xml/pleiades-flow-B.xml";
			safeSWLPort.setSAFeSWLArchFilePath(archFile);
			safeSWLPort.setSAFeSWLFlowFilePath(flowFile);
			
			this.getFramework().connect(HShelfWorkflow.SAFE_WORKFLOW_GO_PORT+2, HShelfWorkflow.SAFE_WORKFLOW_GO_PORT+2);
			HShelfGoWorkflowPortImpl goWorkflowPort = (HShelfGoWorkflowPortImpl)((HShelfUsesPort)this.services.getPort(HShelfWorkflow.SAFE_WORKFLOW_GO_PORT+2)).getProvidesPort();
			goWorkflowPort.loadArchitectureFile();
			goWorkflowPort.loadWorkflowFile();
			
			goWorkflowPort.go();
		}
		
	}
	
	public void runC() throws HShelfException{
		if(this.services!=null){
			
			this.getFramework().connect(HShelfWorkflow.SAFE_WORKFLOW_SWL_PORT+3, HShelfWorkflow.SAFE_WORKFLOW_SWL_PORT+3);
			HShelfSAFeSWLPort safeSWLPort = (HShelfSAFeSWLPort)((HShelfUsesPort)this.services.getPort(HShelfWorkflow.SAFE_WORKFLOW_SWL_PORT+3)).getProvidesPort();
			String archFile = "/home/jefferson/Git/HPC-Storm-SAFe/montage-application/src/br/ufc/montage/xml/pleiades-arch-C.xml";
			String flowFile = "/home/jefferson/Git/HPC-Storm-SAFe/montage-application/src/br/ufc/montage/xml/pleiades-flow-C.xml";
			safeSWLPort.setSAFeSWLArchFilePath(archFile);
			safeSWLPort.setSAFeSWLFlowFilePath(flowFile);
			
			this.getFramework().connect(HShelfWorkflow.SAFE_WORKFLOW_GO_PORT+3, HShelfWorkflow.SAFE_WORKFLOW_GO_PORT+3);
			HShelfGoWorkflowPortImpl goWorkflowPort = (HShelfGoWorkflowPortImpl)((HShelfUsesPort)this.services.getPort(HShelfWorkflow.SAFE_WORKFLOW_GO_PORT+3)).getProvidesPort();
			goWorkflowPort.loadArchitectureFile();
			goWorkflowPort.loadWorkflowFile();
			
			goWorkflowPort.go();
		}
		
	}
	
	public void runD() throws HShelfException{
		if(this.services!=null){
			
			this.getFramework().connect(HShelfWorkflow.SAFE_WORKFLOW_SWL_PORT+4, HShelfWorkflow.SAFE_WORKFLOW_SWL_PORT+4);
			HShelfSAFeSWLPort safeSWLPort = (HShelfSAFeSWLPort)((HShelfUsesPort)this.services.getPort(HShelfWorkflow.SAFE_WORKFLOW_SWL_PORT+4)).getProvidesPort();
			String archFile = "/home/jefferson/Git/HPC-Storm-SAFe/montage-application/src/br/ufc/montage/xml/pleiades-arch-D.xml";
			String flowFile = "/home/jefferson/Git/HPC-Storm-SAFe/montage-application/src/br/ufc/montage/xml/pleiades-flow-D.xml";
			safeSWLPort.setSAFeSWLArchFilePath(archFile);
			safeSWLPort.setSAFeSWLFlowFilePath(flowFile);
			
			this.getFramework().connect(HShelfWorkflow.SAFE_WORKFLOW_GO_PORT+4, HShelfWorkflow.SAFE_WORKFLOW_GO_PORT+4);
			HShelfGoWorkflowPortImpl goWorkflowPort = (HShelfGoWorkflowPortImpl)((HShelfUsesPort)this.services.getPort(HShelfWorkflow.SAFE_WORKFLOW_GO_PORT+4)).getProvidesPort();
			goWorkflowPort.loadArchitectureFile();
			goWorkflowPort.loadWorkflowFile();
			
			goWorkflowPort.go();
		}
		
	}
	
	public static void main(String[] args) {
		final PleiadesApplicationFull pleiadesApplication = new PleiadesApplicationFull("app-pleiades");
		
		long time1 = new GregorianCalendar().getTimeInMillis();
		 
			Thread t1 = new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						pleiadesApplication.runA();
					} catch (HShelfException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			});
			
			Thread t2 = new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						pleiadesApplication.runB();
					} catch (HShelfException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			});
			
			Thread t3 = new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						pleiadesApplication.runC();
					} catch (HShelfException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			});
			
			t1.start();
			t2.start();
			t3.start();
			
			try {
				t1.join();
				t2.join();
				t3.join();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			 
			try {
				//pleiadesApplication.runA();
				//pleiadesApplication.runC();
				//pleiadesApplication.runB();
				pleiadesApplication.runD();
			} catch (HShelfException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		long time2 = new GregorianCalendar().getTimeInMillis();
		System.out.println("elapsed: "+(time2-time1));
		
	}
}

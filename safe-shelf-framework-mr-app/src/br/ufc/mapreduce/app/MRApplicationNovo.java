package br.ufc.mapreduce.app;

import javax.swing.JOptionPane;

import br.ufc.mapreduce.stubs.ports.env.MRStubProvidesPort;
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
		this.getFramework().createWorkflow();
	}

	 
	
	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
	}
	
	public void run() throws HShelfException{
		if(this.services!=null){
			
			//loading files 
			//Essa parte na verdade deveria ser montada por alguma GUI. As classes STUB devem ser geradas automaticamente a partir do 
			//XML arquitetural.
			this.safeSWLPort = (HShelfSAFeSWLPort)this.services.getConnectedProvidesPort(HShelfWorkflow.SAFE_WORKFLOW_SWL_PORT);
			String archFile = "/home/jefferson/git/HPC-Storm-SAFe/safe-shelf-framework-mr-app/src/xml/mr-arch-stub.xml";
			String flowFile = "/home/jefferson/git/HPC-Storm-SAFe/safe-shelf-framework-mr-app/src/xml/mr-flow-stub.xml";
			this.safeSWLPort.setSAFeSWLArchFilePath(archFile);
			this.safeSWLPort.setSAFeSWLFlowFilePath(flowFile);
			
			//GO PORT
			this.goPort = (HShelfGoPort)this.services.getConnectedProvidesPort(HShelfWorkflow.SAFE_WORKFLOW_GO_PORT);
			this.goPort.loadArchitectureFile(); //as classes poderiam ser geradas nesse momento...
			this.goPort.loadWorkflowFile();
			
			//REGISTER USES PORTS (APPLICATION SIDE)
			this.services.registerUsesPort("port-A-splitter-uses", null);
			this.services.registerUsesPort("port-A-mapper-uses", null);
			this.services.registerUsesPort("port-A-combiner-uses", null);
			this.services.registerUsesPort("port-A-shuffler-uses", null);
			this.services.registerUsesPort("port-A-reducer-uses", null);
			
			
			//REGISTER PROVIDES PORTS (APPLICATION SIDE)
			MRStubProvidesPort pPortSplitter = new MRStubProvidesPort();pPortSplitter.setName("port-B-splitter-provides");
			MRStubProvidesPort pPortMapper = new MRStubProvidesPort();pPortMapper.setName("port-B-mapper-provides");
			MRStubProvidesPort pPortCombiner = new MRStubProvidesPort();pPortCombiner.setName("port-B-combiner-provides");
			MRStubProvidesPort pPortShuffler = new MRStubProvidesPort();pPortShuffler.setName("port-B-shuffler-provides");
			MRStubProvidesPort pPortReducer = new MRStubProvidesPort();pPortReducer.setName("port-B-reducer-provides");
			
			this.services.setProvidesPort(pPortSplitter);
			this.services.setProvidesPort(pPortMapper);
			this.services.setProvidesPort(pPortCombiner);
			this.services.setProvidesPort(pPortShuffler);
			this.services.setProvidesPort(pPortReducer);
			
			//CONNECTING ENV PORTS (OBRIGATÓRIO)
			this.getFramework().connectAllEnvironmentPorts();
			
			//RUN WORKFLOW
			/*Thread t = new Thread(){
				public void run() {
					goPort.go();
				};
			};
			t.start();*/
			
			//TESTING uses->provides from application
			/*MRStubProvidesPort splitter = (MRStubProvidesPort)this.services.getConnectedProvidesPort("port-A-splitter-uses");
			MRStubProvidesPort mapper = (MRStubProvidesPort)this.services.getConnectedProvidesPort("port-A-mapper-uses");
			MRStubProvidesPort combiner = (MRStubProvidesPort)this.services.getConnectedProvidesPort("port-A-combiner-uses");
			MRStubProvidesPort shuffler = (MRStubProvidesPort)this.services.getConnectedProvidesPort("port-A-shuffler-uses");
			MRStubProvidesPort reducer = (MRStubProvidesPort)this.services.getConnectedProvidesPort("port-A-reducer-uses");
			MRStubProvidesPort sink = (MRStubProvidesPort)this.services.getConnectedProvidesPort("sink-uses");
			MRStubProvidesPort source = (MRStubProvidesPort)this.services.getConnectedProvidesPort("source-uses");
			
			splitter.invoke("TESTE-SPLITTER " + splitter.getName());
			mapper.invoke("TESTE-MAPPER " + mapper.getName());
			combiner.invoke("TESTE-COMBINER " + combiner.getName());
			shuffler.invoke("TESTE-SHUFFLER " + shuffler.getName());
			reducer.invoke("TESTE-REDUCER " + reducer.getName());
			sink.invoke("TESTE-SINK " + sink.getName());
			source.invoke("TESTE-SOURCE " + source.getName());*/
			
			
			
			
		}
		
		
	}
	
	@Override
	public Object selection(Object objects) {
		HShelfConsoleLogger.write("CALLING SELECTION METHOD - APPLICATION SIDE");
		int n = JOptionPane.showConfirmDialog(null, "SELECT VALORATION SET FOR: "+objects.toString()
				,"TÍTULO",JOptionPane.YES_NO_OPTION);
		if(n==JOptionPane.YES_OPTION){
			
		}else{
			//nothing
		}
		
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

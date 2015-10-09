package br.ufc.mdcc.pargo.safe.sample.wspc.application;

import br.ufc.mdcc.pargo.safe.framework.application.HShelfApplication;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfGoPort;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfGoWorkflowPortImpl;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfSAFeSWLPort;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.mdcc.pargo.safe.sample.wspc.application.proxies.ClientEnvPortProxie;
import br.ufc.mdcc.pargo.safe.sample.wspc.application.proxies.ServerEnvPortProxie;

public class ClientServerApplicationTaskEnv extends HShelfApplication{

	HShelfSAFeSWLPort portSWL_WF;
	HShelfGoPort portGo_WF;
	
	
	ClientEnvPortProxie envClient;
	ServerEnvPortProxie envServer;
	
	public ClientServerApplicationTaskEnv(String name) {
		super(name);
	}

	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
		
		try {
			
			//init WF ports (local) with application
			portSWL_WF = (HShelfSAFeSWLPort)this.services.getProvidesPort("safeswl-port");
			portGo_WF = (HShelfGoPort)this.services.getProvidesPort("go-workflow");
			
			//send arch file
			this.sendArchitectureFile();
			//load arhh file and generate its object
			this.loadArchitectureFile();
			
			//===============================
			//generate and send workflow file
			this.generateAndSendWorkflowFile();
			//load workflow file and generate its object (it depends on arch file)
			this.loadGeneratedWorkflowFile();
			
			//run workflow to load it components and ports...but not his logic yet
			this.runWorkflow();
			//==============================
		
			//remote ports (web services)
			envClient = (ClientEnvPortProxie)this.services.getProvidesPort("env-client");
			envServer = (ServerEnvPortProxie)this.services.getProvidesPort("env-server");
			 
			
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public void sendArchitectureFile(){
		String fileArchitecture = "/home/jefferson/Git/HPC-Storm-SAFe/safe-shelf-application/src/br/ufc/mdcc/pargo/safe/sample/xml/tutorial-arch.xml";
		portSWL_WF.setSAFeSWLArchFilePath(fileArchitecture);
	}
	
	public void loadArchitectureFile(){
		((HShelfGoWorkflowPortImpl)portGo_WF).loadArchitectureFile();
	}
	
	public void generateAndSendWorkflowFile(){
		String fileWorkflow = "/home/jefferson/Git/HPC-Storm-SAFe/safe-shelf-application/src/br/ufc/mdcc/pargo/safe/sample/xml/tutorial-flow.xml";
		portSWL_WF.setSAFeSWLFlowFilePath(fileWorkflow);
	}

	public void loadGeneratedWorkflowFile(){
		((HShelfGoWorkflowPortImpl)portGo_WF).loadWorkflowFile();
	}
	
	public void runWorkflow(){
		this.portGo_WF.go();
	}
	
	public void sendMsg(String msg){
		this.envClient.sendMsg(msg);
	}
	
	public String getMsg(){
		return this.envServer.getMsg();
	}
	
	/****LOGIC***/
	public void runClientServerApplication(){
		
		
		this.sendMsg("Server, tudo bom?");
		
		System.out.println("RECEBIDO: " + this.getMsg());
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.sendMsg("Server, tudo bom novamente?!");
		
		System.out.println("RECEBIDO: " + this.getMsg());
		
	}
	
	public static void main(String[] args) {
		ClientServerApplicationTaskEnv app = new ClientServerApplicationTaskEnv("client-server-app");
		//app.runClientServerApplication();
	}

}

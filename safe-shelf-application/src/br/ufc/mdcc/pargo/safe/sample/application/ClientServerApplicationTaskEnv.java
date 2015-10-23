package br.ufc.mdcc.pargo.safe.sample.application;

import br.ufc.mdcc.pargo.safe.framework.application.HShelfApplication;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfGoPort;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfGoWorkflowPortImpl;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfSAFeSWLPort;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfWorkflowEventPort;
import br.ufc.mdcc.pargo.safe.framework.port.event.HShelfEventType;
import br.ufc.mdcc.pargo.safe.framework.port.event.HShelfWorkflowEvent;
import br.ufc.mdcc.pargo.safe.framework.port.event.IHShelfWorkflowEventListener;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.mdcc.pargo.safe.framework.workflow.HShelfWorkflow;
import br.ufc.mdcc.pargo.safe.sample.application.proxies.ClientEnvPortProxie;
import br.ufc.mdcc.pargo.safe.sample.application.proxies.ServerEnvPortProxie;
import br.ufc.mdcc.pargo.safe.sample.application.services.StartApplicationEnvPort;

public class ClientServerApplicationTaskEnv 
extends HShelfApplication implements IHShelfWorkflowEventListener{

	HShelfSAFeSWLPort portSWL_WF;
	HShelfGoPort portGo_WF;
	HShelfWorkflowEventPort portEvent_WF;
	
	
	ClientEnvPortProxie envClient;
	ServerEnvPortProxie envServer;
	
	StartApplicationEnvPort appPort;
	
	
	public ClientServerApplicationTaskEnv(String name) {
		super(name);
		
		
	}

	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
		
		try {
			
			//init my services
			this.appPort = new StartApplicationEnvPort();
			appPort.start(this);
			
			//init WF ports (local) with application
			portSWL_WF = (HShelfSAFeSWLPort)this.services.getProvidesPort(HShelfWorkflow.SAFE_WORKFLOW_SWL_PORT);
			portGo_WF = (HShelfGoPort)this.services.getProvidesPort(HShelfWorkflow.SAFE_WORKFLOW_GO_PORT);
			portEvent_WF = (HShelfWorkflowEventPort)this.services.getProvidesPort(HShelfWorkflow.SAFE_WORKFLOW_EVENT_PORT);
			
			//subscribe
			portEvent_WF.addWorkflowEventListener(this);
			
			//send arch file
			this.sendArchitectureFile();
			//load arch file and generate its object
			this.loadArchitectureFile();
			
			//===============================
			//generate and send workflow file
			this.generateAndSendWorkflowFile();
			//load workflow file and generate its object (it depends on arch file)
			this.loadGeneratedWorkflowFile();
			
			//run workflow to load it components and ports...but not his logic yet
			this.runWorkflow();
			//==============================
		
			
			 
			
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void runClientServerApplication(){
		
		envServer.setPort(10100);
		envClient.setServerPort(10100);
		
	}
	
	public static void main(String[] args) {
		ClientServerApplicationTaskEnv app = new ClientServerApplicationTaskEnv("client-server-app");
		app.runClientServerApplication();
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
	
	//cliente
	public void requestMessage(){
		
		String message = "olá, sou a aplicação.";
		this.envClient.addMesssageToBuffer(message);
	}
	
	//servidor
	public void receiveMessage(String message){
		System.out.println("MENSAGEM RECEBIDA: " + message);
	}
	
	

	@Override
	public void workflowActivity(HShelfWorkflowEvent event) {
		if(event.getEventType().equals(HShelfEventType.Message)){
			System.out.println("APP-RCV: " + event.getValue());
		}else if(event.getEventType().equals(HShelfEventType.Component_Added)){
			if(event.getValue().equals("client")){
				//remote ports (web services)
				try {
					this.envClient = (ClientEnvPortProxie)this.services.getProvidesPort("env-client");
				} catch (HShelfException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
			}else if(event.getValue().equals("server")){
				try {
					this.envServer = (ServerEnvPortProxie)this.services.getProvidesPort("env-server");
				} catch (HShelfException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}

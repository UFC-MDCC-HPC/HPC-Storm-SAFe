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

public class ClientServerApplication 
extends HShelfApplication implements IHShelfWorkflowEventListener{

	HShelfSAFeSWLPort portSWL_WF;
	HShelfGoPort portGo_WF;
	HShelfWorkflowEventPort portEvent_WF;
	
	
	ClientEnvPortProxie envClient;
	ServerEnvPortProxie envServer;
	
	StartApplicationEnvPort appPort;
	
	public static int id = 0;
	
	public ClientServerApplication(String name) {
		super(name);
	}

	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
		
		try {
			
			//init my services (Application as a service)
			this.appPort = new StartApplicationEnvPort();
			this.appPort.start(this);
			
			//init WF ports (local) with application
			portSWL_WF = (HShelfSAFeSWLPort)this.services.getProvidesPort(HShelfWorkflow.SAFE_WORKFLOW_SWL_PORT);
			portGo_WF = (HShelfGoPort)this.services.getProvidesPort(HShelfWorkflow.SAFE_WORKFLOW_GO_PORT);
			portEvent_WF = (HShelfWorkflowEventPort)this.services.getProvidesPort(HShelfWorkflow.SAFE_WORKFLOW_EVENT_PORT);
			
			//subscribe
			portEvent_WF.addWorkflowEventListener(this);
			
			//send arch file
			String fileArchitecture = "/home/jefferson/Git/HPC-Storm-SAFe/safe-shelf-application/src/br/ufc/mdcc/pargo/safe/sample/xml/tutorial-arch.xml";
			this.portSWL_WF.setSAFeSWLArchFilePath(fileArchitecture);
			//load arch file and generate its object (arvore de objtos arquiteturais)
			((HShelfGoWorkflowPortImpl)portGo_WF).loadArchitectureFile();
			
			
			//===============================
			//generate and send workflow file
			String fileWorkflow = "/home/jefferson/Git/HPC-Storm-SAFe/safe-shelf-application/src/br/ufc/mdcc/pargo/safe/sample/xml/tutorial-flow-B.xml";
			portSWL_WF.setSAFeSWLFlowFilePath(fileWorkflow);
			//load workflow file and generate its object (it depends on arch file)
			((HShelfGoWorkflowPortImpl)this.portGo_WF).loadWorkflowFile();
			
			//run workflow to load it components and ports...but not his logic yet
			this.portGo_WF.go();
			//==============================
		
			
			 
			
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	//executa portas de eventos...no caso, setar a porta TCP tanto do cliente quanto do servidor.
	public void runClientServerApplication(){
		
		envServer.setPort(10100);
		envClient.setServerPort(10100);
		
	}

	//cliente acessa remotamente via proxie
	public void requestMessage(){
		String message = "";
		if(id<3)
			message = "olá, sou a aplicação. MSG ID#:"+id;
		else
			message = "bye";
		this.envClient.addMesssageToBuffer(message);
		id += 1;
	}
	
	//servidor acessa remotamente via proxie
	public void receiveMessage(String message){
		System.out.println("MENSAGEM RECEBIDA: " + message);
	}
	
	

	//escuta eventos do workflow e toma decisões de acordo com o evento...
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
				//remote ports (web services)
				try {
					this.envServer = (ServerEnvPortProxie)this.services.getProvidesPort("env-server");
				} catch (HShelfException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	/**MAIN**/
	public static void main(String[] args) {
		ClientServerApplication app = new ClientServerApplication("client-server-app");
		app.runClientServerApplication();
	}

}

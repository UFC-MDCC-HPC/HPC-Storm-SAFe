package br.ufc.mdcc.pargo.safe.sample.application;

import br.ufc.mdcc.pargo.safe.framework.application.HShelfApplication;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.port.event.HShelfEventType;
import br.ufc.mdcc.pargo.safe.framework.port.event.HShelfWorkflowEvent;
import br.ufc.mdcc.pargo.safe.framework.port.event.IHShelfWorkflowEventListener;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.mdcc.pargo.safe.framework.workflow.HShelfWorkflow;
import br.ufc.mdcc.pargo.safe.sample.port.ApplicationPort_A;


public class ClientServerApplication 
extends HShelfApplication implements IHShelfWorkflowEventListener{

	ClientServerUsesWFSAFeSWL portSWL_WF;
	ClientServerUsesWFGo portGo_WF;
	ClientServerUsesWFEvent portEvent_WF;
	
	
	ClientServerUsesClient envClient;
	ClientServerUsesServer envServer;

	public static int id = 0;
	
	public ClientServerApplication(String name) {
		super(name);
	}

	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
		
		
		try {
			//registering uses
			this.createUsesPort();
			
			//new provides port---heron idea
			ApplicationPort_A port_A = new ApplicationPort_A();
			port_A.setName("port_A");
			this.services.setProvidesPort(port_A);
			
			
			//===============================
			//init SAFESWL and its loading with application (MOST IMPORTANT)
			portSWL_WF = (ClientServerUsesWFSAFeSWL)this.services.getPort(HShelfWorkflow.SAFE_WORKFLOW_SWL_PORT);
			String fileArchitecture = "/home/jefferson/Git/HPC-Storm-SAFe/safe-shelf-application/src/br/ufc/mdcc/pargo/safe/sample/xml/tutorial-arch.xml";
			portSWL_WF.setSAFeSWLArchFilePath(fileArchitecture);
			//init port GO, to load previous file or nothing happens...
			portGo_WF = (ClientServerUsesWFGo)this.services.getPort(HShelfWorkflow.SAFE_WORKFLOW_GO_PORT);
			portGo_WF.loadArchitectureFile();
			//================================
			
			
			//init WF ports (local) with application
			portEvent_WF = (ClientServerUsesWFEvent)this.services.getPort(HShelfWorkflow.SAFE_WORKFLOW_EVENT_PORT);
			//subscribe
			portEvent_WF.addWorkflowEventListener(this);
			
			
			
			
			//===============================
			//generate and send workflow file
			String fileWorkflow = "/home/jefferson/Git/HPC-Storm-SAFe/safe-shelf-application/src/br/ufc/mdcc/pargo/safe/sample/xml/tutorial-flow-B.xml";
			portSWL_WF.setSAFeSWLFlowFilePath(fileWorkflow);
			//load workflow file and generate its object (it depends on arch file)
			this.portGo_WF.loadWorkflowFile();
			
			//run workflow to load it components and ports...but not his logic yet
			this.portGo_WF.go();
			//==============================
		
			
			 
			
		} catch (HShelfException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	//create uses port
	private void createUsesPort() throws HShelfException{
		//register uses port...
		
		// 1 - create
		ClientServerUsesClient clientServerUsesClient = new ClientServerUsesClient();
		clientServerUsesClient.setName("env-client");
		ClientServerUsesServer clientServerUsesServer = new ClientServerUsesServer();
		clientServerUsesServer.setName("env-server");
		ClientServerUsesWFEvent clientServerUsesWFEvent = new ClientServerUsesWFEvent();
		clientServerUsesWFEvent.setName("port_Event");
		ClientServerUsesWFGo clientServerUsesWFGo = new ClientServerUsesWFGo();
		clientServerUsesWFGo.setName("port_Go");
		ClientServerUsesWFSAFeSWL clientServerUsesWFSAFeSWL = new ClientServerUsesWFSAFeSWL();
		clientServerUsesWFSAFeSWL.setName("port_SAFeSWL");
		
		// 2 - register
		this.services.registerUsesPort(clientServerUsesClient);
		this.services.registerUsesPort(clientServerUsesServer);
		this.services.registerUsesPort(clientServerUsesWFEvent);
		this.services.registerUsesPort(clientServerUsesWFGo);
		this.services.registerUsesPort(clientServerUsesWFSAFeSWL);
	}
	
	//executa portas de eventos...no caso, setar a porta TCP tanto do cliente quanto do servidor.
	public void runClientServerApplication(){
		
		envServer.setPort(10100);
		envClient.setServerPort(10100);
		
	}

	
	
	//DIRECT SERVICES INSTEAD OF EVENTS ABOVE
	public void requestMessage(){
		String out = "";
		if(id<3)
			out = "olá, sou a aplicação. MSG ID#:"+id;
		else
			out = "bye";
		this.envClient.addMesssageToBuffer(out);
		id += 1;
	}
	
	public void sendMessage(String message){
		System.out.println("MENSAGEM RECEBIDA direct: " + message);
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
					this.envClient = (ClientServerUsesClient)this.services.getPort("env-client");
				} catch (HShelfException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
			}else if(event.getValue().equals("server")){
				//remote ports (web services)
				try {
					this.envServer = (ClientServerUsesServer)this.services.getPort("env-server");
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

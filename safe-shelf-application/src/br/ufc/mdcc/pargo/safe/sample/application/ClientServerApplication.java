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
import br.ufc.mdcc.pargo.safe.sample.port.ApplicationPort_A;


public class ClientServerApplication 
extends HShelfApplication implements IHShelfWorkflowEventListener{

	HShelfSAFeSWLPort portSWL_WF;
	HShelfGoPort portGo_WF;
	HShelfWorkflowEventPort portEvent_WF;
	
	
	ClientEnvPortProxie envClient;
	ServerEnvPortProxie envServer;
	
	 
	//ClientServerApplicationPort clientServerApplicationPort;
	
	public static int id = 0;
	
	public ClientServerApplication(String name) {
		super(name);
	}

	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
		
		
		try {
			
			 
			/*this.clientServerApplicationPort = new ClientServerApplicationPort();
			this.clientServerApplicationPort.setName("app-client-server-port");
			this.clientServerApplicationPort.setClientServerApplication(this);
			this.services.setProvidesPort(this.clientServerApplicationPort);
			this.clientServerApplicationPort.startService();*/ //starting myservice
			
			//new port---heron idea
			ApplicationPort_A port_A = new ApplicationPort_A();
			port_A.setName("port_A");
			this.services.setProvidesPort(port_A);
			
			
			
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
			
			e.printStackTrace();
		}
		
		
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

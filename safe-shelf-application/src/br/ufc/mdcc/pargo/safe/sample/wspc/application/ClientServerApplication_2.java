package br.ufc.mdcc.pargo.safe.sample.wspc.application;

import br.ufc.mdcc.pargo.safe.framework.application.HShelfApplication;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfGoPort;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfSAFeSWLPort;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.mdcc.pargo.safe.sample.wspc.application.proxies.ClientGoPortProxie;
import br.ufc.mdcc.pargo.safe.sample.wspc.application.proxies.ClientOperationPortProxie;
import br.ufc.mdcc.pargo.safe.sample.wspc.application.proxies.ServerGoPortProxie;
import br.ufc.mdcc.pargo.safe.sample.wspc.application.proxies.ServerOperationPortProxie;

public class ClientServerApplication_2 extends HShelfApplication{

	HShelfSAFeSWLPort portSWL_WF;
	HShelfGoPort portGo_WF;
	
	ClientGoPortProxie goClient;
	ClientOperationPortProxie operClient;
	ServerGoPortProxie goServer;
	ServerOperationPortProxie operServer;
	
	public ClientServerApplication_2(String name) {
		super(name);
	}

	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
		
		try {
			
			portSWL_WF = (HShelfSAFeSWLPort)this.services.getProvidesPort("safeswl-port");
			portGo_WF = (HShelfGoPort)this.services.getProvidesPort("go-workflow");
			
			this.sendSAFeSWL();
			
			//só terei essas portas quando eu rodar o workflow
			goClient = (ClientGoPortProxie)this.services.getProvidesPort("go-client");
			operClient = (ClientOperationPortProxie)this.services.getProvidesPort("oper-client");
			//goServer = (ServerGoPortProxie)this.services.getProvidesPort("go-server");
			//operServer = (ServerOperationPortProxie)this.services.getProvidesPort("oper-server");
			
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void runApplication(){
		this.initServer(10010);
		this.connectClient(10010);
		
		this.sendMsg("Server, vai ter lascar!!!");
		
		System.out.println("RECEBIDO: " + this.getMsg());
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.sendMsg("Server, vai ter lascar novamente!!!");
		
		System.out.println("RECEBIDO: " + this.getMsg());
		
	}
	
	public void sendSAFeSWL(){
		portSWL_WF.setSAFeSWLArchFilePath("/home/jefferson/Git/HPC-Storm-SAFe/safe-shelf-application/src/br/ufc/mdcc/pargo/safe/sample/xml/tutorial-arch.xml");
		portSWL_WF.setSAFeSWLFlowFilePath("/home/jefferson/Git/HPC-Storm-SAFe/safe-shelf-application/src/br/ufc/mdcc/pargo/safe/sample/xml/tutorial-flow.xml");
		portGo_WF.go();
	}
	
	public void initServer(Integer port){
		this.operServer.setPort(port);
		this.goServer.go();
	}
	
	public void connectClient(Integer port){
		this.operClient.setServerPort(port);
		this.goClient.go();
	}
	
	public void sendMsg(String msg){
		this.operClient.sendMsg(msg);
	}
	
	public String getMsg(){
		return this.operServer.getMsg();
	}
	
	public static void main(String[] args) {
		ClientServerApplication_2 app = new ClientServerApplication_2("client-server-app");
		//app.runApplication();
	}

}

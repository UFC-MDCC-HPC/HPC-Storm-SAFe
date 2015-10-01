package br.ufc.mdcc.pargo.safe.sample.wspc.stubs.application;

import br.ufc.mdcc.pargo.safe.application.HShelfApplication;
import br.ufc.mdcc.pargo.safe.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.port.dflt.HShelfGoPort;
import br.ufc.mdcc.pargo.safe.port.dflt.HShelfSAFeSWLPort;
import br.ufc.mdcc.pargo.safe.sample.wspc.stubs.application.proxies.ClientGoPortProxie;
import br.ufc.mdcc.pargo.safe.sample.wspc.stubs.application.proxies.ClientOperationPortProxie;
import br.ufc.mdcc.pargo.safe.sample.wspc.stubs.application.proxies.ServerGoPortProxie;
import br.ufc.mdcc.pargo.safe.sample.wspc.stubs.application.proxies.ServerOperationPortProxie;
import br.ufc.mdcc.pargo.safe.services.IHShelfService;

public class ClientServerApplication extends HShelfApplication{

	HShelfSAFeSWLPort portSWL_WF;
	HShelfGoPort portGo_WF;
	
	ClientGoPortProxie goClient;
	ClientOperationPortProxie operClient;
	ServerGoPortProxie goServer;
	ServerOperationPortProxie operServer;
	
	public ClientServerApplication(String name) {
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
			goServer = (ServerGoPortProxie)this.services.getProvidesPort("go-server");
			operServer = (ServerOperationPortProxie)this.services.getProvidesPort("oper-server");
			
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
		
	}
	
	public void sendSAFeSWL(){
		portSWL_WF.setSAFeSWLArchFilePath("/home/jefferson/Git/HPC-Storm-SAFe/safe-shelf-application/src/br/ufc/mdcc/pargo/safe/sample/xml/mImgtbl-simple-run-arch.xml");
		portSWL_WF.setSAFeSWLFlowFilePath("/home/jefferson/Git/HPC-Storm-SAFe/safe-shelf-application/src/br/ufc/mdcc/pargo/safe/sample/xml/mImgtbl-simple-run-flow.xml");
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
		ClientServerApplication app = new ClientServerApplication("client-server-app");
		app.runApplication();
	}

}

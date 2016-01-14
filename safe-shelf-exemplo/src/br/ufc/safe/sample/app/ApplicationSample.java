package br.ufc.safe.sample.app;

import javax.swing.JOptionPane;
import javax.xml.ws.Endpoint;

import br.ufc.mdcc.pargo.safe.framework.application.HShelfApplication;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfUsesPort;
import br.ufc.mdcc.pargo.safe.framework.port.IHShelfPortTypes;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfGoWorkflowPortImpl;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfSAFeSWLPort;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.safe.sample.app.prt.AppRequestMessageEnvPort;
import br.ufc.safe.sample.app.prt.AppReturnMessageEnvPort;
import br.ufc.safe.sample.app.prt.service.AppRequestMessageEnvPortService;
import br.ufc.safe.sample.app.prt.service.AppReturnMessageEnvPortService;
import br.ufc.safe.sample.app.prt.service.IAppRequestMessageEnvPortService;
import br.ufc.safe.sample.app.prt.service.IAppReturnMessageEnvPortService;
import br.ufc.safe.sample.prt.env.ClientAddMessageEnvPort;

public class ApplicationSample extends HShelfApplication{

	private String message;

	public ApplicationSample(String name) {
		super(name);
	}

	@Override
	public void setServices(IHShelfService services) {
		
		this.services = services;
		AppRequestMessageEnvPort appRequestMessageEnvPort = this.createAppRequestMessageEnvPort();
		appRequestMessageEnvPort.setName("app-req-msg-provides");
		AppReturnMessageEnvPort appReturnMessageEnvPort = this.createAppReturnMessageEnvPort();
		appReturnMessageEnvPort.setName("app-ret-msg-provides");
		
		
		
		try {
			this.services.setProvidesPort(appRequestMessageEnvPort);
			this.services.setProvidesPort(appReturnMessageEnvPort);
			this.services.registerUsesPort("client-add-msg-uses", IHShelfPortTypes.NO_TYPE);
			this.services.registerUsesPort("port_SAFeSWL",IHShelfPortTypes.DEFAULT);
			this.services.registerUsesPort("port_Go",IHShelfPortTypes.DEFAULT);
			
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void requestMessage(){
		try {
			HShelfUsesPort uses = (HShelfUsesPort)this.services.getPort("client-add-msg-uses");
			if(uses!=null){
				((ClientAddMessageEnvPort)uses.getProvidesPort()).addMessage(this.message);
			}
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void returnMessage(String message){
		System.out.println("RECEIVED MESSAGE FROM SERVER: "+message);
	}
	
	public void runApplication() throws HShelfException{
		
		this.message = JOptionPane.showInputDialog("Enter message");
		
		if(this.services!=null){
			HShelfSAFeSWLPort safeSWLPort = (HShelfSAFeSWLPort)((HShelfUsesPort)this.services.getPort("port_SAFeSWL")).getProvidesPort();
			String archFile = "/home/jefferson/Git/HPC-Storm-SAFe/safe-shelf-exemplo/src/br/ufc/safe/sample/xml/exemplo-arch.xml";
			String flowFile = "/home/jefferson/Git/HPC-Storm-SAFe/safe-shelf-exemplo/src/br/ufc/safe/sample/xml/exemplo-flow.xml";
			safeSWLPort.setSAFeSWLArchFilePath(archFile);
			safeSWLPort.setSAFeSWLFlowFilePath(flowFile);
			
			HShelfGoWorkflowPortImpl goWorkflowPort = (HShelfGoWorkflowPortImpl)((HShelfUsesPort)this.services.getPort("port_Go")).getProvidesPort();
			goWorkflowPort.loadArchitectureFile();
			goWorkflowPort.loadWorkflowFile();
			
			goWorkflowPort.go();
		}
	}
	
	private AppRequestMessageEnvPort createAppRequestMessageEnvPort(){
		AppRequestMessageEnvPort appRequestMessageEnvPort = new AppRequestMessageEnvPort();
		IAppRequestMessageEnvPortService srvc = new AppRequestMessageEnvPortService(appRequestMessageEnvPort);
		String url = "http://localhost:10008/app-req";
		Endpoint.publish(url,srvc);
		System.out.println(url);
		return appRequestMessageEnvPort;
	}
	
	private AppReturnMessageEnvPort createAppReturnMessageEnvPort(){
		AppReturnMessageEnvPort appReturnMessageEnvPort = new AppReturnMessageEnvPort();
		IAppReturnMessageEnvPortService srvc = new AppReturnMessageEnvPortService(appReturnMessageEnvPort);
		String url = "http://localhost:10009/app-ret";
		Endpoint.publish(url,srvc);
		System.out.println(url);
		return appReturnMessageEnvPort;
	}
	
	public static void main(String[] args) {
		ApplicationSample as = new ApplicationSample("app-sample-example");
		try {
			as.runApplication();
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

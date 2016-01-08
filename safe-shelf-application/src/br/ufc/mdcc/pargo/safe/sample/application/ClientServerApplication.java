package br.ufc.mdcc.pargo.safe.sample.application;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.ufc.mdcc.pargo.safe.framework.application.HShelfApplication;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfUsesPort;
import br.ufc.mdcc.pargo.safe.framework.port.IHShelfPortTypes;
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

	private Integer portC;
	private Integer portS;
	
	HShelfUsesPort envClient;
	HShelfUsesPort envServer;

	public static int id = 0;
	
	public ClientServerApplication(String name) {
		super(name);
	}

	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
		
		
		try {
			//registering uses
			this.services.registerUsesPort("env-client",IHShelfPortTypes.NO_TYPE);
			this.services.registerUsesPort("env-server",IHShelfPortTypes.NO_TYPE);
			this.services.registerUsesPort("port_Event",IHShelfPortTypes.DEFAULT);
			this.services.registerUsesPort("port_Go",IHShelfPortTypes.DEFAULT);
			this.services.registerUsesPort("port_SAFeSWL",IHShelfPortTypes.DEFAULT);
			
			//application provides port
			ApplicationPort_A port_A = new ApplicationPort_A();
			port_A.setName("port_A");
			this.services.setProvidesPort(port_A);
			
			
			//===============================
			//init SAFESWL and its loading with application (MOST IMPORTANT)
			HShelfUsesPort usesSAFeSWL = (HShelfUsesPort)this.services.getPort(HShelfWorkflow.SAFE_WORKFLOW_SWL_PORT);
			String fileArchitecture = "/home/jefferson/Git/HPC-Storm-SAFe/safe-shelf-application/src/br/ufc/mdcc/pargo/safe/sample/xml/tutorial-arch.xml";
			((HShelfSAFeSWLPort)usesSAFeSWL.getProvidesPort()).setSAFeSWLArchFilePath(fileArchitecture);
			
			//init port GO, to load previous file or nothing happens...
			this.services.getPort(HShelfWorkflow.SAFE_WORKFLOW_GO_PORT);
			
			HShelfUsesPort usesGo = (HShelfUsesPort)this.services.getPort(HShelfWorkflow.SAFE_WORKFLOW_GO_PORT);
			((HShelfGoWorkflowPortImpl)usesGo.getProvidesPort()).loadArchitectureFile();
			//================================
			
			
			//register event
			HShelfUsesPort usesEvent = (HShelfUsesPort)this.services.getPort(HShelfWorkflow.SAFE_WORKFLOW_EVENT_PORT);
			((HShelfWorkflowEventPort)usesEvent.getProvidesPort()).addWorkflowEventListener(this);
			
			
			
			
			
			
			
			//===============================
			//generate and send workflow file
			String fileWorkflow = "/home/jefferson/Git/HPC-Storm-SAFe/safe-shelf-application/src/br/ufc/mdcc/pargo/safe/sample/xml/tutorial-flow-B.xml";
			((HShelfSAFeSWLPort)usesSAFeSWL.getProvidesPort()).setSAFeSWLFlowFilePath(fileWorkflow);
			//load workflow file and generate its object (it depends on arch file)
			((HShelfGoWorkflowPortImpl)usesGo.getProvidesPort()).loadWorkflowFile();
			
			//run workflow to load it components and ports...
			//((HShelfGoWorkflowPortImpl)usesGo.getProvidesPort()).go();
			//==============================
		
			
			 
			
		} catch (HShelfException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	 
	
	
	public void runClientServerApplication(){
		
		boolean res = this.simpleInterface();
		if(res){
			HShelfUsesPort usesGo;
			try {
				usesGo = (HShelfUsesPort)this.services.getPort(HShelfWorkflow.SAFE_WORKFLOW_GO_PORT);
				((HShelfGoWorkflowPortImpl)usesGo.getProvidesPort()).go();
			} catch (HShelfException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}

	
	
	public void requestMessage(){
		String out = "";
		if(id<3)
			out = "olá, sou a aplicação. MSG ID#:"+id;
		else
			out = "bye";
		System.out.println("TESTE:"+envClient.getProvidesPort());
		((ClientEnvPortProxie)envClient.getProvidesPort()).addMesssageToBuffer(out);
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
					
					this.envClient = (HShelfUsesPort)this.services.getPort("env-client");
				
				} catch (HShelfException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
			}else if(event.getValue().equals("server")){
				//remote ports (web services)
				try {
					this.envServer = (HShelfUsesPort)this.services.getPort("env-server");
				} catch (HShelfException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else if(event.getEventType().equals(HShelfEventType.Port_Connected)){
			System.out.println("=>PORT "+event.getValue() + " CONNECTED!");
			if(event.getValue().equals("env-client")){
				((ClientEnvPortProxie)envClient.getProvidesPort()).setServerPort(this.portC);
			}else if(event.getValue().equals("env-server")){
				((ServerEnvPortProxie)envServer.getProvidesPort()).setPort(this.portS);
			}
		}
		
	}
	
	private boolean simpleInterface(){
		  JTextField xField = new JTextField(5);
	      JTextField yField = new JTextField(5);

	      JPanel myPanel = new JPanel();
	      myPanel.add(new JLabel("CLIENT PORT:"));
	      myPanel.add(xField);
	      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
	      myPanel.add(new JLabel("SERVER PORT:"));
	      myPanel.add(yField);

	      int result = JOptionPane.showConfirmDialog(null, myPanel, 
	               "Please Enter TCP-PORT Values", JOptionPane.OK_CANCEL_OPTION);
	      if (result == JOptionPane.OK_OPTION) {
	    	 this.portC = Integer.parseInt(xField.getText());
	    	 this.portS = Integer.parseInt(yField.getText());
	         System.out.println("x value: " + xField.getText());
	         System.out.println("y value: " + yField.getText());
	         return true;
	      }
	      return false;
	}
	
	
	/**MAIN**/
	public static void main(String[] args) {
		ClientServerApplication app = new ClientServerApplication("client-server-app");
		app.runClientServerApplication();
	}

}

 
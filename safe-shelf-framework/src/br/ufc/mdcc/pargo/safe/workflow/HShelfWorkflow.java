package br.ufc.mdcc.pargo.safe.workflow;

import br.ufc.mdcc.pargo.safe.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.HShelfFramework;
import br.ufc.mdcc.pargo.safe.grammar.ISAFeSWLArcherParser;
import br.ufc.mdcc.pargo.safe.grammar.ISAFeSWLFlowParser;
import br.ufc.mdcc.pargo.safe.grammar.SAFeSWLArchParser;
import br.ufc.mdcc.pargo.safe.grammar.SAFeSWLFlowParser;
import br.ufc.mdcc.pargo.safe.port.HShelfPort;
import br.ufc.mdcc.pargo.safe.port.dflt.HShelfGoWorkflowPortImpl;
import br.ufc.mdcc.pargo.safe.port.dflt.HShelfSAFeSWLPort;
import br.ufc.mdcc.pargo.safe.port.dflt.HShelfSAFeSWLPortImpl;
import br.ufc.mdcc.pargo.safe.services.IHShelfService;
import br.ufc.mdcc.pargo.safe.util.HShelfConsoleLogger;

public class HShelfWorkflow extends HShelfComponent {

	private HShelfPort safeSWL;
	private HShelfPort safeGo;
	private HShelfFramework framework;
	
	public HShelfWorkflow(String name, HShelfFramework framework) {
		HShelfConsoleLogger.write("Creating HShelfWorkflow");
		this.framework = framework;
		this.setName(name);
	}

	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
		try {
			safeSWL = new HShelfSAFeSWLPortImpl();
			safeSWL.setName("safeswl-port");
			this.services.setProvidesPort(safeSWL);
			
			safeGo = new HShelfGoWorkflowPortImpl();
			((HShelfGoWorkflowPortImpl)safeGo).workflow = this;
			safeGo.setName("go-workflow");
			this.services.setProvidesPort(safeGo);
			
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 
	
	public void run(){
		
		
		ISAFeSWLArcherParser archParser = new SAFeSWLArchParser(((HShelfSAFeSWLPort)safeSWL).getSAFeSWLArchFilePath());
		ISAFeSWLFlowParser flowParser = new SAFeSWLFlowParser(((HShelfSAFeSWLPort)safeSWL).getSAFeSWLFlowFilePath());
		flowParser.setISAFeSWLArcherParser(archParser);
		flowParser.run();
		
		this.TESTE_APAGAR_DEPOIS();
	}
	
	private void TESTE_APAGAR_DEPOIS(){
		//lê arquitetura
		//lê cada wsdl de cada porta de um componente
		//gera stubs para essas portas
		//gera proxies para essas portas
		//gera compontes proxies que usam essas portas proxies
		
		//cria instância dos componentes proxies
		HShelfComponent client = 
				this.framework.createComponent("client", "br.ufc.mdcc.pargo.safe.sample.wspc.stubs.application.proxies.ComponentClientProxie");
		this.framework.addComponent(client);
		HShelfComponent server = 
				this.framework.createComponent("server", "br.ufc.mdcc.pargo.safe.sample.wspc.stubs.application.proxies.ComponentServerProxie");
		this.framework.addComponent(server);
		//adciona ao framework
		
	}

}

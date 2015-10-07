package br.ufc.mdcc.pargo.safe.framework.workflow;

import java.util.HashMap;
import java.util.Map;

import br.ufc.mdcc.pargo.safe.framework.HShelfFramework;
import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.core.HShelfCoreImpl;
import br.ufc.mdcc.pargo.safe.framework.core.IHShelfCore;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfPort;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfGoWorkflowPortImpl;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfSAFeSWLPort;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfSAFeSWLPortImpl;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.mdcc.pargo.safe.framework.util.HShelfConsoleLogger;
import br.ufc.mdcc.pargo.safe.grammar.ISAFeSWLArcherParser;
import br.ufc.mdcc.pargo.safe.grammar.ISAFeSWLFlowParser;
import br.ufc.mdcc.pargo.safe.grammar.SAFeSWLArchParser;
import br.ufc.mdcc.pargo.safe.grammar.SAFeSWLFlowParser;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchComponent;

public class HShelfWorkflow extends HShelfComponent {

	//ports
	private HShelfPort safeSWL;
	private HShelfPort safeGo;
	
	//util refs
	private HShelfFramework framework;
	private IHShelfCore core;
	
	//language
	private Map<String, HShelfComponentVariableInfo> componentVariableMap;
	private ISAFeSWLArcherParser archParser;
	private ISAFeSWLFlowParser flowParser;
	private HShelfWorkflowFacade workflowFacade;
	
	public HShelfWorkflow(String name, HShelfFramework framework) {
		HShelfConsoleLogger.write("Creating HShelfWorkflow");
		this.framework = framework;
		this.setName(name);
		
		this.core = new HShelfCoreImpl();
		this.componentVariableMap = new HashMap<String, HShelfComponentVariableInfo>();
		this.workflowFacade = new HShelfWorkflowFacade(this);
		
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
			
			e.printStackTrace();
		}
	}
	
	 
	
	public void run(){
		
		
		this.archParser = new SAFeSWLArchParser(((HShelfSAFeSWLPort)safeSWL).getSAFeSWLArchFilePath());
		this.flowParser = new SAFeSWLFlowParser(((HShelfSAFeSWLPort)safeSWL).getSAFeSWLFlowFilePath());
	
		flowParser.setISAFeSWLArcherParser(archParser);
		flowParser.setHShelfWorkflowFacade(workflowFacade);
		flowParser.run();
		
		
	}
	
	public void resolve(String contract, String compID){
		HShelfConsoleLogger.write("Entering Resolve...");
		String candidates = this.core.resolve(contract);
		if(candidates!=null){
			HShelfComponentVariableInfo compInfo = new HShelfComponentVariableInfo();
			compInfo.setCandidates(candidates);
			compInfo.setId(compID);
			this.componentVariableMap.put(compID, compInfo);
		}
	}
	
	public void deploy(String compID){
		HShelfConsoleLogger.write("Entering Deploy...");
		HShelfComponentVariableInfo compInfo = this.componentVariableMap.get(compID);
		if(compInfo!=null){
			String orderedCandidates = compInfo.getCandidates();
			String deployedID = this.core.deploy(orderedCandidates);
			compInfo.setDeployedID(deployedID);
		}
	}

	public void instantiate(String compID){
		HShelfConsoleLogger.write("Entering Instantiate...");
		HShelfComponentVariableInfo compInfo = this.componentVariableMap.get(compID);
		if(compInfo!=null){
			String deployedID = compInfo.getDeployedID();
			String portURLs = this.core.instantiate(deployedID);
			compInfo.setPortURLs(portURLs);
			
			ArchComponent archComponent = this.archParser.getArchComponentByID(Integer.parseInt(compInfo.getId()));
			if(archComponent!=null){
				String compName = archComponent.getName();
				String capCompName = compName.substring(0, 1).toUpperCase() + compName.substring(1);
				HShelfComponent client = 
						this.framework.createComponent(compName,
								"br.ufc.mdcc.pargo.safe.sample.wspc.application.proxies.Component"+capCompName+"Proxie");
				this.framework.addComponent(client);
			}
			
		}
	}

}

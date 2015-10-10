package br.ufc.mdcc.pargo.safe.framework.workflow;

import java.util.HashMap;
import java.util.List;
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
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfWorkflowEventPortImpl;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.mdcc.pargo.safe.framework.util.HShelfConsoleLogger;
import br.ufc.mdcc.pargo.safe.framework.util.HShelfReflectionUtil;
import br.ufc.mdcc.pargo.safe.grammar.ISAFeSWLArcherParser;
import br.ufc.mdcc.pargo.safe.grammar.ISAFeSWLFlowParser;
import br.ufc.mdcc.pargo.safe.grammar.SAFeSWLArchParser;
import br.ufc.mdcc.pargo.safe.grammar.SAFeSWLFlowParser;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchComponent;

public class HShelfWorkflow extends HShelfComponent {

	public static final String SAFE_WORKFLOW_SWL_PORT = "safeswl-port";
	public static final String SAFE_WORKFLOW_GO_PORT = "go-workflow-port";
	public static final String SAFE_WORKFLOW_EVENT_PORT = "workflow-event-port";
			
	//ports
	private HShelfPort safeSWLPort;
	private HShelfPort safeGoPort;
	private HShelfPort safeWorkflowEventPort;
	
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
			safeSWLPort = new HShelfSAFeSWLPortImpl();
			safeSWLPort.setName(HShelfWorkflow.SAFE_WORKFLOW_SWL_PORT);
			this.services.setProvidesPort(safeSWLPort);
			
			safeGoPort = new HShelfGoWorkflowPortImpl();
			((HShelfGoWorkflowPortImpl)safeGoPort).workflow = this;
			safeGoPort.setName(HShelfWorkflow.SAFE_WORKFLOW_GO_PORT);
			this.services.setProvidesPort(safeGoPort);
			
			safeWorkflowEventPort = new HShelfWorkflowEventPortImpl();
			safeWorkflowEventPort.setName(HShelfWorkflow.SAFE_WORKFLOW_EVENT_PORT);
			this.services.setProvidesPort(safeWorkflowEventPort);
			
		} catch (HShelfException e) {
			
			e.printStackTrace();
		}
	}
	
	/**
	 * loads architecture file. 
	 */
	public void loadArchitectureFile(){
		String filePath = ((HShelfSAFeSWLPort)safeSWLPort).getSAFeSWLArchFilePath();
		if(filePath!=null){
			this.archParser = new SAFeSWLArchParser(filePath);
			HShelfConsoleLogger.write("Architecture file loaded");
			this.sendMessageToApp("Architecture file loaded");
		}
		
	}
	
	/**
	 * loads workflow file
	 */
	public void loadWorkflowFile(){
		String filePath = ((HShelfSAFeSWLPort)safeSWLPort).getSAFeSWLFlowFilePath();
		if(filePath!=null){
			this.flowParser = new SAFeSWLFlowParser(filePath);
			this.flowParser.setISAFeSWLArcherParser(archParser);
			this.flowParser.setHShelfWorkflowFacade(workflowFacade);
			HShelfConsoleLogger.write("Workflow file loaded");
			this.sendMessageToApp("Workflow file loaded");
		}
		
	}
	
	public void run(){
		if(this.flowParser!=null){
			HShelfConsoleLogger.write("**WORKFLOW READING STARTED**");
			this.sendMessageToApp("**WORKFLOW READING STARTED**");
			flowParser.run();
			HShelfConsoleLogger.write("**WORKFLOW READING ENDED**");
			this.sendMessageToApp("**WORKFLOW READING ENDED**");
		}
			
	}
	
	//FACADE METHODS
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
								"br.ufc.mdcc.pargo.safe.sample.wspc.application.proxies."+capCompName+"ComponentProxie");
				this.framework.addComponent(client);
			}
			
		}
	}
	
	public void compute(String method, String portName,List<HShelfArgValueType> argValueTypeList){
		try {
			
			HShelfPort port  = this.services.getTaskPort(portName);
			if(port!=null){
				if(argValueTypeList!=null){
					
					Object argsObject[] = new Object[argValueTypeList.size()];
					for(int i=0;i<argValueTypeList.size();i++){
						argsObject[i]=argValueTypeList.get(i).getValue();
					}
					HShelfReflectionUtil.invokeMethod(port, method, argsObject);
				}else{
					HShelfReflectionUtil.invokeMethod(port, method, null);
				}
			}
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void sendMessageToApp(String message){
		if(safeWorkflowEventPort!=null)
			((HShelfWorkflowEventPortImpl)safeWorkflowEventPort).setMessage(message);
	}
}

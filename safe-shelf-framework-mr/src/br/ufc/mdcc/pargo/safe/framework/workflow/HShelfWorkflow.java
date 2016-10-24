package br.ufc.mdcc.pargo.safe.framework.workflow;

import java.util.List;

import br.ufc.mdcc.pargo.safe.framework.HShelfFramework;
import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfProvidesPort;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfTaskPort;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfGoWorkflowPortImpl;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfLifeCyclePort;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfSAFeSWLPort;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfSAFeSWLPortImpl;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfWorkflowEventPortImpl;
import br.ufc.mdcc.pargo.safe.framework.port.event.HShelfEventType;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.mdcc.pargo.safe.framework.util.HShelfConsoleLogger;
import br.ufc.mdcc.pargo.safe.framework.util.HShelfFileUtil;
import br.ufc.mdcc.pargo.safe.framework.util.HShelfReflectionUtil;
import br.ufc.mdcc.pargo.safe.grammar.ISAFeSWLArcherParser;
import br.ufc.mdcc.pargo.safe.grammar.ISAFeSWLFlowParser;
import br.ufc.mdcc.pargo.safe.grammar.SAFeSWLArchParser;
import br.ufc.mdcc.pargo.safe.grammar.SAFeSWLFlowParser;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchComponent;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchTask;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchUses;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchWorkflow;
import br.ufc.mdcc.pargo.safe.grammar.arch.SAFeOrquestrationArchitecture;

public class HShelfWorkflow extends HShelfComponent {

	public static int number = 1;
	public static final String SAFE_WORKFLOW_SWL_PORT = "port_SAFeSWL";
	public static final String SAFE_WORKFLOW_GO_PORT = "port_Go";
	public static final String SAFE_WORKFLOW_EVENT_PORT = "port_Event";
	

	// ports
	private HShelfProvidesPort safeSWLPort;
	private HShelfProvidesPort safeGoPort;
	private HShelfProvidesPort safeWorkflowEventPort;

	// util refs
	private HShelfFramework framework;
	//private IHShelfCore core;
	//private IHShelfCoreXMLReader xmlReader;

	// language
	//private Map<String, HShelfComponentCoreInfo> componentVariableMap;
	private ISAFeSWLArcherParser archParser;
	private ISAFeSWLFlowParser flowParser;
	private HShelfWorkflowFacade workflowFacade;
	


	public HShelfWorkflow(String name, HShelfFramework framework) {
		HShelfConsoleLogger.write("Creating HShelfWorkflow");
		this.framework = framework;
		this.setName(name);

		//this.core = new HShelfCoreImpl();
		//this.xmlReader = new HShelfCoreXMLReaderImpl();
		//this.componentVariableMap = new HashMap<String, HShelfComponentCoreInfo>();
		this.workflowFacade = new HShelfWorkflowFacade(this);

	}

	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
		try {
			safeSWLPort = new HShelfSAFeSWLPortImpl();
			safeSWLPort.setName(HShelfWorkflow.SAFE_WORKFLOW_SWL_PORT+HShelfWorkflow.number);
			this.services.setProvidesPort(safeSWLPort);

			safeGoPort = new HShelfGoWorkflowPortImpl();
			((HShelfGoWorkflowPortImpl) safeGoPort).workflow = this;
			safeGoPort.setName(HShelfWorkflow.SAFE_WORKFLOW_GO_PORT+HShelfWorkflow.number);
			this.services.setProvidesPort(safeGoPort);

			safeWorkflowEventPort = new HShelfWorkflowEventPortImpl();
			safeWorkflowEventPort
					.setName(HShelfWorkflow.SAFE_WORKFLOW_EVENT_PORT+HShelfWorkflow.number);
			this.services.setProvidesPort(safeWorkflowEventPort);
			 
			HShelfWorkflow.number = HShelfWorkflow.number + 1; 
		} catch (HShelfException e) {

			e.printStackTrace();
		}
	}

	/**
	 * loads architecture file.
	 */
	public synchronized void loadArchitectureFile() {
		this.archParser = null;
		String filePath = ((HShelfSAFeSWLPort) safeSWLPort)
				.getSAFeSWLArchFilePath();
		if (filePath != null) {
			this.archParser = new SAFeSWLArchParser(filePath);
			HShelfConsoleLogger.write("Architecture file loaded");
			this.sendMessageToApp("Architecture file loaded",
					HShelfEventType.Message);
			
		}
		
		if(this.services!=null){
			ArchWorkflow archWorkflow = this.archParser.getArchWorkflow();
			for(ArchTask task:archWorkflow.getTaskList()){
				HShelfTaskPort taskPort = new HShelfTaskPort();
				taskPort.setName(task.getName());
				HShelfConsoleLogger.write("TASK-NAME: " + task.getName());
				try {
					this.services.registerTaskPort(taskPort);
				} catch (HShelfException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		if(this.archParser!=null){
			List<ArchComponent> components = this.archParser.getComponents();
			for(ArchComponent cmp: components){
				this.createComponentProxie(cmp);
			}
		}

	}

	/**
	 * loads workflow file
	 */
	public synchronized void loadWorkflowFile() {
		this.flowParser = null;
		String filePath = ((HShelfSAFeSWLPort) safeSWLPort)
				.getSAFeSWLFlowFilePath();
		if (filePath != null) {
			this.flowParser = new SAFeSWLFlowParser(filePath);
			this.flowParser.setISAFeSWLArcherParser(archParser);
			this.flowParser.setHShelfWorkflowFacade(workflowFacade);
			HShelfConsoleLogger.write("Workflow file loaded");
			this.sendMessageToApp("Workflow file loaded",
					HShelfEventType.Message);
		}

	}

	/**
	 * Run worklfow flow control logic
	 */
	public synchronized void run() {
		if (this.flowParser != null) {
			HShelfConsoleLogger.write("**WORKFLOW READING STARTED**");
			this.sendMessageToApp("**WORKFLOW READING STARTED**",
					HShelfEventType.Message);
			flowParser.run();
			HShelfConsoleLogger.write("**WORKFLOW READING ENDED**");
			this.sendMessageToApp("**WORKFLOW READING ENDED**",
					HShelfEventType.Message);
		}

	}

	// FACADE METHODS
	/**
	 * Resolves a contract from a component
	 * @param contract, represents the contract in XML
	 * @param compID, represents the component ID for that contract
	 */
	public synchronized void resolve(String compID) {
		ArchComponent archComponent = this.archParser.getArchComponentByID(Integer.parseInt(compID));
		if(!archComponent.getKind().equals( SAFeOrquestrationArchitecture.REPOSITORY)){
			try {
				String compName = archComponent.getName();
				HShelfTaskPort task = (HShelfTaskPort) this.services.getTaskPort("lyfe-cycle-"+compName+"-port");
				if(task!=null){
					HShelfLifeCyclePort lcPort = (HShelfLifeCyclePort)task;
					lcPort.resolve();
				}
			} catch (HShelfException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/*HShelfConsoleLogger.write("Entering Resolve...");
		String candidates = this.core.resolve(contract);
		if (candidates != null) {
			HShelfComponentCoreInfo compInfo = new HShelfComponentCoreInfo();
			compInfo.setCandidates(candidates);
			compInfo.setId(compID);
			this.componentVariableMap.put(compID, compInfo);
		}*/
	}

	/**
	 * Deploys a component in the Back-end. An ordered list of candidates is sent to Core and he
	 * send a message to deploy a component. A deployed id is saved.
	 * @param compID
	 */
	public synchronized void deploy(String compID) {
		
		ArchComponent archComponent = this.archParser.getArchComponentByID(Integer.parseInt(compID));
		if(!archComponent.getKind().equals( SAFeOrquestrationArchitecture.REPOSITORY)){
			try {
				String compName = archComponent.getName();
				HShelfTaskPort task = (HShelfTaskPort) this.services.getTaskPort("lyfe-cycle-"+compName+"-port");
				if(task!=null){
					HShelfLifeCyclePort lcPort = (HShelfLifeCyclePort)task;
					lcPort.deploy();
				}
			} catch (HShelfException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/*HShelfConsoleLogger.write("Entering Deploy...");
		HShelfComponentCoreInfo compInfo = this.componentVariableMap
				.get(compID);
		if (compInfo != null) {
			String orderedCandidates = compInfo.getCandidates();
			String deployedID = this.core.deploy(orderedCandidates);
			compInfo.setDeployedID(deployedID);
		}*/
	}

	public synchronized void instantiate(String compID) {
		ArchComponent archComponent = this.archParser.getArchComponentByID(Integer.parseInt(compID));
		if(!archComponent.getKind().equals( SAFeOrquestrationArchitecture.REPOSITORY)){
			try {
				String compName = archComponent.getName();
				HShelfTaskPort task = (HShelfTaskPort) this.services.getTaskPort("lyfe-cycle-"+compName+"-port");
				if(task!=null){
					HShelfLifeCyclePort lcPort = (HShelfLifeCyclePort)task;
					lcPort.instantiate();
				}
			} catch (HShelfException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/*HShelfConsoleLogger.write("Entering Instantiate...");
		HShelfComponentCoreInfo compInfo = this.componentVariableMap
				.get(compID);
		if (compInfo != null) {
			//String deployedID = compInfo.getDeployedID();
			//deployedID is fake. Using compID instead
			//String compString = this.core.instantiate(compID);
			//HShelfComponentCoreInfo compInfoTemp = xmlReader.readComponent(compString, compID);
			//variables in session, for proxie acess
			//for(HShelfPortCoreInfo portInfo:compInfoTemp.getPorts()){
				//HShelfSession.putValue(portInfo.getName(), portInfo.getURL());
			//}
			

			ArchComponent archComponent = this.archParser
					.getArchComponentByID(Integer.parseInt(compInfo.getId()));
			if (archComponent != null) {
				String compName = archComponent.getName();
				String capCompName = compName.substring(0, 1).toUpperCase()
						+ compName.substring(1);
				String proxiePkgName = HShelfFileUtil
						.readProperty("proxie-package");
				String proxieClassName = HShelfFileUtil
						.readProperty("proxie-class-name");

				HShelfComponent newComponent = this.framework.createComponent(
						compName, proxiePkgName + "." + capCompName
								+ proxieClassName);
				
				
					
				this.framework.addComponent(newComponent);
				this.sendMessageToApp(compName, HShelfEventType.Component_Added);
				
				
			}
			
			//workflow now need to connect its task ports
			ArchWorkflow archWorkflow = this.archParser.getArchWorkflow();
			for(ArchTask wfTask:archWorkflow.getTaskList()){
				for(ArchTask cTask:archComponent.getTaskList()){
					if(this.archParser.isThereTaskConnection(wfTask.getName(), cTask.getName())){
						this.framework.connectPartners(wfTask.getName(), cTask.getName());
						HShelfConsoleLogger.write("TASK CONNECTED: " + wfTask.getName() + "<->" + cTask.getName());
					}
						
				}
			}
			

		}*/
	}
	
	private synchronized void createComponentProxie(ArchComponent archComponent){
		if (archComponent != null) {
			String compName = archComponent.getName();
			String capCompName = compName.substring(0, 1).toUpperCase()
					+ compName.substring(1);
			String proxiePkgName = HShelfFileUtil
					.readProperty("proxie-package");
			String proxieClassName = HShelfFileUtil
					.readProperty("proxie-class-name");

			HShelfComponent newComponent = this.framework.createComponent(
					compName, proxiePkgName + "." + capCompName
							+ proxieClassName);
			
			this.framework.addComponent(newComponent);
			this.sendMessageToApp(compName, HShelfEventType.Component_Added);
			
			
			if(archComponent.getContract()!=null){
				String filePath = ((HShelfSAFeSWLPort) safeSWLPort)
						.getSAFeSWLArchFilePath();
				//String safeSWLCode = FileUtil.readFileAsString(filePath);
				//newComponent.setSafeSWLCode(safeSWLCode);
				
				newComponent.setSafeSWLPath(filePath);
				newComponent.setKind(archComponent.getKind());
				newComponent.setContract(archComponent.getContract().getUri());
			}
			
			//testing...Resolve, deploy e instantiate
			/*if(!archComponent.getKind().equals( SAFeOrquestrationArchitecture.REPOSITORY)){
				try {
					
					HShelfTaskPort task = (HShelfTaskPort) this.services.getTaskPort("lyfe-cycle-"+compName+"-port");
					if(task!=null){
						HShelfLifeCyclePort lcPort = (HShelfLifeCyclePort)task;
						lcPort.resolve();
						lcPort.instantiate();
						lcPort.deploy();
					}
				} catch (HShelfException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}*/
			
			
		}
		
		//workflow now need to connect its task ports
		ArchWorkflow archWorkflow = this.archParser.getArchWorkflow();
		for(ArchTask wfTask:archWorkflow.getTaskList()){
			for(ArchTask cTask:archComponent.getTaskList()){
				if(this.archParser.isThereTaskConnection(wfTask.getName(), cTask.getName())){
					this.framework.connectPartners(wfTask.getName(), cTask.getName());
					HShelfConsoleLogger.write("TASK CONNECTED: " + wfTask.getName() + "<->" + cTask.getName());
				}
					
			}
		}
	}
	
	//connect env ports
	public void connect(String compId){
		
		ArchComponent archComponent = null;
		
		if(compId.equals("0")){
			archComponent = this.archParser.getArchApplication();
		}else
			archComponent = this.archParser
				.getArchComponentByID(Integer.parseInt(compId));
		
		 
		
		for(ArchUses usesPort: archComponent.getUsesList()){
			
			
			
			String providesPortName = this.archParser.getProvidesPortNameByUsesPortName(usesPort.getName());
			this.framework.connect(usesPort.getName(),providesPortName);
			this.sendMessageToApp(usesPort.getName(), HShelfEventType.Port_Connected);
		}
	}

	public synchronized Object compute(String method, String portName) {
		try {

			HShelfTaskPort port = (HShelfTaskPort)this.services.getTaskPort(portName);
			
			if (port != null && port.isConnected()) {
				
				return HShelfReflectionUtil.invokeMethod(port, method, null);

			}
		} catch (HShelfException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void sendMessageToApp(String message, HShelfEventType eventType) {
		if (safeWorkflowEventPort != null)
			((HShelfWorkflowEventPortImpl) safeWorkflowEventPort).setMessage(
					message, eventType);
	}
}

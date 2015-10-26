package br.ufc.mdcc.pargo.safe.framework.workflow;

import java.util.HashMap;
import java.util.Map;

import br.ufc.mdcc.pargo.safe.framework.HShelfFramework;
import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.core.HShelfCoreImpl;
import br.ufc.mdcc.pargo.safe.framework.core.IHShelfCore;
import br.ufc.mdcc.pargo.safe.framework.core.info.HShelfComponentCoreInfo;
import br.ufc.mdcc.pargo.safe.framework.core.info.HShelfCoreXMLReaderImpl;
import br.ufc.mdcc.pargo.safe.framework.core.info.HShelfPortCoreInfo;
import br.ufc.mdcc.pargo.safe.framework.core.info.IHShelfCoreXMLReader;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfPort;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfGoWorkflowPortImpl;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfSAFeSWLPort;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfSAFeSWLPortImpl;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfWorkflowEventPortImpl;
import br.ufc.mdcc.pargo.safe.framework.port.event.HShelfEventType;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.mdcc.pargo.safe.framework.session.HShelfSession;
import br.ufc.mdcc.pargo.safe.framework.util.HShelfConsoleLogger;
import br.ufc.mdcc.pargo.safe.framework.util.HShelfFileUtil;
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

	// ports
	private HShelfPort safeSWLPort;
	private HShelfPort safeGoPort;
	private HShelfPort safeWorkflowEventPort;

	// util refs
	private HShelfFramework framework;
	private IHShelfCore core;
	private IHShelfCoreXMLReader xmlReader;

	// language
	private Map<String, HShelfComponentCoreInfo> componentVariableMap;
	private ISAFeSWLArcherParser archParser;
	private ISAFeSWLFlowParser flowParser;
	private HShelfWorkflowFacade workflowFacade;
	


	public HShelfWorkflow(String name, HShelfFramework framework) {
		HShelfConsoleLogger.write("Creating HShelfWorkflow");
		this.framework = framework;
		this.setName(name);

		this.core = new HShelfCoreImpl();
		this.xmlReader = new HShelfCoreXMLReaderImpl();
		this.componentVariableMap = new HashMap<String, HShelfComponentCoreInfo>();
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
			((HShelfGoWorkflowPortImpl) safeGoPort).workflow = this;
			safeGoPort.setName(HShelfWorkflow.SAFE_WORKFLOW_GO_PORT);
			this.services.setProvidesPort(safeGoPort);

			safeWorkflowEventPort = new HShelfWorkflowEventPortImpl();
			safeWorkflowEventPort
					.setName(HShelfWorkflow.SAFE_WORKFLOW_EVENT_PORT);
			this.services.setProvidesPort(safeWorkflowEventPort);

		} catch (HShelfException e) {

			e.printStackTrace();
		}
	}

	/**
	 * loads architecture file.
	 */
	public void loadArchitectureFile() {
		String filePath = ((HShelfSAFeSWLPort) safeSWLPort)
				.getSAFeSWLArchFilePath();
		if (filePath != null) {
			this.archParser = new SAFeSWLArchParser(filePath);
			HShelfConsoleLogger.write("Architecture file loaded");
			this.sendMessageToApp("Architecture file loaded",
					HShelfEventType.Message);
		}

	}

	/**
	 * loads workflow file
	 */
	public void loadWorkflowFile() {
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
	public void run() {
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
	public synchronized void resolve(String contract, String compID) {
		HShelfConsoleLogger.write("Entering Resolve...");
		String candidates = this.core.resolve(contract);
		if (candidates != null) {
			HShelfComponentCoreInfo compInfo = new HShelfComponentCoreInfo();
			compInfo.setCandidates(candidates);
			compInfo.setId(compID);
			this.componentVariableMap.put(compID, compInfo);
		}
	}

	/**
	 * Deploys a component in the Back-end. An ordered list of candidates is sent to Core and he
	 * send a message to deploy a component. A deployed id is saved.
	 * @param compID
	 */
	public synchronized void deploy(String compID) {
		HShelfConsoleLogger.write("Entering Deploy...");
		HShelfComponentCoreInfo compInfo = this.componentVariableMap
				.get(compID);
		if (compInfo != null) {
			String orderedCandidates = compInfo.getCandidates();
			String deployedID = this.core.deploy(orderedCandidates);
			compInfo.setDeployedID(deployedID);
		}
	}

	public synchronized void instantiate(String compID) {
		HShelfConsoleLogger.write("Entering Instantiate...");
		HShelfComponentCoreInfo compInfo = this.componentVariableMap
				.get(compID);
		if (compInfo != null) {
			//String deployedID = compInfo.getDeployedID();
			//deployedID is fake. Using compID instead
			String compString = this.core.instantiate(compID);
			HShelfComponentCoreInfo compInfoTemp = xmlReader.readComponent(compString, compID);
			//variables in session, for proxie acess
			for(HShelfPortCoreInfo portInfo:compInfoTemp.getPorts()){
				HShelfSession.putValue(portInfo.getName(), portInfo.getURL());
			}
			

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
				// avisar a aplicação que esse componente está pronto e que ela
				// pode pegar suas portas...
				this.sendMessageToApp(compName, HShelfEventType.Component_Added);
			}

		}
	}

	public synchronized void compute(String method, String portName) {
		try {

			HShelfPort port = this.services.getTaskPort(portName);
			if (port != null) {

				HShelfReflectionUtil.invokeMethod(port, method, null);

			}
		} catch (HShelfException e) {
			e.printStackTrace();
		}
	}

	private void sendMessageToApp(String message, HShelfEventType eventType) {
		if (safeWorkflowEventPort != null)
			((HShelfWorkflowEventPortImpl) safeWorkflowEventPort).setMessage(
					message, eventType);
	}
}

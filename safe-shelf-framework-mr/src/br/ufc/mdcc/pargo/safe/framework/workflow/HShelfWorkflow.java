package br.ufc.mdcc.pargo.safe.framework.workflow;

import java.util.List;

import br.ufc.mdcc.pargo.safe.framework.HShelfFramework;
import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.core.HShelfCoreComponent;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfActionFutureImpl;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfProvidesPort;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfTaskPort;
import br.ufc.mdcc.pargo.safe.framework.port.IHShelfActionFuture;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfGoWorkflowPortImpl;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfLifeCyclePort;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfSAFeSWLPort;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfSAFeSWLPortImpl;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfWorkflowEventPortImpl;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfWorkflowServicesProvidesPort;
import br.ufc.mdcc.pargo.safe.framework.port.event.HShelfEventType;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.mdcc.pargo.safe.framework.util.HShelfConsoleLogger;
import br.ufc.mdcc.pargo.safe.framework.util.HShelfFileUtil;
import br.ufc.mdcc.pargo.safe.grammar.ISAFeSWLArcherParser;
import br.ufc.mdcc.pargo.safe.grammar.ISAFeSWLFlowParser;
import br.ufc.mdcc.pargo.safe.grammar.SAFeSWLArchParser;
import br.ufc.mdcc.pargo.safe.grammar.SAFeSWLFlowParser;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchComponent;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchActionPort;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchUserPort;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchWorkflow;
import br.ufc.mdcc.pargo.safe.grammar.arch.SAFeOrquestrationArchitecture;
import br.ufc.mdcc.pargo.safe.grammar.util.FileUtil;

public class HShelfWorkflow extends HShelfComponent {

	// default port names
	public static final String SAFE_WORKFLOW_SWL_PORT = "port_SAFeSWL";
	public static final String SAFE_WORKFLOW_GO_PORT = "port_Go";
	public static final String SAFE_WORKFLOW_EVENT_PORT = "port_Event";

	// ports
	private HShelfProvidesPort safeSWLPort;
	private HShelfProvidesPort safeGoPort;
	private HShelfProvidesPort safeWorkflowEventPort;

	// util refs
	private HShelfFramework framework;

	// language
	private ISAFeSWLArcherParser archParser;
	private ISAFeSWLFlowParser flowParser;
	private HShelfWorkflowFacade workflowFacade;

	// session manipulator
	//private HShelfWorkflowSession workflowSession;
	private String workflowSession;

	public HShelfWorkflow(String name, HShelfFramework framework) {
		HShelfConsoleLogger.write("Creating HShelfWorkflow");
		this.framework = framework;
		this.setName(name);
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
	public synchronized void loadArchitectureFile() {

		HShelfWorkflowServicesProvidesPort workfloweServicesProvidesPort = null;
		try {
			workfloweServicesProvidesPort = (HShelfWorkflowServicesProvidesPort) this.services
					.getConnectedProvidesPort(HShelfCoreComponent.WORKFLOW_SERVICES_USE);
		} catch (HShelfException e1) {

			e1.printStackTrace();
		}

		this.archParser = null;
		String filePath = ((HShelfSAFeSWLPort) safeSWLPort)
				.getSAFeSWLArchFilePath();
		if (filePath != null) {
			this.archParser = new SAFeSWLArchParser(filePath);
			HShelfConsoleLogger.write("Architecture file loaded");
			this.sendMessageToApp("Architecture file loaded",
					HShelfEventType.Message);

			/*
			 * A-1 : inicia uma sessão, passando como argumento o código SAFeSWL
			 * Arquitetural e recebendo como resultado um manipulador de sessão.
			 */
			String SAFESWLContent = FileUtil.readFileAsString(filePath);
			this.workflowSession =  workfloweServicesProvidesPort
					.openWorkflowSession(SAFESWLContent).toString();
		}

		if (this.services != null) {
			ArchWorkflow archWorkflow = this.archParser.getArchWorkflow();
			for (ArchActionPort task : archWorkflow.getTaskList()) {
				HShelfTaskPort taskPort = new HShelfTaskPort();
				taskPort.setName(task.getName());
				// HShelfConsoleLogger.write("TASK-NAME: " + task.getName());
				try {
					this.services.registerTaskPort(taskPort);
				} catch (HShelfException e) {

					e.printStackTrace();
				}
			}
		}

		if (this.archParser != null) {
			List<ArchComponent> components = this.archParser.getComponents();
			for (ArchComponent cmp : components) {
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

			/* A-3 : finalizar uma sessão, após o final da execução do workflow */
			HShelfWorkflowServicesProvidesPort workfloweServicesProvidesPort = null;
			try {
				workfloweServicesProvidesPort = (HShelfWorkflowServicesProvidesPort) this.services
						.getConnectedProvidesPort(HShelfCoreComponent.WORKFLOW_SERVICES_USE);
			} catch (HShelfException e1) {

				e1.printStackTrace();
			}
			workfloweServicesProvidesPort
					.closeWorkflowSession(this.workflowSession.toString());

		}

	}

	/**
	 * Resolves a contract from a component
	 * 
	 * @param contract
	 *            , represents the contract in XML
	 * @param compID
	 *            , represents the component ID for that contract
	 */
	public synchronized void resolve(String compID) {
		ArchComponent archComponent = this.archParser
				.getArchComponentByID(Integer.parseInt(compID));
		if (!archComponent.getKind().equals(
				SAFeOrquestrationArchitecture.DUMMY)) {
			try {
				String compName = archComponent.getName();
				HShelfTaskPort task = (HShelfTaskPort) this.services
						.getTaskPort("lyfe-cycle-" + compName + "-port");
				if (task != null) {
					HShelfLifeCyclePort lcPort = (HShelfLifeCyclePort) task;
					lcPort.resolve();
				}
			} catch (HShelfException e) {

				e.printStackTrace();
			}
		}

	}

	/**
	 * Deploys a component in the Back-end. An ordered list of candidates is
	 * sent to Core and he send a message to deploy a component. A deployed id
	 * is saved.
	 * 
	 * @param compID
	 */
	public synchronized void deploy(String compID) {

		ArchComponent archComponent = this.archParser
				.getArchComponentByID(Integer.parseInt(compID));
		if (!archComponent.getKind().equals(
				SAFeOrquestrationArchitecture.DUMMY)) {
			try {
				String compName = archComponent.getName();
				HShelfTaskPort task = (HShelfTaskPort) this.services
						.getTaskPort("lyfe-cycle-" + compName + "-port");
				if (task != null) {
					HShelfLifeCyclePort lcPort = (HShelfLifeCyclePort) task;
					lcPort.deploy();
				}
			} catch (HShelfException e) {

				e.printStackTrace();
			}
		}
	}

	public synchronized void instantiate(String compID) {
		ArchComponent archComponent = this.archParser
				.getArchComponentByID(Integer.parseInt(compID));
		if (!archComponent.getKind().equals(
				SAFeOrquestrationArchitecture.DUMMY)) {
			try {
				String compName = archComponent.getName();
				HShelfTaskPort task = (HShelfTaskPort) this.services
						.getTaskPort("lyfe-cycle-" + compName + "-port");
				if (task != null) {
					HShelfLifeCyclePort lcPort = (HShelfLifeCyclePort) task;
					lcPort.instantiate();
				}
			} catch (HShelfException e) {

				e.printStackTrace();
			}
		}

	}

	private synchronized void createComponentProxie(ArchComponent archComponent) {

		HShelfWorkflowServicesProvidesPort workfloweServicesProvidesPort = null;
		try {
			workfloweServicesProvidesPort = (HShelfWorkflowServicesProvidesPort) this.services
					.getConnectedProvidesPort(HShelfCoreComponent.WORKFLOW_SERVICES_USE);
		} catch (HShelfException e1) {

			e1.printStackTrace();
		}

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

			if (archComponent.getContract() != null) {
				String filePath = ((HShelfSAFeSWLPort) safeSWLPort)
						.getSAFeSWLArchFilePath();

				newComponent.setSafeSWLPath(filePath);
				newComponent.setKind(archComponent.getKind());
				newComponent.setContract(archComponent.getContract().getUri());
				newComponent.setId(archComponent.getId());
				newComponent.setWorkflowSession(this.workflowSession);

				/* A-2 : resgistrar contrato para cada componente */
				workfloweServicesProvidesPort.registerContract(newComponent
						.getContract());
			}

			/*
			 * System.out.println("-->"+archComponent.getName()); for(ArchUses
			 * uses:archComponent.getUsesList())
			 * System.out.println("---->"+uses.getName()); for(ArchProvides
			 * prov:archComponent.getProvidesList())
			 * System.out.println("---->"+prov.getName());
			 */

		}

		// workflow now need to connect its task ports
		ArchWorkflow archWorkflow = this.archParser.getArchWorkflow();
		for (ArchActionPort wfTask : archWorkflow.getTaskList()) {
			for (ArchActionPort cTask : archComponent.getTaskList()) {
				if (this.archParser.isThereTaskConnection(wfTask.getName(),
						cTask.getName())) {
					this.framework.connectPartners(wfTask.getName(),
							cTask.getName());
					// HShelfConsoleLogger.write("TASK CONNECTED: " +
					// wfTask.getName() + "<->" + cTask.getName());
				}

			}
		}
	}

	// connect env ports
	public void connect(String compId) {

		ArchComponent archComponent = null;

		if (compId.equals("0")) {
			archComponent = this.archParser.getArchApplication();
		} else
			archComponent = this.archParser.getArchComponentByID(Integer
					.parseInt(compId));

		for (ArchUserPort usesPort : archComponent.getUsesList()) {

			System.out.println("TESTE: " + usesPort.getName());
			String providesPortName = this.archParser
					.getProvidesPortNameByUsesPortName(usesPort.getName());

			this.framework.connect(usesPort.getName(), providesPortName);
			this.sendMessageToApp(usesPort.getName(),
					HShelfEventType.Port_Connected);
		}
	}

	public void connectAllEnvironmentPorts() {
		this.connect("0");
		for (ArchComponent ac : this.archParser.getComponents()) {
			this.connect(ac.getId().toString());
		}
	}

	public synchronized Object compute(String method, String portName) {
		try {

			HShelfTaskPort port = (HShelfTaskPort) this.services
					.getTaskPort(portName);

			if (port != null && port.isConnected()) {

				// return HShelfReflectionUtil.invokeMethod(port, method, null);
				port.invoke(method);

			}
		} catch (HShelfException e) {
			e.printStackTrace();
		}
		return null;
	}

	public synchronized IHShelfActionFuture computeActionFuture(String method,
			String portName) {
		try {

			HShelfTaskPort port = (HShelfTaskPort) this.services
					.getTaskPort(portName);

			if (port != null && port.isConnected()) {

				// return HShelfReflectionUtil.invokeMethod(port, method, null);
				IHShelfActionFuture actionFuture = null;
				port.invoke(method, actionFuture);
				actionFuture = new HShelfActionFutureImpl();
				return actionFuture;

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

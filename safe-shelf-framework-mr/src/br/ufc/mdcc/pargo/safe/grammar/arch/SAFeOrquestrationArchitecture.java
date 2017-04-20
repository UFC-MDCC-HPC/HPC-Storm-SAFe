package br.ufc.mdcc.pargo.safe.grammar.arch;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.jdom2.Element;

public class SAFeOrquestrationArchitecture {

	private ArchApplication archApplication;
	private ArchWorkflow archWorkflow;
	private ArchSolution archSolution;
	private List<ArchBindingService> bindingService;
	private ArchBindingAction bindingAction;

	private Map<String, ArchUserPort> userPortMap;
	private Map<String, ArchProviderPort> providerPortMap;
	private Map<String, ArchActionPort> actionPortMap;

	// list of reserved words in XML
	public static final String APPLICATION = "application";
	public static final String WORKFLOW = "workflow";
	public static final String SOLUTION = "solution";
	public static final String SERVICE_BINDING = "service_binding";
	public static final String ACTION_BINDING = "action_binding";

	public static final String COMPUTATION = "computation";
	public static final String PLATFORM = "platform";
	public static final String CONNECTOR = "connector";
	public static final String REPOSITORY = "repository";
	public static final String DUMMY = "dummy";

	public static final String USER_PORT = "user_port";
	public static final String PROVIDER_PORT = "provider_port";
	public static final String ACTION_PORT = "action_port";
	public static final String ACTION = "action";
	public static final String PEER = "peer";

	public static final String CONTRACT = "contract";
	public static final String URI = "uri";
	public static final String INSTANTIATION_TYPE = "instantiation_type";
	public static final String CONTEXTUAL_TYPE = "contextual_type";
	public static final String UNIT_MAPPING = "unit_mapping";
	public static final String FACET_ADDRESS = "facet_address";
	public static final String NODE = "node";
	public static final String VARIABLE = "variable";
	public static final String TYPE = "type";
	public static final String ARGUMENT = "argument";

	public static final String att_id_port = "id_port";
	public static final String att_id_component = "id_component";
	public static final String att_name = "name";
	public static final String att_instance_ref = "instance_ref";
	public static final String att_unit_id = "unit_id";
	public static final String att_unit_index = "unit_index";
	public static final String att_address = "address";
	public static final String att_port = "port";
	public static final String att_comp_ref = "component_ref";
	public static final String att_parameter_id = "parameter_id";
	public static final String att_wsdl_path = "wsdl_path";

	public SAFeOrquestrationArchitecture() {
		this.bindingService = new ArrayList<ArchBindingService>();
		this.actionPortMap = new Hashtable<String, ArchActionPort>();
		this.userPortMap = new Hashtable<String, ArchUserPort>();
		this.providerPortMap = new Hashtable<String, ArchProviderPort>();
	}

	public ArchApplication getArchApplication() {
		return archApplication;
	}

	public void setArchApplication(ArchApplication archApplication) {
		this.archApplication = archApplication;
	}

	public ArchWorkflow getArchWorkflow() {
		return archWorkflow;
	}

	public void setArchWorkflow(ArchWorkflow archWorkflow) {
		this.archWorkflow = archWorkflow;
	}

	public ArchSolution getArchSolution() {
		return archSolution;
	}

	public void setArchSolution(ArchSolution archSolution) {
		this.archSolution = archSolution;
	}

	public List<ArchBindingService> getBindingService() {
		return bindingService;
	}

	public void setBindingService(List<ArchBindingService> bindingService) {
		this.bindingService = bindingService;
	}

	public ArchBindingAction getBindingAction() {
		return bindingAction;
	}

	public void setBindingAction(ArchBindingAction bindingAction) {
		this.bindingAction = bindingAction;
	}

	public void addBindingService(ArchBindingService bindingService) {
		this.bindingService.add(bindingService);
	}

	public void putActionPort(String idComponent, String idPort, ArchActionPort port) {
		this.actionPortMap.put(idComponent+"$"+idPort,port);
	}

	public void putUserPort(String idComponent, String idPort, ArchUserPort port) {
		this.userPortMap.put(idComponent+"$"+idPort,port);
	}

	public void putProviderPort(String idComponent, String idPort, ArchProviderPort port) {
		this.providerPortMap.put(idComponent+"$"+idPort,port);
	}
	
	public ArchActionPort getActionPort(String idComponent, String idPort) {
		return this.actionPortMap.get(idComponent+"$"+idPort);
	}

	public ArchUserPort getUserPort(String idComponent, String idPort) {
		return this.userPortMap.get(idComponent+"$"+idPort);
	}

	public ArchProviderPort getProviderPort(String idComponent, String idPort) {
		return this.providerPortMap.get(idComponent+"$"+idPort);
	}

	// create methods
	public ArchApplication createArchApplication() {
		ArchApplication archApp = new ArchApplication();
		archApp.setIdComponent("application");
		return archApp;
	}

	public ArchWorkflow createArchWorkflow() {
		ArchWorkflow archWf = new ArchWorkflow();
		archWf.setIdComponent("workflow");
		return archWf;
	}

	public ArchBindingService createArchBindingService() {
		ArchBindingService archAtt = new ArchBindingService();
		return archAtt;
	}

	public ArchBindingAction createArchBindingAction() {
		ArchBindingAction archAtt = new ArchBindingAction();
		return archAtt;
	}

	public ArchSolution createArchSolution() {
		ArchSolution archSolution = new ArchSolution();
		return archSolution;
	}

	public ArchUserPort createArchUserPort(Element e) {
		ArchUserPort archUser = new ArchUserPort();
		archUser.setIdPort(e.getAttributeValue(att_id_port));
		return archUser;
	}

	public ArchProviderPort createArchProviderPort(Element e) {
		ArchProviderPort archProvider = new ArchProviderPort();
		archProvider.setIdPort(e.getAttributeValue(att_id_port));
		return archProvider;
	}

	public ArchActionPort createArchActionPort(Element e) {
		ArchActionPort archActionPort = new ArchActionPort();	
		archActionPort.setIdPort(e.getAttributeValue(att_id_port));

		for (Element child : e.getChildren()) {
			if (child.getName().equalsIgnoreCase(ACTION)) {
				ArchAction archAction = new ArchAction();
				archAction.setParent(archActionPort);
				archAction.setName(child.getAttributeValue(att_name));
				archActionPort.addArchAction(archAction);
			}
		}

		return archActionPort;
	}

	public ArchComponent createArchComponent(Element e, String kind) {
		ArchComponent archComponent = new ArchComponent();
		archComponent.setIdComponent(e.getAttributeValue(att_id_component));
		archComponent.setKind(kind);
		return archComponent;
	}


	@Override
	public String toString() {
		String res = "";
		
		res+=this.archApplication;
		res+="\n\n";
		res+=this.archWorkflow;
		res+="\n\n";
		res+=this.archSolution;
		res+="\n\n";
		for(ArchBindingService service:this.bindingService){
			res+=service;res+="\n";
		}
		res+="\n\n";
		res+=this.bindingAction;
		return res;
		
	}
}

package br.ufc.mdcc.pargo.safe.grammar.arch;

import java.util.ArrayList;
import java.util.List;

import org.jdom2.Element;

public class SAFeOrquestrationArchitecture {
		
		//whole application name
		private String applicationName;
		//Application Component
		private ArchApplication archApplication;
		



		//Workflow Component
		private ArchWorkflow archWorkflow;
		//Body Element
		private ArchBody body;
		//List of Uses Ports
		private List<ArchUses> usesList;
		//List of Provides Ports
		private List<ArchProvides> providesList;
		//List of Task Ports
		private List<ArchTask> taskList;
		//List of Binding elements
		private List<ArchEnvBinding> attachmentEnvList;
		private List<ArchTaskBinding> attachmentTaskList;
		//List of Contracts
		private List<ArchContract> contractList;
		
		//list of reserved words in XML
		public static final String APPLICATION_NAME = "application_name";
		public static final String APPLICATION = "application";
		public static final String WORKFLOW = "workflow";
		public static final String BODY = "body";
		public static final String ENV_BINDING = "env_binding";
		public static final String TASK_BINDING = "task_binding";
		
		public static final String COMPUTATION = "computation";
		public static final String PLATFORM = "platform";
		public static final String CONNECTOR = "connector";
		public static final String REPOSITORY = "repository";
		
		public static final String ENV_PORTS = "env_ports";
		public static final String TASK_PORTS = "task_ports";
		
		public static final String USES = "uses_port";
		public static final String PROVIDES = "provides_port";
		
		public static final String TASK_PORT = "task_port";
		
		public static final String TASK_LEFT_PEER = "left_peer";
		public static final String TASK_RIGHT_PEER = "right_peer";
		
		public static final String ACTION = "action";
		
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
		
		public static final String att_name = "name";
		public static final String att_id = "id";
		public static final String att_url = "url";
		public static final String att_instance_ref = "instance_ref";
		public static final String att_unit_id = "unit_id"; 
		public static final String att_unit_index = "unit_index";
		public static final String att_address = "address";
		public static final String att_port = "port";
		public static final String att_comp_ref = "component_ref";
		public static final String att_parameter_id = "parameter_id";
		public static final String att_wsdl_path = "wsdl_path";
		
		
		
		public SAFeOrquestrationArchitecture(){
			this.usesList = new ArrayList<ArchUses>();
			this.providesList = new ArrayList<ArchProvides>();
			this.taskList = new ArrayList<ArchTask>();
			this.body = new ArchBody();
			this.attachmentEnvList = new ArrayList<ArchEnvBinding>();
			this.attachmentTaskList = new ArrayList<ArchTaskBinding>();
			this.contractList = new ArrayList<ArchContract>();
		}
		
		public ArchApplication getArchApplication() {
			return archApplication;
		}
		
		public ArchWorkflow getArchWorflow() {
			return archWorkflow;
		}
		
		//create methods
		public ArchApplication createArchApplication(Element appElement){
			ArchApplication archApp = new ArchApplication();
			archApp.setName(appElement.getAttributeValue(att_name));
			archApp.setId(Integer.parseInt(appElement.getAttributeValue(att_id)));
			return archApp;
		}
		
		public ArchWorkflow createArchWorkflow(Element wfElement){
			ArchWorkflow archWf = new ArchWorkflow();
			archWf.setName(wfElement.getAttributeValue(att_name));
			archWf.setId(Integer.parseInt(wfElement.getAttributeValue(att_id)));
			return archWf;
		}
		
		public ArchEnvBinding createArchEnvAttachement(Element e){
			ArchEnvBinding archAtt = new ArchEnvBinding();
			archAtt.setName(e.getAttributeValue(att_name));
			if(e.getAttributeValue(att_id)!=null)
				archAtt.setId(Integer.parseInt((e.getAttributeValue(att_id))));
			return archAtt;
		}
		
		public ArchTaskBinding createArchTaskAttachement(Element e){
			ArchTaskBinding archAtt = new ArchTaskBinding();
			archAtt.setName(e.getAttributeValue(att_name));
			if(e.getAttributeValue(att_id)!=null)
				archAtt.setId(Integer.parseInt((e.getAttributeValue(att_id))));
			return archAtt;
		}
		
		public ArchUses createArchUses(Element usesElement){
			ArchUses archUses = new ArchUses();
			archUses.setName(usesElement.getAttributeValue(att_name));
			archUses.setId(Integer.parseInt((usesElement.getAttributeValue(att_id))));
			archUses.setWsdlPath((usesElement.getAttributeValue(att_wsdl_path)));
			return archUses;
		}
		
		public ArchProvides createArchProvides(Element providesElement){
			ArchProvides archProvides = new ArchProvides();
			archProvides.setName(providesElement.getAttributeValue(att_name));
			archProvides.setId(Integer.parseInt((providesElement.getAttributeValue(att_id))));
			archProvides.setWsdlPath((providesElement.getAttributeValue(att_wsdl_path)));
			return archProvides;
		}
		
		public ArchTask createArchTask(Element element){
			ArchTask archTask = new ArchTask();
			//archTask.setName(providesElement.getAttributeValue(att_name));
			
			archTask.setId(Integer.parseInt((element.getAttributeValue(att_id))));
			archTask.setName(element.getAttributeValue(att_name));
			archTask.setWsdlPath(element.getAttributeValue(att_wsdl_path));
			
			for(Element child:element.getChildren()){
				if(child.getName().equalsIgnoreCase(SAFeOrquestrationArchitecture.ACTION)){
					ArchAction action = this.createArchAction(child);
					action.setParent(archTask);
					archTask.addArchAction(action);
				}
			}
			
			return archTask;
		}
		
		public ArchBody createArchBody(Element bodyElement){
			ArchBody archBody = new ArchBody();
			return archBody;
		}
		
		public ArchComponent createArchComputation(Element element){
			ArchComputation comp = new ArchComputation();
			if(element.getAttributeValue(att_address)!=null){
				comp.setAddress(element.getAttributeValue(att_address));
			}
			comp.setName(element.getAttributeValue(att_name));
			comp.setId(Integer.parseInt((element.getAttributeValue(att_id))));
			return comp;
		}
		
		public ArchComponent createArchConnector(Element element){
			ArchConnector conn = new ArchConnector();
			if(element.getAttributeValue(att_address)!=null){
				conn.setAddress(element.getAttributeValue(att_address));
			}
			conn.setName(element.getAttributeValue(att_name));
			conn.setId(Integer.parseInt((element.getAttributeValue(att_id))));
			return conn;
		}
		
		public ArchComponent createArchPlatform(Element element){
			ArchPlatform pla = new ArchPlatform();
			if(element.getAttributeValue(att_address)!=null){
				pla.setAddress(element.getAttributeValue(att_address));
			}
			pla.setName(element.getAttributeValue(att_name));
			pla.setId(Integer.parseInt((element.getAttributeValue(att_id))));
			return pla;
		}
		
		public ArchComponent createArchRepository(Element element){
			ArchRepository rep = new ArchRepository();
			rep.setName(element.getAttributeValue(att_name));
			rep.setId(Integer.parseInt((element.getAttributeValue(att_id))));
			return rep;
		}
		
		public ArchAction createArchAction(Element element){
			ArchAction archAction = new ArchAction();
			archAction.setId(Integer.parseInt((element.getAttributeValue(att_id))));
			archAction.setName(element.getAttributeValue(att_name));
			return archAction;
		}
		
		//adding methods (these methods are used for query purposes only)
		public void addArchUses(ArchUses uses){
			this.usesList.add(uses);
		}
		public void addArchProvides(ArchProvides provides){
			this.providesList.add(provides);
		}
		public void addArchTask(ArchTask task){
			this.taskList.add(task);
		}
		public void addArchEnvAttachment(ArchEnvBinding binding){
			this.attachmentEnvList.add(binding);
		}
		public void addArchTaskAttachment(ArchTaskBinding binding){
			this.attachmentTaskList.add(binding);
		}
		public void addArchContract(ArchContract contract){
			this.contractList.add(contract);
		}
		
		//setting
		public void setArchBody(ArchBody body){
			this.body = body;
		}
		public void setArchApplication(ArchApplication app){
			this.archApplication = app;
		}
		public void setArchWorkflow(ArchWorkflow wf){
			this.archWorkflow = wf;
		}
		
		//getting from collections
		public ArchUses getArchUsesById(Integer id){
			ArchUses uses = new ArchUses();
			uses.setId(id);
			int index = this.usesList.indexOf(uses);
			if(index<0) return null;
			else return this.usesList.get(index);
		}
		
		public ArchProvides getArchProvidesById(Integer id){
			ArchProvides provides = new ArchProvides();
			provides.setId(id);
			int index = this.providesList.indexOf(provides);
			if(index<0) return null;
			else return this.providesList.get(index);
		}
		
		public ArchTask getArchTaskById(Integer id){
			ArchProvides provides = new ArchProvides();
			provides.setId(id);
			int index = this.taskList.indexOf(provides);
			if(index<0) return null;
			else return this.taskList.get(index);
		}
		
		public ArchContract getArchContractById(Integer id){
			ArchContract contract = new ArchContract();
			contract.setId(id);
			int index = this.contractList.indexOf(contract);
			if(index<0) return null;
			else return this.contractList.get(index);
		}
		
		//some services...
		public ArchComponent getArchComponentByID(Integer id){
			return this.body.getArchComponentById(id);
		}
		
		public ArchAction getArchActionBy(Integer id){
			return this.body.getArchActionById(id);
		}
	
		public String getProvidesPortNameByUsesPortName(String usesPortName) {
			
			for(ArchEnvBinding env:this.attachmentEnvList){
				ArchUses uses = env.getUses();
				if(uses.getName().equals(usesPortName))
					return env.getProvides().getName();
			}
			
			return null;
		}
		
		public String getPartnerBByPartnerAName(String partnerAName) {
			for(ArchTaskBinding tsk:this.attachmentTaskList){
				ArchTask ptnA = tsk.getTaskA();
				if(ptnA.getName().equals(partnerAName))
					return tsk.getTaskB().getName();
			}
			return null;
		}
		
		public boolean isThereEnvironmentConnection(String uses,
				String provides) {
			for(ArchEnvBinding env:this.attachmentEnvList){
				if(env.getUses().getName().equals(uses) &&
				   env.getProvides().getName().equals(provides))
					return true;
			}
			return false;
		}

		public boolean isThereTaskConnection(String partnerA, String partnerB) {

			for(ArchTaskBinding task:this.attachmentTaskList){
				if(task.getTaskA().getName().equals(partnerA) &&
				   task.getTaskB().getName().equals(partnerB))
					return true;
					
			}
			return false;
		}
		
		public String getApplicationName() {
			return applicationName;
		}

		public void setApplicationName(String applicationName) {
			this.applicationName = applicationName;
		}

		
		
		
		@Override
		public String toString() {
		
				String res="";
				res+="\nApplication:\n";
				res+=this.archApplication;
				res+="\nWorkflow:\n";
				res+=this.archWorkflow;
				res+="\nBody:\n";
				res+=this.body;
				res+="\n\nEnv Bindings:";
				for(ArchEnvBinding att:attachmentEnvList)
					res+="\n"+att.toString();
				res+="\n\nTask Bindings:";
				for(ArchTaskBinding att:attachmentTaskList)
					res+="\n"+att.toString();
				return res;
		}

		public List<ArchComponent> getComponents() {
			return this.body.getComponents();
		}

		 
		

		

		

		
}

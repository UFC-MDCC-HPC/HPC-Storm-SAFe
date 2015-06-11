package br.ufc.mdcc.pargo.safe.grammar.arch;

import java.util.ArrayList;
import java.util.List;

import org.jdom2.Element;

public class ArchMain {
		
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
		
		//list of reserved words in XML
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
		
		public static final String USES = "uses";
		public static final String PROVIDES = "provides";
		
		public static final String TASK_PORT = "task_port";
		
		public static final String TASK_A = "task_A";
		public static final String TASK_B = "task_B";
		
		public static final String ACTION = "action";
		
		public static final String att_name = "name";
		public static final String att_id = "id";
		
		public ArchMain(){
			this.usesList = new ArrayList<ArchUses>();
			this.providesList = new ArrayList<ArchProvides>();
			this.taskList = new ArrayList<ArchTask>();
			this.body = new ArchBody();
			this.attachmentEnvList = new ArrayList<ArchEnvBinding>();
			this.attachmentTaskList = new ArrayList<ArchTaskBinding>();
		}
		
		//create methods
		public ArchApplication createArchApplication(Element appElement){
			ArchApplication archApp = new ArchApplication();
			archApp.setName(appElement.getAttributeValue(att_name));
			return archApp;
		}
		
		public ArchWorkflow createArchWorkflow(Element wfElement){
			ArchWorkflow archWf = new ArchWorkflow();
			archWf.setName(wfElement.getAttributeValue(att_name));
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
			return archUses;
		}
		
		public ArchProvides createArchProvides(Element providesElement){
			ArchProvides archProvides = new ArchProvides();
			archProvides.setName(providesElement.getAttributeValue(att_name));
			archProvides.setId(Integer.parseInt((providesElement.getAttributeValue(att_id))));
			return archProvides;
		}
		
		public ArchTask createArchTask(Element providesElement){
			ArchTask archTask = new ArchTask();
			archTask.setName(providesElement.getAttributeValue(att_name));
			archTask.setId(Integer.parseInt((providesElement.getAttributeValue(att_id))));
			return archTask;
		}
		
		public ArchBody createArchBody(Element bodyElement){
			ArchBody archBody = new ArchBody();
			return archBody;
		}
		
		public ArchComponent createArchComputation(Element element){
			ArchComputation comp = new ArchComputation();
			comp.setName(element.getAttributeValue(att_name));
			comp.setId(Integer.parseInt((element.getAttributeValue(att_id))));
			return comp;
		}
		
		public ArchComponent createArchConnector(Element element){
			ArchConnector conn = new ArchConnector();
			conn.setName(element.getAttributeValue(att_name));
			conn.setId(Integer.parseInt((element.getAttributeValue(att_id))));
			return conn;
		}
		
		public ArchComponent createArchPlatform(Element element){
			ArchPlatform pla = new ArchPlatform();
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
		
		//adding methods
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
}

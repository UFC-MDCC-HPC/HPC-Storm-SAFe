package br.ufc.mdcc.pargo.safe.grammar.arch;

import java.util.ArrayList;
import java.util.List;

import org.jdom2.Element;

public class ArchitectureMain {
		
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
		//List of Binding elements
		private List<ArchAttachment> attachmentList;
		
		//list of reserved words in XML
		public static final String APPLICATION = "application";
		public static final String WORKFLOW = "workflow";
		public static final String BODY = "body";
		public static final String ATTACHMENT = "attachment";
		
		public static final String COMPUTATION = "computation";
		public static final String PLATFORM = "platform";
		public static final String CONNECTOR = "connector";
		
		public static final String USES = "uses_port";
		public static final String PROVIDES = "provides_port";
		
		public ArchitectureMain(){
			this.usesList = new ArrayList<ArchUses>();
			this.providesList = new ArrayList<ArchProvides>();
			this.body = new ArchBody();
			this.attachmentList = new ArrayList<ArchAttachment>();
		}
		
		//create methods
		public ArchApplication createArchApplication(Element appElement){
			ArchApplication archApp = new ArchApplication();
			archApp.setName(appElement.getAttributeValue("name"));
			return archApp;
		}
		
		public ArchWorkflow createArchWorkflow(Element wfElement){
			ArchWorkflow archWf = new ArchWorkflow();
			archWf.setName(wfElement.getAttributeValue("name"));
			return archWf;
		}
		
		public ArchAttachment createArchAttachement(Element attElement){
			ArchAttachment archAtt = new ArchAttachment();
			return archAtt;
		}
		
		public ArchUses createArchUses(Element usesElement){
			ArchUses archUses = new ArchUses();
			archUses.setName(usesElement.getAttributeValue("name"));
			archUses.setId(Integer.parseInt((usesElement.getAttributeValue("id"))));
			return archUses;
		}
		
		public ArchProvides createArchProvides(Element providesElement){
			ArchProvides archProvides = new ArchProvides();
			archProvides.setName(providesElement.getAttributeValue("name"));
			archProvides.setId(Integer.parseInt((providesElement.getAttributeValue("id"))));
			return archProvides;
		}
		
		public ArchBody createArchBody(Element bodyElement){
			ArchBody archBody = new ArchBody();
			return archBody;
		}
		
		public ArchComponent createArchComputation(Element element){
			ArchComputation comp = new ArchComputation();
			comp.setName(element.getAttributeValue("name"));
			comp.setId(Integer.parseInt((element.getAttributeValue("id"))));
			return comp;
		}
		
		public ArchComponent createArchConnector(Element element){
			ArchConnector conn = new ArchConnector();
			conn.setName(element.getAttributeValue("name"));
			conn.setId(Integer.parseInt((element.getAttributeValue("id"))));
			return conn;
		}
		
		public ArchComponent createArchPlatform(Element element){
			ArchPlatform pla = new ArchPlatform();
			pla.setName(element.getAttributeValue("name"));
			pla.setId(Integer.parseInt((element.getAttributeValue("id"))));
			return pla;
		}
		
		//adding methods
		public void addArchUses(ArchUses uses){
			this.usesList.add(uses);
		}
		public void addArchProvides(ArchProvides provides){
			this.providesList.add(provides);
		}
		public void addArchAttachment(ArchAttachment binding){
			this.attachmentList.add(binding);
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
	
		@Override
		public String toString() {
		
				String res="";
				res+="\nApplication:\n";
				res+=this.archApplication;
				res+="\nWorkflow:\n";
				res+=this.archWorkflow;
				res+="\nBody:\n";
				res+=this.body;
				res+="\nAttachments:\n";
				for(ArchAttachment att:attachmentList)
					res+="\n"+att.toString();
				return res;
		}
}

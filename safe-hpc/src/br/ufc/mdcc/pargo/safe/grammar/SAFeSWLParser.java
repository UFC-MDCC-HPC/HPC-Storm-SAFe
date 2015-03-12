package br.ufc.mdcc.pargo.safe.grammar;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

import br.ufc.mdcc.pargo.safe.grammar.arch.ArchApplication;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchAttachment;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchBody;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchComponent;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchComputation;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchConnector;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchPlatform;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchProvides;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchUses;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchWorkflow;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchitectureMain;

public class SAFeSWLParser {

	private ArchitectureMain architectureMain;
	 
	
	public SAFeSWLParser() {
		this.architectureMain = new ArchitectureMain();
	}
	
	/**
	 * Read Architecture XML file and turn it into an ArchWorkflow objetc
	 * @param fileName
	 */
	public void readArchXML(String fileName){
		try {
			SAXBuilder builder = new SAXBuilder();
			Document doc = builder.build(new File(fileName));
			
			Element rootArch = doc.getRootElement();
			List<Element> children = rootArch.getChildren();
			//reading root element
			for(Element child:children){
				String elementName = child.getName();
				
				//choosing parent element
				//USES
				if(elementName.equalsIgnoreCase(ArchitectureMain.APPLICATION)){
					ArchApplication archApp = this.architectureMain.createArchApplication(child);
					this.readComponentPorts(child, archApp);
					this.architectureMain.setArchApplication(archApp);
				//PROVIDES
				}else if(elementName.equalsIgnoreCase(ArchitectureMain.WORKFLOW)){
					ArchWorkflow archWorkflow = this.architectureMain.createArchWorkflow(child);
					this.readComponentPorts(child, archWorkflow);
					this.architectureMain.setArchWorkflow(archWorkflow);
				//BODY
				}else if(elementName.equalsIgnoreCase(ArchitectureMain.BODY)){
					ArchBody body = this.architectureMain.createArchBody(child);
					this.readArchBody(child, body);
					this.architectureMain.setArchBody(body);
				//BINDING	
				}else if(elementName.equalsIgnoreCase(ArchitectureMain.ATTACHMENT)){
					ArchAttachment att = this.architectureMain.createArchAttachement(child);
					this.readAttchment(child,att);
					this.architectureMain.addArchAttachment(att);
				}
			}
			
			//XMLOutputter fmt = new XMLOutputter();
			//fmt.output(doc, System.out);
		} catch (JDOMException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	private void readComponentPorts(Element element, ArchComponent comp) {
		 for(Element child:element.getChildren()){
			 
			 if(child.getName().equalsIgnoreCase(ArchitectureMain.USES)){
				 ArchUses uses = this.architectureMain.createArchUses(child);
				 comp.addUsesPort(uses);
				 this.architectureMain.addArchUses(uses);
			 }else if(child.getName().equalsIgnoreCase(ArchitectureMain.PROVIDES)){
				 ArchProvides provides = this.architectureMain.createArchProvides(child);
				comp.addProvidesPort(provides); 
				this.architectureMain.addArchProvides(provides);
			 }
		 }
		
	}
	
	private void readAttchment(Element element, ArchAttachment att) {
		 for(Element child:element.getChildren()){
			 
			 if(child.getName().equalsIgnoreCase(ArchitectureMain.USES)){
				 Integer id = Integer.parseInt(child.getAttributeValue("id"));
				 ArchUses uses = this.architectureMain.getArchUsesById(id);
				 if(uses!=null) att.setUses(uses);
				 
			 }else if(child.getName().equalsIgnoreCase(ArchitectureMain.PROVIDES)){
				 Integer id = Integer.parseInt(child.getAttributeValue("id"));
				 ArchProvides provides = this.architectureMain.getArchProvidesById(id);
				 if(provides!=null) att.setProvides(provides);
			 }
		 }
		
	}

	private void readArchBody(Element element, ArchBody body){
		for(Element child:element.getChildren()){
			if(child.getName().equalsIgnoreCase(ArchitectureMain.COMPUTATION)){
				ArchComputation comp = (ArchComputation)this.architectureMain.createArchComputation(child);
				this.readComponentPorts(child, comp);
				body.addArchComponent(comp);
			}else if(child.getName().equalsIgnoreCase(ArchitectureMain.CONNECTOR)){
				ArchConnector conn = (ArchConnector)this.architectureMain.createArchConnector(child);
				this.readComponentPorts(child, conn);
				body.addArchComponent(conn);
			}else if(child.getName().equalsIgnoreCase(ArchitectureMain.PLATFORM)){
				ArchPlatform plat = (ArchPlatform)this.architectureMain.createArchPlatform(child);
				this.readComponentPorts(child, plat);
				body.addArchComponent(plat);
			}
		}
	}
	
	public ArchitectureMain getArchitectureMain(){
		return this.architectureMain;
	}
	
}

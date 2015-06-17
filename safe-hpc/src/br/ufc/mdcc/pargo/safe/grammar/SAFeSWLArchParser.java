package br.ufc.mdcc.pargo.safe.grammar;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import br.ufc.mdcc.pargo.safe.grammar.arch.ArchAction;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchApplication;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchContract;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchEnvBinding;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchBody;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchComponent;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchComputation;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchConnector;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchMain;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchPlatform;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchProvides;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchRepository;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchTask;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchTaskBinding;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchUses;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchWorkflow;

public class SAFeSWLArchParser {

	private ArchMain architectureMain;

	public SAFeSWLArchParser() {
		this.architectureMain = new ArchMain();
	}

	/**
	 * Read Architecture XML file and turn it into an ArchWorkflow objetc
	 * 
	 * @param fileName
	 */
	public void readArchXML(String fileName) {
		try {
			SAXBuilder builder = new SAXBuilder();
			Document doc = builder.build(new File(fileName));

			Element rootArch = doc.getRootElement();
			List<Element> children = rootArch.getChildren();
			// reading root element
			for (Element child : children) {
				String elementName = child.getName();

				// choosing parent element
				// USES
				if (elementName.equalsIgnoreCase(ArchMain.APPLICATION)) {
					ArchApplication archApp = this.architectureMain
							.createArchApplication(child);
					this.readComponentPorts(child, archApp);
					this.architectureMain.setArchApplication(archApp);
					// PROVIDES
				} else if (elementName.equalsIgnoreCase(ArchMain.WORKFLOW)) {
					ArchWorkflow archWorkflow = this.architectureMain
							.createArchWorkflow(child);
					this.readComponentPorts(child, archWorkflow);
					this.architectureMain.setArchWorkflow(archWorkflow);
					// BODY
				} else if (elementName.equalsIgnoreCase(ArchMain.BODY)) {
					ArchBody body = this.architectureMain.createArchBody(child);
					this.readArchBody(child, body);
					this.architectureMain.setArchBody(body);
					// BINDING
				} else if (elementName.equalsIgnoreCase(ArchMain.ENV_BINDING)) {
					ArchEnvBinding att = this.architectureMain
							.createArchEnvAttachement(child);
					this.readEnvAttchment(child, att);
					this.architectureMain.addArchEnvAttachment(att);
				} else if (elementName.equalsIgnoreCase(ArchMain.TASK_BINDING)) {
					ArchTaskBinding att = this.architectureMain
							.createArchTaskAttachement(child);
					this.readTaskAttchment(child, att);
					this.architectureMain.addArchTaskAttachment(att);
				}
			}

		} catch (JDOMException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	private void readComponentPorts(Element element, ArchComponent comp) {
		for (Element child : element.getChildren()) {
			
			if (child.getName().equalsIgnoreCase(ArchMain.ENV_PORTS)) {

				for (Element port : child.getChildren()) {

					if (port.getName().equalsIgnoreCase(ArchMain.USES)) {

						ArchUses uses = this.architectureMain
								.createArchUses(port);
						comp.addUsesPort(uses);
						List<ArchAction> actions = this.readAction(port);
						uses.setActions(actions);
						this.architectureMain.addArchUses(uses);
					} else if (port.getName().equalsIgnoreCase(
							ArchMain.PROVIDES)) {

						ArchProvides provides = this.architectureMain
								.createArchProvides(port);
						comp.addProvidesPort(provides);
						List<ArchAction> actions = this.readAction(port);
						provides.setActions(actions);
						this.architectureMain.addArchProvides(provides);
					}
				}
				
			} else if (child.getName().equalsIgnoreCase(ArchMain.TASK_PORTS)) {
				
				for (Element port : child.getChildren()) {
					
					if (port.getName().equalsIgnoreCase(ArchMain.TASK_PORT)) {
						
						ArchTask task = this.architectureMain
								.createArchTask(port);
						comp.addTaskPort(task);
						List<ArchAction> actions = this.readAction(port);
						task.setActions(actions);
						this.architectureMain.addArchTask(task);
						
					}
				}
			}
		}

	}
	
	private void readComponentContrac(Element element, ArchComponent comp){
		for (Element child : element.getChildren()){
			if (child.getName().equalsIgnoreCase(ArchMain.CONTRACT)) {
				Long id = Long.parseLong(child.getAttributeValue(ArchMain.att_id));
				String name = child.getAttributeValue(ArchMain.att_name);
				String url = child.getAttributeValue(ArchMain.att_url);
				
				ArchContract contract = new ArchContract();
				contract.setId(id);
				contract.setName(name);
				contract.setUrl(url);
				
				comp.setContract(contract);
				
			}
		}
		
	}

	private List<ArchAction> readAction(Element port){
		List<ArchAction> actions = new ArrayList<ArchAction>();
		for(Element action:port.getChildren()){
			if (action.getName().equalsIgnoreCase(ArchMain.ACTION)){
				 ArchAction archAction = architectureMain.createArchAction(action);
				 actions.add(archAction);
			}
		}
		return actions;
	}
	
	private void readEnvAttchment(Element element, ArchEnvBinding att) {
		for (Element child : element.getChildren()) {
			if (child.getName().equalsIgnoreCase(ArchMain.USES)) {
				
				Integer id = Integer.parseInt(child.getAttributeValue(ArchMain.att_id));
				ArchUses uses = this.architectureMain.getArchUsesById(id);
				
				if (uses != null)
					att.setUses(uses);

			} else if (child.getName().equalsIgnoreCase(ArchMain.PROVIDES)) {
				Integer id = Integer.parseInt(child.getAttributeValue(ArchMain.att_id));
				ArchProvides provides = this.architectureMain
						.getArchProvidesById(id);
				if (provides != null)
					att.setProvides(provides);
			}
		}
	}
	
	private void readTaskAttchment(Element element, ArchTaskBinding att) {
		for (Element child : element.getChildren()) {
			if (child.getName().equalsIgnoreCase(ArchMain.TASK_A)) {
				
				Integer id = Integer.parseInt(child.getAttributeValue(ArchMain.att_id));
				ArchTask tsk_a = this.architectureMain.getArchTaskById(id);
				
				if (tsk_a != null)
					att.setTaskA(tsk_a);

			} else if (child.getName().equalsIgnoreCase(ArchMain.TASK_B)) {
				Integer id = Integer.parseInt(child.getAttributeValue(ArchMain.att_id));
				ArchTask tsk_b = this.architectureMain
						.getArchTaskById(id);
				if (tsk_b != null)
					att.setTaskB(tsk_b);
			}
		}
	}

	private void readArchBody(Element element, ArchBody body) {
		for (Element child : element.getChildren()) {
			if (child.getName().equalsIgnoreCase(ArchMain.COMPUTATION)) {
				ArchComputation comp = (ArchComputation) this.architectureMain
						.createArchComputation(child);
				this.readComponentPorts(child, comp);
				this.readComponentContrac(child, comp);
				body.addArchComponent(comp);
			} else if (child.getName().equalsIgnoreCase(ArchMain.CONNECTOR)) {
				ArchConnector conn = (ArchConnector) this.architectureMain
						.createArchConnector(child);
				this.readComponentPorts(child, conn);
				this.readComponentContrac(child, conn);
				body.addArchComponent(conn);
			} else if (child.getName().equalsIgnoreCase(ArchMain.PLATFORM)) {
				ArchPlatform plat = (ArchPlatform) this.architectureMain
						.createArchPlatform(child);
				this.readComponentPorts(child, plat);
				this.readComponentContrac(child, plat);
				body.addArchComponent(plat);
			} else if (child.getName().equalsIgnoreCase(ArchMain.REPOSITORY)) {
				ArchRepository rep = (ArchRepository) this.architectureMain
						.createArchRepository(child);
				this.readComponentPorts(child, rep);
				this.readComponentContrac(child, rep);
				body.addArchComponent(rep);
			}

		}
	}

	public ArchMain getArchitectureMain() {
		return this.architectureMain;
	}

}

package br.ufc.mdcc.pargo.safe.grammar;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import br.ufc.mdcc.pargo.safe.grammar.arch.ArchApplication;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchAttachment;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchBody;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchComponent;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchComputation;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchConnector;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchMain;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchPlatform;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchProvides;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchRepository;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchTask;
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
				} else if (elementName.equalsIgnoreCase(ArchMain.ATTACHMENT)) {
					ArchAttachment att = this.architectureMain
							.createArchAttachement();
					this.readAttchment(child, att);
					this.architectureMain.addArchAttachment(att);
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

				for (Element child2 : child.getChildren()) {

					if (child2.getName().equalsIgnoreCase(ArchMain.USES)) {

						ArchUses uses = this.architectureMain
								.createArchUses(child2);
						comp.addUsesPort(uses);
						this.architectureMain.addArchUses(uses);
					} else if (child2.getName().equalsIgnoreCase(
							ArchMain.PROVIDES)) {

						ArchProvides provides = this.architectureMain
								.createArchProvides(child2);
						comp.addProvidesPort(provides);
						this.architectureMain.addArchProvides(provides);
					}
				}

			} else if (child.getName().equalsIgnoreCase(ArchMain.TASK_PORTS)) {

				for (Element child2 : child.getChildren()) {
					if (child2.getName().equalsIgnoreCase(ArchMain.TASK_PORT)) {

						ArchTask task = this.architectureMain
								.createArchTask(child2);
						comp.addTaskPort(task);
						this.architectureMain.addArchTask(task);
					}
				}
			}
		}

	}

	private void readAttchment(Element element, ArchAttachment att) {
		for (Element child : element.getChildren()) {
			
			System.out.println(child.getName()+ " = " + ArchMain.USES + "-" +ArchMain.PROVIDES);
			
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

	private void readArchBody(Element element, ArchBody body) {
		for (Element child : element.getChildren()) {
			if (child.getName().equalsIgnoreCase(ArchMain.COMPUTATION)) {
				ArchComputation comp = (ArchComputation) this.architectureMain
						.createArchComputation(child);
				this.readComponentPorts(child, comp);
				body.addArchComponent(comp);
			} else if (child.getName().equalsIgnoreCase(ArchMain.CONNECTOR)) {
				ArchConnector conn = (ArchConnector) this.architectureMain
						.createArchConnector(child);
				this.readComponentPorts(child, conn);
				body.addArchComponent(conn);
			} else if (child.getName().equalsIgnoreCase(ArchMain.PLATFORM)) {
				ArchPlatform plat = (ArchPlatform) this.architectureMain
						.createArchPlatform(child);
				this.readComponentPorts(child, plat);
				body.addArchComponent(plat);
			} else if (child.getName().equalsIgnoreCase(ArchMain.REPOSITORY)) {
				ArchRepository rep = (ArchRepository) this.architectureMain
						.createArchRepository(child);
				this.readComponentPorts(child, rep);
				body.addArchComponent(rep);
			}

		}
	}

	public ArchMain getArchitectureMain() {
		return this.architectureMain;
	}

}

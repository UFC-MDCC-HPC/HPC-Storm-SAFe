package br.ufc.mdcc.pargo.safe.grammar;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import br.ufc.mdcc.pargo.safe.grammar.arch.ArchAction;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchApplication;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchBody;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchComponent;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchComputation;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchConnector;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchContract;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchEnvBinding;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchMain;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchPlatform;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchProvides;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchRepository;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchTask;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchTaskBinding;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchUses;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchWorkflow;
import br.ufc.mdcc.pargo.safe.grammar.arch.contract.ArchComponentFunctorApplicationType;
import br.ufc.mdcc.pargo.safe.grammar.arch.contract.ArchContextArgumentType;
import br.ufc.mdcc.pargo.safe.grammar.arch.contract.ArchFacetAddressType;
import br.ufc.mdcc.pargo.safe.grammar.arch.contract.ArchInstanceType;
import br.ufc.mdcc.pargo.safe.grammar.arch.contract.ArchUnitMappingType;

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
			this.architectureMain.setApplicationName(rootArch.getAttributeValue(ArchMain.APPLICATION_NAME));
			
			List<Element> children = rootArch.getChildren();
			// reading root element
			for (Element child : children) {
				String elementName = child.getName();

				if (elementName.equalsIgnoreCase(ArchMain.APPLICATION)) {
					ArchApplication archApp = this.architectureMain
							.createArchApplication(child);
					this.readComponentPorts(child, archApp);
					this.architectureMain.setArchApplication(archApp); 
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
			if (child.getName().equalsIgnoreCase(ArchMain.USES)) {
				ArchUses uses = this.architectureMain
						.createArchUses(child);
				comp.addUsesPort(uses);
				this.architectureMain.addArchUses(uses);
			}else if (child.getName().equalsIgnoreCase(
					ArchMain.PROVIDES)){
				ArchProvides provides = this.architectureMain
						.createArchProvides(child);
				comp.addProvidesPort(provides);
				this.architectureMain.addArchProvides(provides);
			}else if (child.getName().equalsIgnoreCase(ArchMain.TASK_PORT)){
				ArchTask task = this.architectureMain
						.createArchTask(child);
				comp.addTaskPort(task);
				this.architectureMain.addArchTask(task);
			}else if(child.getName().equalsIgnoreCase(
					ArchMain.CONTRACT)){
				ArchContract contract = this.createComponentContract(child);
				comp.setContract(contract);
				this.architectureMain.addArchContract(contract);
			}
		}
	}
	
	private ArchContract createComponentContract(Element element){
		ArchContract contract = new ArchContract();
		contract.setId(Integer.parseInt(element.getAttributeValue(ArchMain.att_id)));
		contract.setName(element.getAttributeValue(ArchMain.att_name));
		for (Element child : element.getChildren()) { //exclusive OR
			if(child.getName().equalsIgnoreCase(
					ArchMain.URI)){
				contract.setUri(child.getText());
			}else if(child.getName().equalsIgnoreCase(ArchMain.INSTANTIATION_TYPE)){
				ArchInstanceType instanceType = new ArchInstanceType();
				instanceType.setInstanceRef(child.getAttributeValue(ArchMain.att_instance_ref));
				for (Element grandChildren : child.getChildren()){
					 if(grandChildren.getName().equalsIgnoreCase(
								ArchMain.CONTEXTUAL_TYPE)){
						 ArchComponentFunctorApplicationType contextType = this.createContextualType(grandChildren);
						 instanceType.setComponentFunctorApplication(contextType);
					 }else if(grandChildren.getName().equalsIgnoreCase(
								ArchMain.UNIT_MAPPING)){
						ArchUnitMappingType unitMapping = this.createUnitMappingType(grandChildren);
						instanceType.addUnitMappingType(unitMapping);
					 }else if(grandChildren.getName().equalsIgnoreCase(
								ArchMain.FACET_ADDRESS)){
						 ArchFacetAddressType facet = this.createFacetAddressType(grandChildren);
						 instanceType.addFacetAddressType(facet);
					 }
				}
				contract.setInstanceType(instanceType);
			}
					
			
		}
		
		return contract; 
		
	}

	private ArchComponentFunctorApplicationType createContextualType(Element e){
		
		ArchComponentFunctorApplicationType compFunctor = new ArchComponentFunctorApplicationType();
		compFunctor.setComponentRef(e.getAttributeValue(ArchMain.att_comp_ref));
		for (Element child : e.getChildren()){
			if(child.getName().equalsIgnoreCase(ArchMain.ARGUMENT)){
				ArchContextArgumentType argument = new ArchContextArgumentType();
				/*BEGIN RECURSION*/
				for (Element gchild : child.getChildren()){
					if(gchild.getName().equalsIgnoreCase(ArchMain.VARIABLE)){
						argument.setVariable(gchild.getValue());
					}else if(gchild.getName().equalsIgnoreCase(ArchMain.TYPE)){
						argument.setType(this.createContextualType(gchild));
					}
				}
				/*END RECURSION*/
				argument.setParameterId(child.getAttributeValue(ArchMain.att_parameter_id));
				compFunctor.addContextArgument(argument);
			}
		}
		
		return compFunctor;
	}
	
	 
	
	private ArchUnitMappingType createUnitMappingType(Element e){
		ArchUnitMappingType unit = new ArchUnitMappingType();
		unit.setUnitId(Integer.parseInt(e.getAttributeValue(ArchMain.att_unit_id)));
		unit.setUnitIndex(Integer.parseInt(e.getAttributeValue(ArchMain.att_unit_index)));
		for (Element child : e.getChildren()){
			if(child.getName().equalsIgnoreCase(ArchMain.NODE)){
				unit.addNode(Integer.parseInt(child.getValue()));
			}
		}
		return unit;
	}
	private ArchFacetAddressType createFacetAddressType(Element e){
		ArchFacetAddressType facet = new ArchFacetAddressType();
		facet.setAddress(e.getAttributeValue(ArchMain.att_address));
		facet.setPort(Integer.parseInt(e.getAttributeValue(ArchMain.att_port)));
		return facet;
	}
	
	/*private ArchAction createArchAction(Element e){
		ArchAction action = new ArchAction();
		action.setId(Integer.parseInt(e.getAttributeValue(ArchMain.att_id)));
		action.setName(e.getAttributeValue(ArchMain.att_name));
		return action;
	}*/
	
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
			if (child.getName().equalsIgnoreCase(ArchMain.TASK_LEFT_PEER)) {
				
				Integer id = Integer.parseInt(child.getAttributeValue(ArchMain.att_id));
				ArchTask tsk_a = this.architectureMain.getArchTaskById(id);
				
				if (tsk_a != null)
					att.setTaskA(tsk_a);

			} else if (child.getName().equalsIgnoreCase(ArchMain.TASK_RIGHT_PEER)) {
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

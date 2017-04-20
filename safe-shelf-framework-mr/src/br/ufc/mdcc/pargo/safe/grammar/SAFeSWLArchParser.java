package br.ufc.mdcc.pargo.safe.grammar;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import br.ufc.mdcc.pargo.safe.grammar.arch.ArchAction;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchActionPort;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchApplication;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchBindingAction;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchBindingService;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchComponent;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchContract;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchPeer;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchProviderPort;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchSolution;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchUserPort;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchWorkflow;
import br.ufc.mdcc.pargo.safe.grammar.arch.SAFeOrquestrationArchitecture;
import br.ufc.mdcc.pargo.safe.grammar.arch.contract.ArchComponentFunctorApplicationType;
import br.ufc.mdcc.pargo.safe.grammar.arch.contract.ArchContextArgumentType;
import br.ufc.mdcc.pargo.safe.grammar.arch.contract.ArchFacetAddressType;
import br.ufc.mdcc.pargo.safe.grammar.arch.contract.ArchInstanceType;
import br.ufc.mdcc.pargo.safe.grammar.arch.contract.ArchUnitMappingType;

public class SAFeSWLArchParser implements ISAFeSWLArcherParser{

	private SAFeOrquestrationArchitecture architectureMain;

	public SAFeSWLArchParser(String fileName) {
		this.architectureMain = new SAFeOrquestrationArchitecture();
		this.readArchXML(fileName);
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

				if (elementName.equalsIgnoreCase(SAFeOrquestrationArchitecture.APPLICATION)) {
					ArchApplication archApp = this.architectureMain
							.createArchApplication();
					this.readComponentPorts(child, archApp);
					this.architectureMain.setArchApplication(archApp);
				} else if (elementName.equalsIgnoreCase(SAFeOrquestrationArchitecture.WORKFLOW)) {
					ArchWorkflow archWorkflow = this.architectureMain
							.createArchWorkflow();
					this.readComponentPorts(child, archWorkflow);
					this.architectureMain.setArchWorkflow(archWorkflow);
				} else if (elementName.equalsIgnoreCase(SAFeOrquestrationArchitecture.SOLUTION)) {
					ArchSolution archSolution = this.architectureMain.createArchSolution();
					this.readArchSolution(child, archSolution);
					this.architectureMain.setArchSolution(archSolution);
				} else if (elementName.equalsIgnoreCase(SAFeOrquestrationArchitecture.SERVICE_BINDING)) {
					ArchBindingService bindingService = this.architectureMain.createArchBindingService();
					this.readServiceBinding(child, bindingService);
					this.architectureMain.addBindingService(bindingService);
				} else if (elementName.equalsIgnoreCase(SAFeOrquestrationArchitecture.ACTION_BINDING)) {
					 
					ArchBindingAction archBidingAction = this.architectureMain.createArchBindingAction();
					this.readActionBinding(child, archBidingAction);
					this.architectureMain.setBindingAction(archBidingAction);
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
			if (child.getName().equalsIgnoreCase(SAFeOrquestrationArchitecture.USER_PORT)) {
				ArchUserPort user = this.architectureMain
						.createArchUserPort(child);
				user.setIdComponent(comp.getIdComponent());
				comp.addUserPort(user);
				this.architectureMain.putUserPort(comp.getIdComponent(), user.getIdPort(), user);
				
			}else if (child.getName().equalsIgnoreCase(
					SAFeOrquestrationArchitecture.PROVIDER_PORT)){
				ArchProviderPort provider = this.architectureMain
						.createArchProviderPort(child);
				provider.setIdComponent(comp.getIdComponent());
				comp.addProviderPort(provider);
				this.architectureMain.putProviderPort(comp.getIdComponent(), provider.getIdPort(), provider);
				
			}else if (child.getName().equalsIgnoreCase(SAFeOrquestrationArchitecture.ACTION_PORT)){
				ArchActionPort action = this.architectureMain.createArchActionPort(child);
				action.setIdComponent(comp.getIdComponent());
				comp.addActionPort(action);
				this.architectureMain.putActionPort(comp.getIdComponent(), action.getIdPort(), action);
			}else if(child.getName().equalsIgnoreCase(
					SAFeOrquestrationArchitecture.CONTRACT)){
				ArchContract contract = this.createComponentContract(child);
				comp.setContract(contract);
			}
		}
	}
	
	/*BEGIN CONTRACT METHODS*/
	private ArchContract createComponentContract(Element element){
		ArchContract contract = new ArchContract();
		contract.setName(element.getAttributeValue(SAFeOrquestrationArchitecture.att_name));
		for (Element child : element.getChildren()) { //exclusive OR
			if(child.getName().equalsIgnoreCase(
					SAFeOrquestrationArchitecture.URI)){
				contract.setUri(child.getText());
			}else if(child.getName().equalsIgnoreCase(SAFeOrquestrationArchitecture.INSTANTIATION_TYPE)){
				ArchInstanceType instanceType = new ArchInstanceType();
				instanceType.setInstanceRef(child.getAttributeValue(SAFeOrquestrationArchitecture.att_instance_ref));
				for (Element grandChildren : child.getChildren()){
					 if(grandChildren.getName().equalsIgnoreCase(
								SAFeOrquestrationArchitecture.CONTEXTUAL_TYPE)){
						 ArchComponentFunctorApplicationType contextType = this.createContextualType(grandChildren);
						 instanceType.setComponentFunctorApplication(contextType);
					 }else if(grandChildren.getName().equalsIgnoreCase(
								SAFeOrquestrationArchitecture.UNIT_MAPPING)){
						ArchUnitMappingType unitMapping = this.createUnitMappingType(grandChildren);
						instanceType.addUnitMappingType(unitMapping);
					 }else if(grandChildren.getName().equalsIgnoreCase(
								SAFeOrquestrationArchitecture.FACET_ADDRESS)){
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
		compFunctor.setComponentRef(e.getAttributeValue(SAFeOrquestrationArchitecture.att_comp_ref));
		for (Element child : e.getChildren()){
			if(child.getName().equalsIgnoreCase(SAFeOrquestrationArchitecture.ARGUMENT)){
				ArchContextArgumentType argument = new ArchContextArgumentType();
				/*BEGIN RECURSION*/
				for (Element gchild : child.getChildren()){
					if(gchild.getName().equalsIgnoreCase(SAFeOrquestrationArchitecture.VARIABLE)){
						argument.setVariable(gchild.getValue());
					}else if(gchild.getName().equalsIgnoreCase(SAFeOrquestrationArchitecture.TYPE)){
						argument.setType(this.createContextualType(gchild));
					}
				}
				/*END RECURSION*/
				argument.setParameterId(child.getAttributeValue(SAFeOrquestrationArchitecture.att_parameter_id));
				compFunctor.addContextArgument(argument);
			}
		}
		
		return compFunctor;
	}
	
	 
	
	private ArchUnitMappingType createUnitMappingType(Element e){
		ArchUnitMappingType unit = new ArchUnitMappingType();
		unit.setUnitId(Integer.parseInt(e.getAttributeValue(SAFeOrquestrationArchitecture.att_unit_id)));
		unit.setUnitIndex(Integer.parseInt(e.getAttributeValue(SAFeOrquestrationArchitecture.att_unit_index)));
		for (Element child : e.getChildren()){
			if(child.getName().equalsIgnoreCase(SAFeOrquestrationArchitecture.NODE)){
				unit.addNode(Integer.parseInt(child.getValue()));
			}
		}
		return unit;
	}
	private ArchFacetAddressType createFacetAddressType(Element e){
		ArchFacetAddressType facet = new ArchFacetAddressType();
		facet.setAddress(e.getAttributeValue(SAFeOrquestrationArchitecture.att_address));
		facet.setPort(Integer.parseInt(e.getAttributeValue(SAFeOrquestrationArchitecture.att_port)));
		return facet;
	}
	/*END CONTRACT METHODS*/
	 
	
	private void readServiceBinding(Element element, ArchBindingService att) {
		for (Element child : element.getChildren()) {
			String idComponent = child.getAttributeValue(SAFeOrquestrationArchitecture.att_id_component);
			String idPort = child.getAttributeValue(SAFeOrquestrationArchitecture.att_id_port); 
			if (child.getName().equalsIgnoreCase(SAFeOrquestrationArchitecture.USER_PORT)) {
				
				ArchUserPort uses = this.architectureMain.getUserPort(idComponent, idPort);
				
				if (uses != null)
					att.setUserPort(uses);

			} else if (child.getName().equalsIgnoreCase(SAFeOrquestrationArchitecture.PROVIDER_PORT)) {
				
				ArchProviderPort provides = this.architectureMain.getProviderPort(idComponent, idPort);
				if (provides != null)
					att.setProviderPort(provides);
			}
		}
	}
	
	private void readActionBinding(Element element, ArchBindingAction att) {
		for (Element child : element.getChildren()) {
			if (child.getName().equalsIgnoreCase(SAFeOrquestrationArchitecture.PEER)) {
				String idComponent = child.getAttributeValue(SAFeOrquestrationArchitecture.att_id_component);
				String idPort = child.getAttributeValue(SAFeOrquestrationArchitecture.att_id_port); 
				ArchPeer peer = new ArchPeer();
				peer.setIdComponent(idComponent);
				peer.setIdPort(idPort);
				att.addArchPeer(peer);
			}
		}
	}

	private void readArchSolution(Element element, ArchSolution solution) {
		for (Element child : element.getChildren()) {
			if (child.getName().equalsIgnoreCase(SAFeOrquestrationArchitecture.COMPUTATION)) {
				ArchComponent comp = this.architectureMain
						.createArchComponent(child, SAFeOrquestrationArchitecture.COMPUTATION);
				this.readComponentPorts(child, comp);
				solution.addArchComponent(comp);
			} else if (child.getName().equalsIgnoreCase(SAFeOrquestrationArchitecture.CONNECTOR)) {
				ArchComponent comp = this.architectureMain
						.createArchComponent(child, SAFeOrquestrationArchitecture.CONNECTOR);
				this.readComponentPorts(child, comp);
				solution.addArchComponent(comp);
			} else if (child.getName().equalsIgnoreCase(SAFeOrquestrationArchitecture.PLATFORM)) {
				ArchComponent comp = this.architectureMain
						.createArchComponent(child, SAFeOrquestrationArchitecture.PLATFORM);
				this.readComponentPorts(child, comp);
				solution.addArchComponent(comp);
			} else if (child.getName().equalsIgnoreCase(SAFeOrquestrationArchitecture.REPOSITORY)) {
				ArchComponent comp = this.architectureMain
						.createArchComponent(child, SAFeOrquestrationArchitecture.REPOSITORY);
				this.readComponentPorts(child, comp);
				solution.addArchComponent(comp);
			}

		}
	}

	public SAFeOrquestrationArchitecture getArchitecture() {
		return this.architectureMain;
	}

	@Override
	public ArchComponent getArchComponentByID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArchAction getArchActionId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getProvidesPortNameByUsesPortName(String usesPortName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPartnerBByPartnerAName(String partnerAName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isThereEnvironmentConnection(String uses, String provides) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isThereTaskConnection(String partnerA, String partnerB) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArchApplication getArchApplication() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArchWorkflow getArchWorkflow() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArchComponent> getComponents() {
		// TODO Auto-generated method stub
		return null;
	}

	
}

package br.ufc.mdcc.pargo.safe.v6.impl;

import java.util.List;

import br.ufc.mdcc.pargo.safe.grammar.ISAFeSWLArcherParser;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchActionPort;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchBindingAction;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchBindingService;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchComponent;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchPeer;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchProviderPort;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchUserPort;
import br.ufc.mdcc.pargo.safe.v6.ISAFeBuilderServicePort;
import br.ufc.mdcc.pargo.safe.v6.ISAFeComponent;
import br.ufc.mdcc.pargo.safe.v6.ISAFePort;
import br.ufc.mdcc.pargo.safe.v6.ISAFeServices;

public class Architecture2SAFeComponentUtil {

	public static ISAFeComponent archApplication2SAFeComponent(
			ISAFeSWLArcherParser archerParser, SAFeApplication application) {
		ISAFeServices services = application.getServices();
		for (ArchUserPort user : archerParser.getArchitecture()
				.getArchApplication().getUsesPortList()) {
			services.registerUsesPort(user.getIdPort());
		}
		for (ArchProviderPort provider : archerParser.getArchitecture()
				.getArchApplication().getProviderPortList()) {
			ISAFePort port = new SAFePort(application, provider.getIdPort());
			services.addProvidesPort(port);
		}

		//go port uses
		services.registerUsesPort("go");
		return application;
	}

	public static ISAFeComponent archWorkflow2SAFeComponent(
			ISAFeSWLArcherParser archerParser, SAFeWorkflow workflow, SAFeFramework framework) {

		ISAFeServices services = workflow.getServices();
		for (ArchUserPort user : archerParser.getArchitecture()
				.getArchWorkflow().getUsesPortList()) {
			services.registerUsesPort(user.getIdPort());
		}
		for (ArchProviderPort provider : archerParser.getArchitecture()
				.getArchWorkflow().getProviderPortList()) {
			ISAFePort port = new SAFePort(workflow, provider.getIdPort());
			services.addProvidesPort(port);
		}

		for (ArchActionPort actionPort : archerParser.getArchitecture()
				.getArchWorkflow().getActionPortList()) {
			services.registerActionPort(actionPort.getIdPort());
		}
		
		//go port provides
		SAFeGoPort goPort = new SAFeGoPort(workflow, "go");
		services.addProvidesPort(goPort);
		//binding
		framework.connectService("application", "go", "workflow", "go");
		
		return workflow;
	}

	public static void archComponent2SAFeComponentList(
			ISAFeSWLArcherParser archerParser, List<ISAFeComponent> components, SAFeWorkflow workflow, SAFeFramework framework) {

		for (ArchComponent component : archerParser.getArchitecture()
				.getArchSolution().getComponents()) {
			ISAFeComponent safeComponent = new SAFeComponent();
			ISAFeServices services = new SAFeServices();
			safeComponent.setServices(services);
			safeComponent.setComponentId(component.getIdComponent());
			for (ArchUserPort user : component.getUsesPortList()) {
				services.registerUsesPort(user.getIdPort());
			}
			for (ArchProviderPort provider : component.getProviderPortList()) {
				ISAFePort port = new SAFePort(safeComponent,
						provider.getIdPort());
				services.addProvidesPort(port);
			}

			
			for (ArchActionPort actionPort : component.getActionPortList()) {
				ISAFePort port = new SAFeTaskPort(safeComponent,
						actionPort.getIdPort());
				services.addActionPort(port);

			}
			
			//life-cycle for workflow
			workflow.getServices().registerActionPort("life-cycle-"+safeComponent.getComponentId());
			
			//life-cycle for each component
			ISAFePort lf_port = new SAFeLifeCycle(safeComponent, "life-cycle");
			services.addActionPort(lf_port);
			
			//life-cycle binding
			framework.connectAction(workflow.getComponentId(), "life-cycle-"+safeComponent.getComponentId(), safeComponent.getComponentId(), lf_port.getId());
			
			components.add(safeComponent);
		}
	}

	public static void archServiceConnection2SAFeServiceConnectionList(
			ISAFeSWLArcherParser archerParser,
			ISAFeBuilderServicePort framework) {
		for(ArchBindingService bs: archerParser.getArchitecture().getBindingService()){
			String userId = bs.getUserPort().getIdComponent();
			String userPortId = bs.getUserPort().getIdPort();
			String providerId = bs.getProviderPort().getIdComponent();
			String providerPortId = bs.getProviderPort().getIdPort();
			framework.connectService(userId, userPortId, providerId, providerPortId);
		}
		
	}

	public static void archActionConnection2SAFeActionConnectionList(
			ISAFeSWLArcherParser archerParser,
			ISAFeBuilderServicePort framework) {
		String masterId = null;
		String masterActionId = null;
		for(ArchBindingAction ba:archerParser.getArchitecture().getBindingAction()){
			for(ArchPeer peer:ba.getPeersList()){
				if(peer.getIdComponent().equals("workflow")){
					masterId = peer.getIdComponent();
					masterActionId = peer.getIdPort();
				}else{
					String slaveId = peer.getIdComponent();
					String slaveActionId = peer.getIdPort();
					framework.connectAction(masterId, masterActionId, slaveId, slaveActionId);
				}
			
			}
		}

	}
}

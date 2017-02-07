package br.ufc.mdcc.pargo.safe.framework.port.dflt;

import br.ufc.mdcc.pargo.safe.framework.core.IHShelfCore;
import br.ufc.mdcc.pargo.safe.framework.fcore.client.ShelfCoreClient;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfProvidesPort;
import br.ufc.mdcc.pargo.safe.framework.util.HShelfConsoleLogger;
import br.ufc.mdcc.pargo.safe.framework.workflow.HShelfWorkflowSession;

/**
 * Core communication class
 * @author jefferson
 *
 */
public class HShelfWorkflowServicesProvidesPort extends HShelfProvidesPort implements IHShelfCore{

	private ShelfCoreClient coreClient = new ShelfCoreClient();
	
	public Object openWorkflowSession(String safeSWLCode){
		HShelfConsoleLogger.write("CORE SERVICES: open workflow session");
		return new HShelfWorkflowSession();
	}
	
	public void registerContract(String contract){
		HShelfConsoleLogger.write("CORE SERVICES: register contract");
	}
	
	public void closeWorkflowSession(String session){
		HShelfConsoleLogger.write("CORE SERVICES: close workflow session");
	}

	@Override
	public String resolve(String contract) {
		HShelfConsoleLogger.write("CORE SERVICES: resolve");
		String out = coreClient.resolve(contract);
		return out;
	}

	@Override
	public String deploy(String safeSWLCode, String componentReference) {
		HShelfConsoleLogger.write("CORE SERVICES: deploy");
		return null;
	}

	@Override
	public String instantiate(String wsession, String reference) {
		HShelfConsoleLogger.write("CORE SERVICES: instantiate");
		return "TESTE-INSTANTIATE";
	}

	@Override
	public void release(String ID) {
		HShelfConsoleLogger.write("CORE SERVICES: release ");
		
	}

	@Override
	public String listParameter(String contract) {
		HShelfConsoleLogger.write("CORE SERVICES: listaParameter ");
		String out = coreClient.listParameter(contract);
		return out;
	}

	@Override
	public void setComponentList(String componentList) {
		HShelfConsoleLogger.write("CORE SERVICES: setComponentList ");
		coreClient.setComponentList(componentList);
		
	}
	

}

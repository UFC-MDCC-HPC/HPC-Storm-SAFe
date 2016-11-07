package br.ufc.mdcc.pargo.safe.framework.port.dflt;

import br.ufc.mdcc.pargo.safe.framework.core.IHShelfCore;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfProvidesPort;
import br.ufc.mdcc.pargo.safe.framework.util.HShelfConsoleLogger;
import br.ufc.mdcc.pargo.safe.framework.workflow.HShelfWorkflowSession;

public class HShelfWorkflowServicesProvidesPort extends HShelfProvidesPort implements IHShelfCore{

	public Object openWorkflowSession(String safeSWLCode){
		HShelfConsoleLogger.write("CORE SERVICES: open workflow session");
		return new HShelfWorkflowSession();
	}
	
	public void registerContract(String contract){
		HShelfConsoleLogger.write("CORE SERVICES: register contract");
	}
	
	public void closeWorkflowSession(Object session){
		HShelfConsoleLogger.write("CORE SERVICES: close workflow session");
	}

	@Override
	public Object resolve(String contract) {
		HShelfConsoleLogger.write("CORE SERVICES: resolve");
		return null;
	}

	@Override
	public Object deploy(String safeSWLCode, Object componentReference) {
		HShelfConsoleLogger.write("CORE SERVICES: deploy");
		return null;
	}

	@Override
	public String instantiate(Object wsession, Object reference) {
		HShelfConsoleLogger.write("CORE SERVICES: instantiate");
		return "TESTE-INSTANTIATE";
	}

	@Override
	public void release(String ID) {
		HShelfConsoleLogger.write("CORE SERVICES: release ");
		
	}

	@Override
	public Object listParameter(String contract) {
		HShelfConsoleLogger.write("CORE SERVICES: listaParameter ");
		return null;
	}

	@Override
	public void setComponentList(Object componentList) {
		HShelfConsoleLogger.write("CORE SERVICES: setComponentList ");
		
	}
	

}

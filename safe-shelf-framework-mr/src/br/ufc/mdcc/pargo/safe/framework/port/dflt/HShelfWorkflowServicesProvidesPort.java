package br.ufc.mdcc.pargo.safe.framework.port.dflt;

import br.ufc.mdcc.pargo.safe.framework.core.IHShelfCore;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfProvidesPort;
import br.ufc.mdcc.pargo.safe.framework.util.HShelfConsoleLogger;

public class HShelfWorkflowServicesProvidesPort extends HShelfProvidesPort implements IHShelfCore{

	public Object openWorkflowSession(String safeSWLCode){
		HShelfConsoleLogger.write("CORE SERVICES: oper workflow session");
		return null;
	}
	
	public void registerContract(String contract){
		HShelfConsoleLogger.write("CORE SERVICES: register contract");
	}
	
	public void closeWorkflowSession(Object session){
		HShelfConsoleLogger.write("CORE SERVICES: close workflow session");
	}

	@Override
	public String resolve(String contract) {
		HShelfConsoleLogger.write("CORE SERVICES: resolve");
		return "TESTE-RESOLVE";
	}

	@Override
	public String deploy(String safeSWLCode, String componentReference,
			Object candidate) {
		HShelfConsoleLogger.write("CORE SERVICES: deploy");
		return "TESTE-DEPLOY";
	}

	@Override
	public String instantiate(String arch_desc_xml, String arch_ref) {
		HShelfConsoleLogger.write("CORE SERVICES: instantiate");
		return "TESTE-INSTANTIATE";
	}

	@Override
	public void release(String ID) {
		HShelfConsoleLogger.write("CORE SERVICES: release ");
		
	}

	@Override
	public String parameterList(String contract) {
		HShelfConsoleLogger.write("CORE SERVICES: parameterList ");
		return "TESTE-PARAMETER-LIST";
	}
}

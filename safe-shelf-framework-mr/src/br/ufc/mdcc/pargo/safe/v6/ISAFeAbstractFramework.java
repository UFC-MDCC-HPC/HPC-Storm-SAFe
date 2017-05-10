package br.ufc.mdcc.pargo.safe.v6;

import java.util.List;

import br.ufc.mdcc.pargo.safe.v6.impl.SAFeApplication;

public interface ISAFeAbstractFramework {

	ISAFeServices getServices();
	void loadArchitecturalLanguageFile(String pathToFile);
	void loadOrchestrationLanguageFile(String pathToFile);
	void setApplication(SAFeApplication safeApplication);
	ISAFePort lookUpServicePort(String usesId, String portId);
	List<ISAFeTaskPort> lookUpActionPort(String masterId, String portId);
}

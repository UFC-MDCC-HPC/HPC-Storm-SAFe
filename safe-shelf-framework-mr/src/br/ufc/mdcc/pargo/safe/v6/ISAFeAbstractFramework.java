package br.ufc.mdcc.pargo.safe.v6;

import br.ufc.mdcc.pargo.safe.v6.impl.SAFeApplication;

public interface ISAFeAbstractFramework {

	ISAFeServices getServices();
	void loadArchitecturalLanguageFile(String pathToFile);
	void loadOrchestrationLanguageFile(String pathToFile);
	void setApplication(SAFeApplication safeApplication);
}

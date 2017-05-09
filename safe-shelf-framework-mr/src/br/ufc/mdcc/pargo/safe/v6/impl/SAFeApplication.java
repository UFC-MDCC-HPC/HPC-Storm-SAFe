package br.ufc.mdcc.pargo.safe.v6.impl;

import br.ufc.mdcc.pargo.safe.v6.ISAFeAbstractFramework;

public class SAFeApplication extends SAFeGenericComponent{

	ISAFeAbstractFramework framework;
	
	public SAFeApplication() {
		this.framework = new SAFeFramework(this);
	}
	
	public void loadArchitecturalLanguageFile(String pathToFile) {
		this.framework.loadArchitecturalLanguageFile(pathToFile);
	}

	public void loadOrchestrationLanguageFile(String pathToFile) {
		this.framework.loadOrchestrationLanguageFile(pathToFile);
		
	}
}

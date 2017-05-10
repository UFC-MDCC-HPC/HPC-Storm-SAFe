package br.ufc.mdcc.pargo.safe.v6.impl;

import br.ufc.mdcc.pargo.safe.v6.ISAFeAbstractFramework;

public class SAFeApplication extends SAFeComponent{

	protected ISAFeAbstractFramework safeFramework;
	
	public SAFeApplication() {
		this.safeFramework = new SAFeFramework(this);
	}
	
/*	public void loadArchitecturalLanguageFile(String pathToFile) {
		this.safeFramework.loadArchitecturalLanguageFile(pathToFile);
	}

	public void loadOrchestrationLanguageFile(String pathToFile) {
		this.safeFramework.loadOrchestrationLanguageFile(pathToFile);
		
	}*/
}

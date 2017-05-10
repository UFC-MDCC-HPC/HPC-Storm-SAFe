package br.ufc.mdcc.pargo.safe.v6.test;

import br.ufc.mdcc.pargo.safe.framework.util.SAFeConsoleLogger;
import br.ufc.mdcc.pargo.safe.v6.impl.SAFeApplication;
import br.ufc.mdcc.pargo.safe.v6.impl.SAFeGoPort;

public class TestApplication extends SAFeApplication{

	public static String fileNameaARCHXML = "arch-v6.xml";
	public static String fileNameaORCHXML = "flow-v6.xml";
	
	public TestApplication() {
		//SAFeConsoleLogger.ON = false;
		String fileNameA = "src/br/ufc/mdcc/pargo/safe/grammar/xml/"+fileNameaARCHXML;
		String fileNameB = "src/br/ufc/mdcc/pargo/safe/grammar/xml/"+fileNameaORCHXML;
		this.safeFramework.loadArchitecturalLanguageFile(fileNameA);
		this.safeFramework.loadOrchestrationLanguageFile(fileNameB);
		
		SAFeGoPort go = (SAFeGoPort)this.safeFramework.lookUpServicePort("application", "go");
		go.go();
		
		
	}
	
	public static void main(String[] args) {
		new TestApplication();
	}
}

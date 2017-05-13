package br.ufc.mdcc.pargo.safe.grammar.xml.examples.simple;

import br.ufc.mdcc.pargo.safe.v6.impl.SAFeApplication;
import br.ufc.mdcc.pargo.safe.v6.impl.SAFeGoPort;

public class SimpleApplication extends SAFeApplication{

	public static String fileNameaARCHXML = "arch-v6.xml";
	public static String fileNameaORCHXML = "flow-v6.xml";
	
	public SimpleApplication() {
		//SAFeConsoleLogger.ON = false;
		String fileNameA = "src/br/ufc/mdcc/pargo/safe/grammar/xml/examples/simple/"+fileNameaARCHXML;
		String fileNameB = "src/br/ufc/mdcc/pargo/safe/grammar/xml/examples/simple/"+fileNameaORCHXML;
		this.safeFramework.loadArchitecturalLanguageFile(fileNameA);
		this.safeFramework.loadOrchestrationLanguageFile(fileNameB);
		
		SAFeGoPort go = (SAFeGoPort)this.safeFramework.lookUpServicePort("application", "go");
		go.go();
		
		
	}
	
	public static void main(String[] args) {
		new SimpleApplication();
	}
}

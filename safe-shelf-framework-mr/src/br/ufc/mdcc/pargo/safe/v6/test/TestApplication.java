package br.ufc.mdcc.pargo.safe.v6.test;

import br.ufc.mdcc.pargo.safe.v6.impl.SAFeApplication;

public class TestApplication extends SAFeApplication{

	public static String fileNameaARCHXML = "arch-v6.xml";
	public static String fileNameaORCHXML = "flow-v6.xml";
	
	public TestApplication() {
		String fileName = "src/br/ufc/mdcc/pargo/safe/grammar/xml/"+fileNameaARCHXML;
		this.loadArchitecturalLanguageFile(fileName);
	}
	
	public static void main(String[] args) {
		new TestApplication();
	}
}

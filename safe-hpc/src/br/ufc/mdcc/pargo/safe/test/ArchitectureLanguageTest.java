package br.ufc.mdcc.pargo.safe.test;

import br.ufc.mdcc.pargo.safe.grammar.SAFeSWLArchParser;
import br.ufc.mdcc.pargo.safe.grammar.SAFeSWLValidator;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchMain;
import br.ufc.mdcc.pargo.safe.util.SAFeConstants;

public class ArchitectureLanguageTest {

	public static boolean testValidator(){
		
		SAFeSWLValidator validator = new SAFeSWLValidator();
		//String xmlFile = SAFeConstants.ARCH_FILE_TEST;
		String xmlFile = "src/br/ufc/mdcc/pargo/safe/grammar/xml/mImgtbl-simple-run-arch.xml";
		
		boolean res = validator.validateXMLArchitecture(xmlFile);
		return res;
	}
	
	public static void testParser(){
		SAFeSWLArchParser parser = new SAFeSWLArchParser();
		//String fileName = SAFeConstants.ARCH_FILE_TEST;
		String fileName = "src/br/ufc/mdcc/pargo/safe/grammar/xml/mImgtbl-simple-run-arch.xml";
		parser.readArchXML(fileName);
		ArchMain archMain = parser.getArchitectureMain();
		System.out.println(archMain);
		
	}
	
	public static void main(String[] args) {
		if(ArchitectureLanguageTest.testValidator())
			ArchitectureLanguageTest.testParser();
	}
}

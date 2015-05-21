package br.ufc.mdcc.pargo.safe.test;

import br.ufc.mdcc.pargo.safe.grammar.SAFeSWLArchParser;
import br.ufc.mdcc.pargo.safe.grammar.SAFeSWLValidator;
import br.ufc.mdcc.pargo.safe.util.SAFeConstants;

public class ArchitectureLanguageTest {

	public static void testValidator(){
		
		SAFeSWLValidator validator = new SAFeSWLValidator();
		String xmlFile = SAFeConstants.ARCH_FILE_TEST;
		
		boolean res = validator.validateXMLArchitecture(xmlFile);
		System.out.println(res);
	}
	
	public static void testParser(){
		SAFeSWLArchParser parser = new SAFeSWLArchParser();
		String fileName = SAFeConstants.ARCH_FILE_TEST;
		parser.readArchXML(fileName);
		System.out.println(parser.getArchitectureMain());
		
	}
	
	public static void main(String[] args) {
		ArchitectureLanguageTest.testValidator();
		ArchitectureLanguageTest.testParser();
	}
}

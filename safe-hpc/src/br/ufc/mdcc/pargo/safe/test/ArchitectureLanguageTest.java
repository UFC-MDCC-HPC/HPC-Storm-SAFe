package br.ufc.mdcc.pargo.safe.test;

import br.ufc.mdcc.pargo.safe.grammar.SAFeSWLArchParser;
import br.ufc.mdcc.pargo.safe.grammar.SAFeSWLValidator;

public class ArchitectureLanguageTest {

	public static void testValidator(){
		
		SAFeSWLValidator validator = new SAFeSWLValidator();
		String xmlFile = "src/br/ufc/mdcc/pargo/safe/grammar/arch_03_example.xml";
		
		boolean res = validator.validateXMLArchitecture(xmlFile);
		System.out.println(res);
	}
	
	public static void testParser(){
		SAFeSWLArchParser parser = new SAFeSWLArchParser();
		String fileName = "src/br/ufc/mdcc/pargo/safe/grammar/arch_03_example.xml";
		parser.readArchXML(fileName);
		System.out.println(parser.getArchitectureMain());
		
	}
	
	public static void main(String[] args) {
		ArchitectureLanguageTest.testValidator();
		ArchitectureLanguageTest.testParser();
	}
}

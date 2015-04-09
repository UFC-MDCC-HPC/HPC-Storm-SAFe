package br.ufc.mdcc.pargo.safe.test;

import java.net.URL;

import br.ufc.mdcc.pargo.safe.grammar.SAFeSWLArchParser;
import br.ufc.mdcc.pargo.safe.grammar.SAFeSWLValidator;

public class ArchLanguageTest {

	public static void testValidator(){
		
		SAFeSWLValidator validator = new SAFeSWLValidator();
		String xmlFile = "src/br/ufc/mdcc/pargo/safe/grammar/arch_01_example.xml";
		
		boolean res = validator.validateXMLArch(xmlFile);
		System.out.println(res);
	}
	
	public static void testParser(){
		SAFeSWLArchParser parser = new SAFeSWLArchParser();
		String fileName = "src/br/ufc/mdcc/pargo/safe/grammar/arch_01_example.xml";
		parser.readArchXML(fileName);
		System.out.println(parser.getArchitectureMain());
		
	}
	
	public static void main(String[] args) {
		ArchLanguageTest.testValidator();
		ArchLanguageTest.testParser();
	}
}

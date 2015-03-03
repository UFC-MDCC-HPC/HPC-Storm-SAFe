package br.ufc.mdcc.pargo.safe.test;

import br.ufc.mdcc.pargo.safe.grammar.SAFeSWLParser;
import br.ufc.mdcc.pargo.safe.grammar.SAFeSWLValidator;

public class XMLTest {

	public void myFileTest(){
		
		SAFeSWLValidator v = new SAFeSWLValidator();
		String xmlLocal = "/home/jefferson/workspace-luna/safe-hpc/src/br/ufc/mdcc/pargo/safe/grammar/arch_01_example.xml";
		boolean result = v.validateXMLArch(xmlLocal);
		System.out.println(result);
	}
	
	public void parserTest(){
		String xmlLocal = "/home/jefferson/workspace-luna/safe-hpc/src/br/ufc/mdcc/pargo/safe/grammar/arch_01_example.xml";
		SAFeSWLParser parser = new SAFeSWLParser();
		parser.readArchXML(xmlLocal);
		System.out.println(parser.getArchitectureMain());
	}
	
	public static void main(String[] args) {
		 XMLTest xml = new XMLTest();
		 xml.parserTest();
	}
}

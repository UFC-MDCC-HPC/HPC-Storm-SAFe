package br.ufc.mdcc.pargo.safe.grammar.test;

import br.ufc.mdcc.pargo.safe.grammar.ISAFeSWLArcherParser;
import br.ufc.mdcc.pargo.safe.grammar.SAFeSWLArchParser;
import br.ufc.mdcc.pargo.safe.grammar.SAFeSWLValidator;

public class ArchitectureLanguageTest {

	public static String fileNameXML = "tutorial-arch.xml";
	
	public static boolean testValidator(){
		
		SAFeSWLValidator validator = new SAFeSWLValidator();
		//String xmlFile = SAFeConstants.ARCH_FILE_TEST;
		String xmlFile = "src/br/ufc/mdcc/pargo/safe/grammar/xml/"+fileNameXML;
		boolean res = validator.validateXMLArchitecture(xmlFile);
		return res;
	}
	
	public static ISAFeSWLArcherParser testParser(){
		String fileName = "src/br/ufc/mdcc/pargo/safe/grammar/xml/"+fileNameXML;
		ISAFeSWLArcherParser parser = new SAFeSWLArchParser(fileName);
		
		return parser;
		
	}
	
	public static void main(String[] args) {
		if(ArchitectureLanguageTest.testValidator()){
			ISAFeSWLArcherParser parser = ArchitectureLanguageTest.testParser();
			System.out.println(parser.getArchitecture());
		}
			
	}
}

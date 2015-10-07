package br.ufc.mdcc.pargo.safe.grammar.test;

import br.ufc.mdcc.pargo.safe.grammar.ISAFeSWLArcherParser;
import br.ufc.mdcc.pargo.safe.grammar.ISAFeSWLFlowParser;
import br.ufc.mdcc.pargo.safe.grammar.SAFeSWLFlowParser;
import br.ufc.mdcc.pargo.safe.grammar.SAFeSWLValidator;
 

public class WorkflowLanguageTest {
	
	public static String fileNameXML = "tutorial-flow.xml";
	
	public static boolean testValidator(){
		
		SAFeSWLValidator validator = new SAFeSWLValidator();
		String xmlFile = "src/br/ufc/mdcc/pargo/safe/grammar/xml/"+fileNameXML;
		boolean res = validator.validateXMLOrchestration(xmlFile);
		return res;
	}
	
	public static void testParser(){
		
		String fileName = "src/br/ufc/mdcc/pargo/safe/grammar/xml/"+fileNameXML;
		ISAFeSWLFlowParser flow = new SAFeSWLFlowParser(fileName);
		ISAFeSWLArcherParser arch = ArchitectureLanguageTest.testParser();
		flow.setISAFeSWLArcherParser(arch);
		flow.run();
	}
	
	

	public static void main(String[] args) {
		if(WorkflowLanguageTest.testValidator()){
			WorkflowLanguageTest.testParser();
		}
			
	}
}

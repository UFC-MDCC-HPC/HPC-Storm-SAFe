package br.ufc.mdcc.pargo.safe.framework;

import br.ufc.mdcc.pargo.safe.grammar.SAFeSWLParser;
import br.ufc.mdcc.pargo.safe.grammar.SAFeSWLValidator;
import br.ufc.mdcc.pargo.safe.util.SAFeConsoleLogger;

public class HPCStormWorkflowEngine {
	
	private HPCStormSAFeSWL safeSWL;
	private SAFeSWLParser safeSWLParser;
	private SAFeSWLValidator safeSWLValidator;
	
	public HPCStormWorkflowEngine() {
		
		this.safeSWLValidator = new SAFeSWLValidator();
		SAFeConsoleLogger.write("Validator created.");
		this.safeSWLParser = new SAFeSWLParser();
		SAFeConsoleLogger.write("Parser created.");
		
	}
	
	public void setSafeSWL(HPCStormSAFeSWL safeSWL){
		this.safeSWL = safeSWL;
	}

	 
}


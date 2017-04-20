package br.ufc.mdcc.pargo.safe.grammar.xml;

import br.ufc.mdcc.pargo.safe.grammar.arch.ArchSolution;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchComponent;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchBindingService;
import br.ufc.mdcc.pargo.safe.grammar.arch.ArchActionPort;

public class ArchStringGenerator {
	
	public static final String COMPUTATION = "computation";
	public static final String PLATFORM = "platform";
	public static final String WORKFLOW = "workflow";
	public static final String APPLICATION = "application";
	public static final String CONNECTOR = "connector";
	
	
	public String componentToString(ArchComponent component){
		return null;
	}
	
	public String bodyToString(ArchSolution body){
		return null;
	}
	
	public String environmentToString(ArchBindingService envBinding){
		return null;
	}
	
	public String taskToString(ArchActionPort taskBinding){
		return null;
	}

}

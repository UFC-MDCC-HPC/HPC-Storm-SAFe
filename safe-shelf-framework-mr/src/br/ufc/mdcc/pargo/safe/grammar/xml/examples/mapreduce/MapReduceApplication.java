package br.ufc.mdcc.pargo.safe.grammar.xml.examples.mapreduce;

import br.ufc.mdcc.pargo.safe.v6.impl.SAFeApplication;
import br.ufc.mdcc.pargo.safe.v6.impl.SAFeGoPort;

public class MapReduceApplication extends SAFeApplication{
	
	public static String fileNameaARCHXML = "arch-mapreduce.xml";
	public static String fileNameaORCHXML = "flow-mapreduce.xml";
	
	public MapReduceApplication() {
		String fileNameA = "src/br/ufc/mdcc/pargo/safe/grammar/xml/examples/mapreduce/"+fileNameaARCHXML;
		String fileNameB = "src/br/ufc/mdcc/pargo/safe/grammar/xml/examples/mapreduce/"+fileNameaORCHXML;
		this.safeFramework.loadArchitecturalLanguageFile(fileNameA);
		this.safeFramework.loadOrchestrationLanguageFile(fileNameB);
		
		SAFeGoPort go = (SAFeGoPort)this.safeFramework.lookUpServicePort("application", "go");
		go.go();
	}
	
	public static void main(String[] args) {
		new MapReduceApplication();
	}

}

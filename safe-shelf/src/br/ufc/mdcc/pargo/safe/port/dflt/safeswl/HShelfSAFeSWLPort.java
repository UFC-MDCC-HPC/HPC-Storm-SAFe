package br.ufc.mdcc.pargo.safe.port.dflt.safeswl;

import br.ufc.mdcc.pargo.safe.port.HShelfPort;

public abstract class HShelfSAFeSWLPort extends HShelfPort{

	public abstract String getSAFeSWLArchFilePath();
	public abstract String getSAFeSWLFlowFilePath();
	public abstract String getSAFeSWLArchSourceXML();
	public abstract String getSAFeSWLFlowSourceXML();
}

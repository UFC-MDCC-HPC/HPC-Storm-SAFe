package br.ufc.mdcc.pargo.safe.port.dflt;

import br.ufc.mdcc.pargo.safe.port.HShelfPort;

public abstract class HShelfSAFeSWLPort extends HShelfPort{

	public abstract String getSAFeSWLArchFilePath();
	public abstract String getSAFeSWLFlowFilePath();
	
	public abstract void setSAFeSWLArchFilePath(String path);
	public abstract void setSAFeSWLFlowFilePath(String path);
}

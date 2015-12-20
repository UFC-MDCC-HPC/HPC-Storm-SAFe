package br.ufc.mdcc.pargo.safe.framework.port.dflt;

import br.ufc.mdcc.pargo.safe.framework.port.HShelfProvidesPort;

public abstract class HShelfSAFeSWLPort extends HShelfProvidesPort{

	public abstract String getSAFeSWLArchFilePath();
	public abstract String getSAFeSWLFlowFilePath();
	
	public abstract void setSAFeSWLArchFilePath(String path);
	public abstract void setSAFeSWLFlowFilePath(String path);
}

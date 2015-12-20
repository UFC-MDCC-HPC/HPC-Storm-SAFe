package br.ufc.mdcc.pargo.safe.sample.application;

import br.ufc.mdcc.pargo.safe.framework.port.HShelfUsesPort;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfSAFeSWLPort;

public class ClientServerUsesWFSAFeSWL extends HShelfUsesPort{

	public void setSAFeSWLArchFilePath(String path){
		((HShelfSAFeSWLPort)this.providesPort).setSAFeSWLArchFilePath(path);
	}
	
	public void setSAFeSWLFlowFilePath(String path){
		((HShelfSAFeSWLPort)this.providesPort).setSAFeSWLFlowFilePath(path);
	}
}

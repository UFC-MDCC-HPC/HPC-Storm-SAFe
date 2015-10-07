package br.ufc.mdcc.pargo.safe.framework.port.dflt;

public class HShelfSAFeSWLPortImpl extends HShelfSAFeSWLPort{

	private String archFilePath;
	private String flowFilePath;
	
	@Override
	public String getSAFeSWLArchFilePath() {
		return this.archFilePath;
	}

	@Override
	public String getSAFeSWLFlowFilePath() {
		
		return this.flowFilePath;
	}

	@Override
	public void setSAFeSWLArchFilePath(String path) {
		this.archFilePath = path;		
	}

	@Override
	public void setSAFeSWLFlowFilePath(String path) {
		this.flowFilePath = path;
	}

	 
}

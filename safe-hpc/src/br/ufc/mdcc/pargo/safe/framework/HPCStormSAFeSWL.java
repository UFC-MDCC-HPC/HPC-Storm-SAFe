package br.ufc.mdcc.pargo.safe.framework;

public class HPCStormSAFeSWL {

	private String archFileName;
	private String flowFileName;
	
	public HPCStormSAFeSWL() {
	}
	
	public HPCStormSAFeSWL(String archFileName, String flowFileName){
		this.archFileName = archFileName;
		this.flowFileName = flowFileName;
	}
	
	public String getArchFileName() {
		return archFileName;
	}
	public void setArchFileName(String archFileName) {
		this.archFileName = archFileName;
	}
	public String getFlowFileName() {
		return flowFileName;
	}
	public void setFlowFileName(String flowFileName) {
		this.flowFileName = flowFileName;
	}
	
	
}

package br.ufc.mdcc.pargo.safe.expert.dao;

public class WorkflowModel {

	private String workflowName;
	private String archXMLFilePath;
	private String flowXMLFilePath;
	private String archXMLFileContent;
	private String flowXMLFileContent;
	
	public WorkflowModel() {
		
	}
	
	public String getWorkflowName() {
		return workflowName;
	}
	public void setWorkflowName(String workflowName) {
		this.workflowName = workflowName;
	}
	public String getArchXMLFilePath() {
		return archXMLFilePath;
	}
	public void setArchXMLFilePath(String archXMLFilePath) {
		this.archXMLFilePath = archXMLFilePath;
	}
	public String getFlowXMLFilePath() {
		return flowXMLFilePath;
	}
	public void setFlowXMLFilePath(String flowXMLFilePath) {
		this.flowXMLFilePath = flowXMLFilePath;
	}
	public String getArchXMLFileContent() {
		return archXMLFileContent;
	}
	public void setArchXMLFileContent(String archXMLFileContent) {
		this.archXMLFileContent = archXMLFileContent;
	}
	public String getFlowXMLFileContent() {
		return flowXMLFileContent;
	}
	public void setFlowXMLFileContent(String flowXMLFileContent) {
		this.flowXMLFileContent = flowXMLFileContent;
	}
	
	@Override
	public String toString() {
		String str = this.workflowName+"\n"+this.archXMLFilePath+"\n"+this.flowXMLFilePath;
		return str;
	}
	
}

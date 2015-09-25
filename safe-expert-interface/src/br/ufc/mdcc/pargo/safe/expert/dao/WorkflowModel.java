package br.ufc.mdcc.pargo.safe.expert.dao;

import java.util.ArrayList;
import java.util.List;

public class WorkflowModel {

	private String workflowName;
	private String archXMLFilePath;
	private String flowXMLFilePath;
	private String archFileName;
	private String flowFileName;
	private String archXMLFileContent;
	private String flowXMLFileContent;
	
	private List<WorkflowParameter> parameters;
	
	
	public WorkflowModel() {
		this.parameters = new ArrayList<WorkflowParameter>();
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
	
	public void addParameter(WorkflowParameter parameter){
		this.parameters.add(parameter);
	}
	
	public List<WorkflowParameter> getParameters(){
		return this.parameters;
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

	@Override
	public String toString() {
		String str = this.workflowName+"\n"+this.archXMLFilePath+"\n"+this.flowXMLFilePath;
		return str;
	}
	
}

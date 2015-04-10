package br.ufc.mdcc.pargo.safe.grammar.flow;

import java.util.ArrayList;
import java.util.List;

public class WorkflowElement {

	private XMLSAFeBase element;
	private WorkflowOperation operation;
	private List<WorkflowElement> children;
	
	public WorkflowElement() {
		this.children = new ArrayList<WorkflowElement>();
	}
	
	public void addWorflowElement(WorkflowElement wf){
		this.children.add(wf);
	}
	
	public XMLSAFeBase getElement() {
		return element;
	}

	public void setElement(XMLSAFeBase element) {
		this.element = element;
	}
	
	public WorkflowOperation getOperation() {
		return operation;
	}

	public void setOperation(String oper) {
		oper = oper.toUpperCase();
		this.operation = WorkflowOperation.valueOf(oper);
	}
	
	public List<WorkflowElement> getChildren() {
		return children;
	}

	@Override
	public String toString() {
		String res="";
		res+=
				"["+(element).getLevel()+"]"
				+"["+(element).getOrder()+"]"
				+(element).getOperName();
		return res;
	}
}

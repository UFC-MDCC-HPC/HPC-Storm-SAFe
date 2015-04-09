package br.ufc.mdcc.pargo.safe.grammar.flow;

import java.util.ArrayList;
import java.util.List;

public class WorkflowElement {

	private Object element;
	private List<WorkflowElement> children;
	
	public WorkflowElement() {
		this.children = new ArrayList<WorkflowElement>();
	}
	
	public void addWorflowElement(WorkflowElement wf){
		this.children.add(wf);
	}
	
	public Object getElement() {
		return element;
	}

	public void setElement(Object element) {
		this.element = element;
	}
	
}

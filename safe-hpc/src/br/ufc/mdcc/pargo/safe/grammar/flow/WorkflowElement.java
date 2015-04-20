package br.ufc.mdcc.pargo.safe.grammar.flow;

import java.util.ArrayList;
import java.util.List;

/**
 * Tree-based workflow. 
 * @author jefferson
 *
 */
public class WorkflowElement {

	private XMLSAFeBase element; //Value of the node. This object is JAXB auto generated.
	private WorkflowOperation operation; //operation related to the node
	private List<WorkflowElement> children; //list o children node
	
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
		if(this.element.getValue()!=null){
			res+="[value="+this.element.getValue()+"]";
		}
		return res;
	}
}

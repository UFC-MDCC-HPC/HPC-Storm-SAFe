package br.ufc.mdcc.pargo.safe.grammar.flow;

import java.util.ArrayList;
import java.util.List;

import br.ufc.mdcc.pargo.safe.grammar.flow.visitor.ISAFeVisitor;

/**
 * Tree-based workflow. 
 * @author jefferson
 *
 */
public class SAFeOrchestrationElement {

	private SAFeSWLOperationBaseType element; //Value of the node. This object is JAXB auto generated.
	private SAFeOrchestrationOperation operation; //operation related to the node
	private String operationStr;
	private List<SAFeOrchestrationElement> children; //list o children node
	private ISAFeVisitor saFeVisitor;
	
	public SAFeOrchestrationElement() {
		this.children = new ArrayList<SAFeOrchestrationElement>();
	}
	
	public void addWorflowElement(SAFeOrchestrationElement wf){
		this.children.add(wf);
	}
	
	public SAFeSWLOperationBaseType getElement() {
		return element;
	}

	public void setElement(SAFeSWLOperationBaseType element) {
		this.element = element;
	}
	
	public SAFeOrchestrationOperation getOperation() {
		return operation;
	}

	public void setOperation(String oper) {
		this.operationStr = oper;
		oper = oper.toUpperCase();
		this.operation = SAFeOrchestrationOperation.valueOf(oper);
	}
	
	public List<SAFeOrchestrationElement> getChildren() {
		return children;
	}

	public void accept(ISAFeVisitor visitor){
		this.saFeVisitor = visitor;
	}
	
	public void run(){
		if(this.saFeVisitor!=null)
			this.saFeVisitor.visit(this);
	}
	
	public String getOperationStr(){
		return this.operationStr;
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

package br.ufc.mdcc.pargo.safe.grammar.flow;

import java.util.ArrayList;
import java.util.List;

import br.ufc.mdcc.pargo.safe.grammar.flow.visitor.AbstractSAFeElementLogic;
import br.ufc.mdcc.pargo.safe.grammar.flow.visitor.ISAFeVisitor;

/**
 * Tree-based workflow.
 * 
 * @author jefferson
 *
 */
public class SAFeOrchestrationElement {

	private SAFeSWLOperationBaseType element; // Value of the node. This object
												// is JAXB auto generated.
	private SAFeOrchestrationOperation operation; // operation related to the
													// node
	private String operationStr;
	private List<SAFeOrchestrationElement> children; // list o children node
	private SAFeOrchestrationElement parent;
	private ISAFeVisitor saFeVisitor;
	private AbstractSAFeElementLogic logicClass;

	public AbstractSAFeElementLogic getLogicClass() {
		return logicClass;
	}

	public void setLogicClass(AbstractSAFeElementLogic logicClass) {
		this.logicClass = logicClass;
	}

	public SAFeOrchestrationElement() {
		this.children = new ArrayList<SAFeOrchestrationElement>();
	}

	public void addWorflowElement(SAFeOrchestrationElement wf) {
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

		this.operationStr = oper.substring(0, 1).toUpperCase()
				+ oper.substring(1);
		oper = oper.toUpperCase();
		this.operation = SAFeOrchestrationOperation.valueOf(oper);

	}

	public List<SAFeOrchestrationElement> getChildren() {
		return children;
	}

	public SAFeOrchestrationElement getParent() {
		return parent;
	}

	public void setParent(SAFeOrchestrationElement parent) {
		this.parent = parent;
	}

	public void accept(ISAFeVisitor visitor) {
		this.saFeVisitor = visitor;
	}

	public void run() {
		if (this.saFeVisitor != null)
			this.saFeVisitor.visit(this);
	}

	public ISAFeVisitor getSaFeVisitor() {
		return saFeVisitor;
	}

	public String getOperationStr() {
		// String output = input.substring(0, 1).toUpperCase()
		return this.operationStr;
	}

	@Override
	public String toString() {
		String res = "";
		res += "[" + (element).getLevel() + "]" + "[" + (element).getOrder()
				+ "]" + (element).getOperName();
		if (this.element.getValue() != null) {
			res += "[value=" + this.element.getValue() + "]";
		}
		return res;
	}
}

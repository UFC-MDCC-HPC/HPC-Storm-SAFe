package br.ufc.mdcc.pargo.safe.grammar.flow;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import br.ufc.mdcc.pargo.safe.grammar.ISAFeSWLArcherParser;
import br.ufc.mdcc.pargo.safe.grammar.flow.visitor.ISAFeVisitor;
import br.ufc.mdcc.pargo.safe.grammar.flow.visitor.SAFeVisitorImpl;

public class SAFeOrchestrationWorkflow {

	private XMLSAFeOperation workflow;
	private SAFeOrchestrationElement root;
	private ISAFeVisitor safeVisitor;
	private ISAFeSWLArcherParser sAFeSWLArcherParser;

	public SAFeOrchestrationWorkflow(String XMLfileName) {
		this.safeVisitor = new SAFeVisitorImpl();
		this.parseWorkflow(XMLfileName);
	}
	
	public void setISAFeSWLArcherParser(ISAFeSWLArcherParser sAFeSWLArcherParser){
		this.sAFeSWLArcherParser = sAFeSWLArcherParser;
		this.safeVisitor.setISAFeSWLArcherParser(sAFeSWLArcherParser);
	}

	public void parseWorkflow(String fileName) {
		try {
			JAXBContext jc = JAXBContext
					.newInstance("br.ufc.mdcc.pargo.safe.grammar.flow");
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			Object out = unmarshaller.unmarshal(new File(fileName));
			JAXBElement<?> je = (JAXBElement<?>) out;
			this.workflow = (XMLSAFeOperation) je.getValue();
			this.navigate(); // this method constructs the tree node workflow
		} catch (JAXBException e) {

			e.printStackTrace();
		}
	}
	
	

	private void navigate() {
		if (this.workflow == null)
			return;
		this.root = new SAFeOrchestrationElement();
		this.root.accept(this.safeVisitor);
		int level = 1;
		int order = 100;

		Stack<Object> elementsStack = new Stack<Object>();
		Stack<SAFeOrchestrationElement> wfElements = new Stack<SAFeOrchestrationElement>();

		elementsStack.push(this.workflow);

		((XMLSAFeBase) this.workflow).setLevel(level); // for fun
		((XMLSAFeBase) this.workflow).setOrder(order);
		((XMLSAFeBase) this.workflow).setOperName("workflow");

		this.root.setElement(this.workflow);
		this.root.setOperation(((XMLSAFeBase) this.workflow).getOperName());
		wfElements.push(this.root);

		while (!elementsStack.isEmpty()) {
			Object element = elementsStack.pop();
			SAFeOrchestrationElement wfElement = wfElements.pop();

			
			int myLevel = ((XMLSAFeBase) element).getLevel();
			List<Object> children = this.getChildren(element);
			int orderCounter = children.size();
			for (int i = children.size() - 1; i >= 0; i--) {
				Object child = children.get(i);
				
				 
				if (((XMLSAFeBase) child).getOperName().equalsIgnoreCase(
						SAFeOrchestrationOperation.OPERATION.name())) {

					child = this.getChildren(child).get(0);
				}

				// level control, for graphical purpouses
				((XMLSAFeBase) child).setLevel(myLevel + 1);
				((XMLSAFeBase) child).setOrder((myLevel + 1) * 100
						+ orderCounter);

				elementsStack.push(child);
				orderCounter--;

				// wfElement
				SAFeOrchestrationElement wfChild = new SAFeOrchestrationElement();
				//adding visitor
				wfChild.accept(this.safeVisitor);
				wfChild.setElement((XMLSAFeBase) child);
				wfChild.setOperation(((XMLSAFeBase) child).getOperName());
				wfElement.addWorflowElement(wfChild);
				wfElements.push(wfChild);
			}
		}

	}

	private List<Object> getChildren(Object element) {
		Method[] workflowMethods = element.getClass().getMethods();
		List<Object> children = new ArrayList<Object>();
		for (Method method : workflowMethods) {

			if (method.getName().startsWith("get")
					&& !method.getName().startsWith("getClass")) {
				try {
					Object args[] = new Object[0]; //useless..
					Object child = method.invoke(element, args);

					if (child != null) {
						String operName = method.getName().replace("get", "");
						
						
						
						if (child instanceof List) {
							
							List<?> l = (List<?>) child;
							for (Object o : l){
								if (o instanceof XMLSAFeBase) {
									((XMLSAFeBase) o).setOperName(operName);
									children.add(o);
								}
							}

						} else if (child instanceof XMLSAFeBase) {
							
							((XMLSAFeBase) child).setOperName(operName);
							children.add(child);
						}

					}

					// System.out.println(child);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return children;
	}

	/**
	 * Runs the workflow
	 */
	public void run(){
		this.root.run();
	}
	
	/**
	 * Translates the abstract tree to a String
	 */
	public String toString() {
		String res = "";
		if (this.workflow == null)
			return "";

		Stack<SAFeOrchestrationElement> nodes = new Stack<SAFeOrchestrationElement>();
		nodes.push(this.root);

		while (!nodes.isEmpty()) {

			SAFeOrchestrationElement e = nodes.pop();
			String space = "";
			for (int i = 0; i <= e.getElement().getLevel(); i++) {
				space += "    ";
			}

			res += space + e + "\n";
			for (SAFeOrchestrationElement child : e.getChildren()) {
				nodes.push(child);
			}
		}

		return res;
	}
}

/* HOW TO COMPILE THE XSD FILE
 * xjc -p br.ufc.mdcc.pargo.safe.grammar.flow SAFe_workflow.xsd -d ../../../../../../
 */

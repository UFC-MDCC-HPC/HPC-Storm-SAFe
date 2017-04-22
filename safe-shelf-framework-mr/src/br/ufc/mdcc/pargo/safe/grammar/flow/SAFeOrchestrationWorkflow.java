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

import br.ufc.mdcc.pargo.safe.framework.workflow.HShelfWorkflowFacade;
import br.ufc.mdcc.pargo.safe.grammar.ISAFeSWLArcherParser;
import br.ufc.mdcc.pargo.safe.grammar.flow.visitor.ISAFeVisitor;
import br.ufc.mdcc.pargo.safe.grammar.flow.visitor.SAFeVisitorImpl;

public class SAFeOrchestrationWorkflow {

	private SAFeSWLOperationBaseType workflow;
	private SAFeOrchestrationElement root;
	private ISAFeVisitor safeVisitor;
	

	public SAFeOrchestrationWorkflow(String XMLfileName) {
		this.safeVisitor = new SAFeVisitorImpl();
		this.parseWorkflow(XMLfileName);
	}
	
	public void setISAFeSWLArcherParser(ISAFeSWLArcherParser sAFeSWLArcherParser){
		this.safeVisitor.setISAFeSWLArcherParser(sAFeSWLArcherParser);
	}
	
	public void setHShelfWorkflowFacade(HShelfWorkflowFacade workflowFacade){
		this.safeVisitor.setHShelfWorkflowFacade(workflowFacade);
	}

	public void parseWorkflow(String fileName) {
		try {
			JAXBContext jc = JAXBContext
					.newInstance("br.ufc.mdcc.pargo.safe.grammar.flow");
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			Object out = unmarshaller.unmarshal(new File(fileName));
			JAXBElement<?> je = (JAXBElement<?>) out;
			
			//System.out.println(je);
			
			this.workflow = (SAFeSWLOperationBaseType)je.getValue();
			this.workflow.setOperName("workflow");
			
			this.navigate_v6(); // this method constructs the tree node workflow
		
		} catch (JAXBException e) {

			e.printStackTrace();
		}
	}
	
    private void navigate_v6(){
    	
    	if(this.workflow ==null) return;
    	
    	int level = 1;
		int order = 100;
		((SAFeSWLOperationBaseType) this.workflow).setLevel(level);
		((SAFeSWLOperationBaseType) this.workflow).setOrder(order);
		
    	
    	this.root = new SAFeOrchestrationElement();
		this.root.accept(this.safeVisitor);
		this.root.setElement(this.workflow);
		this.root.setOperation(((SAFeSWLOperationBaseType) this.workflow).getOperName());
		
		Stack<Object> elementsStack = new Stack<Object>();
		Stack<SAFeOrchestrationElement> workflowElementsStack = new Stack<SAFeOrchestrationElement>();
    	
		elementsStack.push(this.workflow);
		workflowElementsStack.push(this.root);
		while (!elementsStack.isEmpty()) {
			Object element = elementsStack.pop();
			SAFeOrchestrationElement workflowElement = workflowElementsStack.pop();
			
		    
			int myLevel = ((SAFeSWLOperationBaseType) element).getLevel();
			List<Object> elementChildren = this.getChildren_v6(element);
			int orderCounter = elementChildren.size();

			for(int i=elementChildren.size()-1;i>=0;i--){ 
				Object elementChild = elementChildren.get(i);
				((SAFeSWLOperationBaseType) elementChild).setLevel(myLevel + 1);
				((SAFeSWLOperationBaseType) elementChild).setOrder((myLevel + 1) * 100
						+ orderCounter);

				
				elementsStack.push(elementChild);
				SAFeOrchestrationElement workflowfChild = new SAFeOrchestrationElement();
				workflowfChild.accept(this.safeVisitor);
				workflowfChild.setElement((SAFeSWLOperationBaseType) elementChild);
				String operationName = ((SAFeSWLOperationBaseType) elementChild).getOperName();
				
				workflowfChild.setOperation(operationName);
				workflowElement.addWorflowElement(workflowfChild);
				workflowElementsStack.push(workflowfChild);

			}
			
		}
    }

    private List<Object> getChildren_v6(Object element){
       
    	//System.out.println(((SAFeSWLOperationBaseType)element).getOperName());
    	
    	Method[] workflowMethods = element.getClass().getMethods();
		List<Object> children = new ArrayList<Object>();
		for (Method method : workflowMethods) {
		
			if (method.getName().startsWith("get")
					&& !method.getName().startsWith("getClass")) {

				Object args[] = new Object[0]; //useless..
				try {
					Object out = method.invoke(element, args);
					if(out!=null){
						String methodName = method.getName().replace("get", "");
						
						
						
						if(!methodName.equalsIgnoreCase("OperName")){
						
							
							if(methodName.equalsIgnoreCase("SkipOrBreakOrContinue")){
								if(out instanceof List)
								  for(Object o:(List)out){
									JAXBElement<?> el = (JAXBElement<?>)o;
									SAFeSWLOperationBaseType child = (SAFeSWLOperationBaseType)el.getValue(); 
									child.setOperName(el.getName().getLocalPart().toLowerCase());
									children.add(child);
								  }
							}else if(methodName.equalsIgnoreCase("Operation")){
								for(Object o:(List)out){
									((SAFeSWLOperationBaseType) o).setOperName(methodName.toLowerCase());
									children.add(o);
								}
							}else if(methodName.equalsIgnoreCase("Select")){
								for(Object o:(List)out){
									((SAFeSWLOperationBaseType) o).setOperName(methodName.toLowerCase());
									children.add(o);
								}
							}else{
								if(out instanceof SAFeSWLOperationBaseType){
									((SAFeSWLOperationBaseType) out).setOperName(methodName.toLowerCase());
									children.add(out);
									
								}
								
							}
						}
					}
					
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
 * jefferson@jefferson-VPCEB13EB:~/Git/HPC-Storm-SAFe/safe-shelf-framework/src/br/ufc/mdcc/pargo/safe/grammar/xml$ xjc -p br.ufc.mdcc.pargo.safe.grammar.flow SAFe_workflow_V4.xsd -d ../../../../../../../
 */

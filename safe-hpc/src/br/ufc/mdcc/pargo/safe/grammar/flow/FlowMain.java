package br.ufc.mdcc.pargo.safe.grammar.flow;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


public class FlowMain {

	//private XMLSAFeStmt workflow;
	private XMLSAFeOperation workflow;
	
	public FlowMain(){
		//this.workflow = null;
	}

	public FlowMain(String XMLfileName) {
		this.parseWorkflow(XMLfileName);
	}
	
	
	
	public void  parseWorkflow(String fileName){
		try {
			JAXBContext jc = JAXBContext.newInstance("br.ufc.mdcc.pargo.safe.grammar.flow");
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			Object out = unmarshaller.unmarshal(new File( fileName));
			JAXBElement<?> je = (JAXBElement<?>)out;
			//System.out.println(je.getValue());
			
			this.workflow = (XMLSAFeOperation)je.getValue();
			
			this.navigate();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*public XMLSAFeStmt getWorkflow(){
		return this.workflow;
	}*/
	
	public void navigate(){
		if(this.workflow==null) return;
		int level=1;
		int order = 100;
		
		//Queue<Object> elementsQueue = new LinkedList<Object>();
		Stack<Object> elementsStack = new Stack<Object>();
		//elementsQueue.add(this.workflow);
		elementsStack.push(this.workflow);
		
		((XMLSAFeBase)this.workflow).setLevel(level); //for fun
		((XMLSAFeBase)this.workflow).setOrder(order); 
		((XMLSAFeBase)this.workflow).setOperName("workflow");
		//while(!elementsQueue.isEmpty()){
		while(!elementsStack.isEmpty()){	
			Object element = elementsStack.pop();
			//Object element = elementsQueue.remove();
			//printing logic...
			//if(!((XMLSAFeBase)element).getOperName().equalsIgnoreCase("operation")){
				String tabs="";
				for(int i=0;i<=((XMLSAFeBase)element).getLevel();i++)
					tabs+="    ";
				System.out.println(tabs
						+"["+((XMLSAFeBase)element).getLevel()+"]"
						+"["+((XMLSAFeBase)element).getOrder()+"]"
						+((XMLSAFeBase)element).getOperName());
			//}
			
			int myLevel = ((XMLSAFeBase)element).getLevel();
			List<Object> children = this.getChildren(element);
			int orderCounter = children.size();
			for(int i = children.size()-1;i>=0;i--){
				Object child = children.get(i);
				((XMLSAFeBase)child).setLevel(myLevel+1); //for fun
				((XMLSAFeBase)child).setOrder((myLevel+1)*100+orderCounter);
				
				//elementsQueue.add(child);
				elementsStack.push(child);
				orderCounter--;
			}
		}
		
		
		
	}
	
	private String printElement(Object o){
		String res = "";
		/*if(o instanceof XMLSAFeOperation){
			XMLSAFeOperation xso = ((XMLSAFeOperation)o).get
		}else
			res=o.getClass().getSimpleName();*/
		return res;
	}
	
	private List<Object> getChildren(Object element){
		Method[] workflowMethods = element.getClass().getMethods();
		List<Object> children = new ArrayList<Object>();
		for(Method method:workflowMethods){
			if(method.getName().startsWith("get") && !method.getName().startsWith("getClass")){
				try {
					
					Object child = method.invoke(element, null);
					
					if(child!=null){
						String operName = method.getName().replace("get", "");
						
						if(child instanceof List){
							List l = (List)child;
							for(Object o:l)
								if(o instanceof XMLSAFeBase ){
									((XMLSAFeBase)o).setOperName(operName);
									children.add(o);
								}
									
						}else if(child instanceof XMLSAFeBase){
							((XMLSAFeBase)child).setOperName(operName);
							children.add(child);
						}
							
					}
						
					//System.out.println(child);
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
	
	/*
	public String toString(){
		String res = "";
		if(this.workflow==null) return "";
		
		return res;
	}*/
}

/*
 * xjc -p br.ufc.mdcc.pargo.safe.grammar.flow SAFe_workflow.xsd -d ../../../../../../
 */

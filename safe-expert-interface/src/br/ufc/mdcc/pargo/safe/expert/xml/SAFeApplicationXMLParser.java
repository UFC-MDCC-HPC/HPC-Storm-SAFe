package br.ufc.mdcc.pargo.safe.expert.xml;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import br.ufc.mdcc.pargo.safe.expert.dao.WorkflowModel;
import br.ufc.mdcc.pargo.safe.expert.dao.WorkflowParameter;

public class SAFeApplicationXMLParser {

	/**
	 * Get in and out parameters from arch file...
	 * @param filename
	 */
	public void parseXMLWorkflow(String filePath,WorkflowModel workflowModel){
		SAXBuilder builder = new SAXBuilder();
		Document doc;
		try {
			doc = builder.build(new File(filePath));
			Element rootArch = doc.getRootElement();
			List<Element> children = rootArch.getChildren();
			for(Element child:children){
				if(child.getName().equals("parameter")){
					String name = child.getAttributeValue("name");
					String type = child.getAttributeValue("type");
					String nature = child.getAttributeValue("nature");
					
					WorkflowParameter parameter = new WorkflowParameter();
					parameter.setName(name);
					parameter.setType(type);
					parameter.setNature(nature);
					workflowModel.addParameter(parameter);
				}
				
			}
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

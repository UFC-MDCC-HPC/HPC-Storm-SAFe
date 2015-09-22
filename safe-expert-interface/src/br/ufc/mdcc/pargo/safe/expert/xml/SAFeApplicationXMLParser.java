package br.ufc.mdcc.pargo.safe.expert.xml;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class SAFeApplicationXMLParser {

	/**
	 * Get in and out parameters from application component...
	 * @param filename
	 */
	public void parseXMLApplication(String fileName){
		SAXBuilder builder = new SAXBuilder();
		Document doc;
		//System.out.println(fileName+"\n");
		try {
			doc = builder.build(new File(fileName));
			Element rootArch = doc.getRootElement();
			List<Element> children = rootArch.getChildren();
			for(Element child:children){
				if(child.getName().equals("parameter")){
					List<Element> grandChildren = child.getChildren();
					
					for(Element grandChild:grandChildren){
						//System.out.println(grandChild.getName());
					}
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

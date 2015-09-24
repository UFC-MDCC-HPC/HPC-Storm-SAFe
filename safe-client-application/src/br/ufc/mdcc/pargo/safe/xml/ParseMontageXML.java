package br.ufc.mdcc.pargo.safe.xml;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import br.ufc.mdcc.pargo.safe.application.component.MontageRepository;
import br.ufc.mdcc.pargo.safe.application.component.MontageApplication;
import br.ufc.mdcc.pargo.safe.application.component.MontageComponent;
import br.ufc.mdcc.pargo.safe.application.component.MontageParam;

 

public class ParseMontageXML {

	private MontageRepository repository;
	
	public ParseMontageXML(MontageRepository repository) {
		this.repository = repository;
	}
	
	public void parseXMLComponents(String filename){
		
		SAXBuilder builder = new SAXBuilder();
		Document doc;
		try {
			doc = builder.build(new File(filename));
			Element rootArch = doc.getRootElement();
			List<Element> children = rootArch.getChildren();
			for(Element child:children){
				
				String cName = child.getAttributeValue("name");
				MontageComponent mc = new MontageComponent(cName);
				List<Element> grandChildren = child.getChildren();
				for(Element grandChild:grandChildren){
					String paramNature = grandChild.getName();
					String paramName = grandChild.getAttributeValue("name");
					String paramType = grandChild.getAttributeValue("type");
					//System.out.println(paramNature+" "+paramName+" "+paramType);
					MontageParam mp = new MontageParam(paramName, paramType);
					if(paramNature.equals("inParam")){
						mc.addInParam(mp);
					}else if(paramNature.equals("outParam")){
						mc.addOutParam(mp);
					}
				}//for 2
				this.repository.addComponent(mc);
			}//for 1
			
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
public void parseXMLApplications(String filename){
		
		SAXBuilder builder = new SAXBuilder();
		Document doc;
		try {
			doc = builder.build(new File(filename));
			Element rootArch = doc.getRootElement();
			List<Element> children = rootArch.getChildren();
			for(Element child:children){
				
				String cName = child.getAttributeValue("name");
				MontageApplication mapp = new MontageApplication(cName);
				List<Element> grandChildren = child.getChildren();
				for(Element grandChild:grandChildren){
					String paramNature = grandChild.getName();
					String paramName = grandChild.getAttributeValue("name");
					String paramType = grandChild.getAttributeValue("type");
					//System.out.println(paramNature+" "+paramName+" "+paramType);
					MontageParam mp = new MontageParam(paramName, paramType);
					if(paramNature.equals("inParam")){
						mapp.addInParam(mp);
					}else if(paramNature.equals("outParam")){
						mapp.addOutParam(mp);
					}
				}//for 2
				
				this.repository.addApplication(mapp);
			}//for 1
			
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
}
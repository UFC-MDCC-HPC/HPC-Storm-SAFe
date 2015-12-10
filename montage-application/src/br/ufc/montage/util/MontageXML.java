package br.ufc.montage.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import br.ufc.montage.model.MontageComponent;
import br.ufc.montage.model.MontageEnvPort;
import br.ufc.montage.model.MontageTskPort;


public class MontageXML {

	public static List<MontageComponent> parseXMLWorkflow(String filePath){
		SAXBuilder builder = new SAXBuilder();
		Document doc;
		List<MontageComponent> components = new ArrayList<MontageComponent>();
		try {
			File myXML = new File(filePath);
			doc = builder.build(myXML);
			Element rootArch = doc.getRootElement();
			List<Element> children = rootArch.getChildren();
			for(Element c_child:children){
				if(c_child.getName().equals("component")){
					String c_name = c_child.getAttributeValue("name");
					MontageComponent component = new MontageComponent();
					component.setName(c_name);
					
					for(Element p_child:c_child.getChildren()){
						if(p_child.getName().equals("env_ports")){
							for(Element pp_child:p_child.getChildren()){
								if(pp_child.getName().equals("env_port")){
									String pp_name = pp_child.getAttributeValue("name");
									String pp_type = pp_child.getAttributeValue("type");
									MontageEnvPort envPort = new MontageEnvPort();
									envPort.setName(pp_name);
									envPort.setType(pp_type);
									component.addEnvPort(envPort);
								} //env
							}//envs for
						}//envs if
						else if(p_child.getName().equals("tsk_ports")){
							for(Element pp_child:p_child.getChildren()){
								if(pp_child.getName().equals("tsk_port")){
									String pp_name = pp_child.getAttributeValue("name");
									MontageTskPort tskPort = new MontageTskPort();
									tskPort.setName(pp_name);
									component.addTskPort(tskPort);
								}
							} //tsks for
						}//tsks if
					}//ports for
					components.add(component);
				}//component if
			}//component for
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return components;
	}
}

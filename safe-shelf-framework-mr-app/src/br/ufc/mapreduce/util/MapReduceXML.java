package br.ufc.mapreduce.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import br.ufc.mapreduce.model.MapReduceAction;
import br.ufc.mapreduce.model.MapReduceComponent;
import br.ufc.mapreduce.model.MapReduceEnvPort;
import br.ufc.mapreduce.model.MapReduceTskPort;


public class MapReduceXML {

	public static List<MapReduceComponent> parseXMLWorkflow(String filePath){
		SAXBuilder builder = new SAXBuilder();
		Document doc;
		List<MapReduceComponent> components = new ArrayList<MapReduceComponent>();
		try {
			File myXML = new File(filePath);
			doc = builder.build(myXML);
			Element rootArch = doc.getRootElement();
			List<Element> children = rootArch.getChildren();
			for(Element c_child:children){
				if(c_child.getName().equals("component")){
					String c_name = c_child.getAttributeValue("name");
					String k_name = c_child.getAttributeValue("kind");
					String i_name = c_child.getAttributeValue("id");
					MapReduceComponent component = new MapReduceComponent();
					component.setName(c_name);
					component.setKind(k_name);
					component.setId(Integer.parseInt(i_name));
					
					for(Element p_child:c_child.getChildren()){
						if(p_child.getName().equals("env_ports")){
							for(Element pp_child:p_child.getChildren()){
								if(pp_child.getName().equals("env_port")){
									String pp_name = pp_child.getAttributeValue("name");
									String pp_type = pp_child.getAttributeValue("type");
									String pp_id = pp_child.getAttributeValue("id");
									String pp_id_component = pp_child.getAttributeValue("id_component");
									MapReduceEnvPort envPort = new MapReduceEnvPort();
									envPort.setName(pp_name);
									envPort.setType(pp_type);
									envPort.setId(Integer.parseInt(pp_id));
									envPort.setId_component(Integer.parseInt(pp_id_component));
									component.addEnvPort(envPort);
								} //env
							}//envs for
						}//envs if
						else if(p_child.getName().equals("tsk_ports")){
							for(Element pp_child:p_child.getChildren()){
								if(pp_child.getName().equals("tsk_port")){
									String pp_name = pp_child.getAttributeValue("name");
									String pp_id = pp_child.getAttributeValue("id");
									String pp_id_component = pp_child.getAttributeValue("id_component");
									MapReduceTskPort tskPort = new MapReduceTskPort();
									tskPort.setName(pp_name);
									tskPort.setId(Integer.parseInt(pp_id));
									tskPort.setId_component(Integer.parseInt(pp_id_component));
									for(Element action:pp_child.getChildren()){
										if(action.getName().equals("action")){
											String action_name = action.getAttributeValue("name");
											String action_id = action.getAttributeValue("id");
											MapReduceAction actionObj = new MapReduceAction();
											actionObj.setId(Integer.parseInt(action_id));
											actionObj.setName(action_name);
											tskPort.addAction(actionObj);
										}
									}
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

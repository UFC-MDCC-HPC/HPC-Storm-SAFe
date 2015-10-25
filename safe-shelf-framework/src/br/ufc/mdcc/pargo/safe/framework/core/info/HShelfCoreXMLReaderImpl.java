package br.ufc.mdcc.pargo.safe.framework.core.info;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class HShelfCoreXMLReaderImpl implements IHShelfCoreXMLReader {

	@Override
	public HShelfComponentCoreInfo readComponent(String xmlRecords, String cid) {
		DocumentBuilder db;
		try {
			db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(xmlRecords));

			Document doc = db.parse(is);
		    NodeList nodes = doc.getElementsByTagName("component");
		    for (int i = 0; i < nodes.getLength(); i++) {
		        Element element = (Element) nodes.item(i);
		        String id = element.getAttribute("id");
		        if(id.equals(cid)){
		        	HShelfComponentCoreInfo component = new HShelfComponentCoreInfo();
		        	component.setId(cid);
		        	component.setName(element.getAttribute("name"));
		        	NodeList ports = element.getChildNodes();
		        	for (int j = 0; j < ports.getLength(); j++){
		        		 Element port = (Element) ports.item(j);
		        		 HShelfPortCoreInfo portInfo = new HShelfPortCoreInfo();
		        		 portInfo.setID(port.getAttribute("id"));
		        		 portInfo.setName(port.getAttribute("name"));
		        		 portInfo.setURL(port.getAttribute("url"));
		        		 component.addPortInfor(portInfo);
		        	}
		        	return component;
		        }
		    }

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	
}

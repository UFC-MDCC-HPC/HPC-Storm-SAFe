package br.ufc.mdcc.pargo.safe.grammar.util;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLManipulator {

	

	public static void changeComponentAddressAtt(String xmlPath, String name, String address){
		
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

		DocumentBuilder documentBuilder;
		try {
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(xmlPath);
			
			NodeList platforms = document.getElementsByTagName("tns:platform");
			for(int i=0;i<platforms.getLength();i++){
				Element plataform = (Element)platforms.item(i);
				
				if(plataform.getAttribute("name").equals(name)){
					plataform.setAttribute("address", address);
					break;
				}
			}
			
			NodeList connectors = document.getElementsByTagName("tns:connector");
			for(int i=0;i<connectors.getLength();i++){
				Element connector = (Element)connectors.item(i);
				if(connector.getAttribute("name").equals(name)){
					connector.setAttribute("address", address);
					break;
				}
			}
			
			NodeList computations = document.getElementsByTagName("tns:computation");
			for(int i=0;i<computations.getLength();i++){
				Element computation = (Element)computations.item(i);
				if(computation.getAttribute("name").equals(name)){
					computation.setAttribute("address", address);
					break;
				}
			}
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();

			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(document);

			StreamResult streamResult = new StreamResult(new File(xmlPath));
			transformer.transform(domSource, streamResult);
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}
	
	public static void main(String[] args) {
		String xmlPath = "/home/jefferson/Workspaces/workspace-luna/safe-shelf-framework-mr-app/src/xml/mr-arch-novo.xml";
		changeComponentAddressAtt(xmlPath, "1000", "novo-endereco");
	}
	
}

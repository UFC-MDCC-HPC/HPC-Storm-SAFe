package br.ufc.mdcc.pargo.safe.grammar;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

import br.ufc.mdcc.pargo.safe.util.SAFeConstants;

public class SAFeSWLValidator {

	private String archXSD = SAFeConstants.ARCH_XSD;
	private String orchesXSD = SAFeConstants.FLOW_XSD;
	
	public boolean validateXMLArchitecture(String xmlFile){
		boolean result = true;
		try {
			URL schemaFile = this.getClass().getResource(archXSD);
			Source xmlFileSrc = new StreamSource(new File(xmlFile));
			SchemaFactory schemaFactory = SchemaFactory
					.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = schemaFactory.newSchema(schemaFile);
			Validator validator = schema.newValidator();
			validator.validate(xmlFileSrc);
		} catch (MalformedURLException e) {
			result = false;
			e.printStackTrace();
		} catch (SAXException e) {
			result = false;
			e.printStackTrace();
		} catch (IOException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean validateXMLOrchestration(String xmlFile){
		boolean result = true;
		try {
			URL schemaFile = this.getClass().getResource(orchesXSD);
			Source xmlFileSrc = new StreamSource(new File(xmlFile));
			SchemaFactory schemaFactory = SchemaFactory
					.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = schemaFactory.newSchema(schemaFile);
			Validator validator = schema.newValidator();
			validator.validate(xmlFileSrc);
		} catch (MalformedURLException e) {
			result = false;
			e.printStackTrace();
		} catch (SAXException e) {
			result = false;
			e.printStackTrace();
		} catch (IOException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}
}

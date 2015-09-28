//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2015.09.22 às 08:32:28 AM BRT 
//


package br.ufc.mdcc.pargo.safe.grammar.flow;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.ufc.mdcc.pargo.safe.grammar.flow package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Workflow_QNAME = new QName("http://www.example.org/SAFe_workflow_V4", "workflow");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.ufc.mdcc.pargo.safe.grammar.flow
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ChoiceOperComplexType }
     * 
     */
    public ChoiceOperComplexType createChoiceOperComplexType() {
        return new ChoiceOperComplexType();
    }

    /**
     * Create an instance of {@link XMLSAFeOperation }
     * 
     */
    public XMLSAFeOperation createXMLSAFeOperation() {
        return new XMLSAFeOperation();
    }

    /**
     * Create an instance of {@link XMLSAFeAction }
     * 
     */
    public XMLSAFeAction createXMLSAFeAction() {
        return new XMLSAFeAction();
    }

    /**
     * Create an instance of {@link XMLSAFeCompOper }
     * 
     */
    public XMLSAFeCompOper createXMLSAFeCompOper() {
        return new XMLSAFeCompOper();
    }

    /**
     * Create an instance of {@link XMLSAFePrimOper }
     * 
     */
    public XMLSAFePrimOper createXMLSAFePrimOper() {
        return new XMLSAFePrimOper();
    }

    /**
     * Create an instance of {@link XMLSAFeBase }
     * 
     */
    public XMLSAFeBase createXMLSAFeBase() {
        return new XMLSAFeBase();
    }

    /**
     * Create an instance of {@link ChoiceOperComplexType.Select }
     * 
     */
    public ChoiceOperComplexType.Select createChoiceOperComplexTypeSelect() {
        return new ChoiceOperComplexType.Select();
    }

    /**
     * Create an instance of {@link XMLSAFeOperation.IterateOper }
     * 
     */
    public XMLSAFeOperation.IterateOper createXMLSAFeOperationIterateOper() {
        return new XMLSAFeOperation.IterateOper();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLSAFeOperation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/SAFe_workflow_V4", name = "workflow")
    public JAXBElement<XMLSAFeOperation> createWorkflow(XMLSAFeOperation value) {
        return new JAXBElement<XMLSAFeOperation>(_Workflow_QNAME, XMLSAFeOperation.class, null, value);
    }

}

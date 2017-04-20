//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2017.04.20 às 06:33:11 PM BRT 
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

    private final static QName _Workflow_QNAME = new QName("http://www.example.org/SAFe_workflow_V6", "workflow");
    private final static QName _SAFeSWLOperationManyTypeChoice_QNAME = new QName("http://www.example.org/SAFe_workflow_V6", "choice");
    private final static QName _SAFeSWLOperationManyTypeIterate_QNAME = new QName("http://www.example.org/SAFe_workflow_V6", "iterate");
    private final static QName _SAFeSWLOperationManyTypeStart_QNAME = new QName("http://www.example.org/SAFe_workflow_V6", "start");
    private final static QName _SAFeSWLOperationManyTypeSkip_QNAME = new QName("http://www.example.org/SAFe_workflow_V6", "skip");
    private final static QName _SAFeSWLOperationManyTypeInvoke_QNAME = new QName("http://www.example.org/SAFe_workflow_V6", "invoke");
    private final static QName _SAFeSWLOperationManyTypeBreak_QNAME = new QName("http://www.example.org/SAFe_workflow_V6", "break");
    private final static QName _SAFeSWLOperationManyTypeParallel_QNAME = new QName("http://www.example.org/SAFe_workflow_V6", "parallel");
    private final static QName _SAFeSWLOperationManyTypeContinue_QNAME = new QName("http://www.example.org/SAFe_workflow_V6", "continue");
    private final static QName _SAFeSWLOperationManyTypeCancel_QNAME = new QName("http://www.example.org/SAFe_workflow_V6", "cancel");
    private final static QName _SAFeSWLOperationManyTypeSequence_QNAME = new QName("http://www.example.org/SAFe_workflow_V6", "sequence");
    private final static QName _SAFeSWLOperationManyTypeWait_QNAME = new QName("http://www.example.org/SAFe_workflow_V6", "wait");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.ufc.mdcc.pargo.safe.grammar.flow
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SAFeSWLOperationManyType }
     * 
     */
    public SAFeSWLOperationManyType createSAFeSWLOperationManyType() {
        return new SAFeSWLOperationManyType();
    }

    /**
     * Create an instance of {@link SAFeSWLOperationAnyType }
     * 
     */
    public SAFeSWLOperationAnyType createSAFeSWLOperationAnyType() {
        return new SAFeSWLOperationAnyType();
    }

    /**
     * Create an instance of {@link SAFeSWLOperationPrimitiveType }
     * 
     */
    public SAFeSWLOperationPrimitiveType createSAFeSWLOperationPrimitiveType() {
        return new SAFeSWLOperationPrimitiveType();
    }

    /**
     * Create an instance of {@link SAFeSWLOperationPrimitiveInvokeActionAsyncType }
     * 
     */
    public SAFeSWLOperationPrimitiveInvokeActionAsyncType createSAFeSWLOperationPrimitiveInvokeActionAsyncType() {
        return new SAFeSWLOperationPrimitiveInvokeActionAsyncType();
    }

    /**
     * Create an instance of {@link SAFeSWLOperationPrimitiveInvokeActionType }
     * 
     */
    public SAFeSWLOperationPrimitiveInvokeActionType createSAFeSWLOperationPrimitiveInvokeActionType() {
        return new SAFeSWLOperationPrimitiveInvokeActionType();
    }

    /**
     * Create an instance of {@link SAFeSWLSelectionGuardType }
     * 
     */
    public SAFeSWLSelectionGuardType createSAFeSWLSelectionGuardType() {
        return new SAFeSWLSelectionGuardType();
    }

    /**
     * Create an instance of {@link SAFeSWLOperationBaseType }
     * 
     */
    public SAFeSWLOperationBaseType createSAFeSWLOperationBaseType() {
        return new SAFeSWLOperationBaseType();
    }

    /**
     * Create an instance of {@link SAFeSWLOperationChoiceType }
     * 
     */
    public SAFeSWLOperationChoiceType createSAFeSWLOperationChoiceType() {
        return new SAFeSWLOperationChoiceType();
    }

    /**
     * Create an instance of {@link SAFeSWLOperationManyType.Iterate }
     * 
     */
    public SAFeSWLOperationManyType.Iterate createSAFeSWLOperationManyTypeIterate() {
        return new SAFeSWLOperationManyType.Iterate();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SAFeSWLOperationAnyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/SAFe_workflow_V6", name = "workflow")
    public JAXBElement<SAFeSWLOperationAnyType> createWorkflow(SAFeSWLOperationAnyType value) {
        return new JAXBElement<SAFeSWLOperationAnyType>(_Workflow_QNAME, SAFeSWLOperationAnyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SAFeSWLOperationChoiceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/SAFe_workflow_V6", name = "choice", scope = SAFeSWLOperationManyType.class)
    public JAXBElement<SAFeSWLOperationChoiceType> createSAFeSWLOperationManyTypeChoice(SAFeSWLOperationChoiceType value) {
        return new JAXBElement<SAFeSWLOperationChoiceType>(_SAFeSWLOperationManyTypeChoice_QNAME, SAFeSWLOperationChoiceType.class, SAFeSWLOperationManyType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SAFeSWLOperationManyType.Iterate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/SAFe_workflow_V6", name = "iterate", scope = SAFeSWLOperationManyType.class)
    public JAXBElement<SAFeSWLOperationManyType.Iterate> createSAFeSWLOperationManyTypeIterate(SAFeSWLOperationManyType.Iterate value) {
        return new JAXBElement<SAFeSWLOperationManyType.Iterate>(_SAFeSWLOperationManyTypeIterate_QNAME, SAFeSWLOperationManyType.Iterate.class, SAFeSWLOperationManyType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SAFeSWLOperationPrimitiveInvokeActionAsyncType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/SAFe_workflow_V6", name = "start", scope = SAFeSWLOperationManyType.class)
    public JAXBElement<SAFeSWLOperationPrimitiveInvokeActionAsyncType> createSAFeSWLOperationManyTypeStart(SAFeSWLOperationPrimitiveInvokeActionAsyncType value) {
        return new JAXBElement<SAFeSWLOperationPrimitiveInvokeActionAsyncType>(_SAFeSWLOperationManyTypeStart_QNAME, SAFeSWLOperationPrimitiveInvokeActionAsyncType.class, SAFeSWLOperationManyType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SAFeSWLOperationBaseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/SAFe_workflow_V6", name = "skip", scope = SAFeSWLOperationManyType.class)
    public JAXBElement<SAFeSWLOperationBaseType> createSAFeSWLOperationManyTypeSkip(SAFeSWLOperationBaseType value) {
        return new JAXBElement<SAFeSWLOperationBaseType>(_SAFeSWLOperationManyTypeSkip_QNAME, SAFeSWLOperationBaseType.class, SAFeSWLOperationManyType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SAFeSWLOperationPrimitiveInvokeActionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/SAFe_workflow_V6", name = "invoke", scope = SAFeSWLOperationManyType.class)
    public JAXBElement<SAFeSWLOperationPrimitiveInvokeActionType> createSAFeSWLOperationManyTypeInvoke(SAFeSWLOperationPrimitiveInvokeActionType value) {
        return new JAXBElement<SAFeSWLOperationPrimitiveInvokeActionType>(_SAFeSWLOperationManyTypeInvoke_QNAME, SAFeSWLOperationPrimitiveInvokeActionType.class, SAFeSWLOperationManyType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SAFeSWLOperationBaseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/SAFe_workflow_V6", name = "break", scope = SAFeSWLOperationManyType.class)
    public JAXBElement<SAFeSWLOperationBaseType> createSAFeSWLOperationManyTypeBreak(SAFeSWLOperationBaseType value) {
        return new JAXBElement<SAFeSWLOperationBaseType>(_SAFeSWLOperationManyTypeBreak_QNAME, SAFeSWLOperationBaseType.class, SAFeSWLOperationManyType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SAFeSWLOperationManyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/SAFe_workflow_V6", name = "parallel", scope = SAFeSWLOperationManyType.class)
    public JAXBElement<SAFeSWLOperationManyType> createSAFeSWLOperationManyTypeParallel(SAFeSWLOperationManyType value) {
        return new JAXBElement<SAFeSWLOperationManyType>(_SAFeSWLOperationManyTypeParallel_QNAME, SAFeSWLOperationManyType.class, SAFeSWLOperationManyType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SAFeSWLOperationBaseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/SAFe_workflow_V6", name = "continue", scope = SAFeSWLOperationManyType.class)
    public JAXBElement<SAFeSWLOperationBaseType> createSAFeSWLOperationManyTypeContinue(SAFeSWLOperationBaseType value) {
        return new JAXBElement<SAFeSWLOperationBaseType>(_SAFeSWLOperationManyTypeContinue_QNAME, SAFeSWLOperationBaseType.class, SAFeSWLOperationManyType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SAFeSWLOperationPrimitiveInvokeActionAsyncType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/SAFe_workflow_V6", name = "cancel", scope = SAFeSWLOperationManyType.class)
    public JAXBElement<SAFeSWLOperationPrimitiveInvokeActionAsyncType> createSAFeSWLOperationManyTypeCancel(SAFeSWLOperationPrimitiveInvokeActionAsyncType value) {
        return new JAXBElement<SAFeSWLOperationPrimitiveInvokeActionAsyncType>(_SAFeSWLOperationManyTypeCancel_QNAME, SAFeSWLOperationPrimitiveInvokeActionAsyncType.class, SAFeSWLOperationManyType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SAFeSWLOperationManyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/SAFe_workflow_V6", name = "sequence", scope = SAFeSWLOperationManyType.class)
    public JAXBElement<SAFeSWLOperationManyType> createSAFeSWLOperationManyTypeSequence(SAFeSWLOperationManyType value) {
        return new JAXBElement<SAFeSWLOperationManyType>(_SAFeSWLOperationManyTypeSequence_QNAME, SAFeSWLOperationManyType.class, SAFeSWLOperationManyType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SAFeSWLOperationPrimitiveInvokeActionAsyncType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/SAFe_workflow_V6", name = "wait", scope = SAFeSWLOperationManyType.class)
    public JAXBElement<SAFeSWLOperationPrimitiveInvokeActionAsyncType> createSAFeSWLOperationManyTypeWait(SAFeSWLOperationPrimitiveInvokeActionAsyncType value) {
        return new JAXBElement<SAFeSWLOperationPrimitiveInvokeActionAsyncType>(_SAFeSWLOperationManyTypeWait_QNAME, SAFeSWLOperationPrimitiveInvokeActionAsyncType.class, SAFeSWLOperationManyType.class, value);
    }

}

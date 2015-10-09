
package br.ufc.mdcc.pargo.safe.sample.wspc.stubs.client.task;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.ufc.mdcc.pargo.safe.sample.wspc.stubs.client.task package. 
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

    private final static QName _Initialize_QNAME = new QName("http://client.pc.backend.safe.pargo.mdcc.ufc.br/", "initialize");
    private final static QName _SetServerPort_QNAME = new QName("http://client.pc.backend.safe.pargo.mdcc.ufc.br/", "setServerPort");
    private final static QName _SetServerPortResponse_QNAME = new QName("http://client.pc.backend.safe.pargo.mdcc.ufc.br/", "setServerPortResponse");
    private final static QName _InitializeResponse_QNAME = new QName("http://client.pc.backend.safe.pargo.mdcc.ufc.br/", "initializeResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.ufc.mdcc.pargo.safe.sample.wspc.stubs.client.task
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InitializeResponse }
     * 
     */
    public InitializeResponse createInitializeResponse() {
        return new InitializeResponse();
    }

    /**
     * Create an instance of {@link Initialize }
     * 
     */
    public Initialize createInitialize() {
        return new Initialize();
    }

    /**
     * Create an instance of {@link SetServerPort }
     * 
     */
    public SetServerPort createSetServerPort() {
        return new SetServerPort();
    }

    /**
     * Create an instance of {@link SetServerPortResponse }
     * 
     */
    public SetServerPortResponse createSetServerPortResponse() {
        return new SetServerPortResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Initialize }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client.pc.backend.safe.pargo.mdcc.ufc.br/", name = "initialize")
    public JAXBElement<Initialize> createInitialize(Initialize value) {
        return new JAXBElement<Initialize>(_Initialize_QNAME, Initialize.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetServerPort }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client.pc.backend.safe.pargo.mdcc.ufc.br/", name = "setServerPort")
    public JAXBElement<SetServerPort> createSetServerPort(SetServerPort value) {
        return new JAXBElement<SetServerPort>(_SetServerPort_QNAME, SetServerPort.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetServerPortResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client.pc.backend.safe.pargo.mdcc.ufc.br/", name = "setServerPortResponse")
    public JAXBElement<SetServerPortResponse> createSetServerPortResponse(SetServerPortResponse value) {
        return new JAXBElement<SetServerPortResponse>(_SetServerPortResponse_QNAME, SetServerPortResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InitializeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client.pc.backend.safe.pargo.mdcc.ufc.br/", name = "initializeResponse")
    public JAXBElement<InitializeResponse> createInitializeResponse(InitializeResponse value) {
        return new JAXBElement<InitializeResponse>(_InitializeResponse_QNAME, InitializeResponse.class, null, value);
    }

}

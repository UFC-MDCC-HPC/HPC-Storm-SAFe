
package br.ufc.mdcc.pargo.safe.sample.stubs.client.env;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.ufc.mdcc.pargo.safe.sample.stubs.client.env package. 
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

    private final static QName _AddMesssageToBufferResponse_QNAME = new QName("http://env.port.client.backend.pargo.mdcc.ufc.br/", "addMesssageToBufferResponse");
    private final static QName _AddMesssageToBuffer_QNAME = new QName("http://env.port.client.backend.pargo.mdcc.ufc.br/", "addMesssageToBuffer");
    private final static QName _SetServerPortResponse_QNAME = new QName("http://env.port.client.backend.pargo.mdcc.ufc.br/", "setServerPortResponse");
    private final static QName _SetServerPort_QNAME = new QName("http://env.port.client.backend.pargo.mdcc.ufc.br/", "setServerPort");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.ufc.mdcc.pargo.safe.sample.stubs.client.env
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddMesssageToBufferResponse }
     * 
     */
    public AddMesssageToBufferResponse createAddMesssageToBufferResponse() {
        return new AddMesssageToBufferResponse();
    }

    /**
     * Create an instance of {@link SetServerPort }
     * 
     */
    public SetServerPort createSetServerPort() {
        return new SetServerPort();
    }

    /**
     * Create an instance of {@link AddMesssageToBuffer }
     * 
     */
    public AddMesssageToBuffer createAddMesssageToBuffer() {
        return new AddMesssageToBuffer();
    }

    /**
     * Create an instance of {@link SetServerPortResponse }
     * 
     */
    public SetServerPortResponse createSetServerPortResponse() {
        return new SetServerPortResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddMesssageToBufferResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://env.port.client.backend.pargo.mdcc.ufc.br/", name = "addMesssageToBufferResponse")
    public JAXBElement<AddMesssageToBufferResponse> createAddMesssageToBufferResponse(AddMesssageToBufferResponse value) {
        return new JAXBElement<AddMesssageToBufferResponse>(_AddMesssageToBufferResponse_QNAME, AddMesssageToBufferResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddMesssageToBuffer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://env.port.client.backend.pargo.mdcc.ufc.br/", name = "addMesssageToBuffer")
    public JAXBElement<AddMesssageToBuffer> createAddMesssageToBuffer(AddMesssageToBuffer value) {
        return new JAXBElement<AddMesssageToBuffer>(_AddMesssageToBuffer_QNAME, AddMesssageToBuffer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetServerPortResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://env.port.client.backend.pargo.mdcc.ufc.br/", name = "setServerPortResponse")
    public JAXBElement<SetServerPortResponse> createSetServerPortResponse(SetServerPortResponse value) {
        return new JAXBElement<SetServerPortResponse>(_SetServerPortResponse_QNAME, SetServerPortResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetServerPort }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://env.port.client.backend.pargo.mdcc.ufc.br/", name = "setServerPort")
    public JAXBElement<SetServerPort> createSetServerPort(SetServerPort value) {
        return new JAXBElement<SetServerPort>(_SetServerPort_QNAME, SetServerPort.class, null, value);
    }

}


package br.ufc.mdcc.pargo.safe.sample.stubs.server.env;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.ufc.mdcc.pargo.safe.sample.stubs.server.env package. 
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

    private final static QName _SendMessageToApplication_QNAME = new QName("http://env.port.server.safe.pargo.mdcc.ufc.br/", "sendMessageToApplication");
    private final static QName _SetPortResponse_QNAME = new QName("http://env.port.server.safe.pargo.mdcc.ufc.br/", "setPortResponse");
    private final static QName _SendMessageToApplicationResponse_QNAME = new QName("http://env.port.server.safe.pargo.mdcc.ufc.br/", "sendMessageToApplicationResponse");
    private final static QName _SetPort_QNAME = new QName("http://env.port.server.safe.pargo.mdcc.ufc.br/", "setPort");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.ufc.mdcc.pargo.safe.sample.stubs.server.env
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SendMessageToApplication }
     * 
     */
    public SendMessageToApplication createSendMessageToApplication() {
        return new SendMessageToApplication();
    }

    /**
     * Create an instance of {@link SetPortResponse }
     * 
     */
    public SetPortResponse createSetPortResponse() {
        return new SetPortResponse();
    }

    /**
     * Create an instance of {@link SendMessageToApplicationResponse }
     * 
     */
    public SendMessageToApplicationResponse createSendMessageToApplicationResponse() {
        return new SendMessageToApplicationResponse();
    }

    /**
     * Create an instance of {@link SetPort }
     * 
     */
    public SetPort createSetPort() {
        return new SetPort();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendMessageToApplication }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://env.port.server.safe.pargo.mdcc.ufc.br/", name = "sendMessageToApplication")
    public JAXBElement<SendMessageToApplication> createSendMessageToApplication(SendMessageToApplication value) {
        return new JAXBElement<SendMessageToApplication>(_SendMessageToApplication_QNAME, SendMessageToApplication.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetPortResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://env.port.server.safe.pargo.mdcc.ufc.br/", name = "setPortResponse")
    public JAXBElement<SetPortResponse> createSetPortResponse(SetPortResponse value) {
        return new JAXBElement<SetPortResponse>(_SetPortResponse_QNAME, SetPortResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendMessageToApplicationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://env.port.server.safe.pargo.mdcc.ufc.br/", name = "sendMessageToApplicationResponse")
    public JAXBElement<SendMessageToApplicationResponse> createSendMessageToApplicationResponse(SendMessageToApplicationResponse value) {
        return new JAXBElement<SendMessageToApplicationResponse>(_SendMessageToApplicationResponse_QNAME, SendMessageToApplicationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetPort }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://env.port.server.safe.pargo.mdcc.ufc.br/", name = "setPort")
    public JAXBElement<SetPort> createSetPort(SetPort value) {
        return new JAXBElement<SetPort>(_SetPort_QNAME, SetPort.class, null, value);
    }

}

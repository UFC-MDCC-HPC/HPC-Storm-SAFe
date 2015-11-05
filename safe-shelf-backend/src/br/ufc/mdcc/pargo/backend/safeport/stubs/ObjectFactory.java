
package br.ufc.mdcc.pargo.backend.safeport.stubs;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.ufc.mdcc.pargo.backend.safeport.stubs package. 
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

    private final static QName _RequestMessageResponse_QNAME = new QName("http://service.sample.safe.pargo.mdcc.ufc.br/", "requestMessageResponse");
    private final static QName _SendMessageResponse_QNAME = new QName("http://service.sample.safe.pargo.mdcc.ufc.br/", "sendMessageResponse");
    private final static QName _SetApplicationPortResponse_QNAME = new QName("http://service.sample.safe.pargo.mdcc.ufc.br/", "setApplicationPortResponse");
    private final static QName _SendMessage_QNAME = new QName("http://service.sample.safe.pargo.mdcc.ufc.br/", "sendMessage");
    private final static QName _RequestMessage_QNAME = new QName("http://service.sample.safe.pargo.mdcc.ufc.br/", "requestMessage");
    private final static QName _SetApplicationPort_QNAME = new QName("http://service.sample.safe.pargo.mdcc.ufc.br/", "setApplicationPort");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.ufc.mdcc.pargo.backend.safeport.stubs
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RequestMessage }
     * 
     */
    public RequestMessage createRequestMessage() {
        return new RequestMessage();
    }

    /**
     * Create an instance of {@link SetApplicationPort }
     * 
     */
    public SetApplicationPort createSetApplicationPort() {
        return new SetApplicationPort();
    }

    /**
     * Create an instance of {@link SendMessage }
     * 
     */
    public SendMessage createSendMessage() {
        return new SendMessage();
    }

    /**
     * Create an instance of {@link SetApplicationPortResponse }
     * 
     */
    public SetApplicationPortResponse createSetApplicationPortResponse() {
        return new SetApplicationPortResponse();
    }

    /**
     * Create an instance of {@link RequestMessageResponse }
     * 
     */
    public RequestMessageResponse createRequestMessageResponse() {
        return new RequestMessageResponse();
    }

    /**
     * Create an instance of {@link SendMessageResponse }
     * 
     */
    public SendMessageResponse createSendMessageResponse() {
        return new SendMessageResponse();
    }

    /**
     * Create an instance of {@link ClientServerApplicationPort }
     * 
     */
    public ClientServerApplicationPort createClientServerApplicationPort() {
        return new ClientServerApplicationPort();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestMessageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sample.safe.pargo.mdcc.ufc.br/", name = "requestMessageResponse")
    public JAXBElement<RequestMessageResponse> createRequestMessageResponse(RequestMessageResponse value) {
        return new JAXBElement<RequestMessageResponse>(_RequestMessageResponse_QNAME, RequestMessageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendMessageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sample.safe.pargo.mdcc.ufc.br/", name = "sendMessageResponse")
    public JAXBElement<SendMessageResponse> createSendMessageResponse(SendMessageResponse value) {
        return new JAXBElement<SendMessageResponse>(_SendMessageResponse_QNAME, SendMessageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetApplicationPortResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sample.safe.pargo.mdcc.ufc.br/", name = "setApplicationPortResponse")
    public JAXBElement<SetApplicationPortResponse> createSetApplicationPortResponse(SetApplicationPortResponse value) {
        return new JAXBElement<SetApplicationPortResponse>(_SetApplicationPortResponse_QNAME, SetApplicationPortResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendMessage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sample.safe.pargo.mdcc.ufc.br/", name = "sendMessage")
    public JAXBElement<SendMessage> createSendMessage(SendMessage value) {
        return new JAXBElement<SendMessage>(_SendMessage_QNAME, SendMessage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestMessage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sample.safe.pargo.mdcc.ufc.br/", name = "requestMessage")
    public JAXBElement<RequestMessage> createRequestMessage(RequestMessage value) {
        return new JAXBElement<RequestMessage>(_RequestMessage_QNAME, RequestMessage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetApplicationPort }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sample.safe.pargo.mdcc.ufc.br/", name = "setApplicationPort")
    public JAXBElement<SetApplicationPort> createSetApplicationPort(SetApplicationPort value) {
        return new JAXBElement<SetApplicationPort>(_SetApplicationPort_QNAME, SetApplicationPort.class, null, value);
    }

}

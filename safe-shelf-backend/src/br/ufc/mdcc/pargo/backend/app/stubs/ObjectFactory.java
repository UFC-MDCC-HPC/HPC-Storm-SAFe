
package br.ufc.mdcc.pargo.backend.app.stubs;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.ufc.mdcc.pargo.backend.app.stubs package. 
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

    private final static QName _RequestMessageResponse_QNAME = new QName("http://services.application.sample.safe.pargo.mdcc.ufc.br/", "requestMessageResponse");
    private final static QName _RequestMessage_QNAME = new QName("http://services.application.sample.safe.pargo.mdcc.ufc.br/", "requestMessage");
    private final static QName _ReceiveMessage_QNAME = new QName("http://services.application.sample.safe.pargo.mdcc.ufc.br/", "receiveMessage");
    private final static QName _ReceiveMessageResponse_QNAME = new QName("http://services.application.sample.safe.pargo.mdcc.ufc.br/", "receiveMessageResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.ufc.mdcc.pargo.backend.app.stubs
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
     * Create an instance of {@link ReceiveMessage }
     * 
     */
    public ReceiveMessage createReceiveMessage() {
        return new ReceiveMessage();
    }

    /**
     * Create an instance of {@link ReceiveMessageResponse }
     * 
     */
    public ReceiveMessageResponse createReceiveMessageResponse() {
        return new ReceiveMessageResponse();
    }

    /**
     * Create an instance of {@link RequestMessageResponse }
     * 
     */
    public RequestMessageResponse createRequestMessageResponse() {
        return new RequestMessageResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestMessageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.application.sample.safe.pargo.mdcc.ufc.br/", name = "requestMessageResponse")
    public JAXBElement<RequestMessageResponse> createRequestMessageResponse(RequestMessageResponse value) {
        return new JAXBElement<RequestMessageResponse>(_RequestMessageResponse_QNAME, RequestMessageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestMessage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.application.sample.safe.pargo.mdcc.ufc.br/", name = "requestMessage")
    public JAXBElement<RequestMessage> createRequestMessage(RequestMessage value) {
        return new JAXBElement<RequestMessage>(_RequestMessage_QNAME, RequestMessage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReceiveMessage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.application.sample.safe.pargo.mdcc.ufc.br/", name = "receiveMessage")
    public JAXBElement<ReceiveMessage> createReceiveMessage(ReceiveMessage value) {
        return new JAXBElement<ReceiveMessage>(_ReceiveMessage_QNAME, ReceiveMessage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReceiveMessageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.application.sample.safe.pargo.mdcc.ufc.br/", name = "receiveMessageResponse")
    public JAXBElement<ReceiveMessageResponse> createReceiveMessageResponse(ReceiveMessageResponse value) {
        return new JAXBElement<ReceiveMessageResponse>(_ReceiveMessageResponse_QNAME, ReceiveMessageResponse.class, null, value);
    }

}


package br.ufc.mdcc.pargo.backend.server.proxy.stubs;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.ufc.mdcc.pargo.backend.server.proxy.stubs package. 
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

    private final static QName _SendMessage_QNAME = new QName("http://service.server.sample.safe.pargo.mdcc.ufc.br/", "sendMessage");
    private final static QName _SendMessageResponse_QNAME = new QName("http://service.server.sample.safe.pargo.mdcc.ufc.br/", "sendMessageResponse");
    private final static QName _SetServerProxieResponse_QNAME = new QName("http://service.server.sample.safe.pargo.mdcc.ufc.br/", "setServerProxieResponse");
    private final static QName _SetServerProxie_QNAME = new QName("http://service.server.sample.safe.pargo.mdcc.ufc.br/", "setServerProxie");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.ufc.mdcc.pargo.backend.server.proxy.stubs
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SetServerProxie }
     * 
     */
    public SetServerProxie createSetServerProxie() {
        return new SetServerProxie();
    }

    /**
     * Create an instance of {@link SendMessage }
     * 
     */
    public SendMessage createSendMessage() {
        return new SendMessage();
    }

    /**
     * Create an instance of {@link SendMessageResponse }
     * 
     */
    public SendMessageResponse createSendMessageResponse() {
        return new SendMessageResponse();
    }

    /**
     * Create an instance of {@link SetServerProxieResponse }
     * 
     */
    public SetServerProxieResponse createSetServerProxieResponse() {
        return new SetServerProxieResponse();
    }

    /**
     * Create an instance of {@link ServerComponentProxie }
     * 
     */
    public ServerComponentProxie createServerComponentProxie() {
        return new ServerComponentProxie();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendMessage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.server.sample.safe.pargo.mdcc.ufc.br/", name = "sendMessage")
    public JAXBElement<SendMessage> createSendMessage(SendMessage value) {
        return new JAXBElement<SendMessage>(_SendMessage_QNAME, SendMessage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendMessageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.server.sample.safe.pargo.mdcc.ufc.br/", name = "sendMessageResponse")
    public JAXBElement<SendMessageResponse> createSendMessageResponse(SendMessageResponse value) {
        return new JAXBElement<SendMessageResponse>(_SendMessageResponse_QNAME, SendMessageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetServerProxieResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.server.sample.safe.pargo.mdcc.ufc.br/", name = "setServerProxieResponse")
    public JAXBElement<SetServerProxieResponse> createSetServerProxieResponse(SetServerProxieResponse value) {
        return new JAXBElement<SetServerProxieResponse>(_SetServerProxieResponse_QNAME, SetServerProxieResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetServerProxie }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.server.sample.safe.pargo.mdcc.ufc.br/", name = "setServerProxie")
    public JAXBElement<SetServerProxie> createSetServerProxie(SetServerProxie value) {
        return new JAXBElement<SetServerProxie>(_SetServerProxie_QNAME, SetServerProxie.class, null, value);
    }

}

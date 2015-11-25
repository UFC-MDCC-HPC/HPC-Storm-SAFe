
package br.ufc.mdcc.pargo.backend.client.proxy.stubs;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.ufc.mdcc.pargo.backend.client.proxy.stubs package. 
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

    private final static QName _SetClientProxieResponse_QNAME = new QName("http://service.client.sample.safe.pargo.mdcc.ufc.br/", "setClientProxieResponse");
    private final static QName _RequestMessageResponse_QNAME = new QName("http://service.client.sample.safe.pargo.mdcc.ufc.br/", "requestMessageResponse");
    private final static QName _SetClientProxie_QNAME = new QName("http://service.client.sample.safe.pargo.mdcc.ufc.br/", "setClientProxie");
    private final static QName _RequestMessage_QNAME = new QName("http://service.client.sample.safe.pargo.mdcc.ufc.br/", "requestMessage");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.ufc.mdcc.pargo.backend.client.proxy.stubs
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
     * Create an instance of {@link SetClientProxieResponse }
     * 
     */
    public SetClientProxieResponse createSetClientProxieResponse() {
        return new SetClientProxieResponse();
    }

    /**
     * Create an instance of {@link RequestMessageResponse }
     * 
     */
    public RequestMessageResponse createRequestMessageResponse() {
        return new RequestMessageResponse();
    }

    /**
     * Create an instance of {@link SetClientProxie }
     * 
     */
    public SetClientProxie createSetClientProxie() {
        return new SetClientProxie();
    }

    /**
     * Create an instance of {@link ClientComponentProxie }
     * 
     */
    public ClientComponentProxie createClientComponentProxie() {
        return new ClientComponentProxie();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetClientProxieResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.client.sample.safe.pargo.mdcc.ufc.br/", name = "setClientProxieResponse")
    public JAXBElement<SetClientProxieResponse> createSetClientProxieResponse(SetClientProxieResponse value) {
        return new JAXBElement<SetClientProxieResponse>(_SetClientProxieResponse_QNAME, SetClientProxieResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestMessageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.client.sample.safe.pargo.mdcc.ufc.br/", name = "requestMessageResponse")
    public JAXBElement<RequestMessageResponse> createRequestMessageResponse(RequestMessageResponse value) {
        return new JAXBElement<RequestMessageResponse>(_RequestMessageResponse_QNAME, RequestMessageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetClientProxie }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.client.sample.safe.pargo.mdcc.ufc.br/", name = "setClientProxie")
    public JAXBElement<SetClientProxie> createSetClientProxie(SetClientProxie value) {
        return new JAXBElement<SetClientProxie>(_SetClientProxie_QNAME, SetClientProxie.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestMessage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.client.sample.safe.pargo.mdcc.ufc.br/", name = "requestMessage")
    public JAXBElement<RequestMessage> createRequestMessage(RequestMessage value) {
        return new JAXBElement<RequestMessage>(_RequestMessage_QNAME, RequestMessage.class, null, value);
    }

}

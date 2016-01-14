
package br.ufc.safe.sample.stubs.app_1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.ufc.safe.sample.stubs.app_1 package. 
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

    private final static QName _ReturnMessage_QNAME = new QName("http://service.prt.app.sample.safe.ufc.br/", "returnMessage");
    private final static QName _ReturnMessageResponse_QNAME = new QName("http://service.prt.app.sample.safe.ufc.br/", "returnMessageResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.ufc.safe.sample.stubs.app_1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReturnMessage }
     * 
     */
    public ReturnMessage createReturnMessage() {
        return new ReturnMessage();
    }

    /**
     * Create an instance of {@link ReturnMessageResponse }
     * 
     */
    public ReturnMessageResponse createReturnMessageResponse() {
        return new ReturnMessageResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReturnMessage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.prt.app.sample.safe.ufc.br/", name = "returnMessage")
    public JAXBElement<ReturnMessage> createReturnMessage(ReturnMessage value) {
        return new JAXBElement<ReturnMessage>(_ReturnMessage_QNAME, ReturnMessage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReturnMessageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.prt.app.sample.safe.ufc.br/", name = "returnMessageResponse")
    public JAXBElement<ReturnMessageResponse> createReturnMessageResponse(ReturnMessageResponse value) {
        return new JAXBElement<ReturnMessageResponse>(_ReturnMessageResponse_QNAME, ReturnMessageResponse.class, null, value);
    }

}

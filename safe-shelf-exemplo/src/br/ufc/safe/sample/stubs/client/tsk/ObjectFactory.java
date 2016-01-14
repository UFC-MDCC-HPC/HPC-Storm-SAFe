
package br.ufc.safe.sample.stubs.client.tsk;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.ufc.safe.sample.stubs.client.tsk package. 
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

    private final static QName _SendResponse_QNAME = new QName("http://client.service.sample.safe.ufc.br/", "sendResponse");
    private final static QName _Send_QNAME = new QName("http://client.service.sample.safe.ufc.br/", "send");
    private final static QName _PostResponse_QNAME = new QName("http://client.service.sample.safe.ufc.br/", "postResponse");
    private final static QName _Post_QNAME = new QName("http://client.service.sample.safe.ufc.br/", "post");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.ufc.safe.sample.stubs.client.tsk
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PostResponse }
     * 
     */
    public PostResponse createPostResponse() {
        return new PostResponse();
    }

    /**
     * Create an instance of {@link Post }
     * 
     */
    public Post createPost() {
        return new Post();
    }

    /**
     * Create an instance of {@link SendResponse }
     * 
     */
    public SendResponse createSendResponse() {
        return new SendResponse();
    }

    /**
     * Create an instance of {@link Send }
     * 
     */
    public Send createSend() {
        return new Send();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client.service.sample.safe.ufc.br/", name = "sendResponse")
    public JAXBElement<SendResponse> createSendResponse(SendResponse value) {
        return new JAXBElement<SendResponse>(_SendResponse_QNAME, SendResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Send }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client.service.sample.safe.ufc.br/", name = "send")
    public JAXBElement<Send> createSend(Send value) {
        return new JAXBElement<Send>(_Send_QNAME, Send.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client.service.sample.safe.ufc.br/", name = "postResponse")
    public JAXBElement<PostResponse> createPostResponse(PostResponse value) {
        return new JAXBElement<PostResponse>(_PostResponse_QNAME, PostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Post }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client.service.sample.safe.ufc.br/", name = "post")
    public JAXBElement<Post> createPost(Post value) {
        return new JAXBElement<Post>(_Post_QNAME, Post.class, null, value);
    }

}

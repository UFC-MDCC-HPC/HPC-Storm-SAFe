
package br.ufc.mdcc.pargo.safe.sample.stubs.client.task;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.ufc.mdcc.pargo.safe.sample.stubs.client.task package. 
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

    private final static QName _PostResponse_QNAME = new QName("http://tsk.port.client.backend.pargo.mdcc.ufc.br/", "postResponse");
    private final static QName _ConnectResponse_QNAME = new QName("http://tsk.port.client.backend.pargo.mdcc.ufc.br/", "connectResponse");
    private final static QName _Post_QNAME = new QName("http://tsk.port.client.backend.pargo.mdcc.ufc.br/", "post");
    private final static QName _Connect_QNAME = new QName("http://tsk.port.client.backend.pargo.mdcc.ufc.br/", "connect");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.ufc.mdcc.pargo.safe.sample.stubs.client.task
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConnectResponse }
     * 
     */
    public ConnectResponse createConnectResponse() {
        return new ConnectResponse();
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
     * Create an instance of {@link Connect }
     * 
     */
    public Connect createConnect() {
        return new Connect();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tsk.port.client.backend.pargo.mdcc.ufc.br/", name = "postResponse")
    public JAXBElement<PostResponse> createPostResponse(PostResponse value) {
        return new JAXBElement<PostResponse>(_PostResponse_QNAME, PostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConnectResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tsk.port.client.backend.pargo.mdcc.ufc.br/", name = "connectResponse")
    public JAXBElement<ConnectResponse> createConnectResponse(ConnectResponse value) {
        return new JAXBElement<ConnectResponse>(_ConnectResponse_QNAME, ConnectResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Post }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tsk.port.client.backend.pargo.mdcc.ufc.br/", name = "post")
    public JAXBElement<Post> createPost(Post value) {
        return new JAXBElement<Post>(_Post_QNAME, Post.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Connect }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tsk.port.client.backend.pargo.mdcc.ufc.br/", name = "connect")
    public JAXBElement<Connect> createConnect(Connect value) {
        return new JAXBElement<Connect>(_Connect_QNAME, Connect.class, null, value);
    }

}

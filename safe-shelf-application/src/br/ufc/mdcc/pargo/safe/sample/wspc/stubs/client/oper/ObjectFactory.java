
package br.ufc.mdcc.pargo.safe.sample.wspc.stubs.client.oper;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.ufc.mdcc.pargo.safe.sample.wspc.stubs.client.oper package. 
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

    private final static QName _SendMsg_QNAME = new QName("http://client.pc.backend.safe.pargo.mdcc.ufc.br/", "sendMsg");
    private final static QName _SetServerPort_QNAME = new QName("http://client.pc.backend.safe.pargo.mdcc.ufc.br/", "setServerPort");
    private final static QName _SendMsgResponse_QNAME = new QName("http://client.pc.backend.safe.pargo.mdcc.ufc.br/", "sendMsgResponse");
    private final static QName _SetServerPortResponse_QNAME = new QName("http://client.pc.backend.safe.pargo.mdcc.ufc.br/", "setServerPortResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.ufc.mdcc.pargo.safe.sample.wspc.stubs.client.oper
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SendMsg }
     * 
     */
    public SendMsg createSendMsg() {
        return new SendMsg();
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
     * Create an instance of {@link SendMsgResponse }
     * 
     */
    public SendMsgResponse createSendMsgResponse() {
        return new SendMsgResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendMsg }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client.pc.backend.safe.pargo.mdcc.ufc.br/", name = "sendMsg")
    public JAXBElement<SendMsg> createSendMsg(SendMsg value) {
        return new JAXBElement<SendMsg>(_SendMsg_QNAME, SendMsg.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link SendMsgResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client.pc.backend.safe.pargo.mdcc.ufc.br/", name = "sendMsgResponse")
    public JAXBElement<SendMsgResponse> createSendMsgResponse(SendMsgResponse value) {
        return new JAXBElement<SendMsgResponse>(_SendMsgResponse_QNAME, SendMsgResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetServerPortResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://client.pc.backend.safe.pargo.mdcc.ufc.br/", name = "setServerPortResponse")
    public JAXBElement<SetServerPortResponse> createSetServerPortResponse(SetServerPortResponse value) {
        return new JAXBElement<SetServerPortResponse>(_SetServerPortResponse_QNAME, SetServerPortResponse.class, null, value);
    }

}

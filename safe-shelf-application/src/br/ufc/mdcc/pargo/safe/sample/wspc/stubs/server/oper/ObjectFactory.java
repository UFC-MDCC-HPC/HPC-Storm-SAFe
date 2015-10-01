
package br.ufc.mdcc.pargo.safe.sample.wspc.stubs.server.oper;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.ufc.mdcc.pargo.safe.sample.wspc.stubs.server.oper package. 
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

    private final static QName _GetMsg_QNAME = new QName("http://server.pc.backend.safe.pargo.mdcc.ufc.br/", "getMsg");
    private final static QName _GetMsgResponse_QNAME = new QName("http://server.pc.backend.safe.pargo.mdcc.ufc.br/", "getMsgResponse");
    private final static QName _SetPortResponse_QNAME = new QName("http://server.pc.backend.safe.pargo.mdcc.ufc.br/", "setPortResponse");
    private final static QName _SetPort_QNAME = new QName("http://server.pc.backend.safe.pargo.mdcc.ufc.br/", "setPort");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.ufc.mdcc.pargo.safe.sample.wspc.stubs.server.oper
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SetPortResponse }
     * 
     */
    public SetPortResponse createSetPortResponse() {
        return new SetPortResponse();
    }

    /**
     * Create an instance of {@link GetMsgResponse }
     * 
     */
    public GetMsgResponse createGetMsgResponse() {
        return new GetMsgResponse();
    }

    /**
     * Create an instance of {@link GetMsg }
     * 
     */
    public GetMsg createGetMsg() {
        return new GetMsg();
    }

    /**
     * Create an instance of {@link SetPort }
     * 
     */
    public SetPort createSetPort() {
        return new SetPort();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMsg }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.pc.backend.safe.pargo.mdcc.ufc.br/", name = "getMsg")
    public JAXBElement<GetMsg> createGetMsg(GetMsg value) {
        return new JAXBElement<GetMsg>(_GetMsg_QNAME, GetMsg.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMsgResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.pc.backend.safe.pargo.mdcc.ufc.br/", name = "getMsgResponse")
    public JAXBElement<GetMsgResponse> createGetMsgResponse(GetMsgResponse value) {
        return new JAXBElement<GetMsgResponse>(_GetMsgResponse_QNAME, GetMsgResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetPortResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.pc.backend.safe.pargo.mdcc.ufc.br/", name = "setPortResponse")
    public JAXBElement<SetPortResponse> createSetPortResponse(SetPortResponse value) {
        return new JAXBElement<SetPortResponse>(_SetPortResponse_QNAME, SetPortResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetPort }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.pc.backend.safe.pargo.mdcc.ufc.br/", name = "setPort")
    public JAXBElement<SetPort> createSetPort(SetPort value) {
        return new JAXBElement<SetPort>(_SetPort_QNAME, SetPort.class, null, value);
    }

}

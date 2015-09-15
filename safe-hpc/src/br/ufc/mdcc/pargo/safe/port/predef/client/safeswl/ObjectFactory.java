
package br.ufc.mdcc.pargo.safe.port.predef.client.safeswl;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.ufc.mdcc.pargo.safe.port.predef.client.safeswl package. 
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

    private final static QName _GetFlowXMLLocation_QNAME = new QName("http://predef.port.safe.pargo.mdcc.ufc.br/", "getFlowXMLLocation");
    private final static QName _GetFlowXMLSourceCode_QNAME = new QName("http://predef.port.safe.pargo.mdcc.ufc.br/", "getFlowXMLSourceCode");
    private final static QName _GetId_QNAME = new QName("http://predef.port.safe.pargo.mdcc.ufc.br/", "getId");
    private final static QName _GetFlowXMLLocationResponse_QNAME = new QName("http://predef.port.safe.pargo.mdcc.ufc.br/", "getFlowXMLLocationResponse");
    private final static QName _GetFlowXMLSourceCodeResponse_QNAME = new QName("http://predef.port.safe.pargo.mdcc.ufc.br/", "getFlowXMLSourceCodeResponse");
    private final static QName _GetArchXMLLocation_QNAME = new QName("http://predef.port.safe.pargo.mdcc.ufc.br/", "getArchXMLLocation");
    private final static QName _GetIdResponse_QNAME = new QName("http://predef.port.safe.pargo.mdcc.ufc.br/", "getIdResponse");
    private final static QName _GetArchXMLSourceCode_QNAME = new QName("http://predef.port.safe.pargo.mdcc.ufc.br/", "getArchXMLSourceCode");
    private final static QName _GetName_QNAME = new QName("http://predef.port.safe.pargo.mdcc.ufc.br/", "getName");
    private final static QName _GetArchXMLSourceCodeResponse_QNAME = new QName("http://predef.port.safe.pargo.mdcc.ufc.br/", "getArchXMLSourceCodeResponse");
    private final static QName _GetNameResponse_QNAME = new QName("http://predef.port.safe.pargo.mdcc.ufc.br/", "getNameResponse");
    private final static QName _GetArchXMLLocationResponse_QNAME = new QName("http://predef.port.safe.pargo.mdcc.ufc.br/", "getArchXMLLocationResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.ufc.mdcc.pargo.safe.port.predef.client.safeswl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetArchXMLSourceCode }
     * 
     */
    public GetArchXMLSourceCode createGetArchXMLSourceCode() {
        return new GetArchXMLSourceCode();
    }

    /**
     * Create an instance of {@link GetName }
     * 
     */
    public GetName createGetName() {
        return new GetName();
    }

    /**
     * Create an instance of {@link GetArchXMLSourceCodeResponse }
     * 
     */
    public GetArchXMLSourceCodeResponse createGetArchXMLSourceCodeResponse() {
        return new GetArchXMLSourceCodeResponse();
    }

    /**
     * Create an instance of {@link GetArchXMLLocationResponse }
     * 
     */
    public GetArchXMLLocationResponse createGetArchXMLLocationResponse() {
        return new GetArchXMLLocationResponse();
    }

    /**
     * Create an instance of {@link GetNameResponse }
     * 
     */
    public GetNameResponse createGetNameResponse() {
        return new GetNameResponse();
    }

    /**
     * Create an instance of {@link GetFlowXMLLocation }
     * 
     */
    public GetFlowXMLLocation createGetFlowXMLLocation() {
        return new GetFlowXMLLocation();
    }

    /**
     * Create an instance of {@link GetFlowXMLSourceCode }
     * 
     */
    public GetFlowXMLSourceCode createGetFlowXMLSourceCode() {
        return new GetFlowXMLSourceCode();
    }

    /**
     * Create an instance of {@link GetId }
     * 
     */
    public GetId createGetId() {
        return new GetId();
    }

    /**
     * Create an instance of {@link GetFlowXMLLocationResponse }
     * 
     */
    public GetFlowXMLLocationResponse createGetFlowXMLLocationResponse() {
        return new GetFlowXMLLocationResponse();
    }

    /**
     * Create an instance of {@link GetFlowXMLSourceCodeResponse }
     * 
     */
    public GetFlowXMLSourceCodeResponse createGetFlowXMLSourceCodeResponse() {
        return new GetFlowXMLSourceCodeResponse();
    }

    /**
     * Create an instance of {@link GetIdResponse }
     * 
     */
    public GetIdResponse createGetIdResponse() {
        return new GetIdResponse();
    }

    /**
     * Create an instance of {@link GetArchXMLLocation }
     * 
     */
    public GetArchXMLLocation createGetArchXMLLocation() {
        return new GetArchXMLLocation();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFlowXMLLocation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://predef.port.safe.pargo.mdcc.ufc.br/", name = "getFlowXMLLocation")
    public JAXBElement<GetFlowXMLLocation> createGetFlowXMLLocation(GetFlowXMLLocation value) {
        return new JAXBElement<GetFlowXMLLocation>(_GetFlowXMLLocation_QNAME, GetFlowXMLLocation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFlowXMLSourceCode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://predef.port.safe.pargo.mdcc.ufc.br/", name = "getFlowXMLSourceCode")
    public JAXBElement<GetFlowXMLSourceCode> createGetFlowXMLSourceCode(GetFlowXMLSourceCode value) {
        return new JAXBElement<GetFlowXMLSourceCode>(_GetFlowXMLSourceCode_QNAME, GetFlowXMLSourceCode.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://predef.port.safe.pargo.mdcc.ufc.br/", name = "getId")
    public JAXBElement<GetId> createGetId(GetId value) {
        return new JAXBElement<GetId>(_GetId_QNAME, GetId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFlowXMLLocationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://predef.port.safe.pargo.mdcc.ufc.br/", name = "getFlowXMLLocationResponse")
    public JAXBElement<GetFlowXMLLocationResponse> createGetFlowXMLLocationResponse(GetFlowXMLLocationResponse value) {
        return new JAXBElement<GetFlowXMLLocationResponse>(_GetFlowXMLLocationResponse_QNAME, GetFlowXMLLocationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFlowXMLSourceCodeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://predef.port.safe.pargo.mdcc.ufc.br/", name = "getFlowXMLSourceCodeResponse")
    public JAXBElement<GetFlowXMLSourceCodeResponse> createGetFlowXMLSourceCodeResponse(GetFlowXMLSourceCodeResponse value) {
        return new JAXBElement<GetFlowXMLSourceCodeResponse>(_GetFlowXMLSourceCodeResponse_QNAME, GetFlowXMLSourceCodeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetArchXMLLocation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://predef.port.safe.pargo.mdcc.ufc.br/", name = "getArchXMLLocation")
    public JAXBElement<GetArchXMLLocation> createGetArchXMLLocation(GetArchXMLLocation value) {
        return new JAXBElement<GetArchXMLLocation>(_GetArchXMLLocation_QNAME, GetArchXMLLocation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://predef.port.safe.pargo.mdcc.ufc.br/", name = "getIdResponse")
    public JAXBElement<GetIdResponse> createGetIdResponse(GetIdResponse value) {
        return new JAXBElement<GetIdResponse>(_GetIdResponse_QNAME, GetIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetArchXMLSourceCode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://predef.port.safe.pargo.mdcc.ufc.br/", name = "getArchXMLSourceCode")
    public JAXBElement<GetArchXMLSourceCode> createGetArchXMLSourceCode(GetArchXMLSourceCode value) {
        return new JAXBElement<GetArchXMLSourceCode>(_GetArchXMLSourceCode_QNAME, GetArchXMLSourceCode.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://predef.port.safe.pargo.mdcc.ufc.br/", name = "getName")
    public JAXBElement<GetName> createGetName(GetName value) {
        return new JAXBElement<GetName>(_GetName_QNAME, GetName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetArchXMLSourceCodeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://predef.port.safe.pargo.mdcc.ufc.br/", name = "getArchXMLSourceCodeResponse")
    public JAXBElement<GetArchXMLSourceCodeResponse> createGetArchXMLSourceCodeResponse(GetArchXMLSourceCodeResponse value) {
        return new JAXBElement<GetArchXMLSourceCodeResponse>(_GetArchXMLSourceCodeResponse_QNAME, GetArchXMLSourceCodeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://predef.port.safe.pargo.mdcc.ufc.br/", name = "getNameResponse")
    public JAXBElement<GetNameResponse> createGetNameResponse(GetNameResponse value) {
        return new JAXBElement<GetNameResponse>(_GetNameResponse_QNAME, GetNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetArchXMLLocationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://predef.port.safe.pargo.mdcc.ufc.br/", name = "getArchXMLLocationResponse")
    public JAXBElement<GetArchXMLLocationResponse> createGetArchXMLLocationResponse(GetArchXMLLocationResponse value) {
        return new JAXBElement<GetArchXMLLocationResponse>(_GetArchXMLLocationResponse_QNAME, GetArchXMLLocationResponse.class, null, value);
    }

}

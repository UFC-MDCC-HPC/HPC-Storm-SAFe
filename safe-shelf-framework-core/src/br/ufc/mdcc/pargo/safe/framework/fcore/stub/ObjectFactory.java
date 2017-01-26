
package br.ufc.mdcc.pargo.safe.framework.fcore.stub;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.ufc.mdcc.pargo.safe.framework.fcore.stub package. 
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

    private final static QName _Release_QNAME = new QName("http://server.fcore.framework.safe.pargo.mdcc.ufc.br/", "release");
    private final static QName _ListParameterResponse_QNAME = new QName("http://server.fcore.framework.safe.pargo.mdcc.ufc.br/", "listParameterResponse");
    private final static QName _SetComponentListResponse_QNAME = new QName("http://server.fcore.framework.safe.pargo.mdcc.ufc.br/", "setComponentListResponse");
    private final static QName _Resolve_QNAME = new QName("http://server.fcore.framework.safe.pargo.mdcc.ufc.br/", "resolve");
    private final static QName _DeployResponse_QNAME = new QName("http://server.fcore.framework.safe.pargo.mdcc.ufc.br/", "deployResponse");
    private final static QName _ResolveResponse_QNAME = new QName("http://server.fcore.framework.safe.pargo.mdcc.ufc.br/", "resolveResponse");
    private final static QName _ReleaseResponse_QNAME = new QName("http://server.fcore.framework.safe.pargo.mdcc.ufc.br/", "releaseResponse");
    private final static QName _SetComponentList_QNAME = new QName("http://server.fcore.framework.safe.pargo.mdcc.ufc.br/", "setComponentList");
    private final static QName _Deploy_QNAME = new QName("http://server.fcore.framework.safe.pargo.mdcc.ufc.br/", "deploy");
    private final static QName _InstantiateResponse_QNAME = new QName("http://server.fcore.framework.safe.pargo.mdcc.ufc.br/", "instantiateResponse");
    private final static QName _ListParameter_QNAME = new QName("http://server.fcore.framework.safe.pargo.mdcc.ufc.br/", "listParameter");
    private final static QName _Instantiate_QNAME = new QName("http://server.fcore.framework.safe.pargo.mdcc.ufc.br/", "instantiate");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.ufc.mdcc.pargo.safe.framework.fcore.stub
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReleaseResponse }
     * 
     */
    public ReleaseResponse createReleaseResponse() {
        return new ReleaseResponse();
    }

    /**
     * Create an instance of {@link SetComponentList }
     * 
     */
    public SetComponentList createSetComponentList() {
        return new SetComponentList();
    }

    /**
     * Create an instance of {@link DeployResponse }
     * 
     */
    public DeployResponse createDeployResponse() {
        return new DeployResponse();
    }

    /**
     * Create an instance of {@link ResolveResponse }
     * 
     */
    public ResolveResponse createResolveResponse() {
        return new ResolveResponse();
    }

    /**
     * Create an instance of {@link Resolve }
     * 
     */
    public Resolve createResolve() {
        return new Resolve();
    }

    /**
     * Create an instance of {@link Release }
     * 
     */
    public Release createRelease() {
        return new Release();
    }

    /**
     * Create an instance of {@link ListParameterResponse }
     * 
     */
    public ListParameterResponse createListParameterResponse() {
        return new ListParameterResponse();
    }

    /**
     * Create an instance of {@link SetComponentListResponse }
     * 
     */
    public SetComponentListResponse createSetComponentListResponse() {
        return new SetComponentListResponse();
    }

    /**
     * Create an instance of {@link ListParameter }
     * 
     */
    public ListParameter createListParameter() {
        return new ListParameter();
    }

    /**
     * Create an instance of {@link Instantiate }
     * 
     */
    public Instantiate createInstantiate() {
        return new Instantiate();
    }

    /**
     * Create an instance of {@link Deploy }
     * 
     */
    public Deploy createDeploy() {
        return new Deploy();
    }

    /**
     * Create an instance of {@link InstantiateResponse }
     * 
     */
    public InstantiateResponse createInstantiateResponse() {
        return new InstantiateResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Release }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.fcore.framework.safe.pargo.mdcc.ufc.br/", name = "release")
    public JAXBElement<Release> createRelease(Release value) {
        return new JAXBElement<Release>(_Release_QNAME, Release.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListParameterResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.fcore.framework.safe.pargo.mdcc.ufc.br/", name = "listParameterResponse")
    public JAXBElement<ListParameterResponse> createListParameterResponse(ListParameterResponse value) {
        return new JAXBElement<ListParameterResponse>(_ListParameterResponse_QNAME, ListParameterResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetComponentListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.fcore.framework.safe.pargo.mdcc.ufc.br/", name = "setComponentListResponse")
    public JAXBElement<SetComponentListResponse> createSetComponentListResponse(SetComponentListResponse value) {
        return new JAXBElement<SetComponentListResponse>(_SetComponentListResponse_QNAME, SetComponentListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Resolve }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.fcore.framework.safe.pargo.mdcc.ufc.br/", name = "resolve")
    public JAXBElement<Resolve> createResolve(Resolve value) {
        return new JAXBElement<Resolve>(_Resolve_QNAME, Resolve.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeployResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.fcore.framework.safe.pargo.mdcc.ufc.br/", name = "deployResponse")
    public JAXBElement<DeployResponse> createDeployResponse(DeployResponse value) {
        return new JAXBElement<DeployResponse>(_DeployResponse_QNAME, DeployResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResolveResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.fcore.framework.safe.pargo.mdcc.ufc.br/", name = "resolveResponse")
    public JAXBElement<ResolveResponse> createResolveResponse(ResolveResponse value) {
        return new JAXBElement<ResolveResponse>(_ResolveResponse_QNAME, ResolveResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReleaseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.fcore.framework.safe.pargo.mdcc.ufc.br/", name = "releaseResponse")
    public JAXBElement<ReleaseResponse> createReleaseResponse(ReleaseResponse value) {
        return new JAXBElement<ReleaseResponse>(_ReleaseResponse_QNAME, ReleaseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetComponentList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.fcore.framework.safe.pargo.mdcc.ufc.br/", name = "setComponentList")
    public JAXBElement<SetComponentList> createSetComponentList(SetComponentList value) {
        return new JAXBElement<SetComponentList>(_SetComponentList_QNAME, SetComponentList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Deploy }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.fcore.framework.safe.pargo.mdcc.ufc.br/", name = "deploy")
    public JAXBElement<Deploy> createDeploy(Deploy value) {
        return new JAXBElement<Deploy>(_Deploy_QNAME, Deploy.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InstantiateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.fcore.framework.safe.pargo.mdcc.ufc.br/", name = "instantiateResponse")
    public JAXBElement<InstantiateResponse> createInstantiateResponse(InstantiateResponse value) {
        return new JAXBElement<InstantiateResponse>(_InstantiateResponse_QNAME, InstantiateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListParameter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.fcore.framework.safe.pargo.mdcc.ufc.br/", name = "listParameter")
    public JAXBElement<ListParameter> createListParameter(ListParameter value) {
        return new JAXBElement<ListParameter>(_ListParameter_QNAME, ListParameter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Instantiate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.fcore.framework.safe.pargo.mdcc.ufc.br/", name = "instantiate")
    public JAXBElement<Instantiate> createInstantiate(Instantiate value) {
        return new JAXBElement<Instantiate>(_Instantiate_QNAME, Instantiate.class, null, value);
    }

}

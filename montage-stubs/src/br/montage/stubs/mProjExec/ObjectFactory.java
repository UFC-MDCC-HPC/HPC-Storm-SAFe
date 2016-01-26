
package br.montage.stubs.mProjExec;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.montage.stubs.mProjExec package. 
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

    private final static QName _GetTblPortProvidesResponse_QNAME = new QName("http://be.montage.ufc.br/", "getTblPortProvidesResponse");
    private final static QName _SetTblPortUses_QNAME = new QName("http://be.montage.ufc.br/", "setTblPortUses");
    private final static QName _SetDirPortUsesInResponse_QNAME = new QName("http://be.montage.ufc.br/", "setDirPortUsesInResponse");
    private final static QName _GetTblPortProvides_QNAME = new QName("http://be.montage.ufc.br/", "getTblPortProvides");
    private final static QName _SetHdrPortUses_QNAME = new QName("http://be.montage.ufc.br/", "setHdrPortUses");
    private final static QName _GoResponse_QNAME = new QName("http://be.montage.ufc.br/", "goResponse");
    private final static QName _SetDirPortUsesIn_QNAME = new QName("http://be.montage.ufc.br/", "setDirPortUsesIn");
    private final static QName _SetTblPortUsesResponse_QNAME = new QName("http://be.montage.ufc.br/", "setTblPortUsesResponse");
    private final static QName _SetDirPortUsesOutResponse_QNAME = new QName("http://be.montage.ufc.br/", "setDirPortUsesOutResponse");
    private final static QName _SetHdrPortUsesResponse_QNAME = new QName("http://be.montage.ufc.br/", "setHdrPortUsesResponse");
    private final static QName _Go_QNAME = new QName("http://be.montage.ufc.br/", "go");
    private final static QName _SetDirPortUsesOut_QNAME = new QName("http://be.montage.ufc.br/", "setDirPortUsesOut");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.montage.stubs.mProjExec
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SetHdrPortUses }
     * 
     */
    public SetHdrPortUses createSetHdrPortUses() {
        return new SetHdrPortUses();
    }

    /**
     * Create an instance of {@link GoResponse }
     * 
     */
    public GoResponse createGoResponse() {
        return new GoResponse();
    }

    /**
     * Create an instance of {@link SetDirPortUsesInResponse }
     * 
     */
    public SetDirPortUsesInResponse createSetDirPortUsesInResponse() {
        return new SetDirPortUsesInResponse();
    }

    /**
     * Create an instance of {@link GetTblPortProvides }
     * 
     */
    public GetTblPortProvides createGetTblPortProvides() {
        return new GetTblPortProvides();
    }

    /**
     * Create an instance of {@link GetTblPortProvidesResponse }
     * 
     */
    public GetTblPortProvidesResponse createGetTblPortProvidesResponse() {
        return new GetTblPortProvidesResponse();
    }

    /**
     * Create an instance of {@link SetTblPortUses }
     * 
     */
    public SetTblPortUses createSetTblPortUses() {
        return new SetTblPortUses();
    }

    /**
     * Create an instance of {@link Go }
     * 
     */
    public Go createGo() {
        return new Go();
    }

    /**
     * Create an instance of {@link SetDirPortUsesOut }
     * 
     */
    public SetDirPortUsesOut createSetDirPortUsesOut() {
        return new SetDirPortUsesOut();
    }

    /**
     * Create an instance of {@link SetDirPortUsesOutResponse }
     * 
     */
    public SetDirPortUsesOutResponse createSetDirPortUsesOutResponse() {
        return new SetDirPortUsesOutResponse();
    }

    /**
     * Create an instance of {@link SetHdrPortUsesResponse }
     * 
     */
    public SetHdrPortUsesResponse createSetHdrPortUsesResponse() {
        return new SetHdrPortUsesResponse();
    }

    /**
     * Create an instance of {@link SetDirPortUsesIn }
     * 
     */
    public SetDirPortUsesIn createSetDirPortUsesIn() {
        return new SetDirPortUsesIn();
    }

    /**
     * Create an instance of {@link SetTblPortUsesResponse }
     * 
     */
    public SetTblPortUsesResponse createSetTblPortUsesResponse() {
        return new SetTblPortUsesResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTblPortProvidesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "getTblPortProvidesResponse")
    public JAXBElement<GetTblPortProvidesResponse> createGetTblPortProvidesResponse(GetTblPortProvidesResponse value) {
        return new JAXBElement<GetTblPortProvidesResponse>(_GetTblPortProvidesResponse_QNAME, GetTblPortProvidesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetTblPortUses }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "setTblPortUses")
    public JAXBElement<SetTblPortUses> createSetTblPortUses(SetTblPortUses value) {
        return new JAXBElement<SetTblPortUses>(_SetTblPortUses_QNAME, SetTblPortUses.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetDirPortUsesInResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "setDirPortUsesInResponse")
    public JAXBElement<SetDirPortUsesInResponse> createSetDirPortUsesInResponse(SetDirPortUsesInResponse value) {
        return new JAXBElement<SetDirPortUsesInResponse>(_SetDirPortUsesInResponse_QNAME, SetDirPortUsesInResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTblPortProvides }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "getTblPortProvides")
    public JAXBElement<GetTblPortProvides> createGetTblPortProvides(GetTblPortProvides value) {
        return new JAXBElement<GetTblPortProvides>(_GetTblPortProvides_QNAME, GetTblPortProvides.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetHdrPortUses }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "setHdrPortUses")
    public JAXBElement<SetHdrPortUses> createSetHdrPortUses(SetHdrPortUses value) {
        return new JAXBElement<SetHdrPortUses>(_SetHdrPortUses_QNAME, SetHdrPortUses.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "goResponse")
    public JAXBElement<GoResponse> createGoResponse(GoResponse value) {
        return new JAXBElement<GoResponse>(_GoResponse_QNAME, GoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetDirPortUsesIn }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "setDirPortUsesIn")
    public JAXBElement<SetDirPortUsesIn> createSetDirPortUsesIn(SetDirPortUsesIn value) {
        return new JAXBElement<SetDirPortUsesIn>(_SetDirPortUsesIn_QNAME, SetDirPortUsesIn.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetTblPortUsesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "setTblPortUsesResponse")
    public JAXBElement<SetTblPortUsesResponse> createSetTblPortUsesResponse(SetTblPortUsesResponse value) {
        return new JAXBElement<SetTblPortUsesResponse>(_SetTblPortUsesResponse_QNAME, SetTblPortUsesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetDirPortUsesOutResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "setDirPortUsesOutResponse")
    public JAXBElement<SetDirPortUsesOutResponse> createSetDirPortUsesOutResponse(SetDirPortUsesOutResponse value) {
        return new JAXBElement<SetDirPortUsesOutResponse>(_SetDirPortUsesOutResponse_QNAME, SetDirPortUsesOutResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetHdrPortUsesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "setHdrPortUsesResponse")
    public JAXBElement<SetHdrPortUsesResponse> createSetHdrPortUsesResponse(SetHdrPortUsesResponse value) {
        return new JAXBElement<SetHdrPortUsesResponse>(_SetHdrPortUsesResponse_QNAME, SetHdrPortUsesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Go }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "go")
    public JAXBElement<Go> createGo(Go value) {
        return new JAXBElement<Go>(_Go_QNAME, Go.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetDirPortUsesOut }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "setDirPortUsesOut")
    public JAXBElement<SetDirPortUsesOut> createSetDirPortUsesOut(SetDirPortUsesOut value) {
        return new JAXBElement<SetDirPortUsesOut>(_SetDirPortUsesOut_QNAME, SetDirPortUsesOut.class, null, value);
    }

}

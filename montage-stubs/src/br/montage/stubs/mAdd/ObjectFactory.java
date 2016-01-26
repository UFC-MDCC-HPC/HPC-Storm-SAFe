
package br.montage.stubs.mAdd;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.montage.stubs.mAdd package. 
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

    private final static QName _SetDirPortUses_QNAME = new QName("http://be.montage.ufc.br/", "setDirPortUses");
    private final static QName _SetTblPortUses_QNAME = new QName("http://be.montage.ufc.br/", "setTblPortUses");
    private final static QName _GetfitsPortProvides_QNAME = new QName("http://be.montage.ufc.br/", "getfitsPortProvides");
    private final static QName _SetHdrPortUses_QNAME = new QName("http://be.montage.ufc.br/", "setHdrPortUses");
    private final static QName _GoResponse_QNAME = new QName("http://be.montage.ufc.br/", "goResponse");
    private final static QName _GetfitsPortProvidesResponse_QNAME = new QName("http://be.montage.ufc.br/", "getfitsPortProvidesResponse");
    private final static QName _SetDirPortUsesResponse_QNAME = new QName("http://be.montage.ufc.br/", "setDirPortUsesResponse");
    private final static QName _SetTblPortUsesResponse_QNAME = new QName("http://be.montage.ufc.br/", "setTblPortUsesResponse");
    private final static QName _SetHdrPortUsesResponse_QNAME = new QName("http://be.montage.ufc.br/", "setHdrPortUsesResponse");
    private final static QName _Go_QNAME = new QName("http://be.montage.ufc.br/", "go");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.montage.stubs.mAdd
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetfitsPortProvidesResponse }
     * 
     */
    public GetfitsPortProvidesResponse createGetfitsPortProvidesResponse() {
        return new GetfitsPortProvidesResponse();
    }

    /**
     * Create an instance of {@link SetDirPortUsesResponse }
     * 
     */
    public SetDirPortUsesResponse createSetDirPortUsesResponse() {
        return new SetDirPortUsesResponse();
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
     * Create an instance of {@link GetfitsPortProvides }
     * 
     */
    public GetfitsPortProvides createGetfitsPortProvides() {
        return new GetfitsPortProvides();
    }

    /**
     * Create an instance of {@link SetDirPortUses }
     * 
     */
    public SetDirPortUses createSetDirPortUses() {
        return new SetDirPortUses();
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
     * Create an instance of {@link SetHdrPortUsesResponse }
     * 
     */
    public SetHdrPortUsesResponse createSetHdrPortUsesResponse() {
        return new SetHdrPortUsesResponse();
    }

    /**
     * Create an instance of {@link SetTblPortUsesResponse }
     * 
     */
    public SetTblPortUsesResponse createSetTblPortUsesResponse() {
        return new SetTblPortUsesResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetDirPortUses }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "setDirPortUses")
    public JAXBElement<SetDirPortUses> createSetDirPortUses(SetDirPortUses value) {
        return new JAXBElement<SetDirPortUses>(_SetDirPortUses_QNAME, SetDirPortUses.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetfitsPortProvides }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "getfitsPortProvides")
    public JAXBElement<GetfitsPortProvides> createGetfitsPortProvides(GetfitsPortProvides value) {
        return new JAXBElement<GetfitsPortProvides>(_GetfitsPortProvides_QNAME, GetfitsPortProvides.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetfitsPortProvidesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "getfitsPortProvidesResponse")
    public JAXBElement<GetfitsPortProvidesResponse> createGetfitsPortProvidesResponse(GetfitsPortProvidesResponse value) {
        return new JAXBElement<GetfitsPortProvidesResponse>(_GetfitsPortProvidesResponse_QNAME, GetfitsPortProvidesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetDirPortUsesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "setDirPortUsesResponse")
    public JAXBElement<SetDirPortUsesResponse> createSetDirPortUsesResponse(SetDirPortUsesResponse value) {
        return new JAXBElement<SetDirPortUsesResponse>(_SetDirPortUsesResponse_QNAME, SetDirPortUsesResponse.class, null, value);
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

}

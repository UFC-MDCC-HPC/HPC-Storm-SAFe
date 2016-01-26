
package br.montage.stubs.mJpeg;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.montage.stubs.mJpeg package. 
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

    private final static QName _GetJpgPortProvides_QNAME = new QName("http://be.montage.ufc.br/", "getJpgPortProvides");
    private final static QName _GoResponse_QNAME = new QName("http://be.montage.ufc.br/", "goResponse");
    private final static QName _SetFitsPortUsesResponse_QNAME = new QName("http://be.montage.ufc.br/", "setFitsPortUsesResponse");
    private final static QName _GetJpgPortProvidesResponse_QNAME = new QName("http://be.montage.ufc.br/", "getJpgPortProvidesResponse");
    private final static QName _SetFitsPortUses_QNAME = new QName("http://be.montage.ufc.br/", "setFitsPortUses");
    private final static QName _Go_QNAME = new QName("http://be.montage.ufc.br/", "go");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.montage.stubs.mJpeg
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetJpgPortProvidesResponse }
     * 
     */
    public GetJpgPortProvidesResponse createGetJpgPortProvidesResponse() {
        return new GetJpgPortProvidesResponse();
    }

    /**
     * Create an instance of {@link GetJpgPortProvides }
     * 
     */
    public GetJpgPortProvides createGetJpgPortProvides() {
        return new GetJpgPortProvides();
    }

    /**
     * Create an instance of {@link GoResponse }
     * 
     */
    public GoResponse createGoResponse() {
        return new GoResponse();
    }

    /**
     * Create an instance of {@link SetFitsPortUsesResponse }
     * 
     */
    public SetFitsPortUsesResponse createSetFitsPortUsesResponse() {
        return new SetFitsPortUsesResponse();
    }

    /**
     * Create an instance of {@link Go }
     * 
     */
    public Go createGo() {
        return new Go();
    }

    /**
     * Create an instance of {@link SetFitsPortUses }
     * 
     */
    public SetFitsPortUses createSetFitsPortUses() {
        return new SetFitsPortUses();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetJpgPortProvides }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "getJpgPortProvides")
    public JAXBElement<GetJpgPortProvides> createGetJpgPortProvides(GetJpgPortProvides value) {
        return new JAXBElement<GetJpgPortProvides>(_GetJpgPortProvides_QNAME, GetJpgPortProvides.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link SetFitsPortUsesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "setFitsPortUsesResponse")
    public JAXBElement<SetFitsPortUsesResponse> createSetFitsPortUsesResponse(SetFitsPortUsesResponse value) {
        return new JAXBElement<SetFitsPortUsesResponse>(_SetFitsPortUsesResponse_QNAME, SetFitsPortUsesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetJpgPortProvidesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "getJpgPortProvidesResponse")
    public JAXBElement<GetJpgPortProvidesResponse> createGetJpgPortProvidesResponse(GetJpgPortProvidesResponse value) {
        return new JAXBElement<GetJpgPortProvidesResponse>(_GetJpgPortProvidesResponse_QNAME, GetJpgPortProvidesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetFitsPortUses }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "setFitsPortUses")
    public JAXBElement<SetFitsPortUses> createSetFitsPortUses(SetFitsPortUses value) {
        return new JAXBElement<SetFitsPortUses>(_SetFitsPortUses_QNAME, SetFitsPortUses.class, null, value);
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

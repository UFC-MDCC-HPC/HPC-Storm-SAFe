
package br.montage.stubs.mArchiveList;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.montage.stubs.mArchiveList package. 
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

    private final static QName _GetTblProvidesResponse_QNAME = new QName("http://be.montage.ufc.br/", "getTblProvidesResponse");
    private final static QName _SetRawUses_QNAME = new QName("http://be.montage.ufc.br/", "setRawUses");
    private final static QName _GoResponse_QNAME = new QName("http://be.montage.ufc.br/", "goResponse");
    private final static QName _SetRawUsesResponse_QNAME = new QName("http://be.montage.ufc.br/", "setRawUsesResponse");
    private final static QName _GetTblProvides_QNAME = new QName("http://be.montage.ufc.br/", "getTblProvides");
    private final static QName _Go_QNAME = new QName("http://be.montage.ufc.br/", "go");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.montage.stubs.mArchiveList
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SetRawUses }
     * 
     */
    public SetRawUses createSetRawUses() {
        return new SetRawUses();
    }

    /**
     * Create an instance of {@link GoResponse }
     * 
     */
    public GoResponse createGoResponse() {
        return new GoResponse();
    }

    /**
     * Create an instance of {@link SetRawUsesResponse }
     * 
     */
    public SetRawUsesResponse createSetRawUsesResponse() {
        return new SetRawUsesResponse();
    }

    /**
     * Create an instance of {@link GetTblProvidesResponse }
     * 
     */
    public GetTblProvidesResponse createGetTblProvidesResponse() {
        return new GetTblProvidesResponse();
    }

    /**
     * Create an instance of {@link Go }
     * 
     */
    public Go createGo() {
        return new Go();
    }

    /**
     * Create an instance of {@link GetTblProvides }
     * 
     */
    public GetTblProvides createGetTblProvides() {
        return new GetTblProvides();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTblProvidesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "getTblProvidesResponse")
    public JAXBElement<GetTblProvidesResponse> createGetTblProvidesResponse(GetTblProvidesResponse value) {
        return new JAXBElement<GetTblProvidesResponse>(_GetTblProvidesResponse_QNAME, GetTblProvidesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetRawUses }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "setRawUses")
    public JAXBElement<SetRawUses> createSetRawUses(SetRawUses value) {
        return new JAXBElement<SetRawUses>(_SetRawUses_QNAME, SetRawUses.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link SetRawUsesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "setRawUsesResponse")
    public JAXBElement<SetRawUsesResponse> createSetRawUsesResponse(SetRawUsesResponse value) {
        return new JAXBElement<SetRawUsesResponse>(_SetRawUsesResponse_QNAME, SetRawUsesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTblProvides }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "getTblProvides")
    public JAXBElement<GetTblProvides> createGetTblProvides(GetTblProvides value) {
        return new JAXBElement<GetTblProvides>(_GetTblProvides_QNAME, GetTblProvides.class, null, value);
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

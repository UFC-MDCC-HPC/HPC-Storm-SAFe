
package br.montage.stubs.mArchiveExec;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.montage.stubs.mArchiveExec package. 
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

    private final static QName _SetDirUsesResponse_QNAME = new QName("http://be.montage.ufc.br/", "setDirUsesResponse");
    private final static QName _GoResponse_QNAME = new QName("http://be.montage.ufc.br/", "goResponse");
    private final static QName _SetDirUses_QNAME = new QName("http://be.montage.ufc.br/", "setDirUses");
    private final static QName _SetTblUses_QNAME = new QName("http://be.montage.ufc.br/", "setTblUses");
    private final static QName _SetTblUsesResponse_QNAME = new QName("http://be.montage.ufc.br/", "setTblUsesResponse");
    private final static QName _Go_QNAME = new QName("http://be.montage.ufc.br/", "go");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.montage.stubs.mArchiveExec
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GoResponse }
     * 
     */
    public GoResponse createGoResponse() {
        return new GoResponse();
    }

    /**
     * Create an instance of {@link SetDirUsesResponse }
     * 
     */
    public SetDirUsesResponse createSetDirUsesResponse() {
        return new SetDirUsesResponse();
    }

    /**
     * Create an instance of {@link Go }
     * 
     */
    public Go createGo() {
        return new Go();
    }

    /**
     * Create an instance of {@link SetTblUsesResponse }
     * 
     */
    public SetTblUsesResponse createSetTblUsesResponse() {
        return new SetTblUsesResponse();
    }

    /**
     * Create an instance of {@link SetDirUses }
     * 
     */
    public SetDirUses createSetDirUses() {
        return new SetDirUses();
    }

    /**
     * Create an instance of {@link SetTblUses }
     * 
     */
    public SetTblUses createSetTblUses() {
        return new SetTblUses();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetDirUsesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "setDirUsesResponse")
    public JAXBElement<SetDirUsesResponse> createSetDirUsesResponse(SetDirUsesResponse value) {
        return new JAXBElement<SetDirUsesResponse>(_SetDirUsesResponse_QNAME, SetDirUsesResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link SetDirUses }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "setDirUses")
    public JAXBElement<SetDirUses> createSetDirUses(SetDirUses value) {
        return new JAXBElement<SetDirUses>(_SetDirUses_QNAME, SetDirUses.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetTblUses }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "setTblUses")
    public JAXBElement<SetTblUses> createSetTblUses(SetTblUses value) {
        return new JAXBElement<SetTblUses>(_SetTblUses_QNAME, SetTblUses.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetTblUsesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "setTblUsesResponse")
    public JAXBElement<SetTblUsesResponse> createSetTblUsesResponse(SetTblUsesResponse value) {
        return new JAXBElement<SetTblUsesResponse>(_SetTblUsesResponse_QNAME, SetTblUsesResponse.class, null, value);
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

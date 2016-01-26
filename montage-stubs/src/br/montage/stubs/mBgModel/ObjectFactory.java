
package br.montage.stubs.mBgModel;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.montage.stubs.mBgModel package. 
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
    private final static QName _GetTblPortProvides_QNAME = new QName("http://be.montage.ufc.br/", "getTblPortProvides");
    private final static QName _GoResponse_QNAME = new QName("http://be.montage.ufc.br/", "goResponse");
    private final static QName _SetTblPortUsesAResponse_QNAME = new QName("http://be.montage.ufc.br/", "setTblPortUsesAResponse");
    private final static QName _SettblPortUsesBResponse_QNAME = new QName("http://be.montage.ufc.br/", "settblPortUsesBResponse");
    private final static QName _SettblPortUsesB_QNAME = new QName("http://be.montage.ufc.br/", "settblPortUsesB");
    private final static QName _SetTblPortUsesA_QNAME = new QName("http://be.montage.ufc.br/", "setTblPortUsesA");
    private final static QName _Go_QNAME = new QName("http://be.montage.ufc.br/", "go");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.montage.stubs.mBgModel
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SettblPortUsesB }
     * 
     */
    public SettblPortUsesB createSettblPortUsesB() {
        return new SettblPortUsesB();
    }

    /**
     * Create an instance of {@link GoResponse }
     * 
     */
    public GoResponse createGoResponse() {
        return new GoResponse();
    }

    /**
     * Create an instance of {@link SetTblPortUsesAResponse }
     * 
     */
    public SetTblPortUsesAResponse createSetTblPortUsesAResponse() {
        return new SetTblPortUsesAResponse();
    }

    /**
     * Create an instance of {@link SettblPortUsesBResponse }
     * 
     */
    public SettblPortUsesBResponse createSettblPortUsesBResponse() {
        return new SettblPortUsesBResponse();
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
     * Create an instance of {@link Go }
     * 
     */
    public Go createGo() {
        return new Go();
    }

    /**
     * Create an instance of {@link SetTblPortUsesA }
     * 
     */
    public SetTblPortUsesA createSetTblPortUsesA() {
        return new SetTblPortUsesA();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTblPortProvides }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "getTblPortProvides")
    public JAXBElement<GetTblPortProvides> createGetTblPortProvides(GetTblPortProvides value) {
        return new JAXBElement<GetTblPortProvides>(_GetTblPortProvides_QNAME, GetTblPortProvides.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link SetTblPortUsesAResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "setTblPortUsesAResponse")
    public JAXBElement<SetTblPortUsesAResponse> createSetTblPortUsesAResponse(SetTblPortUsesAResponse value) {
        return new JAXBElement<SetTblPortUsesAResponse>(_SetTblPortUsesAResponse_QNAME, SetTblPortUsesAResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SettblPortUsesBResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "settblPortUsesBResponse")
    public JAXBElement<SettblPortUsesBResponse> createSettblPortUsesBResponse(SettblPortUsesBResponse value) {
        return new JAXBElement<SettblPortUsesBResponse>(_SettblPortUsesBResponse_QNAME, SettblPortUsesBResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SettblPortUsesB }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "settblPortUsesB")
    public JAXBElement<SettblPortUsesB> createSettblPortUsesB(SettblPortUsesB value) {
        return new JAXBElement<SettblPortUsesB>(_SettblPortUsesB_QNAME, SettblPortUsesB.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetTblPortUsesA }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "setTblPortUsesA")
    public JAXBElement<SetTblPortUsesA> createSetTblPortUsesA(SetTblPortUsesA value) {
        return new JAXBElement<SetTblPortUsesA>(_SetTblPortUsesA_QNAME, SetTblPortUsesA.class, null, value);
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

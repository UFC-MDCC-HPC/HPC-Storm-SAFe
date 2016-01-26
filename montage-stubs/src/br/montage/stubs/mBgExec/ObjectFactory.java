
package br.montage.stubs.mBgExec;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.montage.stubs.mBgExec package. 
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

    private final static QName _SetDirPortUsesInResponse_QNAME = new QName("http://be.montage.ufc.br/", "setDirPortUsesInResponse");
    private final static QName _SetTblPortUsesBResponse_QNAME = new QName("http://be.montage.ufc.br/", "setTblPortUsesBResponse");
    private final static QName _GoResponse_QNAME = new QName("http://be.montage.ufc.br/", "goResponse");
    private final static QName _SetTblPortUsesAResponse_QNAME = new QName("http://be.montage.ufc.br/", "setTblPortUsesAResponse");
    private final static QName _SetDirPortUsesIn_QNAME = new QName("http://be.montage.ufc.br/", "setDirPortUsesIn");
    private final static QName _SetTblPortUsesB_QNAME = new QName("http://be.montage.ufc.br/", "setTblPortUsesB");
    private final static QName _SetDirPortUsesOutResponse_QNAME = new QName("http://be.montage.ufc.br/", "setDirPortUsesOutResponse");
    private final static QName _SetTblPortUsesA_QNAME = new QName("http://be.montage.ufc.br/", "setTblPortUsesA");
    private final static QName _Go_QNAME = new QName("http://be.montage.ufc.br/", "go");
    private final static QName _SetDirPortUsesOut_QNAME = new QName("http://be.montage.ufc.br/", "setDirPortUsesOut");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.montage.stubs.mBgExec
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
     * Create an instance of {@link SetTblPortUsesAResponse }
     * 
     */
    public SetTblPortUsesAResponse createSetTblPortUsesAResponse() {
        return new SetTblPortUsesAResponse();
    }

    /**
     * Create an instance of {@link SetDirPortUsesInResponse }
     * 
     */
    public SetDirPortUsesInResponse createSetDirPortUsesInResponse() {
        return new SetDirPortUsesInResponse();
    }

    /**
     * Create an instance of {@link SetTblPortUsesBResponse }
     * 
     */
    public SetTblPortUsesBResponse createSetTblPortUsesBResponse() {
        return new SetTblPortUsesBResponse();
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
     * Create an instance of {@link SetTblPortUsesB }
     * 
     */
    public SetTblPortUsesB createSetTblPortUsesB() {
        return new SetTblPortUsesB();
    }

    /**
     * Create an instance of {@link SetDirPortUsesOutResponse }
     * 
     */
    public SetDirPortUsesOutResponse createSetDirPortUsesOutResponse() {
        return new SetDirPortUsesOutResponse();
    }

    /**
     * Create an instance of {@link SetTblPortUsesA }
     * 
     */
    public SetTblPortUsesA createSetTblPortUsesA() {
        return new SetTblPortUsesA();
    }

    /**
     * Create an instance of {@link SetDirPortUsesIn }
     * 
     */
    public SetDirPortUsesIn createSetDirPortUsesIn() {
        return new SetDirPortUsesIn();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link SetTblPortUsesBResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "setTblPortUsesBResponse")
    public JAXBElement<SetTblPortUsesBResponse> createSetTblPortUsesBResponse(SetTblPortUsesBResponse value) {
        return new JAXBElement<SetTblPortUsesBResponse>(_SetTblPortUsesBResponse_QNAME, SetTblPortUsesBResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link SetDirPortUsesIn }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "setDirPortUsesIn")
    public JAXBElement<SetDirPortUsesIn> createSetDirPortUsesIn(SetDirPortUsesIn value) {
        return new JAXBElement<SetDirPortUsesIn>(_SetDirPortUsesIn_QNAME, SetDirPortUsesIn.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetTblPortUsesB }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "setTblPortUsesB")
    public JAXBElement<SetTblPortUsesB> createSetTblPortUsesB(SetTblPortUsesB value) {
        return new JAXBElement<SetTblPortUsesB>(_SetTblPortUsesB_QNAME, SetTblPortUsesB.class, null, value);
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

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetDirPortUsesOut }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "setDirPortUsesOut")
    public JAXBElement<SetDirPortUsesOut> createSetDirPortUsesOut(SetDirPortUsesOut value) {
        return new JAXBElement<SetDirPortUsesOut>(_SetDirPortUsesOut_QNAME, SetDirPortUsesOut.class, null, value);
    }

}

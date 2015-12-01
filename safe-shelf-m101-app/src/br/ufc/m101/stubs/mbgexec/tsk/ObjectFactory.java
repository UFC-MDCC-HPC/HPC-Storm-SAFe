
package br.ufc.m101.stubs.mbgexec.tsk;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.ufc.m101.stubs.mbgexec.tsk package. 
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

    private final static QName _Go_QNAME = new QName("http://mbgexec.component.m101.ufc.br/", "go");
    private final static QName _GoResponse_QNAME = new QName("http://mbgexec.component.m101.ufc.br/", "goResponse");
    private final static QName _SetMBgExec_QNAME = new QName("http://mbgexec.component.m101.ufc.br/", "setMBgExec");
    private final static QName _SetMBgExecResponse_QNAME = new QName("http://mbgexec.component.m101.ufc.br/", "setMBgExecResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.ufc.m101.stubs.mbgexec.tsk
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
     * Create an instance of {@link SetMBgExec }
     * 
     */
    public SetMBgExec createSetMBgExec() {
        return new SetMBgExec();
    }

    /**
     * Create an instance of {@link SetMBgExecResponse }
     * 
     */
    public SetMBgExecResponse createSetMBgExecResponse() {
        return new SetMBgExecResponse();
    }

    /**
     * Create an instance of {@link Go }
     * 
     */
    public Go createGo() {
        return new Go();
    }

    /**
     * Create an instance of {@link MBgExec }
     * 
     */
    public MBgExec createMBgExec() {
        return new MBgExec();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Go }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mbgexec.component.m101.ufc.br/", name = "go")
    public JAXBElement<Go> createGo(Go value) {
        return new JAXBElement<Go>(_Go_QNAME, Go.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mbgexec.component.m101.ufc.br/", name = "goResponse")
    public JAXBElement<GoResponse> createGoResponse(GoResponse value) {
        return new JAXBElement<GoResponse>(_GoResponse_QNAME, GoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetMBgExec }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mbgexec.component.m101.ufc.br/", name = "setMBgExec")
    public JAXBElement<SetMBgExec> createSetMBgExec(SetMBgExec value) {
        return new JAXBElement<SetMBgExec>(_SetMBgExec_QNAME, SetMBgExec.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetMBgExecResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mbgexec.component.m101.ufc.br/", name = "setMBgExecResponse")
    public JAXBElement<SetMBgExecResponse> createSetMBgExecResponse(SetMBgExecResponse value) {
        return new JAXBElement<SetMBgExecResponse>(_SetMBgExecResponse_QNAME, SetMBgExecResponse.class, null, value);
    }

}

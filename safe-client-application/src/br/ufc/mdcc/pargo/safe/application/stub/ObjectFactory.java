
package br.ufc.mdcc.pargo.safe.application.stub;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.ufc.mdcc.pargo.safe.application.stubs package. 
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

    private final static QName _SetSAFeSWLFlowSourceResponse_QNAME = new QName("http://service.application.safe.pargo.mdcc.ufc.br/", "setSAFeSWLFlowSourceResponse");
    private final static QName _RunResponse_QNAME = new QName("http://service.application.safe.pargo.mdcc.ufc.br/", "runResponse");
    private final static QName _Run_QNAME = new QName("http://service.application.safe.pargo.mdcc.ufc.br/", "run");
    private final static QName _SetSAFeSWLArchSource_QNAME = new QName("http://service.application.safe.pargo.mdcc.ufc.br/", "setSAFeSWLArchSource");
    private final static QName _SetSAFeSWLArchSourceResponse_QNAME = new QName("http://service.application.safe.pargo.mdcc.ufc.br/", "setSAFeSWLArchSourceResponse");
    private final static QName _SetSAFeSWLFlowSource_QNAME = new QName("http://service.application.safe.pargo.mdcc.ufc.br/", "setSAFeSWLFlowSource");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.ufc.mdcc.pargo.safe.application.stubs
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SetSAFeSWLFlowSource }
     * 
     */
    public SetSAFeSWLFlowSource createSetSAFeSWLFlowSource() {
        return new SetSAFeSWLFlowSource();
    }

    /**
     * Create an instance of {@link SetSAFeSWLArchSourceResponse }
     * 
     */
    public SetSAFeSWLArchSourceResponse createSetSAFeSWLArchSourceResponse() {
        return new SetSAFeSWLArchSourceResponse();
    }

    /**
     * Create an instance of {@link SetSAFeSWLArchSource }
     * 
     */
    public SetSAFeSWLArchSource createSetSAFeSWLArchSource() {
        return new SetSAFeSWLArchSource();
    }

    /**
     * Create an instance of {@link Run }
     * 
     */
    public Run createRun() {
        return new Run();
    }

    /**
     * Create an instance of {@link RunResponse }
     * 
     */
    public RunResponse createRunResponse() {
        return new RunResponse();
    }

    /**
     * Create an instance of {@link SetSAFeSWLFlowSourceResponse }
     * 
     */
    public SetSAFeSWLFlowSourceResponse createSetSAFeSWLFlowSourceResponse() {
        return new SetSAFeSWLFlowSourceResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetSAFeSWLFlowSourceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.application.safe.pargo.mdcc.ufc.br/", name = "setSAFeSWLFlowSourceResponse")
    public JAXBElement<SetSAFeSWLFlowSourceResponse> createSetSAFeSWLFlowSourceResponse(SetSAFeSWLFlowSourceResponse value) {
        return new JAXBElement<SetSAFeSWLFlowSourceResponse>(_SetSAFeSWLFlowSourceResponse_QNAME, SetSAFeSWLFlowSourceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RunResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.application.safe.pargo.mdcc.ufc.br/", name = "runResponse")
    public JAXBElement<RunResponse> createRunResponse(RunResponse value) {
        return new JAXBElement<RunResponse>(_RunResponse_QNAME, RunResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Run }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.application.safe.pargo.mdcc.ufc.br/", name = "run")
    public JAXBElement<Run> createRun(Run value) {
        return new JAXBElement<Run>(_Run_QNAME, Run.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetSAFeSWLArchSource }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.application.safe.pargo.mdcc.ufc.br/", name = "setSAFeSWLArchSource")
    public JAXBElement<SetSAFeSWLArchSource> createSetSAFeSWLArchSource(SetSAFeSWLArchSource value) {
        return new JAXBElement<SetSAFeSWLArchSource>(_SetSAFeSWLArchSource_QNAME, SetSAFeSWLArchSource.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetSAFeSWLArchSourceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.application.safe.pargo.mdcc.ufc.br/", name = "setSAFeSWLArchSourceResponse")
    public JAXBElement<SetSAFeSWLArchSourceResponse> createSetSAFeSWLArchSourceResponse(SetSAFeSWLArchSourceResponse value) {
        return new JAXBElement<SetSAFeSWLArchSourceResponse>(_SetSAFeSWLArchSourceResponse_QNAME, SetSAFeSWLArchSourceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetSAFeSWLFlowSource }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.application.safe.pargo.mdcc.ufc.br/", name = "setSAFeSWLFlowSource")
    public JAXBElement<SetSAFeSWLFlowSource> createSetSAFeSWLFlowSource(SetSAFeSWLFlowSource value) {
        return new JAXBElement<SetSAFeSWLFlowSource>(_SetSAFeSWLFlowSource_QNAME, SetSAFeSWLFlowSource.class, null, value);
    }

}

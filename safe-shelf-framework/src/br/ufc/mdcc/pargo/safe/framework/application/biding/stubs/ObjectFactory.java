
package br.ufc.mdcc.pargo.safe.framework.application.biding.stubs;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.ufc.mdcc.pargo.safe.framework.application.biding.stubs package. 
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

    private final static QName _SetApplicationFacadeResponse_QNAME = new QName("http://biding.application.framework.safe.pargo.mdcc.ufc.br/", "setApplicationFacadeResponse");
    private final static QName _SetApplicationFacade_QNAME = new QName("http://biding.application.framework.safe.pargo.mdcc.ufc.br/", "setApplicationFacade");
    private final static QName _Service_QNAME = new QName("http://biding.application.framework.safe.pargo.mdcc.ufc.br/", "service");
    private final static QName _ServiceResponse_QNAME = new QName("http://biding.application.framework.safe.pargo.mdcc.ufc.br/", "serviceResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.ufc.mdcc.pargo.safe.framework.application.biding.stubs
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Service }
     * 
     */
    public Service createService() {
        return new Service();
    }

    /**
     * Create an instance of {@link ServiceResponse }
     * 
     */
    public ServiceResponse createServiceResponse() {
        return new ServiceResponse();
    }

    /**
     * Create an instance of {@link SetApplicationFacadeResponse }
     * 
     */
    public SetApplicationFacadeResponse createSetApplicationFacadeResponse() {
        return new SetApplicationFacadeResponse();
    }

    /**
     * Create an instance of {@link SetApplicationFacade }
     * 
     */
    public SetApplicationFacade createSetApplicationFacade() {
        return new SetApplicationFacade();
    }

    /**
     * Create an instance of {@link HShelfApplicationBidingServerFacade }
     * 
     */
    public HShelfApplicationBidingServerFacade createHShelfApplicationBidingServerFacade() {
        return new HShelfApplicationBidingServerFacade();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetApplicationFacadeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://biding.application.framework.safe.pargo.mdcc.ufc.br/", name = "setApplicationFacadeResponse")
    public JAXBElement<SetApplicationFacadeResponse> createSetApplicationFacadeResponse(SetApplicationFacadeResponse value) {
        return new JAXBElement<SetApplicationFacadeResponse>(_SetApplicationFacadeResponse_QNAME, SetApplicationFacadeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetApplicationFacade }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://biding.application.framework.safe.pargo.mdcc.ufc.br/", name = "setApplicationFacade")
    public JAXBElement<SetApplicationFacade> createSetApplicationFacade(SetApplicationFacade value) {
        return new JAXBElement<SetApplicationFacade>(_SetApplicationFacade_QNAME, SetApplicationFacade.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Service }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://biding.application.framework.safe.pargo.mdcc.ufc.br/", name = "service")
    public JAXBElement<Service> createService(Service value) {
        return new JAXBElement<Service>(_Service_QNAME, Service.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://biding.application.framework.safe.pargo.mdcc.ufc.br/", name = "serviceResponse")
    public JAXBElement<ServiceResponse> createServiceResponse(ServiceResponse value) {
        return new JAXBElement<ServiceResponse>(_ServiceResponse_QNAME, ServiceResponse.class, null, value);
    }

}

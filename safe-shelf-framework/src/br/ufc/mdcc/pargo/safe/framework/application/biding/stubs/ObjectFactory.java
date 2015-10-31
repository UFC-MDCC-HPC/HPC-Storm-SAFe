
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

    private final static QName _SetApplicationResponse_QNAME = new QName("http://biding.application.framework.safe.pargo.mdcc.ufc.br/", "setApplicationResponse");
    private final static QName _Service_QNAME = new QName("http://biding.application.framework.safe.pargo.mdcc.ufc.br/", "service");
    private final static QName _ServiceResponse_QNAME = new QName("http://biding.application.framework.safe.pargo.mdcc.ufc.br/", "serviceResponse");
    private final static QName _SetApplication_QNAME = new QName("http://biding.application.framework.safe.pargo.mdcc.ufc.br/", "setApplication");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.ufc.mdcc.pargo.safe.framework.application.biding.stubs
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SetApplication }
     * 
     */
    public SetApplication createSetApplication() {
        return new SetApplication();
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
     * Create an instance of {@link SetApplicationResponse }
     * 
     */
    public SetApplicationResponse createSetApplicationResponse() {
        return new SetApplicationResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetApplicationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://biding.application.framework.safe.pargo.mdcc.ufc.br/", name = "setApplicationResponse")
    public JAXBElement<SetApplicationResponse> createSetApplicationResponse(SetApplicationResponse value) {
        return new JAXBElement<SetApplicationResponse>(_SetApplicationResponse_QNAME, SetApplicationResponse.class, null, value);
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

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetApplication }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://biding.application.framework.safe.pargo.mdcc.ufc.br/", name = "setApplication")
    public JAXBElement<SetApplication> createSetApplication(SetApplication value) {
        return new JAXBElement<SetApplication>(_SetApplication_QNAME, SetApplication.class, null, value);
    }

}

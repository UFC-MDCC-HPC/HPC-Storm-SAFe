
package br.ufc.m101.stubs.overlaps.env;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "MOverlapsEnvPortImplService", targetNamespace = "http://moverlaps.component.m101.ufc.br/", wsdlLocation = "http://localhost:11414/moverlaps-env?wsdl")
public class MOverlapsEnvPortImplService
    extends Service
{

    private final static URL MOVERLAPSENVPORTIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException MOVERLAPSENVPORTIMPLSERVICE_EXCEPTION;
    private final static QName MOVERLAPSENVPORTIMPLSERVICE_QNAME = new QName("http://moverlaps.component.m101.ufc.br/", "MOverlapsEnvPortImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:11414/moverlaps-env?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        MOVERLAPSENVPORTIMPLSERVICE_WSDL_LOCATION = url;
        MOVERLAPSENVPORTIMPLSERVICE_EXCEPTION = e;
    }

    public MOverlapsEnvPortImplService() {
        super(__getWsdlLocation(), MOVERLAPSENVPORTIMPLSERVICE_QNAME);
    }

    public MOverlapsEnvPortImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), MOVERLAPSENVPORTIMPLSERVICE_QNAME, features);
    }

    public MOverlapsEnvPortImplService(URL wsdlLocation) {
        super(wsdlLocation, MOVERLAPSENVPORTIMPLSERVICE_QNAME);
    }

    public MOverlapsEnvPortImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, MOVERLAPSENVPORTIMPLSERVICE_QNAME, features);
    }

    public MOverlapsEnvPortImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MOverlapsEnvPortImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns MOverlapsEnvPort
     */
    @WebEndpoint(name = "MOverlapsEnvPortImplPort")
    public MOverlapsEnvPort getMOverlapsEnvPortImplPort() {
        return super.getPort(new QName("http://moverlaps.component.m101.ufc.br/", "MOverlapsEnvPortImplPort"), MOverlapsEnvPort.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MOverlapsEnvPort
     */
    @WebEndpoint(name = "MOverlapsEnvPortImplPort")
    public MOverlapsEnvPort getMOverlapsEnvPortImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://moverlaps.component.m101.ufc.br/", "MOverlapsEnvPortImplPort"), MOverlapsEnvPort.class, features);
    }

    private static URL __getWsdlLocation() {
        if (MOVERLAPSENVPORTIMPLSERVICE_EXCEPTION!= null) {
            throw MOVERLAPSENVPORTIMPLSERVICE_EXCEPTION;
        }
        return MOVERLAPSENVPORTIMPLSERVICE_WSDL_LOCATION;
    }

}

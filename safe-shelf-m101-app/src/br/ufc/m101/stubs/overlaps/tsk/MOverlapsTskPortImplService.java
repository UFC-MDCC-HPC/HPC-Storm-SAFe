
package br.ufc.m101.stubs.overlaps.tsk;

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
@WebServiceClient(name = "MOverlapsTskPortImplService", targetNamespace = "http://moverlaps.component.m101.ufc.br/", wsdlLocation = "http://localhost:11415/moverlaps-tsk?wsdl")
public class MOverlapsTskPortImplService
    extends Service
{

    private final static URL MOVERLAPSTSKPORTIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException MOVERLAPSTSKPORTIMPLSERVICE_EXCEPTION;
    private final static QName MOVERLAPSTSKPORTIMPLSERVICE_QNAME = new QName("http://moverlaps.component.m101.ufc.br/", "MOverlapsTskPortImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:11415/moverlaps-tsk?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        MOVERLAPSTSKPORTIMPLSERVICE_WSDL_LOCATION = url;
        MOVERLAPSTSKPORTIMPLSERVICE_EXCEPTION = e;
    }

    public MOverlapsTskPortImplService() {
        super(__getWsdlLocation(), MOVERLAPSTSKPORTIMPLSERVICE_QNAME);
    }

    public MOverlapsTskPortImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), MOVERLAPSTSKPORTIMPLSERVICE_QNAME, features);
    }

    public MOverlapsTskPortImplService(URL wsdlLocation) {
        super(wsdlLocation, MOVERLAPSTSKPORTIMPLSERVICE_QNAME);
    }

    public MOverlapsTskPortImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, MOVERLAPSTSKPORTIMPLSERVICE_QNAME, features);
    }

    public MOverlapsTskPortImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MOverlapsTskPortImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns MOverlapsTskPort
     */
    @WebEndpoint(name = "MOverlapsTskPortImplPort")
    public MOverlapsTskPort getMOverlapsTskPortImplPort() {
        return super.getPort(new QName("http://moverlaps.component.m101.ufc.br/", "MOverlapsTskPortImplPort"), MOverlapsTskPort.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MOverlapsTskPort
     */
    @WebEndpoint(name = "MOverlapsTskPortImplPort")
    public MOverlapsTskPort getMOverlapsTskPortImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://moverlaps.component.m101.ufc.br/", "MOverlapsTskPortImplPort"), MOverlapsTskPort.class, features);
    }

    private static URL __getWsdlLocation() {
        if (MOVERLAPSTSKPORTIMPLSERVICE_EXCEPTION!= null) {
            throw MOVERLAPSTSKPORTIMPLSERVICE_EXCEPTION;
        }
        return MOVERLAPSTSKPORTIMPLSERVICE_WSDL_LOCATION;
    }

}
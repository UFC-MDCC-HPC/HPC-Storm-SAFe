
package br.ufc.m101.stubs.madd.tsk;

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
@WebServiceClient(name = "MAddTskPortImplService", targetNamespace = "http://madd.component.m101.ufc.br/", wsdlLocation = "http://localhost:11401/madd-tsk?wsdl")
public class MAddTskPortImplService
    extends Service
{

    private final static URL MADDTSKPORTIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException MADDTSKPORTIMPLSERVICE_EXCEPTION;
    private final static QName MADDTSKPORTIMPLSERVICE_QNAME = new QName("http://madd.component.m101.ufc.br/", "MAddTskPortImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:11401/madd-tsk?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        MADDTSKPORTIMPLSERVICE_WSDL_LOCATION = url;
        MADDTSKPORTIMPLSERVICE_EXCEPTION = e;
    }

    public MAddTskPortImplService() {
        super(__getWsdlLocation(), MADDTSKPORTIMPLSERVICE_QNAME);
    }

    public MAddTskPortImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), MADDTSKPORTIMPLSERVICE_QNAME, features);
    }

    public MAddTskPortImplService(URL wsdlLocation) {
        super(wsdlLocation, MADDTSKPORTIMPLSERVICE_QNAME);
    }

    public MAddTskPortImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, MADDTSKPORTIMPLSERVICE_QNAME, features);
    }

    public MAddTskPortImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MAddTskPortImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns MAddTskPort
     */
    @WebEndpoint(name = "MAddTskPortImplPort")
    public MAddTskPort getMAddTskPortImplPort() {
        return super.getPort(new QName("http://madd.component.m101.ufc.br/", "MAddTskPortImplPort"), MAddTskPort.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MAddTskPort
     */
    @WebEndpoint(name = "MAddTskPortImplPort")
    public MAddTskPort getMAddTskPortImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://madd.component.m101.ufc.br/", "MAddTskPortImplPort"), MAddTskPort.class, features);
    }

    private static URL __getWsdlLocation() {
        if (MADDTSKPORTIMPLSERVICE_EXCEPTION!= null) {
            throw MADDTSKPORTIMPLSERVICE_EXCEPTION;
        }
        return MADDTSKPORTIMPLSERVICE_WSDL_LOCATION;
    }

}
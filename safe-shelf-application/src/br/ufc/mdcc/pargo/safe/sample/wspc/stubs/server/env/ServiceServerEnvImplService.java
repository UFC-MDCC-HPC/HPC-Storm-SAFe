
package br.ufc.mdcc.pargo.safe.sample.wspc.stubs.server.env;

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
@WebServiceClient(name = "ServiceServerEnvImplService", targetNamespace = "http://server.pc.backend.safe.pargo.mdcc.ufc.br/", wsdlLocation = "http://localhost:10003/server-env?wsdl")
public class ServiceServerEnvImplService
    extends Service
{

    private final static URL SERVICESERVERENVIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException SERVICESERVERENVIMPLSERVICE_EXCEPTION;
    private final static QName SERVICESERVERENVIMPLSERVICE_QNAME = new QName("http://server.pc.backend.safe.pargo.mdcc.ufc.br/", "ServiceServerEnvImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:10003/server-env?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SERVICESERVERENVIMPLSERVICE_WSDL_LOCATION = url;
        SERVICESERVERENVIMPLSERVICE_EXCEPTION = e;
    }

    public ServiceServerEnvImplService() {
        super(__getWsdlLocation(), SERVICESERVERENVIMPLSERVICE_QNAME);
    }

    public ServiceServerEnvImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), SERVICESERVERENVIMPLSERVICE_QNAME, features);
    }

    public ServiceServerEnvImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICESERVERENVIMPLSERVICE_QNAME);
    }

    public ServiceServerEnvImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SERVICESERVERENVIMPLSERVICE_QNAME, features);
    }

    public ServiceServerEnvImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ServiceServerEnvImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ServiceIServerEnv
     */
    @WebEndpoint(name = "ServiceServerEnvImplPort")
    public ServiceIServerEnv getServiceServerEnvImplPort() {
        return super.getPort(new QName("http://server.pc.backend.safe.pargo.mdcc.ufc.br/", "ServiceServerEnvImplPort"), ServiceIServerEnv.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ServiceIServerEnv
     */
    @WebEndpoint(name = "ServiceServerEnvImplPort")
    public ServiceIServerEnv getServiceServerEnvImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://server.pc.backend.safe.pargo.mdcc.ufc.br/", "ServiceServerEnvImplPort"), ServiceIServerEnv.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SERVICESERVERENVIMPLSERVICE_EXCEPTION!= null) {
            throw SERVICESERVERENVIMPLSERVICE_EXCEPTION;
        }
        return SERVICESERVERENVIMPLSERVICE_WSDL_LOCATION;
    }

}

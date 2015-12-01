
package br.ufc.mdcc.pargo.backend.client.proxy.stubs;

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
@WebServiceClient(name = "ClientProxieWSService", targetNamespace = "http://service.client.sample.safe.pargo.mdcc.ufc.br/", wsdlLocation = "http://localhost:10030/client-service-port?wsdl")
public class ClientProxieWSService
    extends Service
{

    private final static URL CLIENTPROXIEWSSERVICE_WSDL_LOCATION;
    private final static WebServiceException CLIENTPROXIEWSSERVICE_EXCEPTION;
    private final static QName CLIENTPROXIEWSSERVICE_QNAME = new QName("http://service.client.sample.safe.pargo.mdcc.ufc.br/", "ClientProxieWSService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:10030/client-service-port?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CLIENTPROXIEWSSERVICE_WSDL_LOCATION = url;
        CLIENTPROXIEWSSERVICE_EXCEPTION = e;
    }

    public ClientProxieWSService() {
        super(__getWsdlLocation(), CLIENTPROXIEWSSERVICE_QNAME);
    }

    public ClientProxieWSService(WebServiceFeature... features) {
        super(__getWsdlLocation(), CLIENTPROXIEWSSERVICE_QNAME, features);
    }

    public ClientProxieWSService(URL wsdlLocation) {
        super(wsdlLocation, CLIENTPROXIEWSSERVICE_QNAME);
    }

    public ClientProxieWSService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CLIENTPROXIEWSSERVICE_QNAME, features);
    }

    public ClientProxieWSService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ClientProxieWSService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns IClientProxieWS
     */
    @WebEndpoint(name = "ClientProxieWSPort")
    public IClientProxieWS getClientProxieWSPort() {
        return super.getPort(new QName("http://service.client.sample.safe.pargo.mdcc.ufc.br/", "ClientProxieWSPort"), IClientProxieWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IClientProxieWS
     */
    @WebEndpoint(name = "ClientProxieWSPort")
    public IClientProxieWS getClientProxieWSPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://service.client.sample.safe.pargo.mdcc.ufc.br/", "ClientProxieWSPort"), IClientProxieWS.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CLIENTPROXIEWSSERVICE_EXCEPTION!= null) {
            throw CLIENTPROXIEWSSERVICE_EXCEPTION;
        }
        return CLIENTPROXIEWSSERVICE_WSDL_LOCATION;
    }

}
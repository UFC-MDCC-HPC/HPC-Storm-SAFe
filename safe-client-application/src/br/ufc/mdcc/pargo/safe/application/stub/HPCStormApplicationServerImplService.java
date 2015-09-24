
package br.ufc.mdcc.pargo.safe.application.stub;

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
@WebServiceClient(name = "HPCStormApplicationServerImplService", targetNamespace = "http://service.application.safe.pargo.mdcc.ufc.br/", wsdlLocation = "http://localhost:10100/appserver-ws?wsdl")
public class HPCStormApplicationServerImplService
    extends Service
{

    private final static URL HPCSTORMAPPLICATIONSERVERIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException HPCSTORMAPPLICATIONSERVERIMPLSERVICE_EXCEPTION;
    private final static QName HPCSTORMAPPLICATIONSERVERIMPLSERVICE_QNAME = new QName("http://service.application.safe.pargo.mdcc.ufc.br/", "HPCStormApplicationServerImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:10100/appserver-ws?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        HPCSTORMAPPLICATIONSERVERIMPLSERVICE_WSDL_LOCATION = url;
        HPCSTORMAPPLICATIONSERVERIMPLSERVICE_EXCEPTION = e;
    }

    public HPCStormApplicationServerImplService() {
        super(__getWsdlLocation(), HPCSTORMAPPLICATIONSERVERIMPLSERVICE_QNAME);
    }

    public HPCStormApplicationServerImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), HPCSTORMAPPLICATIONSERVERIMPLSERVICE_QNAME, features);
    }

    public HPCStormApplicationServerImplService(URL wsdlLocation) {
        super(wsdlLocation, HPCSTORMAPPLICATIONSERVERIMPLSERVICE_QNAME);
    }

    public HPCStormApplicationServerImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, HPCSTORMAPPLICATIONSERVERIMPLSERVICE_QNAME, features);
    }

    public HPCStormApplicationServerImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public HPCStormApplicationServerImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns IHPCStormApplicationServer
     */
    @WebEndpoint(name = "HPCStormApplicationServerImplPort")
    public IHPCStormApplicationServer getHPCStormApplicationServerImplPort() {
        return super.getPort(new QName("http://service.application.safe.pargo.mdcc.ufc.br/", "HPCStormApplicationServerImplPort"), IHPCStormApplicationServer.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IHPCStormApplicationServer
     */
    @WebEndpoint(name = "HPCStormApplicationServerImplPort")
    public IHPCStormApplicationServer getHPCStormApplicationServerImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://service.application.safe.pargo.mdcc.ufc.br/", "HPCStormApplicationServerImplPort"), IHPCStormApplicationServer.class, features);
    }

    private static URL __getWsdlLocation() {
        if (HPCSTORMAPPLICATIONSERVERIMPLSERVICE_EXCEPTION!= null) {
            throw HPCSTORMAPPLICATIONSERVERIMPLSERVICE_EXCEPTION;
        }
        return HPCSTORMAPPLICATIONSERVERIMPLSERVICE_WSDL_LOCATION;
    }

}
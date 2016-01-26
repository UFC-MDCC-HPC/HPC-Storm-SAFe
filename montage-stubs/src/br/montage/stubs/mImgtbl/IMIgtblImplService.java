
package br.montage.stubs.mImgtbl;

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
@WebServiceClient(name = "I_mIgtblImplService", targetNamespace = "http://be.montage.ufc.br/", wsdlLocation = "http://localhost:10009/mImgtbl?wsdl")
public class IMIgtblImplService
    extends Service
{

    private final static URL IMIGTBLIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException IMIGTBLIMPLSERVICE_EXCEPTION;
    private final static QName IMIGTBLIMPLSERVICE_QNAME = new QName("http://be.montage.ufc.br/", "I_mIgtblImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:10009/mImgtbl?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        IMIGTBLIMPLSERVICE_WSDL_LOCATION = url;
        IMIGTBLIMPLSERVICE_EXCEPTION = e;
    }

    public IMIgtblImplService() {
        super(__getWsdlLocation(), IMIGTBLIMPLSERVICE_QNAME);
    }

    public IMIgtblImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), IMIGTBLIMPLSERVICE_QNAME, features);
    }

    public IMIgtblImplService(URL wsdlLocation) {
        super(wsdlLocation, IMIGTBLIMPLSERVICE_QNAME);
    }

    public IMIgtblImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, IMIGTBLIMPLSERVICE_QNAME, features);
    }

    public IMIgtblImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public IMIgtblImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns IMIgtbl
     */
    @WebEndpoint(name = "I_mIgtblImplPort")
    public IMIgtbl getIMIgtblImplPort() {
        return super.getPort(new QName("http://be.montage.ufc.br/", "I_mIgtblImplPort"), IMIgtbl.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IMIgtbl
     */
    @WebEndpoint(name = "I_mIgtblImplPort")
    public IMIgtbl getIMIgtblImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://be.montage.ufc.br/", "I_mIgtblImplPort"), IMIgtbl.class, features);
    }

    private static URL __getWsdlLocation() {
        if (IMIGTBLIMPLSERVICE_EXCEPTION!= null) {
            throw IMIGTBLIMPLSERVICE_EXCEPTION;
        }
        return IMIGTBLIMPLSERVICE_WSDL_LOCATION;
    }

}

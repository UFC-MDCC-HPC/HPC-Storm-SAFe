
package br.montage.stubs.mFitExec;

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
@WebServiceClient(name = "I_mFitExecImplService", targetNamespace = "http://be.montage.ufc.br/", wsdlLocation = "http://localhost:10008/mFitExec?wsdl")
public class IMFitExecImplService
    extends Service
{

    private final static URL IMFITEXECIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException IMFITEXECIMPLSERVICE_EXCEPTION;
    private final static QName IMFITEXECIMPLSERVICE_QNAME = new QName("http://be.montage.ufc.br/", "I_mFitExecImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:10008/mFitExec?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        IMFITEXECIMPLSERVICE_WSDL_LOCATION = url;
        IMFITEXECIMPLSERVICE_EXCEPTION = e;
    }

    public IMFitExecImplService() {
        super(__getWsdlLocation(), IMFITEXECIMPLSERVICE_QNAME);
    }

    public IMFitExecImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), IMFITEXECIMPLSERVICE_QNAME, features);
    }

    public IMFitExecImplService(URL wsdlLocation) {
        super(wsdlLocation, IMFITEXECIMPLSERVICE_QNAME);
    }

    public IMFitExecImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, IMFITEXECIMPLSERVICE_QNAME, features);
    }

    public IMFitExecImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public IMFitExecImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns IMFitExec
     */
    @WebEndpoint(name = "I_mFitExecImplPort")
    public IMFitExec getIMFitExecImplPort() {
        return super.getPort(new QName("http://be.montage.ufc.br/", "I_mFitExecImplPort"), IMFitExec.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IMFitExec
     */
    @WebEndpoint(name = "I_mFitExecImplPort")
    public IMFitExec getIMFitExecImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://be.montage.ufc.br/", "I_mFitExecImplPort"), IMFitExec.class, features);
    }

    private static URL __getWsdlLocation() {
        if (IMFITEXECIMPLSERVICE_EXCEPTION!= null) {
            throw IMFITEXECIMPLSERVICE_EXCEPTION;
        }
        return IMFITEXECIMPLSERVICE_WSDL_LOCATION;
    }

}

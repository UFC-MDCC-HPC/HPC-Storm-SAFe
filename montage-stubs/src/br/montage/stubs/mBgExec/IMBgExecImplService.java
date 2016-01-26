
package br.montage.stubs.mBgExec;

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
@WebServiceClient(name = "I_mBgExecImplService", targetNamespace = "http://be.montage.ufc.br/", wsdlLocation = "http://localhost:10005/mBgExec?wsdl")
public class IMBgExecImplService
    extends Service
{

    private final static URL IMBGEXECIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException IMBGEXECIMPLSERVICE_EXCEPTION;
    private final static QName IMBGEXECIMPLSERVICE_QNAME = new QName("http://be.montage.ufc.br/", "I_mBgExecImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:10005/mBgExec?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        IMBGEXECIMPLSERVICE_WSDL_LOCATION = url;
        IMBGEXECIMPLSERVICE_EXCEPTION = e;
    }

    public IMBgExecImplService() {
        super(__getWsdlLocation(), IMBGEXECIMPLSERVICE_QNAME);
    }

    public IMBgExecImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), IMBGEXECIMPLSERVICE_QNAME, features);
    }

    public IMBgExecImplService(URL wsdlLocation) {
        super(wsdlLocation, IMBGEXECIMPLSERVICE_QNAME);
    }

    public IMBgExecImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, IMBGEXECIMPLSERVICE_QNAME, features);
    }

    public IMBgExecImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public IMBgExecImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns IMBgExec
     */
    @WebEndpoint(name = "I_mBgExecImplPort")
    public IMBgExec getIMBgExecImplPort() {
        return super.getPort(new QName("http://be.montage.ufc.br/", "I_mBgExecImplPort"), IMBgExec.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IMBgExec
     */
    @WebEndpoint(name = "I_mBgExecImplPort")
    public IMBgExec getIMBgExecImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://be.montage.ufc.br/", "I_mBgExecImplPort"), IMBgExec.class, features);
    }

    private static URL __getWsdlLocation() {
        if (IMBGEXECIMPLSERVICE_EXCEPTION!= null) {
            throw IMBGEXECIMPLSERVICE_EXCEPTION;
        }
        return IMBGEXECIMPLSERVICE_WSDL_LOCATION;
    }

}

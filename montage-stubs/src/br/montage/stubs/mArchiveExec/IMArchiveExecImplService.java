
package br.montage.stubs.mArchiveExec;

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
@WebServiceClient(name = "I_mArchiveExecImplService", targetNamespace = "http://be.montage.ufc.br/", wsdlLocation = "http://localhost:10014/mArchiveExec?wsdl")
public class IMArchiveExecImplService
    extends Service
{

    private final static URL IMARCHIVEEXECIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException IMARCHIVEEXECIMPLSERVICE_EXCEPTION;
    private final static QName IMARCHIVEEXECIMPLSERVICE_QNAME = new QName("http://be.montage.ufc.br/", "I_mArchiveExecImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:10014/mArchiveExec?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        IMARCHIVEEXECIMPLSERVICE_WSDL_LOCATION = url;
        IMARCHIVEEXECIMPLSERVICE_EXCEPTION = e;
    }

    public IMArchiveExecImplService() {
        super(__getWsdlLocation(), IMARCHIVEEXECIMPLSERVICE_QNAME);
    }

    public IMArchiveExecImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), IMARCHIVEEXECIMPLSERVICE_QNAME, features);
    }

    public IMArchiveExecImplService(URL wsdlLocation) {
        super(wsdlLocation, IMARCHIVEEXECIMPLSERVICE_QNAME);
    }

    public IMArchiveExecImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, IMARCHIVEEXECIMPLSERVICE_QNAME, features);
    }

    public IMArchiveExecImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public IMArchiveExecImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns IMArchiveExec
     */
    @WebEndpoint(name = "I_mArchiveExecImplPort")
    public IMArchiveExec getIMArchiveExecImplPort() {
        return super.getPort(new QName("http://be.montage.ufc.br/", "I_mArchiveExecImplPort"), IMArchiveExec.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IMArchiveExec
     */
    @WebEndpoint(name = "I_mArchiveExecImplPort")
    public IMArchiveExec getIMArchiveExecImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://be.montage.ufc.br/", "I_mArchiveExecImplPort"), IMArchiveExec.class, features);
    }

    private static URL __getWsdlLocation() {
        if (IMARCHIVEEXECIMPLSERVICE_EXCEPTION!= null) {
            throw IMARCHIVEEXECIMPLSERVICE_EXCEPTION;
        }
        return IMARCHIVEEXECIMPLSERVICE_WSDL_LOCATION;
    }

}

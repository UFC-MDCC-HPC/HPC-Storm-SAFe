
package br.ufc.m101.stubs.mfitexec.tsk;

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
@WebServiceClient(name = "MFitExecTskPortImplService", targetNamespace = "http://mfitexec.component.m101.ufc.br/", wsdlLocation = "http://localhost:11409/mfitexec-tsk?wsdl")
public class MFitExecTskPortImplService
    extends Service
{

    private final static URL MFITEXECTSKPORTIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException MFITEXECTSKPORTIMPLSERVICE_EXCEPTION;
    private final static QName MFITEXECTSKPORTIMPLSERVICE_QNAME = new QName("http://mfitexec.component.m101.ufc.br/", "MFitExecTskPortImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:11409/mfitexec-tsk?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        MFITEXECTSKPORTIMPLSERVICE_WSDL_LOCATION = url;
        MFITEXECTSKPORTIMPLSERVICE_EXCEPTION = e;
    }

    public MFitExecTskPortImplService() {
        super(__getWsdlLocation(), MFITEXECTSKPORTIMPLSERVICE_QNAME);
    }

    public MFitExecTskPortImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), MFITEXECTSKPORTIMPLSERVICE_QNAME, features);
    }

    public MFitExecTskPortImplService(URL wsdlLocation) {
        super(wsdlLocation, MFITEXECTSKPORTIMPLSERVICE_QNAME);
    }

    public MFitExecTskPortImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, MFITEXECTSKPORTIMPLSERVICE_QNAME, features);
    }

    public MFitExecTskPortImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MFitExecTskPortImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns MFitExecTskPort
     */
    @WebEndpoint(name = "MFitExecTskPortImplPort")
    public MFitExecTskPort getMFitExecTskPortImplPort() {
        return super.getPort(new QName("http://mfitexec.component.m101.ufc.br/", "MFitExecTskPortImplPort"), MFitExecTskPort.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MFitExecTskPort
     */
    @WebEndpoint(name = "MFitExecTskPortImplPort")
    public MFitExecTskPort getMFitExecTskPortImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://mfitexec.component.m101.ufc.br/", "MFitExecTskPortImplPort"), MFitExecTskPort.class, features);
    }

    private static URL __getWsdlLocation() {
        if (MFITEXECTSKPORTIMPLSERVICE_EXCEPTION!= null) {
            throw MFITEXECTSKPORTIMPLSERVICE_EXCEPTION;
        }
        return MFITEXECTSKPORTIMPLSERVICE_WSDL_LOCATION;
    }

}

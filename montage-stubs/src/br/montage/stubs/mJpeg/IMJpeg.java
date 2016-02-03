
package br.montage.stubs.mJpeg;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "I_mJpeg", targetNamespace = "http://be.montage.ufc.br/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IMJpeg {


    /**
     * 
     */
    @WebMethod
    @RequestWrapper(localName = "go", targetNamespace = "http://be.montage.ufc.br/", className = "br.montage.stubs.mJpeg.Go")
    @ResponseWrapper(localName = "goResponse", targetNamespace = "http://be.montage.ufc.br/", className = "br.montage.stubs.mJpeg.GoResponse")
    @Action(input = "http://be.montage.ufc.br/I_mJpeg/goRequest", output = "http://be.montage.ufc.br/I_mJpeg/goResponse")
    public void go();

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "setFitsPortUses", targetNamespace = "http://be.montage.ufc.br/", className = "br.montage.stubs.mJpeg.SetFitsPortUses")
    @ResponseWrapper(localName = "setFitsPortUsesResponse", targetNamespace = "http://be.montage.ufc.br/", className = "br.montage.stubs.mJpeg.SetFitsPortUsesResponse")
    @Action(input = "http://be.montage.ufc.br/I_mJpeg/setFitsPortUsesRequest", output = "http://be.montage.ufc.br/I_mJpeg/setFitsPortUsesResponse")
    public void setFitsPortUses(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getJpgPortProvides", targetNamespace = "http://be.montage.ufc.br/", className = "br.montage.stubs.mJpeg.GetJpgPortProvides")
    @ResponseWrapper(localName = "getJpgPortProvidesResponse", targetNamespace = "http://be.montage.ufc.br/", className = "br.montage.stubs.mJpeg.GetJpgPortProvidesResponse")
    @Action(input = "http://be.montage.ufc.br/I_mJpeg/getJpgPortProvidesRequest", output = "http://be.montage.ufc.br/I_mJpeg/getJpgPortProvidesResponse")
    public String getJpgPortProvides();

}
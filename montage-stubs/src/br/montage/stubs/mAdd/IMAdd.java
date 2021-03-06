
package br.montage.stubs.mAdd;

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
@WebService(name = "I_mAdd", targetNamespace = "http://be.montage.ufc.br/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IMAdd {


    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getfitsPortProvides", targetNamespace = "http://be.montage.ufc.br/", className = "br.montage.stubs.mAdd.GetfitsPortProvides")
    @ResponseWrapper(localName = "getfitsPortProvidesResponse", targetNamespace = "http://be.montage.ufc.br/", className = "br.montage.stubs.mAdd.GetfitsPortProvidesResponse")
    @Action(input = "http://be.montage.ufc.br/I_mAdd/getfitsPortProvidesRequest", output = "http://be.montage.ufc.br/I_mAdd/getfitsPortProvidesResponse")
    public String getfitsPortProvides();

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "setTblPortUses", targetNamespace = "http://be.montage.ufc.br/", className = "br.montage.stubs.mAdd.SetTblPortUses")
    @ResponseWrapper(localName = "setTblPortUsesResponse", targetNamespace = "http://be.montage.ufc.br/", className = "br.montage.stubs.mAdd.SetTblPortUsesResponse")
    @Action(input = "http://be.montage.ufc.br/I_mAdd/setTblPortUsesRequest", output = "http://be.montage.ufc.br/I_mAdd/setTblPortUsesResponse")
    public void setTblPortUses(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "setDirPortUses", targetNamespace = "http://be.montage.ufc.br/", className = "br.montage.stubs.mAdd.SetDirPortUses")
    @ResponseWrapper(localName = "setDirPortUsesResponse", targetNamespace = "http://be.montage.ufc.br/", className = "br.montage.stubs.mAdd.SetDirPortUsesResponse")
    @Action(input = "http://be.montage.ufc.br/I_mAdd/setDirPortUsesRequest", output = "http://be.montage.ufc.br/I_mAdd/setDirPortUsesResponse")
    public void setDirPortUses(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "setHdrPortUses", targetNamespace = "http://be.montage.ufc.br/", className = "br.montage.stubs.mAdd.SetHdrPortUses")
    @ResponseWrapper(localName = "setHdrPortUsesResponse", targetNamespace = "http://be.montage.ufc.br/", className = "br.montage.stubs.mAdd.SetHdrPortUsesResponse")
    @Action(input = "http://be.montage.ufc.br/I_mAdd/setHdrPortUsesRequest", output = "http://be.montage.ufc.br/I_mAdd/setHdrPortUsesResponse")
    public void setHdrPortUses(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     */
    @WebMethod
    @RequestWrapper(localName = "go", targetNamespace = "http://be.montage.ufc.br/", className = "br.montage.stubs.mAdd.Go")
    @ResponseWrapper(localName = "goResponse", targetNamespace = "http://be.montage.ufc.br/", className = "br.montage.stubs.mAdd.GoResponse")
    @Action(input = "http://be.montage.ufc.br/I_mAdd/goRequest", output = "http://be.montage.ufc.br/I_mAdd/goResponse")
    public void go();

}


package br.montage.stubs.mBgModel;

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
@WebService(name = "I_mBgModel", targetNamespace = "http://be.montage.ufc.br/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IMBgModel {


    /**
     * 
     */
    @WebMethod
    @RequestWrapper(localName = "go", targetNamespace = "http://be.montage.ufc.br/", className = "br.montage.stubs.mBgModel.Go")
    @ResponseWrapper(localName = "goResponse", targetNamespace = "http://be.montage.ufc.br/", className = "br.montage.stubs.mBgModel.GoResponse")
    @Action(input = "http://be.montage.ufc.br/I_mBgModel/goRequest", output = "http://be.montage.ufc.br/I_mBgModel/goResponse")
    public void go();

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "setTblPortUsesA", targetNamespace = "http://be.montage.ufc.br/", className = "br.montage.stubs.mBgModel.SetTblPortUsesA")
    @ResponseWrapper(localName = "setTblPortUsesAResponse", targetNamespace = "http://be.montage.ufc.br/", className = "br.montage.stubs.mBgModel.SetTblPortUsesAResponse")
    @Action(input = "http://be.montage.ufc.br/I_mBgModel/setTblPortUsesARequest", output = "http://be.montage.ufc.br/I_mBgModel/setTblPortUsesAResponse")
    public void setTblPortUsesA(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getTblPortProvides", targetNamespace = "http://be.montage.ufc.br/", className = "br.montage.stubs.mBgModel.GetTblPortProvides")
    @ResponseWrapper(localName = "getTblPortProvidesResponse", targetNamespace = "http://be.montage.ufc.br/", className = "br.montage.stubs.mBgModel.GetTblPortProvidesResponse")
    @Action(input = "http://be.montage.ufc.br/I_mBgModel/getTblPortProvidesRequest", output = "http://be.montage.ufc.br/I_mBgModel/getTblPortProvidesResponse")
    public String getTblPortProvides();

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "settblPortUsesB", targetNamespace = "http://be.montage.ufc.br/", className = "br.montage.stubs.mBgModel.SettblPortUsesB")
    @ResponseWrapper(localName = "settblPortUsesBResponse", targetNamespace = "http://be.montage.ufc.br/", className = "br.montage.stubs.mBgModel.SettblPortUsesBResponse")
    @Action(input = "http://be.montage.ufc.br/I_mBgModel/settblPortUsesBRequest", output = "http://be.montage.ufc.br/I_mBgModel/settblPortUsesBResponse")
    public void settblPortUsesB(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
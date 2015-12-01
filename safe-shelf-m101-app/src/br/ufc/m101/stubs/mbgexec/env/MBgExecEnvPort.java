
package br.ufc.m101.stubs.mbgexec.env;

import javax.jws.WebMethod;
import javax.jws.WebParam;
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
@WebService(name = "MBgExecEnvPort", targetNamespace = "http://mbgexec.component.m101.ufc.br/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface MBgExecEnvPort {


    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "setParams", targetNamespace = "http://mbgexec.component.m101.ufc.br/", className = "br.ufc.m101.stubs.mbgexec.env.SetParams")
    @ResponseWrapper(localName = "setParamsResponse", targetNamespace = "http://mbgexec.component.m101.ufc.br/", className = "br.ufc.m101.stubs.mbgexec.env.SetParamsResponse")
    @Action(input = "http://mbgexec.component.m101.ufc.br/MBgExecEnvPort/setParamsRequest", output = "http://mbgexec.component.m101.ufc.br/MBgExecEnvPort/setParamsResponse")
    public void setParams(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}

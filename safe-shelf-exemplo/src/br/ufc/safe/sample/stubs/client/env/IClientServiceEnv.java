
package br.ufc.safe.sample.stubs.client.env;

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
@WebService(name = "IClientServiceEnv", targetNamespace = "http://client.service.sample.safe.ufc.br/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IClientServiceEnv {


    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "addMessage", targetNamespace = "http://client.service.sample.safe.ufc.br/", className = "br.ufc.safe.sample.stubs.client.env.AddMessage")
    @ResponseWrapper(localName = "addMessageResponse", targetNamespace = "http://client.service.sample.safe.ufc.br/", className = "br.ufc.safe.sample.stubs.client.env.AddMessageResponse")
    @Action(input = "http://client.service.sample.safe.ufc.br/IClientServiceEnv/addMessageRequest", output = "http://client.service.sample.safe.ufc.br/IClientServiceEnv/addMessageResponse")
    public void addMessage(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
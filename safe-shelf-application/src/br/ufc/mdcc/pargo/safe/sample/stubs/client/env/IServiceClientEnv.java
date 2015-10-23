
package br.ufc.mdcc.pargo.safe.sample.stubs.client.env;

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
@WebService(name = "IServiceClientEnv", targetNamespace = "http://env.port.client.backend.pargo.mdcc.ufc.br/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IServiceClientEnv {


    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "setServerPort", targetNamespace = "http://env.port.client.backend.pargo.mdcc.ufc.br/", className = "br.ufc.mdcc.pargo.safe.sample.stubs.client.env.SetServerPort")
    @ResponseWrapper(localName = "setServerPortResponse", targetNamespace = "http://env.port.client.backend.pargo.mdcc.ufc.br/", className = "br.ufc.mdcc.pargo.safe.sample.stubs.client.env.SetServerPortResponse")
    @Action(input = "http://env.port.client.backend.pargo.mdcc.ufc.br/IServiceClientEnv/setServerPortRequest", output = "http://env.port.client.backend.pargo.mdcc.ufc.br/IServiceClientEnv/setServerPortResponse")
    public void setServerPort(
        @WebParam(name = "arg0", targetNamespace = "")
        Integer arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "addMesssageToBuffer", targetNamespace = "http://env.port.client.backend.pargo.mdcc.ufc.br/", className = "br.ufc.mdcc.pargo.safe.sample.stubs.client.env.AddMesssageToBuffer")
    @ResponseWrapper(localName = "addMesssageToBufferResponse", targetNamespace = "http://env.port.client.backend.pargo.mdcc.ufc.br/", className = "br.ufc.mdcc.pargo.safe.sample.stubs.client.env.AddMesssageToBufferResponse")
    @Action(input = "http://env.port.client.backend.pargo.mdcc.ufc.br/IServiceClientEnv/addMesssageToBufferRequest", output = "http://env.port.client.backend.pargo.mdcc.ufc.br/IServiceClientEnv/addMesssageToBufferResponse")
    public void addMesssageToBuffer(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     */
    @WebMethod
    @RequestWrapper(localName = "requestMessage", targetNamespace = "http://env.port.client.backend.pargo.mdcc.ufc.br/", className = "br.ufc.mdcc.pargo.safe.sample.stubs.client.env.RequestMessage")
    @ResponseWrapper(localName = "requestMessageResponse", targetNamespace = "http://env.port.client.backend.pargo.mdcc.ufc.br/", className = "br.ufc.mdcc.pargo.safe.sample.stubs.client.env.RequestMessageResponse")
    @Action(input = "http://env.port.client.backend.pargo.mdcc.ufc.br/IServiceClientEnv/requestMessageRequest", output = "http://env.port.client.backend.pargo.mdcc.ufc.br/IServiceClientEnv/requestMessageResponse")
    public void requestMessage();

}

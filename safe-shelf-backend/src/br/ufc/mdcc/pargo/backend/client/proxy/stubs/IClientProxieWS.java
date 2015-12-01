
package br.ufc.mdcc.pargo.backend.client.proxy.stubs;

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
@WebService(name = "IClientProxieWS", targetNamespace = "http://service.client.sample.safe.pargo.mdcc.ufc.br/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IClientProxieWS {


    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "setClientProxie", targetNamespace = "http://service.client.sample.safe.pargo.mdcc.ufc.br/", className = "br.ufc.mdcc.pargo.backend.client.proxy.stubs.SetClientProxie")
    @ResponseWrapper(localName = "setClientProxieResponse", targetNamespace = "http://service.client.sample.safe.pargo.mdcc.ufc.br/", className = "br.ufc.mdcc.pargo.backend.client.proxy.stubs.SetClientProxieResponse")
    @Action(input = "http://service.client.sample.safe.pargo.mdcc.ufc.br/IClientProxieWS/setClientProxieRequest", output = "http://service.client.sample.safe.pargo.mdcc.ufc.br/IClientProxieWS/setClientProxieResponse")
    public void setClientProxie(
        @WebParam(name = "arg0", targetNamespace = "")
        ClientComponentProxie arg0);

    /**
     * 
     */
    @WebMethod
    @RequestWrapper(localName = "requestMessage", targetNamespace = "http://service.client.sample.safe.pargo.mdcc.ufc.br/", className = "br.ufc.mdcc.pargo.backend.client.proxy.stubs.RequestMessage")
    @ResponseWrapper(localName = "requestMessageResponse", targetNamespace = "http://service.client.sample.safe.pargo.mdcc.ufc.br/", className = "br.ufc.mdcc.pargo.backend.client.proxy.stubs.RequestMessageResponse")
    @Action(input = "http://service.client.sample.safe.pargo.mdcc.ufc.br/IClientProxieWS/requestMessageRequest", output = "http://service.client.sample.safe.pargo.mdcc.ufc.br/IClientProxieWS/requestMessageResponse")
    public void requestMessage();

}
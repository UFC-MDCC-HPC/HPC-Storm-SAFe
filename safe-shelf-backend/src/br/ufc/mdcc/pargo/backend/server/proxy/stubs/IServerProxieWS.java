
package br.ufc.mdcc.pargo.backend.server.proxy.stubs;

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
@WebService(name = "IServerProxieWS", targetNamespace = "http://service.server.sample.safe.pargo.mdcc.ufc.br/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IServerProxieWS {


    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "setServerProxie", targetNamespace = "http://service.server.sample.safe.pargo.mdcc.ufc.br/", className = "br.ufc.mdcc.pargo.backend.server.proxy.stubs.SetServerProxie")
    @ResponseWrapper(localName = "setServerProxieResponse", targetNamespace = "http://service.server.sample.safe.pargo.mdcc.ufc.br/", className = "br.ufc.mdcc.pargo.backend.server.proxy.stubs.SetServerProxieResponse")
    @Action(input = "http://service.server.sample.safe.pargo.mdcc.ufc.br/IServerProxieWS/setServerProxieRequest", output = "http://service.server.sample.safe.pargo.mdcc.ufc.br/IServerProxieWS/setServerProxieResponse")
    public void setServerProxie(
        @WebParam(name = "arg0", targetNamespace = "")
        ServerComponentProxie arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "sendMessage", targetNamespace = "http://service.server.sample.safe.pargo.mdcc.ufc.br/", className = "br.ufc.mdcc.pargo.backend.server.proxy.stubs.SendMessage")
    @ResponseWrapper(localName = "sendMessageResponse", targetNamespace = "http://service.server.sample.safe.pargo.mdcc.ufc.br/", className = "br.ufc.mdcc.pargo.backend.server.proxy.stubs.SendMessageResponse")
    @Action(input = "http://service.server.sample.safe.pargo.mdcc.ufc.br/IServerProxieWS/sendMessageRequest", output = "http://service.server.sample.safe.pargo.mdcc.ufc.br/IServerProxieWS/sendMessageResponse")
    public void sendMessage(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}

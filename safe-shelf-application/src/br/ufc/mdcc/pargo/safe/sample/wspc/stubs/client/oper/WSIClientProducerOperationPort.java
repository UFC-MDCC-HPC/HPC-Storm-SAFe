
package br.ufc.mdcc.pargo.safe.sample.wspc.stubs.client.oper;

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
@WebService(name = "WSIClientProducerOperationPort", targetNamespace = "http://client.pc.backend.safe.pargo.mdcc.ufc.br/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WSIClientProducerOperationPort {


    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "setServerPort", targetNamespace = "http://client.pc.backend.safe.pargo.mdcc.ufc.br/", className = "br.ufc.mdcc.pargo.safe.sample.wspc.stubs.client.oper.SetServerPort")
    @ResponseWrapper(localName = "setServerPortResponse", targetNamespace = "http://client.pc.backend.safe.pargo.mdcc.ufc.br/", className = "br.ufc.mdcc.pargo.safe.sample.wspc.stubs.client.oper.SetServerPortResponse")
    @Action(input = "http://client.pc.backend.safe.pargo.mdcc.ufc.br/WSIClientProducerOperationPort/setServerPortRequest", output = "http://client.pc.backend.safe.pargo.mdcc.ufc.br/WSIClientProducerOperationPort/setServerPortResponse")
    public void setServerPort(
        @WebParam(name = "arg0", targetNamespace = "")
        Integer arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "sendMsg", targetNamespace = "http://client.pc.backend.safe.pargo.mdcc.ufc.br/", className = "br.ufc.mdcc.pargo.safe.sample.wspc.stubs.client.oper.SendMsg")
    @ResponseWrapper(localName = "sendMsgResponse", targetNamespace = "http://client.pc.backend.safe.pargo.mdcc.ufc.br/", className = "br.ufc.mdcc.pargo.safe.sample.wspc.stubs.client.oper.SendMsgResponse")
    @Action(input = "http://client.pc.backend.safe.pargo.mdcc.ufc.br/WSIClientProducerOperationPort/sendMsgRequest", output = "http://client.pc.backend.safe.pargo.mdcc.ufc.br/WSIClientProducerOperationPort/sendMsgResponse")
    public void sendMsg(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}

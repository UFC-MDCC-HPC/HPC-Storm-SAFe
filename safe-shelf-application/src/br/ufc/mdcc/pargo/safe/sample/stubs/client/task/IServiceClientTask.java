
package br.ufc.mdcc.pargo.safe.sample.stubs.client.task;

import javax.jws.WebMethod;
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
@WebService(name = "IServiceClientTask", targetNamespace = "http://tsk.port.client.backend.pargo.mdcc.ufc.br/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IServiceClientTask {


    /**
     * 
     */
    @WebMethod
    @RequestWrapper(localName = "post", targetNamespace = "http://tsk.port.client.backend.pargo.mdcc.ufc.br/", className = "br.ufc.mdcc.pargo.safe.sample.stubs.client.task.Post")
    @ResponseWrapper(localName = "postResponse", targetNamespace = "http://tsk.port.client.backend.pargo.mdcc.ufc.br/", className = "br.ufc.mdcc.pargo.safe.sample.stubs.client.task.PostResponse")
    @Action(input = "http://tsk.port.client.backend.pargo.mdcc.ufc.br/IServiceClientTask/postRequest", output = "http://tsk.port.client.backend.pargo.mdcc.ufc.br/IServiceClientTask/postResponse")
    public void post();

    /**
     * 
     */
    @WebMethod
    @RequestWrapper(localName = "connect", targetNamespace = "http://tsk.port.client.backend.pargo.mdcc.ufc.br/", className = "br.ufc.mdcc.pargo.safe.sample.stubs.client.task.Connect")
    @ResponseWrapper(localName = "connectResponse", targetNamespace = "http://tsk.port.client.backend.pargo.mdcc.ufc.br/", className = "br.ufc.mdcc.pargo.safe.sample.stubs.client.task.ConnectResponse")
    @Action(input = "http://tsk.port.client.backend.pargo.mdcc.ufc.br/IServiceClientTask/connectRequest", output = "http://tsk.port.client.backend.pargo.mdcc.ufc.br/IServiceClientTask/connectResponse")
    public void connect();

}
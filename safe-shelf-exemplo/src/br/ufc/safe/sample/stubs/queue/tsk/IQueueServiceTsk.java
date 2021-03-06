
package br.ufc.safe.sample.stubs.queue.tsk;

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
@WebService(name = "IQueueServiceTsk", targetNamespace = "http://queue.service.sample.safe.ufc.br/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IQueueServiceTsk {


    /**
     * 
     */
    @WebMethod
    @RequestWrapper(localName = "go", targetNamespace = "http://queue.service.sample.safe.ufc.br/", className = "br.ufc.safe.sample.stubs.queue.tsk.Go")
    @ResponseWrapper(localName = "goResponse", targetNamespace = "http://queue.service.sample.safe.ufc.br/", className = "br.ufc.safe.sample.stubs.queue.tsk.GoResponse")
    @Action(input = "http://queue.service.sample.safe.ufc.br/IQueueServiceTsk/goRequest", output = "http://queue.service.sample.safe.ufc.br/IQueueServiceTsk/goResponse")
    public void go();

}

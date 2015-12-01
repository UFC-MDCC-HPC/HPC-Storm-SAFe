
package br.ufc.m101.stubs.mbgmodel.tsk;

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
@WebService(name = "MBgModelTskPort", targetNamespace = "http://mbgmodel.component.m101.ufc.br/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface MBgModelTskPort {


    /**
     * 
     */
    @WebMethod
    @RequestWrapper(localName = "go", targetNamespace = "http://mbgmodel.component.m101.ufc.br/", className = "br.ufc.m101.stubs.mbgmodel.tsk.Go")
    @ResponseWrapper(localName = "goResponse", targetNamespace = "http://mbgmodel.component.m101.ufc.br/", className = "br.ufc.m101.stubs.mbgmodel.tsk.GoResponse")
    @Action(input = "http://mbgmodel.component.m101.ufc.br/MBgModelTskPort/goRequest", output = "http://mbgmodel.component.m101.ufc.br/MBgModelTskPort/goResponse")
    public void go();

}

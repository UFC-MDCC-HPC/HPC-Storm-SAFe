
package br.ufc.m101.stubs.mbgexec.tsk;

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
@WebService(name = "MBgExecTskPortImpl", targetNamespace = "http://mbgexec.component.m101.ufc.br/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface MBgExecTskPortImpl {


    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "setMBgExec", targetNamespace = "http://mbgexec.component.m101.ufc.br/", className = "br.ufc.m101.stubs.mbgexec.tsk.SetMBgExec")
    @ResponseWrapper(localName = "setMBgExecResponse", targetNamespace = "http://mbgexec.component.m101.ufc.br/", className = "br.ufc.m101.stubs.mbgexec.tsk.SetMBgExecResponse")
    @Action(input = "http://mbgexec.component.m101.ufc.br/MBgExecTskPortImpl/setMBgExecRequest", output = "http://mbgexec.component.m101.ufc.br/MBgExecTskPortImpl/setMBgExecResponse")
    public void setMBgExec(
        @WebParam(name = "arg0", targetNamespace = "")
        MBgExec arg0);

    /**
     * 
     */
    @WebMethod
    @RequestWrapper(localName = "go", targetNamespace = "http://mbgexec.component.m101.ufc.br/", className = "br.ufc.m101.stubs.mbgexec.tsk.Go")
    @ResponseWrapper(localName = "goResponse", targetNamespace = "http://mbgexec.component.m101.ufc.br/", className = "br.ufc.m101.stubs.mbgexec.tsk.GoResponse")
    @Action(input = "http://mbgexec.component.m101.ufc.br/MBgExecTskPortImpl/goRequest", output = "http://mbgexec.component.m101.ufc.br/MBgExecTskPortImpl/goResponse")
    public void go();

}
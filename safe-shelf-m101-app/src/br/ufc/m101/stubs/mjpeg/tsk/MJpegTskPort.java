
package br.ufc.m101.stubs.mjpeg.tsk;

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
@WebService(name = "MJpegTskPort", targetNamespace = "http://mjpeg.component.m101.ufc.br/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface MJpegTskPort {


    /**
     * 
     */
    @WebMethod
    @RequestWrapper(localName = "go", targetNamespace = "http://mjpeg.component.m101.ufc.br/", className = "br.ufc.m101.stubs.mjpeg.tsk.Go")
    @ResponseWrapper(localName = "goResponse", targetNamespace = "http://mjpeg.component.m101.ufc.br/", className = "br.ufc.m101.stubs.mjpeg.tsk.GoResponse")
    @Action(input = "http://mjpeg.component.m101.ufc.br/MJpegTskPort/goRequest", output = "http://mjpeg.component.m101.ufc.br/MJpegTskPort/goResponse")
    public void go();

}

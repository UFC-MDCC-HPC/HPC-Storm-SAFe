
package br.montage.stubs.mMontageDir;

import javax.jws.WebMethod;
import javax.jws.WebResult;
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
@WebService(name = "I_MontageDir", targetNamespace = "http://be.montage.ufc.br/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IMontageDir {


    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getRawDir", targetNamespace = "http://be.montage.ufc.br/", className = "br.montage.stubs.mMontageDir.GetRawDir")
    @ResponseWrapper(localName = "getRawDirResponse", targetNamespace = "http://be.montage.ufc.br/", className = "br.montage.stubs.mMontageDir.GetRawDirResponse")
    @Action(input = "http://be.montage.ufc.br/I_MontageDir/getRawDirRequest", output = "http://be.montage.ufc.br/I_MontageDir/getRawDirResponse")
    public String getRawDir();

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getProjDir", targetNamespace = "http://be.montage.ufc.br/", className = "br.montage.stubs.mMontageDir.GetProjDir")
    @ResponseWrapper(localName = "getProjDirResponse", targetNamespace = "http://be.montage.ufc.br/", className = "br.montage.stubs.mMontageDir.GetProjDirResponse")
    @Action(input = "http://be.montage.ufc.br/I_MontageDir/getProjDirRequest", output = "http://be.montage.ufc.br/I_MontageDir/getProjDirResponse")
    public String getProjDir();

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCorrDir", targetNamespace = "http://be.montage.ufc.br/", className = "br.montage.stubs.mMontageDir.GetCorrDir")
    @ResponseWrapper(localName = "getCorrDirResponse", targetNamespace = "http://be.montage.ufc.br/", className = "br.montage.stubs.mMontageDir.GetCorrDirResponse")
    @Action(input = "http://be.montage.ufc.br/I_MontageDir/getCorrDirRequest", output = "http://be.montage.ufc.br/I_MontageDir/getCorrDirResponse")
    public String getCorrDir();

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getDiffDir", targetNamespace = "http://be.montage.ufc.br/", className = "br.montage.stubs.mMontageDir.GetDiffDir")
    @ResponseWrapper(localName = "getDiffDirResponse", targetNamespace = "http://be.montage.ufc.br/", className = "br.montage.stubs.mMontageDir.GetDiffDirResponse")
    @Action(input = "http://be.montage.ufc.br/I_MontageDir/getDiffDirRequest", output = "http://be.montage.ufc.br/I_MontageDir/getDiffDirResponse")
    public String getDiffDir();

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "getDss2bDir")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getDss2bDir", targetNamespace = "http://be.montage.ufc.br/", className = "br.montage.stubs.mMontageDir.GetDss2BDir")
    @ResponseWrapper(localName = "getDss2bDirResponse", targetNamespace = "http://be.montage.ufc.br/", className = "br.montage.stubs.mMontageDir.GetDss2BDirResponse")
    @Action(input = "http://be.montage.ufc.br/I_MontageDir/getDss2bDirRequest", output = "http://be.montage.ufc.br/I_MontageDir/getDss2bDirResponse")
    public String getDss2BDir();

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "getDss2rDir")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getDss2rDir", targetNamespace = "http://be.montage.ufc.br/", className = "br.montage.stubs.mMontageDir.GetDss2RDir")
    @ResponseWrapper(localName = "getDss2rDirResponse", targetNamespace = "http://be.montage.ufc.br/", className = "br.montage.stubs.mMontageDir.GetDss2RDirResponse")
    @Action(input = "http://be.montage.ufc.br/I_MontageDir/getDss2rDirRequest", output = "http://be.montage.ufc.br/I_MontageDir/getDss2rDirResponse")
    public String getDss2RDir();

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "getDss2irDir")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getDss2irDir", targetNamespace = "http://be.montage.ufc.br/", className = "br.montage.stubs.mMontageDir.GetDss2IrDir")
    @ResponseWrapper(localName = "getDss2irDirResponse", targetNamespace = "http://be.montage.ufc.br/", className = "br.montage.stubs.mMontageDir.GetDss2IrDirResponse")
    @Action(input = "http://be.montage.ufc.br/I_MontageDir/getDss2irDirRequest", output = "http://be.montage.ufc.br/I_MontageDir/getDss2irDirResponse")
    public String getDss2IrDir();

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getFitsDir", targetNamespace = "http://be.montage.ufc.br/", className = "br.montage.stubs.mMontageDir.GetFitsDir")
    @ResponseWrapper(localName = "getFitsDirResponse", targetNamespace = "http://be.montage.ufc.br/", className = "br.montage.stubs.mMontageDir.GetFitsDirResponse")
    @Action(input = "http://be.montage.ufc.br/I_MontageDir/getFitsDirRequest", output = "http://be.montage.ufc.br/I_MontageDir/getFitsDirResponse")
    public String getFitsDir();

}

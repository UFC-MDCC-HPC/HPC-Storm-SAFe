
package br.montage.stubs.mMontageDir;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.montage.stubs.mMontageDir package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetRawDir_QNAME = new QName("http://be.montage.ufc.br/", "getRawDir");
    private final static QName _GetDss2BDirResponse_QNAME = new QName("http://be.montage.ufc.br/", "getDss2bDirResponse");
    private final static QName _GetProjDirResponse_QNAME = new QName("http://be.montage.ufc.br/", "getProjDirResponse");
    private final static QName _GetCorrDir_QNAME = new QName("http://be.montage.ufc.br/", "getCorrDir");
    private final static QName _GetDss2RDir_QNAME = new QName("http://be.montage.ufc.br/", "getDss2rDir");
    private final static QName _GetDss2IrDirResponse_QNAME = new QName("http://be.montage.ufc.br/", "getDss2irDirResponse");
    private final static QName _GetDiffDirResponse_QNAME = new QName("http://be.montage.ufc.br/", "getDiffDirResponse");
    private final static QName _GetProjDir_QNAME = new QName("http://be.montage.ufc.br/", "getProjDir");
    private final static QName _GetDiffDir_QNAME = new QName("http://be.montage.ufc.br/", "getDiffDir");
    private final static QName _GetDss2RDirResponse_QNAME = new QName("http://be.montage.ufc.br/", "getDss2rDirResponse");
    private final static QName _GetRawDirResponse_QNAME = new QName("http://be.montage.ufc.br/", "getRawDirResponse");
    private final static QName _GetDss2IrDir_QNAME = new QName("http://be.montage.ufc.br/", "getDss2irDir");
    private final static QName _GetCorrDirResponse_QNAME = new QName("http://be.montage.ufc.br/", "getCorrDirResponse");
    private final static QName _GetDss2BDir_QNAME = new QName("http://be.montage.ufc.br/", "getDss2bDir");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.montage.stubs.mMontageDir
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetDss2RDirResponse }
     * 
     */
    public GetDss2RDirResponse createGetDss2RDirResponse() {
        return new GetDss2RDirResponse();
    }

    /**
     * Create an instance of {@link GetRawDirResponse }
     * 
     */
    public GetRawDirResponse createGetRawDirResponse() {
        return new GetRawDirResponse();
    }

    /**
     * Create an instance of {@link GetDiffDir }
     * 
     */
    public GetDiffDir createGetDiffDir() {
        return new GetDiffDir();
    }

    /**
     * Create an instance of {@link GetDiffDirResponse }
     * 
     */
    public GetDiffDirResponse createGetDiffDirResponse() {
        return new GetDiffDirResponse();
    }

    /**
     * Create an instance of {@link GetProjDir }
     * 
     */
    public GetProjDir createGetProjDir() {
        return new GetProjDir();
    }

    /**
     * Create an instance of {@link GetCorrDirResponse }
     * 
     */
    public GetCorrDirResponse createGetCorrDirResponse() {
        return new GetCorrDirResponse();
    }

    /**
     * Create an instance of {@link GetDss2BDir }
     * 
     */
    public GetDss2BDir createGetDss2BDir() {
        return new GetDss2BDir();
    }

    /**
     * Create an instance of {@link GetDss2IrDir }
     * 
     */
    public GetDss2IrDir createGetDss2IrDir() {
        return new GetDss2IrDir();
    }

    /**
     * Create an instance of {@link GetCorrDir }
     * 
     */
    public GetCorrDir createGetCorrDir() {
        return new GetCorrDir();
    }

    /**
     * Create an instance of {@link GetDss2RDir }
     * 
     */
    public GetDss2RDir createGetDss2RDir() {
        return new GetDss2RDir();
    }

    /**
     * Create an instance of {@link GetRawDir }
     * 
     */
    public GetRawDir createGetRawDir() {
        return new GetRawDir();
    }

    /**
     * Create an instance of {@link GetDss2BDirResponse }
     * 
     */
    public GetDss2BDirResponse createGetDss2BDirResponse() {
        return new GetDss2BDirResponse();
    }

    /**
     * Create an instance of {@link GetProjDirResponse }
     * 
     */
    public GetProjDirResponse createGetProjDirResponse() {
        return new GetProjDirResponse();
    }

    /**
     * Create an instance of {@link GetDss2IrDirResponse }
     * 
     */
    public GetDss2IrDirResponse createGetDss2IrDirResponse() {
        return new GetDss2IrDirResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRawDir }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "getRawDir")
    public JAXBElement<GetRawDir> createGetRawDir(GetRawDir value) {
        return new JAXBElement<GetRawDir>(_GetRawDir_QNAME, GetRawDir.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDss2BDirResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "getDss2bDirResponse")
    public JAXBElement<GetDss2BDirResponse> createGetDss2BDirResponse(GetDss2BDirResponse value) {
        return new JAXBElement<GetDss2BDirResponse>(_GetDss2BDirResponse_QNAME, GetDss2BDirResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProjDirResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "getProjDirResponse")
    public JAXBElement<GetProjDirResponse> createGetProjDirResponse(GetProjDirResponse value) {
        return new JAXBElement<GetProjDirResponse>(_GetProjDirResponse_QNAME, GetProjDirResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCorrDir }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "getCorrDir")
    public JAXBElement<GetCorrDir> createGetCorrDir(GetCorrDir value) {
        return new JAXBElement<GetCorrDir>(_GetCorrDir_QNAME, GetCorrDir.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDss2RDir }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "getDss2rDir")
    public JAXBElement<GetDss2RDir> createGetDss2RDir(GetDss2RDir value) {
        return new JAXBElement<GetDss2RDir>(_GetDss2RDir_QNAME, GetDss2RDir.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDss2IrDirResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "getDss2irDirResponse")
    public JAXBElement<GetDss2IrDirResponse> createGetDss2IrDirResponse(GetDss2IrDirResponse value) {
        return new JAXBElement<GetDss2IrDirResponse>(_GetDss2IrDirResponse_QNAME, GetDss2IrDirResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDiffDirResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "getDiffDirResponse")
    public JAXBElement<GetDiffDirResponse> createGetDiffDirResponse(GetDiffDirResponse value) {
        return new JAXBElement<GetDiffDirResponse>(_GetDiffDirResponse_QNAME, GetDiffDirResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProjDir }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "getProjDir")
    public JAXBElement<GetProjDir> createGetProjDir(GetProjDir value) {
        return new JAXBElement<GetProjDir>(_GetProjDir_QNAME, GetProjDir.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDiffDir }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "getDiffDir")
    public JAXBElement<GetDiffDir> createGetDiffDir(GetDiffDir value) {
        return new JAXBElement<GetDiffDir>(_GetDiffDir_QNAME, GetDiffDir.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDss2RDirResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "getDss2rDirResponse")
    public JAXBElement<GetDss2RDirResponse> createGetDss2RDirResponse(GetDss2RDirResponse value) {
        return new JAXBElement<GetDss2RDirResponse>(_GetDss2RDirResponse_QNAME, GetDss2RDirResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRawDirResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "getRawDirResponse")
    public JAXBElement<GetRawDirResponse> createGetRawDirResponse(GetRawDirResponse value) {
        return new JAXBElement<GetRawDirResponse>(_GetRawDirResponse_QNAME, GetRawDirResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDss2IrDir }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "getDss2irDir")
    public JAXBElement<GetDss2IrDir> createGetDss2IrDir(GetDss2IrDir value) {
        return new JAXBElement<GetDss2IrDir>(_GetDss2IrDir_QNAME, GetDss2IrDir.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCorrDirResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "getCorrDirResponse")
    public JAXBElement<GetCorrDirResponse> createGetCorrDirResponse(GetCorrDirResponse value) {
        return new JAXBElement<GetCorrDirResponse>(_GetCorrDirResponse_QNAME, GetCorrDirResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDss2BDir }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://be.montage.ufc.br/", name = "getDss2bDir")
    public JAXBElement<GetDss2BDir> createGetDss2BDir(GetDss2BDir value) {
        return new JAXBElement<GetDss2BDir>(_GetDss2BDir_QNAME, GetDss2BDir.class, null, value);
    }

}

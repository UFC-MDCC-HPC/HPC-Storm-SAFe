
package br.ufc.mdcc.pargo.safe.framework.application.biding.stubs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de setApplicationFacade complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="setApplicationFacade">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://biding.application.framework.safe.pargo.mdcc.ufc.br/}hShelfApplicationBidingServerFacade" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setApplicationFacade", propOrder = {
    "arg0"
})
public class SetApplicationFacade {

    protected HShelfApplicationBidingServerFacade arg0;

    /**
     * Obtém o valor da propriedade arg0.
     * 
     * @return
     *     possible object is
     *     {@link HShelfApplicationBidingServerFacade }
     *     
     */
    public HShelfApplicationBidingServerFacade getArg0() {
        return arg0;
    }

    /**
     * Define o valor da propriedade arg0.
     * 
     * @param value
     *     allowed object is
     *     {@link HShelfApplicationBidingServerFacade }
     *     
     */
    public void setArg0(HShelfApplicationBidingServerFacade value) {
        this.arg0 = value;
    }

}

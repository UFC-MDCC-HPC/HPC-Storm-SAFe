
package br.ufc.mdcc.pargo.safe.framework.application.biding.stubs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de fireEvent complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="fireEvent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://biding.application.framework.safe.pargo.mdcc.ufc.br/}hShelfApplicationBidingEvent" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fireEvent", propOrder = {
    "arg0"
})
public class FireEvent {

    protected HShelfApplicationBidingEvent arg0;

    /**
     * Obtém o valor da propriedade arg0.
     * 
     * @return
     *     possible object is
     *     {@link HShelfApplicationBidingEvent }
     *     
     */
    public HShelfApplicationBidingEvent getArg0() {
        return arg0;
    }

    /**
     * Define o valor da propriedade arg0.
     * 
     * @param value
     *     allowed object is
     *     {@link HShelfApplicationBidingEvent }
     *     
     */
    public void setArg0(HShelfApplicationBidingEvent value) {
        this.arg0 = value;
    }

}

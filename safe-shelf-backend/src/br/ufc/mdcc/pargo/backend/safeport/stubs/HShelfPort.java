
package br.ufc.mdcc.pargo.backend.safeport.stubs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de hShelfPort complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="hShelfPort">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="parentComponent" type="{http://service.sample.safe.pargo.mdcc.ufc.br/}hShelfComponent" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "hShelfPort", propOrder = {
    "name",
    "parentComponent"
})
@XmlSeeAlso({
    ClientServerApplicationPort.class
})
public abstract class HShelfPort {

    protected String name;
    protected HShelfComponent parentComponent;

    /**
     * Obtém o valor da propriedade name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Define o valor da propriedade name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtém o valor da propriedade parentComponent.
     * 
     * @return
     *     possible object is
     *     {@link HShelfComponent }
     *     
     */
    public HShelfComponent getParentComponent() {
        return parentComponent;
    }

    /**
     * Define o valor da propriedade parentComponent.
     * 
     * @param value
     *     allowed object is
     *     {@link HShelfComponent }
     *     
     */
    public void setParentComponent(HShelfComponent value) {
        this.parentComponent = value;
    }

}

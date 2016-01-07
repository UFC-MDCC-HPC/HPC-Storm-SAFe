//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2016.01.07 às 01:06:50 PM BRT 
//


package br.ufc.mdcc.pargo.safe.grammar.flow;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de XML_SAFe_Base complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="XML_SAFe_Base">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="order" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="oper_name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="level" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XML_SAFe_Base")
@XmlSeeAlso({
    XMLSAFeOperation.IterateOper.class,
    XMLSAFeOperation.class,
    XMLSAFeAction.class,
    XMLSAFeCompOper.class,
    XMLSAFePrimOper.class,
    ChoiceOperComplexType.Select.class,
    ChoiceOperComplexType.class
})
public class XMLSAFeBase {

    @XmlAttribute(name = "order")
    protected Integer order;
    @XmlAttribute(name = "value")
    protected String value;
    @XmlAttribute(name = "oper_name")
    protected String operName;
    @XmlAttribute(name = "level")
    protected Integer level;

    /**
     * Obtém o valor da propriedade order.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOrder() {
        return order;
    }

    /**
     * Define o valor da propriedade order.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOrder(Integer value) {
        this.order = value;
    }

    /**
     * Obtém o valor da propriedade value.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Define o valor da propriedade value.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Obtém o valor da propriedade operName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperName() {
        return operName;
    }

    /**
     * Define o valor da propriedade operName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperName(String value) {
        this.operName = value;
    }

    /**
     * Obtém o valor da propriedade level.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * Define o valor da propriedade level.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLevel(Integer value) {
        this.level = value;
    }

}

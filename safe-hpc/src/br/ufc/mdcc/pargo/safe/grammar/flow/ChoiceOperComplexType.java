//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2015.09.10 às 03:16:35 PM BRT 
//


package br.ufc.mdcc.pargo.safe.grammar.flow;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de choice_operComplexType complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="choice_operComplexType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.example.org/SAFe_workflow_V4}XML_SAFe_Base">
 *       &lt;sequence>
 *         &lt;element name="select" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.example.org/SAFe_workflow_V4}XML_SAFe_Base">
 *                 &lt;sequence>
 *                   &lt;element name="operation" type="{http://www.example.org/SAFe_workflow_V4}XML_SAFe_Operation"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="action_id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="chosen" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "choice_operComplexType", propOrder = {
    "select"
})
public class ChoiceOperComplexType
    extends XMLSAFeBase
{

    @XmlElement(required = true)
    protected List<ChoiceOperComplexType.Select> select;
    @XmlAttribute(name = "chosen")
    protected String chosen;

    /**
     * Gets the value of the select property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the select property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSelect().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ChoiceOperComplexType.Select }
     * 
     * 
     */
    public List<ChoiceOperComplexType.Select> getSelect() {
        if (select == null) {
            select = new ArrayList<ChoiceOperComplexType.Select>();
        }
        return this.select;
    }

    /**
     * Obtém o valor da propriedade chosen.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChosen() {
        return chosen;
    }

    /**
     * Define o valor da propriedade chosen.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChosen(String value) {
        this.chosen = value;
    }


    /**
     * <p>Classe Java de anonymous complex type.
     * 
     * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://www.example.org/SAFe_workflow_V4}XML_SAFe_Base">
     *       &lt;sequence>
     *         &lt;element name="operation" type="{http://www.example.org/SAFe_workflow_V4}XML_SAFe_Operation"/>
     *       &lt;/sequence>
     *       &lt;attribute name="action_id" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "operation"
    })
    public static class Select
        extends XMLSAFeBase
    {

        @XmlElement(required = true)
        protected XMLSAFeOperation operation;
        @XmlAttribute(name = "action_id")
        protected String actionId;

        /**
         * Obtém o valor da propriedade operation.
         * 
         * @return
         *     possible object is
         *     {@link XMLSAFeOperation }
         *     
         */
        public XMLSAFeOperation getOperation() {
            return operation;
        }

        /**
         * Define o valor da propriedade operation.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLSAFeOperation }
         *     
         */
        public void setOperation(XMLSAFeOperation value) {
            this.operation = value;
        }

        /**
         * Obtém o valor da propriedade actionId.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getActionId() {
            return actionId;
        }

        /**
         * Define o valor da propriedade actionId.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setActionId(String value) {
            this.actionId = value;
        }

    }

}

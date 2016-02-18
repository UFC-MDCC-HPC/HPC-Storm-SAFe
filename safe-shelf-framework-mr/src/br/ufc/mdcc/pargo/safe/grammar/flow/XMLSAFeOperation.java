//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2016.02.09 às 01:00:37 PM BRT 
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
 * <p>Classe Java de XML_SAFe_Operation complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="XML_SAFe_Operation">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.example.org/SAFe_workflow_V4}XML_SAFe_Base">
 *       &lt;choice>
 *         &lt;element name="skip_oper" type="{http://www.example.org/SAFe_workflow_V4}XML_SAFe_Base"/>
 *         &lt;element name="break_oper" type="{http://www.example.org/SAFe_workflow_V4}XML_SAFe_Base"/>
 *         &lt;element name="continue_oper" type="{http://www.example.org/SAFe_workflow_V4}XML_SAFe_Base"/>
 *         &lt;element name="start_oper" type="{http://www.example.org/SAFe_workflow_V4}XML_SAFe_Prim_Oper"/>
 *         &lt;element name="wait_oper" type="{http://www.example.org/SAFe_workflow_V4}XML_SAFe_Prim_Oper"/>
 *         &lt;element name="cancel_oper" type="{http://www.example.org/SAFe_workflow_V4}XML_SAFe_Prim_Oper"/>
 *         &lt;element name="invoke_oper" type="{http://www.example.org/SAFe_workflow_V4}XML_SAFe_Action"/>
 *         &lt;element name="sequence_oper" type="{http://www.example.org/SAFe_workflow_V4}XML_SAFe_Comp_Oper"/>
 *         &lt;element name="parallel_oper" type="{http://www.example.org/SAFe_workflow_V4}XML_SAFe_Comp_Oper"/>
 *         &lt;element name="choice_oper" type="{http://www.example.org/SAFe_workflow_V4}choice_operComplexType"/>
 *         &lt;element name="iterate_oper">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.example.org/SAFe_workflow_V4}XML_SAFe_Base">
 *                 &lt;sequence>
 *                   &lt;element name="operation" type="{http://www.example.org/SAFe_workflow_V4}XML_SAFe_Operation" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="max" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                 &lt;attribute name="iter_label" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/choice>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XML_SAFe_Operation", propOrder = {
    "skipOper",
    "breakOper",
    "continueOper",
    "startOper",
    "waitOper",
    "cancelOper",
    "invokeOper",
    "sequenceOper",
    "parallelOper",
    "choiceOper",
    "iterateOper"
})
public class XMLSAFeOperation
    extends XMLSAFeBase
{

    @XmlElement(name = "skip_oper")
    protected XMLSAFeBase skipOper;
    @XmlElement(name = "break_oper")
    protected XMLSAFeBase breakOper;
    @XmlElement(name = "continue_oper")
    protected XMLSAFeBase continueOper;
    @XmlElement(name = "start_oper")
    protected XMLSAFePrimOper startOper;
    @XmlElement(name = "wait_oper")
    protected XMLSAFePrimOper waitOper;
    @XmlElement(name = "cancel_oper")
    protected XMLSAFePrimOper cancelOper;
    @XmlElement(name = "invoke_oper")
    protected XMLSAFeAction invokeOper;
    @XmlElement(name = "sequence_oper")
    protected XMLSAFeCompOper sequenceOper;
    @XmlElement(name = "parallel_oper")
    protected XMLSAFeCompOper parallelOper;
    @XmlElement(name = "choice_oper")
    protected ChoiceOperComplexType choiceOper;
    @XmlElement(name = "iterate_oper")
    protected XMLSAFeOperation.IterateOper iterateOper;

    /**
     * Obtém o valor da propriedade skipOper.
     * 
     * @return
     *     possible object is
     *     {@link XMLSAFeBase }
     *     
     */
    public XMLSAFeBase getSkipOper() {
        return skipOper;
    }

    /**
     * Define o valor da propriedade skipOper.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLSAFeBase }
     *     
     */
    public void setSkipOper(XMLSAFeBase value) {
        this.skipOper = value;
    }

    /**
     * Obtém o valor da propriedade breakOper.
     * 
     * @return
     *     possible object is
     *     {@link XMLSAFeBase }
     *     
     */
    public XMLSAFeBase getBreakOper() {
        return breakOper;
    }

    /**
     * Define o valor da propriedade breakOper.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLSAFeBase }
     *     
     */
    public void setBreakOper(XMLSAFeBase value) {
        this.breakOper = value;
    }

    /**
     * Obtém o valor da propriedade continueOper.
     * 
     * @return
     *     possible object is
     *     {@link XMLSAFeBase }
     *     
     */
    public XMLSAFeBase getContinueOper() {
        return continueOper;
    }

    /**
     * Define o valor da propriedade continueOper.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLSAFeBase }
     *     
     */
    public void setContinueOper(XMLSAFeBase value) {
        this.continueOper = value;
    }

    /**
     * Obtém o valor da propriedade startOper.
     * 
     * @return
     *     possible object is
     *     {@link XMLSAFePrimOper }
     *     
     */
    public XMLSAFePrimOper getStartOper() {
        return startOper;
    }

    /**
     * Define o valor da propriedade startOper.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLSAFePrimOper }
     *     
     */
    public void setStartOper(XMLSAFePrimOper value) {
        this.startOper = value;
    }

    /**
     * Obtém o valor da propriedade waitOper.
     * 
     * @return
     *     possible object is
     *     {@link XMLSAFePrimOper }
     *     
     */
    public XMLSAFePrimOper getWaitOper() {
        return waitOper;
    }

    /**
     * Define o valor da propriedade waitOper.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLSAFePrimOper }
     *     
     */
    public void setWaitOper(XMLSAFePrimOper value) {
        this.waitOper = value;
    }

    /**
     * Obtém o valor da propriedade cancelOper.
     * 
     * @return
     *     possible object is
     *     {@link XMLSAFePrimOper }
     *     
     */
    public XMLSAFePrimOper getCancelOper() {
        return cancelOper;
    }

    /**
     * Define o valor da propriedade cancelOper.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLSAFePrimOper }
     *     
     */
    public void setCancelOper(XMLSAFePrimOper value) {
        this.cancelOper = value;
    }

    /**
     * Obtém o valor da propriedade invokeOper.
     * 
     * @return
     *     possible object is
     *     {@link XMLSAFeAction }
     *     
     */
    public XMLSAFeAction getInvokeOper() {
        return invokeOper;
    }

    /**
     * Define o valor da propriedade invokeOper.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLSAFeAction }
     *     
     */
    public void setInvokeOper(XMLSAFeAction value) {
        this.invokeOper = value;
    }

    /**
     * Obtém o valor da propriedade sequenceOper.
     * 
     * @return
     *     possible object is
     *     {@link XMLSAFeCompOper }
     *     
     */
    public XMLSAFeCompOper getSequenceOper() {
        return sequenceOper;
    }

    /**
     * Define o valor da propriedade sequenceOper.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLSAFeCompOper }
     *     
     */
    public void setSequenceOper(XMLSAFeCompOper value) {
        this.sequenceOper = value;
    }

    /**
     * Obtém o valor da propriedade parallelOper.
     * 
     * @return
     *     possible object is
     *     {@link XMLSAFeCompOper }
     *     
     */
    public XMLSAFeCompOper getParallelOper() {
        return parallelOper;
    }

    /**
     * Define o valor da propriedade parallelOper.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLSAFeCompOper }
     *     
     */
    public void setParallelOper(XMLSAFeCompOper value) {
        this.parallelOper = value;
    }

    /**
     * Obtém o valor da propriedade choiceOper.
     * 
     * @return
     *     possible object is
     *     {@link ChoiceOperComplexType }
     *     
     */
    public ChoiceOperComplexType getChoiceOper() {
        return choiceOper;
    }

    /**
     * Define o valor da propriedade choiceOper.
     * 
     * @param value
     *     allowed object is
     *     {@link ChoiceOperComplexType }
     *     
     */
    public void setChoiceOper(ChoiceOperComplexType value) {
        this.choiceOper = value;
    }

    /**
     * Obtém o valor da propriedade iterateOper.
     * 
     * @return
     *     possible object is
     *     {@link XMLSAFeOperation.IterateOper }
     *     
     */
    public XMLSAFeOperation.IterateOper getIterateOper() {
        return iterateOper;
    }

    /**
     * Define o valor da propriedade iterateOper.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLSAFeOperation.IterateOper }
     *     
     */
    public void setIterateOper(XMLSAFeOperation.IterateOper value) {
        this.iterateOper = value;
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
     *         &lt;element name="operation" type="{http://www.example.org/SAFe_workflow_V4}XML_SAFe_Operation" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *       &lt;attribute name="max" type="{http://www.w3.org/2001/XMLSchema}int" />
     *       &lt;attribute name="iter_label" type="{http://www.w3.org/2001/XMLSchema}string" />
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
    public static class IterateOper
        extends XMLSAFeBase
    {

        @XmlElement(required = true)
        protected List<XMLSAFeOperation> operation;
        @XmlAttribute(name = "max")
        protected Integer max;
        @XmlAttribute(name = "iter_label")
        protected String iterLabel;

        /**
         * Gets the value of the operation property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the operation property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getOperation().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link XMLSAFeOperation }
         * 
         * 
         */
        public List<XMLSAFeOperation> getOperation() {
            if (operation == null) {
                operation = new ArrayList<XMLSAFeOperation>();
            }
            return this.operation;
        }

        /**
         * Obtém o valor da propriedade max.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getMax() {
            return max;
        }

        /**
         * Define o valor da propriedade max.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setMax(Integer value) {
            this.max = value;
        }

        /**
         * Obtém o valor da propriedade iterLabel.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIterLabel() {
            return iterLabel;
        }

        /**
         * Define o valor da propriedade iterLabel.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIterLabel(String value) {
            this.iterLabel = value;
        }

    }

}

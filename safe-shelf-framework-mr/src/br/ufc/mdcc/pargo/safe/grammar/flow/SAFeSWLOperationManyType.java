//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2017.04.20 às 06:33:11 PM BRT 
//


package br.ufc.mdcc.pargo.safe.grammar.flow;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de SAFeSWL_OperationManyType complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="SAFeSWL_OperationManyType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.example.org/SAFe_workflow_V6}SAFeSWL_OperationBaseType">
 *       &lt;choice maxOccurs="unbounded">
 *         &lt;element name="skip" type="{http://www.example.org/SAFe_workflow_V6}SAFeSWL_OperationBaseType"/>
 *         &lt;element name="break" type="{http://www.example.org/SAFe_workflow_V6}SAFeSWL_OperationBaseType"/>
 *         &lt;element name="continue" type="{http://www.example.org/SAFe_workflow_V6}SAFeSWL_OperationBaseType"/>
 *         &lt;element name="start" type="{http://www.example.org/SAFe_workflow_V6}SAFeSWL_OperationPrimitiveInvokeActionAsyncType"/>
 *         &lt;element name="wait" type="{http://www.example.org/SAFe_workflow_V6}SAFeSWL_OperationPrimitiveInvokeActionAsyncType"/>
 *         &lt;element name="cancel" type="{http://www.example.org/SAFe_workflow_V6}SAFeSWL_OperationPrimitiveInvokeActionAsyncType"/>
 *         &lt;element name="invoke" type="{http://www.example.org/SAFe_workflow_V6}SAFeSWL_OperationPrimitiveInvokeActionType"/>
 *         &lt;element name="sequence" type="{http://www.example.org/SAFe_workflow_V6}SAFeSWL_OperationManyType"/>
 *         &lt;element name="parallel" type="{http://www.example.org/SAFe_workflow_V6}SAFeSWL_OperationManyType"/>
 *         &lt;element name="choice" type="{http://www.example.org/SAFe_workflow_V6}SAFeSWL_OperationChoiceType"/>
 *         &lt;element name="iterate">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.example.org/SAFe_workflow_V6}SAFeSWL_OperationBaseType">
 *                 &lt;sequence>
 *                   &lt;element name="operation" type="{http://www.example.org/SAFe_workflow_V6}SAFeSWL_OperationManyType" maxOccurs="unbounded"/>
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
@XmlType(name = "SAFeSWL_OperationManyType", propOrder = {
    "skipOrBreakOrContinue"
})
public class SAFeSWLOperationManyType
    extends SAFeSWLOperationBaseType
{

    @XmlElementRefs({
        @XmlElementRef(name = "skip", namespace = "http://www.example.org/SAFe_workflow_V6", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "parallel", namespace = "http://www.example.org/SAFe_workflow_V6", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "wait", namespace = "http://www.example.org/SAFe_workflow_V6", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "iterate", namespace = "http://www.example.org/SAFe_workflow_V6", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "sequence", namespace = "http://www.example.org/SAFe_workflow_V6", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "continue", namespace = "http://www.example.org/SAFe_workflow_V6", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "choice", namespace = "http://www.example.org/SAFe_workflow_V6", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "invoke", namespace = "http://www.example.org/SAFe_workflow_V6", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "start", namespace = "http://www.example.org/SAFe_workflow_V6", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "break", namespace = "http://www.example.org/SAFe_workflow_V6", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "cancel", namespace = "http://www.example.org/SAFe_workflow_V6", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<? extends SAFeSWLOperationBaseType>> skipOrBreakOrContinue;

    /**
     * Gets the value of the skipOrBreakOrContinue property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the skipOrBreakOrContinue property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSkipOrBreakOrContinue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link SAFeSWLOperationBaseType }{@code >}
     * {@link JAXBElement }{@code <}{@link SAFeSWLOperationManyType }{@code >}
     * {@link JAXBElement }{@code <}{@link SAFeSWLOperationPrimitiveInvokeActionAsyncType }{@code >}
     * {@link JAXBElement }{@code <}{@link SAFeSWLOperationManyType.Iterate }{@code >}
     * {@link JAXBElement }{@code <}{@link SAFeSWLOperationManyType }{@code >}
     * {@link JAXBElement }{@code <}{@link SAFeSWLOperationBaseType }{@code >}
     * {@link JAXBElement }{@code <}{@link SAFeSWLOperationChoiceType }{@code >}
     * {@link JAXBElement }{@code <}{@link SAFeSWLOperationPrimitiveInvokeActionType }{@code >}
     * {@link JAXBElement }{@code <}{@link SAFeSWLOperationPrimitiveInvokeActionAsyncType }{@code >}
     * {@link JAXBElement }{@code <}{@link SAFeSWLOperationBaseType }{@code >}
     * {@link JAXBElement }{@code <}{@link SAFeSWLOperationPrimitiveInvokeActionAsyncType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<? extends SAFeSWLOperationBaseType>> getSkipOrBreakOrContinue() {
        if (skipOrBreakOrContinue == null) {
            skipOrBreakOrContinue = new ArrayList<JAXBElement<? extends SAFeSWLOperationBaseType>>();
        }
        return this.skipOrBreakOrContinue;
    }


    /**
     * <p>Classe Java de anonymous complex type.
     * 
     * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://www.example.org/SAFe_workflow_V6}SAFeSWL_OperationBaseType">
     *       &lt;sequence>
     *         &lt;element name="operation" type="{http://www.example.org/SAFe_workflow_V6}SAFeSWL_OperationManyType" maxOccurs="unbounded"/>
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
    public static class Iterate
        extends SAFeSWLOperationBaseType
    {

        @XmlElement(required = true)
        protected List<SAFeSWLOperationManyType> operation;
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
         * {@link SAFeSWLOperationManyType }
         * 
         * 
         */
        public List<SAFeSWLOperationManyType> getOperation() {
            if (operation == null) {
                operation = new ArrayList<SAFeSWLOperationManyType>();
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

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.05.21 at 11:38:14 AM BRT 
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
 * <p>Java class for choice_operComplexType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="choice_operComplexType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.example.org/SAFe_workflow_V4}XML_SAFe_Base">
 *       &lt;sequence>
 *         &lt;element name="operation" maxOccurs="unbounded">
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
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "choice_operComplexType", propOrder = {
    "operation"
})
public class ChoiceOperComplexType
    extends XMLSAFeBase
{

    @XmlElement(required = true)
    protected List<ChoiceOperComplexType.Operation> operation;

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
     * {@link ChoiceOperComplexType.Operation }
     * 
     * 
     */
    public List<ChoiceOperComplexType.Operation> getOperation() {
        if (operation == null) {
            operation = new ArrayList<ChoiceOperComplexType.Operation>();
        }
        return this.operation;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
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
    public static class Operation
        extends XMLSAFeBase
    {

        @XmlElement(required = true)
        protected XMLSAFeOperation operation;
        @XmlAttribute(name = "action_id")
        protected String actionId;

        /**
         * Gets the value of the operation property.
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
         * Sets the value of the operation property.
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
         * Gets the value of the actionId property.
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
         * Sets the value of the actionId property.
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

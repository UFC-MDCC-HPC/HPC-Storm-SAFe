//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2017.04.20 às 06:33:11 PM BRT 
//


package br.ufc.mdcc.pargo.safe.grammar.flow;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de SAFeSWL_OperationAnyType complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="SAFeSWL_OperationAnyType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.example.org/SAFe_workflow_V6}SAFeSWL_OperationBaseType">
 *       &lt;choice>
 *         &lt;element name="skip" type="{http://www.example.org/SAFe_workflow_V6}SAFeSWL_OperationPrimitiveType"/>
 *         &lt;element name="break" type="{http://www.example.org/SAFe_workflow_V6}SAFeSWL_OperationPrimitiveType"/>
 *         &lt;element name="continue" type="{http://www.example.org/SAFe_workflow_V6}SAFeSWL_OperationPrimitiveType"/>
 *         &lt;element name="start" type="{http://www.example.org/SAFe_workflow_V6}SAFeSWL_OperationPrimitiveInvokeActionAsyncType"/>
 *         &lt;element name="wait" type="{http://www.example.org/SAFe_workflow_V6}SAFeSWL_OperationPrimitiveInvokeActionAsyncType"/>
 *         &lt;element name="cancel" type="{http://www.example.org/SAFe_workflow_V6}SAFeSWL_OperationPrimitiveInvokeActionAsyncType"/>
 *         &lt;element name="invoke" type="{http://www.example.org/SAFe_workflow_V6}SAFeSWL_OperationPrimitiveInvokeActionType"/>
 *         &lt;element name="sequence" type="{http://www.example.org/SAFe_workflow_V6}SAFeSWL_OperationManyType"/>
 *         &lt;element name="parallel" type="{http://www.example.org/SAFe_workflow_V6}SAFeSWL_OperationManyType"/>
 *         &lt;element name="choice" type="{http://www.example.org/SAFe_workflow_V6}SAFeSWL_OperationChoiceType"/>
 *         &lt;element name="iterate" type="{http://www.example.org/SAFe_workflow_V6}SAFeSWL_OperationAnyType"/>
 *       &lt;/choice>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SAFeSWL_OperationAnyType", propOrder = {
    "skip",
    "_break",
    "_continue",
    "start",
    "wait",
    "cancel",
    "invoke",
    "sequence",
    "parallel",
    "choice",
    "iterate"
})
@XmlSeeAlso({
    SAFeSWLSelectionGuardType.class
})
public class SAFeSWLOperationAnyType
    extends SAFeSWLOperationBaseType
{

    protected SAFeSWLOperationPrimitiveType skip;
    @XmlElement(name = "break")
    protected SAFeSWLOperationPrimitiveType _break;
    @XmlElement(name = "continue")
    protected SAFeSWLOperationPrimitiveType _continue;
    protected SAFeSWLOperationPrimitiveInvokeActionAsyncType start;
    protected SAFeSWLOperationPrimitiveInvokeActionAsyncType wait;
    protected SAFeSWLOperationPrimitiveInvokeActionAsyncType cancel;
    protected SAFeSWLOperationPrimitiveInvokeActionType invoke;
    protected SAFeSWLOperationManyType sequence;
    protected SAFeSWLOperationManyType parallel;
    protected SAFeSWLOperationChoiceType choice;
    protected SAFeSWLOperationAnyType iterate;

    /**
     * Obtém o valor da propriedade skip.
     * 
     * @return
     *     possible object is
     *     {@link SAFeSWLOperationPrimitiveType }
     *     
     */
    public SAFeSWLOperationPrimitiveType getSkip() {
        return skip;
    }

    /**
     * Define o valor da propriedade skip.
     * 
     * @param value
     *     allowed object is
     *     {@link SAFeSWLOperationPrimitiveType }
     *     
     */
    public void setSkip(SAFeSWLOperationPrimitiveType value) {
        this.skip = value;
    }

    /**
     * Obtém o valor da propriedade break.
     * 
     * @return
     *     possible object is
     *     {@link SAFeSWLOperationPrimitiveType }
     *     
     */
    public SAFeSWLOperationPrimitiveType getBreak() {
        return _break;
    }

    /**
     * Define o valor da propriedade break.
     * 
     * @param value
     *     allowed object is
     *     {@link SAFeSWLOperationPrimitiveType }
     *     
     */
    public void setBreak(SAFeSWLOperationPrimitiveType value) {
        this._break = value;
    }

    /**
     * Obtém o valor da propriedade continue.
     * 
     * @return
     *     possible object is
     *     {@link SAFeSWLOperationPrimitiveType }
     *     
     */
    public SAFeSWLOperationPrimitiveType getContinue() {
        return _continue;
    }

    /**
     * Define o valor da propriedade continue.
     * 
     * @param value
     *     allowed object is
     *     {@link SAFeSWLOperationPrimitiveType }
     *     
     */
    public void setContinue(SAFeSWLOperationPrimitiveType value) {
        this._continue = value;
    }

    /**
     * Obtém o valor da propriedade start.
     * 
     * @return
     *     possible object is
     *     {@link SAFeSWLOperationPrimitiveInvokeActionAsyncType }
     *     
     */
    public SAFeSWLOperationPrimitiveInvokeActionAsyncType getStart() {
        return start;
    }

    /**
     * Define o valor da propriedade start.
     * 
     * @param value
     *     allowed object is
     *     {@link SAFeSWLOperationPrimitiveInvokeActionAsyncType }
     *     
     */
    public void setStart(SAFeSWLOperationPrimitiveInvokeActionAsyncType value) {
        this.start = value;
    }

    /**
     * Obtém o valor da propriedade wait.
     * 
     * @return
     *     possible object is
     *     {@link SAFeSWLOperationPrimitiveInvokeActionAsyncType }
     *     
     */
    public SAFeSWLOperationPrimitiveInvokeActionAsyncType getWait() {
        return wait;
    }

    /**
     * Define o valor da propriedade wait.
     * 
     * @param value
     *     allowed object is
     *     {@link SAFeSWLOperationPrimitiveInvokeActionAsyncType }
     *     
     */
    public void setWait(SAFeSWLOperationPrimitiveInvokeActionAsyncType value) {
        this.wait = value;
    }

    /**
     * Obtém o valor da propriedade cancel.
     * 
     * @return
     *     possible object is
     *     {@link SAFeSWLOperationPrimitiveInvokeActionAsyncType }
     *     
     */
    public SAFeSWLOperationPrimitiveInvokeActionAsyncType getCancel() {
        return cancel;
    }

    /**
     * Define o valor da propriedade cancel.
     * 
     * @param value
     *     allowed object is
     *     {@link SAFeSWLOperationPrimitiveInvokeActionAsyncType }
     *     
     */
    public void setCancel(SAFeSWLOperationPrimitiveInvokeActionAsyncType value) {
        this.cancel = value;
    }

    /**
     * Obtém o valor da propriedade invoke.
     * 
     * @return
     *     possible object is
     *     {@link SAFeSWLOperationPrimitiveInvokeActionType }
     *     
     */
    public SAFeSWLOperationPrimitiveInvokeActionType getInvoke() {
        return invoke;
    }

    /**
     * Define o valor da propriedade invoke.
     * 
     * @param value
     *     allowed object is
     *     {@link SAFeSWLOperationPrimitiveInvokeActionType }
     *     
     */
    public void setInvoke(SAFeSWLOperationPrimitiveInvokeActionType value) {
        this.invoke = value;
    }

    /**
     * Obtém o valor da propriedade sequence.
     * 
     * @return
     *     possible object is
     *     {@link SAFeSWLOperationManyType }
     *     
     */
    public SAFeSWLOperationManyType getSequence() {
        return sequence;
    }

    /**
     * Define o valor da propriedade sequence.
     * 
     * @param value
     *     allowed object is
     *     {@link SAFeSWLOperationManyType }
     *     
     */
    public void setSequence(SAFeSWLOperationManyType value) {
        this.sequence = value;
    }

    /**
     * Obtém o valor da propriedade parallel.
     * 
     * @return
     *     possible object is
     *     {@link SAFeSWLOperationManyType }
     *     
     */
    public SAFeSWLOperationManyType getParallel() {
        return parallel;
    }

    /**
     * Define o valor da propriedade parallel.
     * 
     * @param value
     *     allowed object is
     *     {@link SAFeSWLOperationManyType }
     *     
     */
    public void setParallel(SAFeSWLOperationManyType value) {
        this.parallel = value;
    }

    /**
     * Obtém o valor da propriedade choice.
     * 
     * @return
     *     possible object is
     *     {@link SAFeSWLOperationChoiceType }
     *     
     */
    public SAFeSWLOperationChoiceType getChoice() {
        return choice;
    }

    /**
     * Define o valor da propriedade choice.
     * 
     * @param value
     *     allowed object is
     *     {@link SAFeSWLOperationChoiceType }
     *     
     */
    public void setChoice(SAFeSWLOperationChoiceType value) {
        this.choice = value;
    }

    /**
     * Obtém o valor da propriedade iterate.
     * 
     * @return
     *     possible object is
     *     {@link SAFeSWLOperationAnyType }
     *     
     */
    public SAFeSWLOperationAnyType getIterate() {
        return iterate;
    }

    /**
     * Define o valor da propriedade iterate.
     * 
     * @param value
     *     allowed object is
     *     {@link SAFeSWLOperationAnyType }
     *     
     */
    public void setIterate(SAFeSWLOperationAnyType value) {
        this.iterate = value;
    }

}

//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2017.04.20 às 06:33:11 PM BRT 
//


package br.ufc.mdcc.pargo.safe.grammar.flow;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de SAFeSWL_OperationPrimitiveInvokeActionAsyncType complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="SAFeSWL_OperationPrimitiveInvokeActionAsyncType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.example.org/SAFe_workflow_V6}SAFeSWL_OperationPrimitiveInvokeActionType">
 *       &lt;attribute name="handle_id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SAFeSWL_OperationPrimitiveInvokeActionAsyncType")
public class SAFeSWLOperationPrimitiveInvokeActionAsyncType
    extends SAFeSWLOperationPrimitiveInvokeActionType
{

    @XmlAttribute(name = "handle_id")
    protected String handleId;

    /**
     * Obtém o valor da propriedade handleId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHandleId() {
        return handleId;
    }

    /**
     * Define o valor da propriedade handleId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHandleId(String value) {
        this.handleId = value;
    }

}

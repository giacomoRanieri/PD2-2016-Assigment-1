//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.12.11 at 11:43:24 AM CET 
//


package it.polito.dp2.NFFG.sol1.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for traversalPolicyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="traversalPolicyType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.example.org/nffgInfo}reachabilityPolicyType">
 *       &lt;sequence>
 *         &lt;element name="traversedFunctionalTypes">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="funcType" type="{http://www.example.org/nffgInfo}functionalType" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
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
@XmlType(name = "traversalPolicyType", propOrder = {
    "traversedFunctionalTypes"
})
public class TraversalPolicyType
    extends ReachabilityPolicyType
{

    @XmlElement(required = true)
    protected TraversalPolicyType.TraversedFunctionalTypes traversedFunctionalTypes;

    /**
     * Gets the value of the traversedFunctionalTypes property.
     * 
     * @return
     *     possible object is
     *     {@link TraversalPolicyType.TraversedFunctionalTypes }
     *     
     */
    public TraversalPolicyType.TraversedFunctionalTypes getTraversedFunctionalTypes() {
        return traversedFunctionalTypes;
    }

    /**
     * Sets the value of the traversedFunctionalTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link TraversalPolicyType.TraversedFunctionalTypes }
     *     
     */
    public void setTraversedFunctionalTypes(TraversalPolicyType.TraversedFunctionalTypes value) {
        this.traversedFunctionalTypes = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="funcType" type="{http://www.example.org/nffgInfo}functionalType" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "funcType"
    })
    public static class TraversedFunctionalTypes {

        @XmlSchemaType(name = "string")
        protected List<FunctionalType> funcType;

        /**
         * Gets the value of the funcType property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the funcType property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getFuncType().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link FunctionalType }
         * 
         * 
         */
        public List<FunctionalType> getFuncType() {
            if (funcType == null) {
                funcType = new ArrayList<FunctionalType>();
            }
            return this.funcType;
        }

    }

}
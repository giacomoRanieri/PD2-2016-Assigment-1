//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.16 at 03:34:18 PM CET 
//


package it.polito.dp2.NFFG.sol1.jaxb;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for functionalTypeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="functionalTypeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FW"/>
 *     &lt;enumeration value="DPI"/>
 *     &lt;enumeration value="NAT"/>
 *     &lt;enumeration value="SPAM"/>
 *     &lt;enumeration value="CACHE"/>
 *     &lt;enumeration value="VPN"/>
 *     &lt;enumeration value="WEB_SERVER"/>
 *     &lt;enumeration value="WEB_CLIENT"/>
 *     &lt;enumeration value="MAIL_SERVER"/>
 *     &lt;enumeration value="MAIL_CLIENT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "functionalTypeType")
@XmlEnum
public enum FunctionalTypeType {

    FW,
    DPI,
    NAT,
    SPAM,
    CACHE,
    VPN,
    WEB_SERVER,
    WEB_CLIENT,
    MAIL_SERVER,
    MAIL_CLIENT;

    public String value() {
        return name();
    }

    public static FunctionalTypeType fromValue(String v) {
        return valueOf(v);
    }

}

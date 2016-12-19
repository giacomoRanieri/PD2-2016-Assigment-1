//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.12.19 at 11:01:42 AM CET 
//


package it.polito.dp2.NFFG.sol1.jaxb;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.polito.dp2.NFFG.sol1.jaxb package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _NffgVerifier_QNAME = new QName("http://www.example.org/nffgInfo", "nffgVerifier");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.polito.dp2.NFFG.sol1.jaxb
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link NffgType }
     * 
     */
    public NffgType createNffgType() {
        return new NffgType();
    }

    /**
     * Create an instance of {@link NodeType }
     * 
     */
    public NodeType createNodeType() {
        return new NodeType();
    }

    /**
     * Create an instance of {@link TraversalPolicyType }
     * 
     */
    public TraversalPolicyType createTraversalPolicyType() {
        return new TraversalPolicyType();
    }

    /**
     * Create an instance of {@link NffgVerifierType }
     * 
     */
    public NffgVerifierType createNffgVerifierType() {
        return new NffgVerifierType();
    }

    /**
     * Create an instance of {@link ReachabilityPolicyType }
     * 
     */
    public ReachabilityPolicyType createReachabilityPolicyType() {
        return new ReachabilityPolicyType();
    }

    /**
     * Create an instance of {@link NamedEntityType }
     * 
     */
    public NamedEntityType createNamedEntityType() {
        return new NamedEntityType();
    }

    /**
     * Create an instance of {@link PolicyType }
     * 
     */
    public PolicyType createPolicyType() {
        return new PolicyType();
    }

    /**
     * Create an instance of {@link LinkType }
     * 
     */
    public LinkType createLinkType() {
        return new LinkType();
    }

    /**
     * Create an instance of {@link VerificationResultType }
     * 
     */
    public VerificationResultType createVerificationResultType() {
        return new VerificationResultType();
    }

    /**
     * Create an instance of {@link NffgType.Nodes }
     * 
     */
    public NffgType.Nodes createNffgTypeNodes() {
        return new NffgType.Nodes();
    }

    /**
     * Create an instance of {@link NffgType.Policies }
     * 
     */
    public NffgType.Policies createNffgTypePolicies() {
        return new NffgType.Policies();
    }

    /**
     * Create an instance of {@link NodeType.Links }
     * 
     */
    public NodeType.Links createNodeTypeLinks() {
        return new NodeType.Links();
    }

    /**
     * Create an instance of {@link TraversalPolicyType.TraversedFunctionalTypes }
     * 
     */
    public TraversalPolicyType.TraversedFunctionalTypes createTraversalPolicyTypeTraversedFunctionalTypes() {
        return new TraversalPolicyType.TraversedFunctionalTypes();
    }

    /**
     * Create an instance of {@link NffgVerifierType.Nffgs }
     * 
     */
    public NffgVerifierType.Nffgs createNffgVerifierTypeNffgs() {
        return new NffgVerifierType.Nffgs();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NffgVerifierType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/nffgInfo", name = "nffgVerifier")
    public JAXBElement<NffgVerifierType> createNffgVerifier(NffgVerifierType value) {
        return new JAXBElement<NffgVerifierType>(_NffgVerifier_QNAME, NffgVerifierType.class, null, value);
    }

}

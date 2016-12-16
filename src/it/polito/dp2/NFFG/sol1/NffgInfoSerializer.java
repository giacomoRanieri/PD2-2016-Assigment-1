package it.polito.dp2.NFFG.sol1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import it.polito.dp2.NFFG.*;
import it.polito.dp2.NFFG.sol1.jaxb.*;

public class NffgInfoSerializer {

	private NffgVerifier verifier;
	private NffgVerifierType jaxbVerifier;
	private ObjectFactory objFact;

	/**
	 * Default constructror
	 *
	 * @throws NffgVerifierException
	 */
	public NffgInfoSerializer() throws NffgVerifierException {
		NffgVerifierFactory factory = NffgVerifierFactory.newInstance();
		verifier = factory.newNffgVerifier();
		this.objFact = new ObjectFactory();
		this.jaxbVerifier = objFact.createNffgVerifierType();
	}

	/**
	 * Constructor with verifier
	 *
	 * @param verifier
	 * @throws IllegalArgumentException
	 */
	public NffgInfoSerializer(NffgVerifier verifier) {
		super();
		if (verifier != null) {
			this.verifier = verifier;
			this.objFact = new ObjectFactory();
			this.jaxbVerifier = objFact.createNffgVerifierType();
		} else
			throw new IllegalArgumentException("Missing Verifier");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NffgInfoSerializer wf;
		try {
			wf = new NffgInfoSerializer();
			wf.exportToXML(args[0]);
		} catch (NffgVerifierException e) {
			System.err.println("Could not instantiate data generator.");
			e.printStackTrace();
			System.exit(1);
		} catch (JAXBException e) {
			System.err.println("Could not instantiate the JAXB context.");
			e.printStackTrace();
			System.exit(1);
		} catch (FileNotFoundException e) {
			System.err.println("Could not find the file.");
			e.printStackTrace();
			System.exit(1);
		} catch (Exception e) {
			System.err.println("Generic Error");
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void exportToXML(String outputFile) throws JAXBException, FileNotFoundException {
		JAXBContext context = JAXBContext.newInstance("it.polito.dp2.NFFG.sol1.jaxb");
		Marshaller marsh = context.createMarshaller();

		copyNffgs();

		JAXBElement<NffgVerifierType> jaxbElement = objFact.createNffgVerifier(jaxbVerifier);


		FileOutputStream output = new FileOutputStream(outputFile);
		marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
				Boolean.TRUE);
		marsh.marshal(jaxbElement, output);

	}

	public void copyNffgs() {
		NffgVerifierType.Nffgs nffgs = new NffgVerifierType.Nffgs();

		List<NffgType> nffgList = nffgs.getNffg();
		for (NffgReader graph : verifier.getNffgs()) {

			NffgType nffg = new NffgType();
			nffg.setName(graph.getName());
			nffg.setUpdateTime(convertToXMLCalendar(graph.getUpdateTime()));

			nffg.setPolicies(copyPolicies(graph.getName()));

			nffg.setNodes(copyNodes(graph.getNodes()));

			nffgList.add(nffg);
		}
		jaxbVerifier.setNffgs(nffgs);

	}

	public NffgType.Nodes copyNodes(Set<NodeReader> nodeset) {

		NffgType.Nodes nodes = new NffgType.Nodes();
		List<NodeType> nodelist = nodes.getNode();

		for (NodeReader node : nodeset) {

			NodeType nodeT = new NodeType();
			nodeT.setName(node.getName());
			nodeT.setFuncType(FunctionalTypeType.valueOf(node.getFuncType().name()));

			nodeT.setLinks(copyLinks(node.getLinks()));

			nodelist.add(nodeT);
		}

		return nodes;
	}

	public NodeType.Links copyLinks(Set<LinkReader> linkset) {
		NodeType.Links links = new NodeType.Links();
		List<LinkType> linklist = links.getLink();

		for (LinkReader link : linkset) {

			LinkType linkT = new LinkType();
			linkT.setName(link.getName());

			NamedEntityType dest = new NamedEntityType();
			dest.setName(link.getDestinationNode().getName());
			linkT.setDestinationNode(dest);

			linklist.add(linkT);
		}

		return links;
	}

	public XMLGregorianCalendar convertToXMLCalendar(Calendar c) {
		XMLGregorianCalendar calendar;
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(c.getTime());
		gc.setTimeZone(c.getTimeZone());
		try {
			calendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
		} catch (DatatypeConfigurationException e) {
			throw new Error(e);
		}
		return calendar;
	}

	public NffgType.Policies copyPolicies(String nffgName) {

		NffgType.Policies policies = new NffgType.Policies();
		List<TraversalPolicyType> traversals = policies.getTraversalPolicy();
		List<ReachabilityPolicyType> reachabilities = policies.getReachabilityPolicy();

		for (PolicyReader policy : verifier.getPolicies(nffgName)) {

			ReachabilityPolicyReader reachpol = (ReachabilityPolicyReader) policy;


			NamedEntityType dest = new NamedEntityType();
			dest.setName(reachpol.getDestinationNode().getName());

			NamedEntityType sour = new NamedEntityType();
			sour.setName(reachpol.getSourceNode().getName());

			VerificationResultType res = null;
			if (reachpol.getResult() != null) {
				res = new VerificationResultType();
				res.setVerificationResult(reachpol.getResult().getVerificationResult());
				res.setVerificationResultMsg(reachpol.getResult().getVerificationResultMsg());
				res.setVerificationTime(convertToXMLCalendar(reachpol.getResult().getVerificationTime()));
			}

			if (reachpol instanceof TraversalPolicyReader) {
				// is a traversal Policy
				TraversalPolicyReader travpol = (TraversalPolicyReader) reachpol;
				TraversalPolicyType trav = new TraversalPolicyType();

				trav.setName(travpol.getName());
				trav.setPositive(travpol.isPositive());
				trav.setResult(res);
				trav.setDestinationNode(dest);
				trav.setSourceNode(sour);

				TraversalPolicyType.TraversedFunctionalTypes types = new TraversalPolicyType.TraversedFunctionalTypes();
				List<FunctionalTypeType> typeList = types.getFuncType();
				for (FunctionalType type : travpol.getTraversedFuctionalTypes()) {
					FunctionalTypeType typetype = FunctionalTypeType.valueOf(type.name());
					typeList.add(typetype);
				}
				trav.setTraversedFunctionalTypes(types);

				traversals.add(trav);
			} else {
				// is a reachability Policy
				ReachabilityPolicyType reach = new ReachabilityPolicyType();

				reach.setName(reachpol.getName());
				reach.setPositive(reachpol.isPositive());
				reach.setResult(res);
				reach.setDestinationNode(dest);
				reach.setSourceNode(sour);

				reachabilities.add(reach);
			}
		}

		return policies;
	}

}

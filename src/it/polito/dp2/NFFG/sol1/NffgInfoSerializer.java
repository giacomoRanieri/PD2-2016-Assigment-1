package it.polito.dp2.NFFG.sol1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import it.polito.dp2.NFFG.NffgReader;
import it.polito.dp2.NFFG.NffgVerifier;
import it.polito.dp2.NFFG.NffgVerifierException;
import it.polito.dp2.NFFG.NffgVerifierFactory;
import it.polito.dp2.NFFG.sol1.jaxb.NffgType;
import it.polito.dp2.NFFG.sol1.jaxb.NffgVerifierType;
import it.polito.dp2.NFFG.sol1.jaxb.ObjectFactory;

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
	}

	/**
	 * Constructor with verifier
	 *
	 * @param verifier
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

	private void copyNffgs() {
		NffgVerifierType.Nffgs nffgs = new NffgVerifierType.Nffgs();

		List<NffgType> nffgList = nffgs.getNffg();
		for(NffgReader graph : verifier.getNffgs()){
			NffgType nffg = new NffgType();

			nffgList.add(nffg);
		}
		jaxbVerifier.setNffgs(nffgs);

	}

}

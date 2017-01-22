package it.polito.dp2.NFFG.sol1;

import it.polito.dp2.NFFG.NffgVerifier;
import it.polito.dp2.NFFG.NffgVerifierException;
import it.polito.dp2.NFFG.sol1.jaxb.NffgVerifierType;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;

public class NffgVerifierFactory extends it.polito.dp2.NFFG.NffgVerifierFactory {

	@Override
	public NffgVerifier newNffgVerifier() throws NffgVerifierException {
		String fname = System.getProperty("it.polito.dp2.NFFG.sol1.NffgInfo.file");

		NffgVerifierImpl nffgVerifier;
		try {
			JAXBContext jc = JAXBContext.newInstance("it.polito.dp2.NFFG.sol1.jaxb");

			Unmarshaller u = jc.createUnmarshaller();

			SchemaFactory sf = SchemaFactory.newInstance(javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = sf.newSchema(new File("." + File.separator + "xsd" + File.separator + "nffgInfo.xsd"));
			u.setSchema(schema);

			File xml = new File(fname);
			JAXBElement<NffgVerifierType> nv = u.unmarshal(new StreamSource(xml), NffgVerifierType.class);
			NffgVerifierType verifierType = nv.getValue();

			nffgVerifier = new NffgVerifierImpl(verifierType);
		} catch (JAXBException | SAXException e) {
			e.printStackTrace();
			throw new NffgVerifierException(e, "Unmarshal failed");
		}

		return nffgVerifier;
	}

}

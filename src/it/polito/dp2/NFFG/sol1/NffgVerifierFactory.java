package it.polito.dp2.NFFG.sol1;

import it.polito.dp2.NFFG.NffgVerifier;
import it.polito.dp2.NFFG.NffgVerifierException;
import it.polito.dp2.NFFG.sol1.jaxb.NffgVerifierType;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;

public class NffgVerifierFactory extends it.polito.dp2.NFFG.NffgVerifierFactory {

	private NffgVerifierImpl wm;

	@Override
	public NffgVerifier newNffgVerifier() throws NffgVerifierException {
		String fname = System.getProperty("it.polito.dp2.NFFG.sol1.NffgInfo.file");

		try {
			// create a JAXBContext capable of handling classes generated into
			// the primer.po package
			JAXBContext jc = JAXBContext.newInstance("it.polito.dp2.NFFG.sol1.jaxb");
			// create an Unmarshaller
			Unmarshaller u = jc.createUnmarshaller();

			SchemaFactory sf = SchemaFactory.newInstance(javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = sf.newSchema(new File("." + File.separator + "xsd" + File.separator + "nffgInfo.xsd"));
			u.setSchema(schema);

			Object nv = u.unmarshal(new File(fname));
			if (!(nv instanceof JAXBElement<?>))
				throw new NffgVerifierException();
			NffgVerifierType verifierType = ((JAXBElement<NffgVerifierType>) nv).getValue();

			wm = new NffgVerifierImpl(verifierType);
		} catch (JAXBException e) {
			e.printStackTrace();
			throw new NffgVerifierException();
		} catch (SAXException e) {
			e.printStackTrace();
		}

		return wm;
	}

}

package it.polito.dp2.NFFG.sol1;

import it.polito.dp2.NFFG.NffgVerifier;
import it.polito.dp2.NFFG.NffgVerifierException;
import it.polito.dp2.NFFG.NffgVerifierFactory;
public class NffgInfoSerializer {

	private NffgVerifier verifier;

	/**
	 * Default constructror
	 * @throws NffgVerifierException
	 */
	public NffgInfoSerializer() throws NffgVerifierException {
		NffgVerifierFactory factory = NffgVerifierFactory.newInstance();
		verifier = factory.newNffgVerifier();
	}

	/**
	 * Constructor with verifier
	 * @param verifier
	 */
	public NffgInfoSerializer(NffgVerifier verifier) {
		super();
		if (verifier != null)
			this.verifier = verifier;
		else
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
		}
	}
	
	public void exportToXML(String outputFile){
		
	}

}

package it.polito.dp2.NFFG.sol1;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import it.polito.dp2.NFFG.NffgReader;
import it.polito.dp2.NFFG.NffgVerifier;
import it.polito.dp2.NFFG.NffgVerifierException;
import it.polito.dp2.NFFG.PolicyReader;
import it.polito.dp2.NFFG.sol1.jaxb.*;

public class NffgVerifierImpl implements NffgVerifier {

	private NffgVerifierType verifier;
	private Set<NffgReader> nffgs;
	private Set<PolicyReader> policy;

	public NffgVerifierImpl(NffgVerifierType veri) throws NffgVerifierException{
		this.verifier = veri;
		this.nffgs = new HashSet<NffgReader>();
		this.policy = new HashSet<PolicyReader>();

		this.init();
	}

	private void init() throws NffgVerifierException{
		for(NffgType fg: verifier.getNffgs().getNffg()){
			NffgReader nffg = new NffgReaderImpl(fg);
			nffgs.add(nffg);
			/*for(ReachabilityPolicyType pol:fg.getPolicies().getReachabilityPolicy()){
				PolicyReader policy = new
			}
			for(TraversalPolicyType pol:fg.getPolicies().getTraversalPolicy()){

			}*/
		}
	}

	@Override
	public Set<NffgReader> getNffgs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NffgReader getNffg(String var1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<PolicyReader> getPolicies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<PolicyReader> getPolicies(String var1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<PolicyReader> getPolicies(Calendar var1) {
		// TODO Auto-generated method stub
		return null;
	}

}

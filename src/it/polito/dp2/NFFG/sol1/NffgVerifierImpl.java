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

	public NffgVerifierImpl(NffgVerifierType veri) throws NffgVerifierException {
		this.verifier = veri;
		this.nffgs = new HashSet<NffgReader>();
		this.policy = new HashSet<PolicyReader>();

		this.init();
	}

	private void init() throws NffgVerifierException {
		for (NffgType fg : verifier.getNffgs().getNffg()) {
			NffgReader nffg = new NffgImpl(fg);
			nffgs.add(nffg);
			for (ReachabilityPolicyType pol : fg.getPolicies().getReachabilityPolicy()) {
				if (this.getPolicies(pol.getName()) != null) {
					throw new NffgVerifierException("Duplicated Policy Name");
				}
				policy.add(new ReachabilityPolicyImpl(pol, nffg));
			}
			for (TraversalPolicyType pol : fg.getPolicies().getTraversalPolicy()) {
				if (this.getPolicies(pol.getName()) != null) {
					throw new NffgVerifierException("Duplicated Policy Name");
				}
				policy.add(new TraversalPolicyImpl(pol, nffg));
			}
		}
	}

	@Override
	public Set<NffgReader> getNffgs() {
		return nffgs;
	}

	@Override
	public NffgReader getNffg(String nffgName) {
		for (NffgReader nffg : this.nffgs) {
			if (nffg.getName().equals(nffgName))
				return nffg;
		}
		return null;
	}

	@Override
	public Set<PolicyReader> getPolicies() {
		return new HashSet<PolicyReader>(policy);
	}

	@Override
	public Set<PolicyReader> getPolicies(String nffgName) {

		return null;
	}

	@Override
	public Set<PolicyReader> getPolicies(Calendar verificationTime) {
		// TODO Auto-generated method stub
		return null;
	}

}

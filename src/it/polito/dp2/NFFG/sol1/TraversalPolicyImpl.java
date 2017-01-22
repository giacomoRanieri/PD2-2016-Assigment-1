package it.polito.dp2.NFFG.sol1;

import it.polito.dp2.NFFG.*;
import it.polito.dp2.NFFG.sol1.jaxb.FunctionalTypeType;
import it.polito.dp2.NFFG.sol1.jaxb.TraversalPolicyType;

import java.util.HashSet;
import java.util.Set;

public class TraversalPolicyImpl extends ReachabilityPolicyImpl implements TraversalPolicyReader {

	private Set<FunctionalType> fts;

	public TraversalPolicyImpl(TraversalPolicyType policy, NffgReader fg) throws NffgVerifierException {
		super(policy, fg);
		this.fts = new HashSet<>();
		init();
	}

	private void init() {
		for (FunctionalTypeType res : ((TraversalPolicyType) this.entity).getTraversedFunctionalTypes().getFuncType()) {
			fts.add(FunctionalType.valueOf(res.name()));
		}
	}

	@Override
	public Set<FunctionalType> getTraversedFuctionalTypes() {
		return new HashSet<>(fts);
	}

}

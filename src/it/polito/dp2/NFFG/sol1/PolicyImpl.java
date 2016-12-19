package it.polito.dp2.NFFG.sol1;

import it.polito.dp2.NFFG.NffgReader;
import it.polito.dp2.NFFG.PolicyReader;
import it.polito.dp2.NFFG.VerificationResultReader;
import it.polito.dp2.NFFG.sol1.jaxb.PolicyType;
import it.polito.dp2.NFFG.sol1.jaxb.ReachabilityPolicyType;


public class PolicyImpl extends NamedEntityImpl implements PolicyReader {

	protected NffgReader nffg;
	private VerificationResultReader vr;

	public PolicyImpl(PolicyType policy, NffgReader fg) {
		super(policy);
		this.nffg = fg;
		init();
	}

	private void init() {
		this.vr = new VerificationResultImpl(((ReachabilityPolicyType) this.entity).getResult(), this);
	}

	@Override
	public NffgReader getNffg() {
		return nffg;
	}

	@Override
	public VerificationResultReader getResult() {
		return vr;
	}

	@Override
	public Boolean isPositive() {
		return ((PolicyType) this.entity).isPositive();
	}
}

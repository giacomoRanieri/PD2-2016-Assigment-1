package it.polito.dp2.NFFG.sol1;

import it.polito.dp2.NFFG.NffgReader;
import it.polito.dp2.NFFG.NffgVerifierException;
import it.polito.dp2.NFFG.PolicyReader;
import it.polito.dp2.NFFG.VerificationResultReader;
import it.polito.dp2.NFFG.sol1.jaxb.PolicyType;


public class PolicyImpl extends NamedEntityImpl implements PolicyReader {

	protected NffgReader nffg;
	private VerificationResultReader vr;

	public PolicyImpl(PolicyType policy, NffgReader fg) throws NffgVerifierException {
		super(policy);
		if (fg == null)
			throw new NffgVerifierException("Nffg is null");
		this.nffg = fg;
		init();
	}

	private void init() throws NffgVerifierException {
		if (((PolicyType) this.entity).getResult() != null)
			this.vr = new VerificationResultImpl(((PolicyType) this.entity).getResult(), this);
		else
			this.vr = null;
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

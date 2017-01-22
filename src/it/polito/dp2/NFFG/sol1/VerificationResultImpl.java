package it.polito.dp2.NFFG.sol1;

import it.polito.dp2.NFFG.NffgVerifierException;
import it.polito.dp2.NFFG.PolicyReader;
import it.polito.dp2.NFFG.VerificationResultReader;
import it.polito.dp2.NFFG.sol1.jaxb.VerificationResultType;

import java.util.Calendar;


public class VerificationResultImpl implements VerificationResultReader {

	private VerificationResultType res;
	private PolicyReader pol;

	public VerificationResultImpl(VerificationResultType res, PolicyReader policy) throws NffgVerifierException {
		if (res == null)
			throw new NffgVerifierException("VerificationResultType is null");
		if (policy == null)
			throw new NffgVerifierException("Policy is null");
		this.res = res;
		this.pol = policy;
	}

	@Override
	public PolicyReader getPolicy() {
		return pol;
	}

	@Override
	public Boolean getVerificationResult() {
		return res.isVerificationResult();
	}

	@Override
	public String getVerificationResultMsg() {
		return res.getVerificationResultMsg();
	}

	@Override
	public Calendar getVerificationTime() {
		return res.getVerificationTime().toGregorianCalendar();
	}
}

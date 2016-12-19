package it.polito.dp2.NFFG.sol1;

import it.polito.dp2.NFFG.NffgReader;
import it.polito.dp2.NFFG.NodeReader;
import it.polito.dp2.NFFG.ReachabilityPolicyReader;
import it.polito.dp2.NFFG.sol1.jaxb.ReachabilityPolicyType;


public class ReachabilityPolicyImpl extends PolicyImpl implements ReachabilityPolicyReader {


	public ReachabilityPolicyImpl(ReachabilityPolicyType policy, NffgReader fg) {
		super(policy, fg);
	}

	@Override
	public NodeReader getSourceNode() {
		return nffg.getNode(((ReachabilityPolicyType) this.entity).getSourceNode().getName());
	}

	@Override
	public NodeReader getDestinationNode() {
		return nffg.getNode(((ReachabilityPolicyType) this.entity).getDestinationNode().getName());
	}
}

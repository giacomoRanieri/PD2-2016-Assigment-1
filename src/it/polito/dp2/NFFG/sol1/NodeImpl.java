package it.polito.dp2.NFFG.sol1;

import java.util.HashSet;
import java.util.Set;

import it.polito.dp2.NFFG.*;
import it.polito.dp2.NFFG.sol1.jaxb.LinkType;
import it.polito.dp2.NFFG.sol1.jaxb.NodeType;

public class NodeImpl extends NamedEntityImpl implements NodeReader {

	private NffgReader nffg;
	private Set<LinkReader> links;

	public NodeImpl(NodeType np, NffgReader nffg) throws NffgVerifierException {
		super(np);
		this.nffg = nffg;
		this.links = new HashSet<LinkReader>();
	}

	private void init() throws NffgVerifierException {
		for (LinkType lk : ((NodeType) this.entity).getLinks().getLink()) {
			LinkReader link = new LinkImpl(lk, nffg, this);
			links.add(link);
		}
	}

	@Override
	public FunctionalType getFuncType() {
		return FunctionalType.valueOf(((NodeType) this.entity).getFuncType().name());
	}

	@Override
	public Set<LinkReader> getLinks() {
		return new HashSet<LinkReader>(links);
	}

}

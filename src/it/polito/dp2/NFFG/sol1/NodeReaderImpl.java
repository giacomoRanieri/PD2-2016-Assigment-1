package it.polito.dp2.NFFG.sol1;

import java.util.HashSet;
import java.util.Set;

import it.polito.dp2.NFFG.*;
import it.polito.dp2.NFFG.sol1.jaxb.LinkType;
import it.polito.dp2.NFFG.sol1.jaxb.NodeType;

public class NodeReaderImpl implements NodeReader {

	NodeType node;
	NffgReader nffg;
	Set<LinkReader> links;

	public NodeReaderImpl(NodeType np, NffgReader nffg) throws NffgVerifierException {
		this.node = np;
		this.nffg = nffg;
		this.links = new HashSet<LinkReader>();
	}

	private void init() throws NffgVerifierException {
		for (LinkType lk : node.getLinks().getLink()) {
			LinkReader link = new LinkReaderImpl(lk,nffg);
			links.add(link);
		}
	}

	@Override
	public String getName() {
		return node.getName();
	}

	@Override
	public FunctionalType getFuncType() {
		return FunctionalType.valueOf(node.getFuncType().name());
	}

	@Override
	public Set<LinkReader> getLinks() {
		return new HashSet<LinkReader>(links);
	}

}

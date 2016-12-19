package it.polito.dp2.NFFG.sol1;

import it.polito.dp2.NFFG.LinkReader;
import it.polito.dp2.NFFG.NffgReader;
import it.polito.dp2.NFFG.NodeReader;
import it.polito.dp2.NFFG.sol1.jaxb.LinkType;

public class LinkImpl extends NamedEntityImpl implements LinkReader {

	private NffgReader nffg;
	private NodeReader source;

	public LinkImpl(LinkType link, NffgReader fg, NodeReader sourceNode) {
		super(link);
		this.nffg = fg;
		this.source = sourceNode;
	}

	@Override
	public NodeReader getSourceNode() {
		return source;
	}

	@Override
	public NodeReader getDestinationNode() {
		return nffg.getNode(((LinkType) this.entity).getDestinationNode().getName());
	}

}

package it.polito.dp2.NFFG.sol1;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import it.polito.dp2.NFFG.NffgReader;
import it.polito.dp2.NFFG.NffgVerifierException;
import it.polito.dp2.NFFG.NodeReader;
import it.polito.dp2.NFFG.sol1.jaxb.NffgType;
import it.polito.dp2.NFFG.sol1.jaxb.NodeType;

public class NffgImpl extends NamedEntityImpl implements NffgReader {

	private Set<NodeReader> nodes;

	public NffgImpl(NffgType fg) throws NffgVerifierException {
		super(fg);
		this.nodes = new HashSet<>();

		this.init();
	}

	private void init() throws NffgVerifierException {
		for (NodeType nt : ((NffgType) this.entity).getNodes().getNode()) {
			NodeReader node = new NodeImpl(nt, this);
			nodes.add(node);
		}
	}

	@Override
	public Calendar getUpdateTime() {
		return ((NffgType) this.entity).getUpdateTime().toGregorianCalendar();
	}

	@Override
	public Set<NodeReader> getNodes() {
		return new HashSet<>(nodes);
	}

	@Override
	public NodeReader getNode(String var1) {
		for (NodeReader node : nodes) {
			if (node.getName().equals(var1))
				return node;
		}
		return null;
	}

}

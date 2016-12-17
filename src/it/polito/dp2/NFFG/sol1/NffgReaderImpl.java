package it.polito.dp2.NFFG.sol1;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import it.polito.dp2.NFFG.NffgReader;
import it.polito.dp2.NFFG.NffgVerifierException;
import it.polito.dp2.NFFG.NodeReader;
import it.polito.dp2.NFFG.sol1.jaxb.NffgType;
import it.polito.dp2.NFFG.sol1.jaxb.NodeType;

import javax.xml.soap.Node;

public class NffgReaderImpl implements NffgReader {

	NffgType fg;
	Set<NodeReader> nodes;

	public NffgReaderImpl(NffgType fg) throws NffgVerifierException{
		this.fg = fg;
		this.nodes = new HashSet<NodeReader>();

		this.init();
	}

	private void init() throws NffgVerifierException{
		for(NodeType nt: fg.getNodes().getNode()){
			NodeReader node = new NodeReaderImpl(nt,this);
			nodes.add(node);
		}
	}

	@Override
	public String getName() {
		return fg.getName();
	}

	@Override
	public Calendar getUpdateTime() {
		return fg.getUpdateTime().toGregorianCalendar();
	}

	@Override
	public Set<NodeReader> getNodes() {
		return new HashSet<NodeReader>(nodes);
	}

	@Override
	public NodeReader getNode(String var1) {
		for(NodeReader node: nodes){
			if(node.getName().equals(var1))
				return node;
		}
		return null;
	}

}

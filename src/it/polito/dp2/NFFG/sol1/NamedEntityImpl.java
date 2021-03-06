package it.polito.dp2.NFFG.sol1;

import it.polito.dp2.NFFG.NamedEntityReader;
import it.polito.dp2.NFFG.NffgVerifierException;
import it.polito.dp2.NFFG.sol1.jaxb.NamedEntityType;


public class NamedEntityImpl implements NamedEntityReader {

	protected NamedEntityType entity;

	public NamedEntityImpl(NamedEntityType entity) throws NffgVerifierException {
		if (entity == null)
			throw new NffgVerifierException("Entity is null");
		this.entity = entity;
	}

	@Override
	public String getName() {
		return entity.getName();
	}
}

package co.sdj.sdjgym.domain;

import java.util.UUID;

import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;

public class IdentificationTypeDomain extends Domain {
	
	private String name;
	
	private IdentificationTypeDomain(final UUID id, final String name) {
		super(id);
		setName(name);
	}
	
	public static final IdentificationTypeDomain create(final UUID id, final String name) {
		return new IdentificationTypeDomain(id, name);
	}
	
	public static final IdentificationTypeDomain create() {
		return new IdentificationTypeDomain(UUIDHelper.getDefault(), TextHelper.EMPTY);
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = TextHelper.applyTrim(name);
	}
	
	@Override
	public UUID getId() {
		return super.getId();
	}

}

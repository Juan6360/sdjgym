package co.sdj.sdjgym.domain;

import java.util.UUID;

import co.sdj.sdjgym.crosscutting.helpers.TextHelper;
import co.sdj.sdjgym.crosscutting.helpers.UUIDHelper;

class CountryDomain extends Domain{

	private String name;
	
	private CountryDomain(final UUID id, final String name) {
		super(id);
		setName(name);
	}
	
	public static final CountryDomain create(final UUID id, final String name) {
		return new CountryDomain(id, name);
	}
	
	static final CountryDomain create() {
		return new CountryDomain(UUIDHelper.getDefault(), TextHelper.EMPTY);
	}
	
	public String getName() {
		return name;
	}

	private void setName(final String name) {
		this.name = TextHelper.applyTrim(name);
	}
	
	@Override
	public UUID getId() {
		return super.getId();
	}
	
}

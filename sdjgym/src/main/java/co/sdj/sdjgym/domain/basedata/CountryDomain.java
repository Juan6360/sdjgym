package co.sdj.sdjgym.domain.basedata;

import java.util.UUID;

import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.domain.Domain;

public class CountryDomain extends Domain{

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

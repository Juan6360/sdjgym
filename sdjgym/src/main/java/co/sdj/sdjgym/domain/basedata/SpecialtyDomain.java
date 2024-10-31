package co.sdj.sdjgym.domain.basedata;

import java.util.UUID;

import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.domain.Domain;

public class SpecialtyDomain extends Domain {
	
	
	private String name;
	
	private SpecialtyDomain(UUID id, String name) {
		super(id);
		setName(name);
	}
	
	public static final SpecialtyDomain create(final UUID id, final String name) {
		return new SpecialtyDomain(id, name);
	}
	
	static final SpecialtyDomain create() {
		return new SpecialtyDomain(UUIDHelper.getDefault(), TextHelper.EMPTY);
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

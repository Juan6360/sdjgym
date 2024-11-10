package co.sdj.sdjgym.domain;

import java.util.UUID;

import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;

public class EpsDomain extends Domain {
	
	private String name;
	
	private EpsDomain(final UUID id, final String name) {
		super(id);
		setName(name);
	}
	
	public static final EpsDomain create(final UUID id, final String name) {
		return new EpsDomain(id, name);
	}
	
	public static final EpsDomain create() {
		return new EpsDomain(UUIDHelper.getDefault(), TextHelper.EMPTY);
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


package co.sdj.sdjgym.entity;

import java.util.UUID;

import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;

public class IdentificationTypeEntity extends DomainEntity {

	private String name;
	
	public IdentificationTypeEntity() {
		super(UUIDHelper.getDefault());
		setName(TextHelper.EMPTY);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = TextHelper.applyTrim(name);
	}
	
	@Override
	public void setId(final UUID id) {
		super.setId(id);
	}
	
	@Override
	public UUID getId() {
		return super.getId();
	}

}

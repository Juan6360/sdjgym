package co.sdj.sdjgym.entity;

import java.util.UUID;

import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;

public class SpecialtyEntity extends DomainEntity{	
	
	protected SpecialtyEntity(UUID id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	private String name;
	
	public SpecialtyEntity() {
		super(UUIDHelper.getDefault());
		setName(TextHelper.EMPTY);
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
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


package co.sdj.sdjgym.dto;

import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;

public class IdentificationTypeDTO extends DomainDTO {
	
	private String name;

	public IdentificationTypeDTO() {
		super(UUIDHelper.getDefaultAsString());
		setName(TextHelper.EMPTY);
	}
	
	public static final IdentificationTypeDTO create() {
		return new IdentificationTypeDTO();
	}

	public String getName() {
		return name;
	}

	public IdentificationTypeDTO setName(final String name) {
		this.name = TextHelper.applyTrim(name);
		return this;
	}
	
	public IdentificationTypeDTO setId(final String id) {
		super.setIdentifier(id);
		return this;
	}
	
	@Override
	public String getId() {
		return super.getId();
	}
	
}

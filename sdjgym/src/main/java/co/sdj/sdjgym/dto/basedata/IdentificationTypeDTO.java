package co.sdj.sdjgym.dto.basedata;

import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.dto.DomainDTO;

public class IdentificationTypeDTO extends DomainDTO {
	
	private String name;

	private IdentificationTypeDTO() {
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

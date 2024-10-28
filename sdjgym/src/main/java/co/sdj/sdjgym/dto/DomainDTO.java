package co.sdj.sdjgym.dto;

import java.util.UUID;

import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;

class DomainDTO {
	
	private String id;
	
	protected DomainDTO(final String id) {
		setIdentifier(id);
	}

	protected String getId() {
		return id;
	}

	protected void setIdentifier(final String id) {
		this.id = TextHelper.getDefault(id, UUIDHelper.getDefaultAsString());
	}
	
}

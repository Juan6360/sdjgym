package co.sdj.sdjgym.dto;

import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;

public class CoachDTO extends DomainDTO {

	private SpecialtyDTO specialty;
	
	protected CoachDTO() {
		super(UUIDHelper.getDefaultAsString());
		setSpecialty(specialty);
	}
	
	public static final CoachDTO create() {
		return new CoachDTO();
	}
	
	public SpecialtyDTO getSpecialty() {
		return specialty;
	}

	public CoachDTO setSpecialty(final SpecialtyDTO specialty) {
		this.specialty = ObjectHelper.getDefault(specialty, SpecialtyDTO.create());
		return this;
	}

	
}

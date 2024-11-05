package co.sdj.sdjgym.dto.coach;

import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.sdjgym.dto.PersonDTO;
import co.sdj.sdjgym.dto.basedata.SpecialtyDTO;

public class CoachDTO extends PersonDTO {

	private SpecialtyDTO specialty;
	
	protected CoachDTO() {
		super();
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

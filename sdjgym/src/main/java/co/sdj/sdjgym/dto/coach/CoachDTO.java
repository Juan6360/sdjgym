package co.sdj.sdjgym.dto.coach;

import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.dto.PersonDTO;
import co.sdj.sdjgym.dto.basedata.CityDTO;
import co.sdj.sdjgym.dto.basedata.EpsDTO;
import co.sdj.sdjgym.dto.basedata.IdentificationTypeDTO;
import co.sdj.sdjgym.dto.basedata.SpecialtyDTO;
import co.sdj.sdjgym.dto.basedata.StateDTO;

public class CoachDTO extends PersonDTO {

	private SpecialtyDTO specialty;
	
	protected CoachDTO() {
		super(TextHelper.EMPTY, TextHelper.EMPTY, TextHelper.EMPTY, TextHelper.EMPTY,
				TextHelper.EMPTY, TextHelper.EMPTY, TextHelper.EMPTY, TextHelper.EMPTY,
				IdentificationTypeDTO.create(), TextHelper.EMPTY, EpsDTO.create(),
				TextHelper.EMPTY, StateDTO.create(), CityDTO.create());
		
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

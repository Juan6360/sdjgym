package co.sdj.sdjgym.dto.coach;

import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.sdjgym.dto.PersonDTO;
import co.sdj.sdjgym.dto.basedata.CityDTO;
import co.sdj.sdjgym.dto.basedata.EpsDTO;
import co.sdj.sdjgym.dto.basedata.IdentificationTypeDTO;
import co.sdj.sdjgym.dto.basedata.SpecialtyDTO;
import co.sdj.sdjgym.dto.basedata.StateDTO;

public class CoachDTO extends PersonDTO {

	private SpecialtyDTO specialty;
	
	protected CoachDTO(final String firstName, final String middleName, final String firstSurName, final String secondSurName,
			final String phoneNumber, final String emergencyNumber, final String email, final String birthDate,
			final IdentificationTypeDTO identificationType, final String identification, final EpsDTO eps, final String address, final StateDTO state,
			final CityDTO city, final SpecialtyDTO specialty) {
		
		super(firstName, middleName, firstSurName, secondSurName, phoneNumber, emergencyNumber, email, birthDate,
				identificationType, identification, eps, address, state, city);
		setSpecialty(SpecialtyDTO.create());
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

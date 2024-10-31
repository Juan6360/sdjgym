package co.sdj.sdjgym.domain.coach;

import java.util.Date;
import java.util.UUID;

import co.sdj.sdjgym.domain.PersonDomain;
import co.sdj.sdjgym.domain.basedata.CityDomain;
import co.sdj.sdjgym.domain.basedata.EpsDomain;
import co.sdj.sdjgym.domain.basedata.IdentificationTypeDomain;
import co.sdj.sdjgym.domain.basedata.SpecialtyDomain;
import co.sdj.sdjgym.domain.basedata.StateDomain;

public class CoachDomain extends PersonDomain {
	
	private SpecialtyDomain specialty;

	protected CoachDomain(UUID id, String firstName, String middleName, String firstSurName, String secondSurName,
			String phoneNumber2, String emergencyNumber2, String email, Date birthDate,
			IdentificationTypeDomain tipoIdentificacion, String identificacion, EpsDomain eps, String address,
			StateDomain state2, CityDomain city2) {
		super(id, firstName, middleName, firstSurName, secondSurName, phoneNumber2, emergencyNumber2, email, birthDate,
				tipoIdentificacion, identificacion, eps, address, state2, city2);
	}
	
	@Override
	public UUID getId() {
		return super.getId();
	}
}

package co.sdj.sdjgym.domain.user;

import java.util.Date;
import java.util.UUID;

import co.sdj.sdjgym.domain.Domain;
import co.sdj.sdjgym.domain.PersonDomain;
import co.sdj.sdjgym.domain.basedata.CityDomain;
import co.sdj.sdjgym.domain.basedata.EpsDomain;
import co.sdj.sdjgym.domain.basedata.IdentificationTypeDomain;
import co.sdj.sdjgym.domain.basedata.StateDomain;

public class UserDomain extends PersonDomain{
	
	
	
	
	
	
	protected UserDomain(final UUID id,
			final String firstName,
			final String middleName,
			final String firstSurName, 
			final String secondSurName,
			final String phoneNumber,
			final String emergencyNumber,
			final String email,
			final Date birthDate,
			final IdentificationTypeDomain tipoIdentificacion,
			final String identificacion,
			final EpsDomain eps,
			final String address,
			final StateDomain state,
			final CityDomain city) {
		super(id, firstName, middleName, firstSurName, secondSurName, phoneNumber, emergencyNumber, email, birthDate, tipoIdentificacion, identificacion, eps, address, state, city);
		// TODO Auto-generated constructor stub
	}

}

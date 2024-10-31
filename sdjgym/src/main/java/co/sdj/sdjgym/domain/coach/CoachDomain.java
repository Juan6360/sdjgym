package co.sdj.sdjgym.domain.coach;

import java.util.Date;
import java.util.UUID;

import co.sdj.sdjgym.domain.PersonDomain;
import co.sdj.sdjgym.domain.basedata.EpsDomain;
import co.sdj.sdjgym.domain.basedata.IdentificationTypeDomain;

public class CoachDomain extends PersonDomain {

	protected CoachDomain(UUID id, 
							String firstName,
							String middleName,
							String firstSurName,
							String secondSurName,
							int phoneNumber,
							String emergencyNumber,
							String email,
							Date birthDate,
							UUID identificadorTipoIdentificacion,
							IdentificationTypeDomain tipoIdentificacion,
							int identificacion,
							EpsDomain eps,
							String address,
							UUID identificatorState,
							String state,
							UUID identificadorCity,
							String city) {
		
		super(id,
				firstName,
				middleName,
				firstSurName,
				secondSurName,
				phoneNumber,
				emergencyNumber,
				email,
				birthDate,
				identificadorTipoIdentificacion,
				tipoIdentificacion,
				identificacion,
				eps,
				address,
				identificatorState,
				state,
				identificadorCity,
				city);
	}
	
	
	
}

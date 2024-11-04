package co.sdj.sdjgym.domain.coach;

import java.util.Date;
import java.util.UUID;

import co.sdj.sdjgym.domain.PersonDomain;
import co.sdj.sdjgym.domain.basedata.CityDomain;
import co.sdj.sdjgym.domain.basedata.EpsDomain;
import co.sdj.sdjgym.domain.basedata.IdentificationTypeDomain;
import co.sdj.sdjgym.domain.basedata.SpecialtyDomain;
import co.sdj.sdjgym.domain.basedata.StateDomain;
import co.sdj.crosscutting.helpers.DateHelper;
import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;

public class CoachDomain extends PersonDomain {
	
	private SpecialtyDomain specialty;

	protected CoachDomain(final UUID id, final String firstName, final String middleName, final String firstSurName, final String secondSurName,
							final String phoneNumber2, final String emergencyNumber2, final String email, final Date birthDate,
							final IdentificationTypeDomain tipoIdentificacion, final String identificacion, final EpsDomain eps, final String address,
							final StateDomain state, final CityDomain city) {
		
		super(id, firstName, middleName, firstSurName, secondSurName, phoneNumber2, emergencyNumber2, email, birthDate,
				tipoIdentificacion, identificacion, eps, address, state, city);
	}
	
	public static final CoachDomain create(final UUID id, final String firstName, final String middleName, final String firstSurName, final String secondSurName,
											final String phoneNumber2, final String emergencyNumber2, final String email, final Date birthDate,
											final IdentificationTypeDomain tipoIdentificacion, final String identificacion, final EpsDomain eps, final String address,
											final StateDomain state, final CityDomain city) {
		
		return new CoachDomain(id, firstName, middleName, firstSurName, secondSurName, phoneNumber2, emergencyNumber2, email, birthDate,
				tipoIdentificacion, identificacion, eps, address, state, city);
	}
	
	public static final CoachDomain create() {
		return new CoachDomain(UUIDHelper.getDefault(), TextHelper.EMPTY, TextHelper.EMPTY, TextHelper.EMPTY, TextHelper.EMPTY,
								TextHelper.EMPTY, TextHelper.EMPTY, TextHelper.EMPTY, DateHelper.getDefault(), IdentificationTypeDomain.create(), TextHelper.EMPTY, EpsDomain.create(), TextHelper.EMPTY,
								StateDomain.create(), CityDomain.create());
	}
	
	@Override
	public UUID getId() {
		return super.getId();
	}
}

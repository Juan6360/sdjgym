package co.sdj.sdjgym.domain;

import java.util.Date;
import java.util.UUID;

import co.sdj.crosscutting.helpers.DateHelper;
import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;

public class CoachDomain extends Domain {
	
	private SpecialtyDomain specialty;

	protected CoachDomain(final UUID id, final String firstName, final String middleName, final String firstSurName, final String secondSurName,
							final String phoneNumber2, final String emergencyNumber2, final String email, final Date birthDate,
							final IdentificationTypeDomain tipoIdentificacion, final String identificacion, final EpsDomain eps, final String address,
							final StateDomain state, final CityDomain city, final SpecialtyDomain specialty) {
		
		super(id);
		setSpecialty(specialty);
	}
	
	static final CoachDomain create(final UUID id, final String firstName, final String middleName, final String firstSurName, final String secondSurName,
											final String phoneNumber2, final String emergencyNumber2, final String email, final Date birthDate,
											final IdentificationTypeDomain tipoIdentificacion, final String identificacion, final EpsDomain eps, final String address,
											final StateDomain state, final CityDomain city, final SpecialtyDomain specialty) {
		
		return new CoachDomain(id, firstName, middleName, firstSurName, secondSurName, phoneNumber2, emergencyNumber2, email, birthDate,
				tipoIdentificacion, identificacion, eps, address, state, city, specialty);
	}
	
	public static final CoachDomain create() {
		return new CoachDomain(UUIDHelper.getDefault(), TextHelper.EMPTY, TextHelper.EMPTY, TextHelper.EMPTY, TextHelper.EMPTY,
								TextHelper.EMPTY, TextHelper.EMPTY, TextHelper.EMPTY, DateHelper.DEFAULT_DATE, IdentificationTypeDomain.create(), TextHelper.EMPTY, EpsDomain.create(), TextHelper.EMPTY,
								StateDomain.create(), CityDomain.create(), SpecialtyDomain.create());
	}
	
	
	
	public SpecialtyDomain getSpecialty() {
		return specialty;
	}

	public void setSpecialty(SpecialtyDomain specialty) {
		this.specialty = specialty;
	}

	@Override
	public UUID getId() {
		return super.getId();
	}
}

package co.sdj.sdjgym.domain;

import java.util.Date;
import java.util.UUID;

import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.domain.basedata.CityDomain;
import co.sdj.sdjgym.domain.basedata.EpsDomain;
import co.sdj.sdjgym.domain.basedata.IdentificationTypeDomain;
import co.sdj.sdjgym.domain.basedata.StateDomain;



public class PersonDomain extends Domain {
	
	private String firstName;
	private String middleName;
	private String firstSurName;
	private String secondSurName;
	private String phoneNumber;
	private String emergencyNumber;
	private String email;
	private Date birthDate;
	private UUID identificadorTipoIdentificacion;
	private IdentificationTypeDomain tipoIdentificacion;
	private String identificacion;
	private UUID identificadorEps;
	private EpsDomain eps;
	private String address;
	private UUID identificatorState;
	private StateDomain state;
	private UUID identificadorCity;
	private CityDomain city;

	protected PersonDomain( final UUID id,
							final String firstName,
							final String middleName,
							final String firstSurName, 
							final String secondSurName,
							final String phoneNumber2,
							final String emergencyNumber2,
							final String email,
							final Date birthDate,
							final UUID identificadorTipoIdentificacion,
							final IdentificationTypeDomain tipoIdentificacion,
							final String identificacion,
							final EpsDomain eps,
							final String address,
							final UUID identificatorState,
							final StateDomain state2,
							final UUID identificadorCity,
							final CityDomain city2) {
		super(id);
		setFirstName(firstName);
		setMiddleName(middleName);
		setFirstSurName(firstSurName);
		setSecondSurName(secondSurName);
		setPhoneNumber(phoneNumber2);
		setEmergencyNumber(emergencyNumber2);
		setEmail(email);
		setBirthDate(birthDate);
		setIdentificadorTipoIdentificacion(UUIDHelper.getDefault(identificadorTipoIdentificacion, UUIDHelper.getDefault()) );
		setTipoIdentificacion(tipoIdentificacion);
		setIdentificacion(identificacion);
		setIdentificadorEps(UUIDHelper.getDefault(identificadorEps, UUIDHelper.getDefault()));//hacer el UUIDHelper
		setEps(eps);
		setAddress(address);
		setIdentificatorState(UUIDHelper.getDefault(identificatorState, UUIDHelper.getDefault()));//hacer el UUIDHelper
		setState(state2);
		setIdentificadorCity(UUIDHelper.getDefault(identificadorCity, UUIDHelper.getDefault()));
		setCity(city2);
		
		
		
		// TODO Auto-generated constructor stub
	}
	
	
	public static final PersonDomain create(final UUID id,
											final String firstName,
											final String middleName,
											final String firstSurName, 
											final String secondSurName,
											final String phoneNumber,
											final String emergencyNumber,
											final String email,
											final Date birthDate,
											final UUID identificadorTipoIdentificacion,
											final IdentificationTypeDomain tipoIdentificacion,
											final String identificacion,
											final EpsDomain eps,
											final String address,
											final UUID identificatorState,
											final StateDomain state,
											final UUID identificadorCity,
											final CityDomain city) {
		return new PersonDomain(id,
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
	
	public static final PersonDomain create(final UUID id,
			final String firstName,
			final String middleName,
			final String firstSurName, 
			final String secondSurName,
			final String phoneNumber,
			final String emergencyNumber,
			final String email,
			final Date birthDate,
			final UUID identificadorTipoIdentificacion,
			final IdentificationTypeDomain tipoIdentificacion,
			final String identificacion,
			final EpsDomain eps,
			final String address,
			final UUID identificatorState,
			final StateDomain state,
			final UUID identificadorCity,
			final CityDomain city) {
		return new PersonDomain(UUIDHelper.getDefault(),
				TextHelper.EMPTY,
				TextHelper.EMPTY,
				TextHelper.EMPTY,
				TextHelper.EMPTY,
				TextHelper.EMPTY,
				TextHelper.EMPTY,
				TextHelper.EMPTY,
				birthDate,
				UUIDHelper.getDefault(),
				IdentificationTypeDomain.create(),
				TextHelper.EMPTY,
				EpsDomain.create(),
				TextHelper.EMPTY,
				UUIDHelper.getDefault(),
				StateDomain.create(),
				UUIDHelper.getDefault(),
				CityDomain.create());
	}
	
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getFirstSurName() {
		return firstSurName;
	}

	public void setFirstSurName(String firstSurName) {
		this.firstSurName = firstSurName;
	}

	public String getSecondSurName() {
		return secondSurName;
	}

	public void setSecondSurName(String secondSurName) {
		this.secondSurName = secondSurName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmergencyNumber() {
		return emergencyNumber;
	}

	public void setEmergencyNumber(String emergencyNumber) {
		this.emergencyNumber = emergencyNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public UUID getIdentificadorTipoIdentificacion() {
		return identificadorTipoIdentificacion;
	}

	public void setIdentificadorTipoIdentificacion(UUID identificadorTipoIdentificacion) {
		this.identificadorTipoIdentificacion = identificadorTipoIdentificacion;
	}

	public IdentificationTypeDomain getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(IdentificationTypeDomain tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public UUID getIdentificadorEps() {
		return identificadorEps;
	}

	public void setIdentificadorEps(UUID identificadorEps) {
		this.identificadorEps = identificadorEps;
	}

	public EpsDomain getEps() {
		return eps;
	}

	public void setEps(EpsDomain eps) {
		this.eps = eps;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public UUID getIdentificatorState() {
		return identificatorState;
	}

	public void setIdentificatorState(UUID identificatorState) {
		this.identificatorState = identificatorState;
	}

	public StateDomain getState() {
		return state;
	}

	public void setState(StateDomain state) {
		this.state = state;
	}

	public UUID getIdentificadorCity() {
		return identificadorCity;
	}

	public void setIdentificadorCity(UUID identificadorCity) {
		this.identificadorCity = identificadorCity;
	}

	public CityDomain getCity() {
		return city;
	}

	public void setCity(CityDomain city) {
		this.city = city;
	}

}

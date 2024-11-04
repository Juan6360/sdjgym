package co.sdj.sdjgym.domain;
import java.util.Date;
import java.util.UUID;

import co.sdj.crosscutting.helpers.DateHelper;
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
	private IdentificationTypeDomain tipoIdentificacion;
	private String identificacion;
	private EpsDomain eps;
	private String address;
	private StateDomain state;
	private CityDomain city;

	public PersonDomain( final UUID id,
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
		super(id);
		setFirstName(firstName);
		setMiddleName(middleName);
		setFirstSurName(firstSurName);
		setSecondSurName(secondSurName);
		setPhoneNumber(phoneNumber);
		setEmergencyNumber(emergencyNumber);
		setEmail(email);
		setBirthDate(birthDate);
		setTipoIdentificacion(tipoIdentificacion);
		setIdentificacion(identificacion);
		setEps(eps);
		setAddress(address);
		setState(state);
		setCity(city);
		
		
		// TODO Auto-generated constructor stub
	}
	
	
	public static PersonDomain create(final UUID id,
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
		return new PersonDomain(id,
								firstName,
								middleName,
								firstSurName,
								secondSurName,
								phoneNumber,
								emergencyNumber,
								email,
								birthDate,
								
								tipoIdentificacion,
								identificacion,
								eps,
								address,
								
								state,
								
								city);
	}
	
	public static PersonDomain create() {
		return new PersonDomain(UUIDHelper.getDefault(),
				TextHelper.EMPTY,
				TextHelper.EMPTY,
				TextHelper.EMPTY,
				TextHelper.EMPTY,
				TextHelper.EMPTY,
				TextHelper.EMPTY,
				TextHelper.EMPTY,
				DateHelper.DEFAULT_DATE,
				IdentificationTypeDomain.create(),
				TextHelper.EMPTY,
				EpsDomain.create(),
				TextHelper.EMPTY,
				StateDomain.create(),
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


	public StateDomain getState() {
		return state;
	}

	public void setState(StateDomain state) {
		this.state = state;
	}


	public CityDomain getCity() {
		return city;
	}

	public void setCity(CityDomain city) {
		this.city = city;
	}
	
	@Override
	public UUID getId() {
		return super.getId();
	}
	

}

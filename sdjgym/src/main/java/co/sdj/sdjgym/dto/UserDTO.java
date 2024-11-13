package co.sdj.sdjgym.dto;

import java.util.Date;

import co.sdj.crosscutting.helpers.DateHelper;
import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;

public class UserDTO extends DomainDTO{
	
	private String firstName;
	private String middleName;
	private String firstSurName;
	private String secondSurName;
	private String phoneNumber;
	private String emergencyNumber;
	private String email;
	private Date birthDate;
	private IdentificationTypeDTO identificationType;
	private String identification;
	private EpsDTO eps;
	private String address;
	private CityDTO city;
	
	protected UserDTO() {
		super(UUIDHelper.getDefaultAsString());
		setFirstName(TextHelper.EMPTY);
		setMiddleName(TextHelper.EMPTY);
		setFirstSurName(TextHelper.EMPTY);
		setSecondSurName(TextHelper.EMPTY);
		setEmergencyNumber(TextHelper.EMPTY);
		setEmail(TextHelper.EMPTY);
		setBirthDate(DateHelper.DEFAULT_DATE);
		setIdentification(TextHelper.EMPTY);
		setEps(EpsDTO.create());
		setAddress(TextHelper.EMPTY);
		setIdentificationType(IdentificationTypeDTO.create());
		setIdentification(TextHelper.EMPTY);
		setCity(CityDTO.create());
	}
	
	public static final UserDTO create() {
		return new UserDTO();
	}
	
	public String getFirstName() {
		return firstName;
	}

	public UserDTO setFirstName(String firstName) {
		this.firstName = TextHelper.applyTrim(firstName);
		return this;
	}

	public String getMiddleName() {
		return middleName;
	}

	public UserDTO setMiddleName(String middleName) {
		this.middleName = TextHelper.applyTrim(middleName);
		return this;
	}

	public String getFirstSurName() {
		return firstSurName;
	}

	public UserDTO setFirstSurName(String firstSurName) {
		this.firstSurName = TextHelper.applyTrim(firstSurName);
		return this;
	}

	public String getSecondSurName() {
		return secondSurName;
	}

	public UserDTO setSecondSurName(String secondSurName) {
		this.secondSurName = TextHelper.applyTrim(secondSurName);
		return this;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public UserDTO setPhoneNumber(String phoneNumber) {
		this.phoneNumber = TextHelper.applyTrim(phoneNumber);
		return this;
	}

	public String getEmergencyNumber() {
		return emergencyNumber;
	}

	public UserDTO setEmergencyNumber(String emergencyNumber) {
		this.emergencyNumber = TextHelper.applyTrim(emergencyNumber);
		return this;
	}

	public String getEmail() {
		return email;
	}

	public UserDTO setEmail(String email) {
		this.email = TextHelper.applyTrim(email);
		return this;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public UserDTO setBirthDate(Date birthDate) {
		this.birthDate = DateHelper.getDefault(birthDate);
		return this;
	}

	public IdentificationTypeDTO getIdentificationType() {
		return identificationType;
	}

	public UserDTO setIdentificationType(final IdentificationTypeDTO identificationType) {
		this.identificationType = ObjectHelper.getDefault(identificationType, IdentificationTypeDTO.create());
		return this;
	}

	public String getIdentification() {
		return identification;
	}

	public UserDTO setIdentification(String identification) {
		this.identification = TextHelper.applyTrim(identification);
		return this;
	}

	public EpsDTO getEps() {
		return eps;
	}

	public UserDTO setEps(final EpsDTO eps) {
		this.eps = ObjectHelper.getDefault(eps, EpsDTO.create());
		return this;
	}

	public String getAddress() {
		return address;
	}

	public UserDTO setAddress(String address) {
		this.address = address;
		return this;
	}

	public CityDTO getCity() {
		return city;
	}

	public UserDTO setCity(CityDTO city) {
		this.city = ObjectHelper.getDefault(city, CityDTO.create());
		return this;
	}
	
	public UserDTO setId(final String id) {
		super.setIdentifier(id);
		return this;
	}
	
	@Override
	public String getId() {
		return super.getId();
	}
}

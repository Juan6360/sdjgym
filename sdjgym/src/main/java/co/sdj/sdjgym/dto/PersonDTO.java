package co.sdj.sdjgym.dto;

import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.dto.basedata.CityDTO;
import co.sdj.sdjgym.dto.basedata.EpsDTO;
import co.sdj.sdjgym.dto.basedata.IdentificationTypeDTO;
import co.sdj.sdjgym.dto.basedata.StateDTO;


public class PersonDTO extends DomainDTO{
	
	private String firstName;
	private String middleName;
	private String firstSurName;
	private String secondSurName;
	private String phoneNumber;
	private String emergencyNumber;
	private String email;
	private String birthDate;
	private IdentificationTypeDTO identificationType;
	private String identification;
	private EpsDTO eps;
	private String address;
	private StateDTO state;
	private CityDTO city;
	
	protected PersonDTO(final String firstName,
						final String middleName,
						final String firstSurName,
						final String secondSurName,
						final String phoneNumber,
						final String emergencyNumber,
						final String email,
						final String birthDate,
						final IdentificationTypeDTO identificationType,
						final String identification,
						final EpsDTO eps,
						final String address,
						final StateDTO state,
						final CityDTO city) {
		
		super(UUIDHelper.getDefaultAsString());
		setFirstName(TextHelper.EMPTY);
		setMiddleName(TextHelper.EMPTY);
		setFirstSurName(TextHelper.EMPTY);
		setSecondSurName(TextHelper.EMPTY);
		setEmergencyNumber(TextHelper.EMPTY);
		setEmail(TextHelper.EMPTY);
		setBirthDate(TextHelper.EMPTY);
		setIdentification(TextHelper.EMPTY);
		setEps(new EpsDTO());
		setAddress(TextHelper.EMPTY);
		setIdentificationType(new IdentificationTypeDTO());
		setIdentification(TextHelper.EMPTY);
		setState(new StateDTO());
		setCity(new CityDTO());
		

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = TextHelper.applyTrim(firstName);
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

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public IdentificationTypeDTO getIdentificationType() {
		return identificationType;
	}

	public void setIdentificationType(IdentificationTypeDTO identificationType) {
		this.identificationType = identificationType;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public EpsDTO getEps() {
		return eps;
	}

	public void setEps(EpsDTO eps) {
		this.eps = eps;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public StateDTO getState() {
		return state;
	}

	public void setState(StateDTO state) {
		this.state = state;
	}

	public CityDTO getCity() {
		return city;
	}

	public void setCity(CityDTO city) {
		this.city = city;
	}
	
	
}
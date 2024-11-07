package co.sdj.sdjgym.dto.user;

import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.dto.DomainDTO;
import co.sdj.sdjgym.dto.basedata.CityDTO;
import co.sdj.sdjgym.dto.basedata.EpsDTO;
import co.sdj.sdjgym.dto.basedata.IdentificationTypeDTO;
import co.sdj.sdjgym.dto.basedata.StateDTO;

public class UserDTO extends DomainDTO{
	
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
	
	protected UserDTO() {
		super(UUIDHelper.getDefaultAsString());
		setFirstName(TextHelper.EMPTY);
		setMiddleName(TextHelper.EMPTY);
		setFirstSurName(TextHelper.EMPTY);
		setSecondSurName(TextHelper.EMPTY);
		setEmergencyNumber(TextHelper.EMPTY);
		setEmail(TextHelper.EMPTY);
		setBirthDate(TextHelper.EMPTY);
		setIdentification(TextHelper.EMPTY);
		setEps(EpsDTO.create());
		setAddress(TextHelper.EMPTY);
		setIdentificationType(IdentificationTypeDTO.create());
		setIdentification(TextHelper.EMPTY);
		setState(StateDTO.create());
		setCity(CityDTO.create());
	}
	
	public static final UserDTO create() {
		return new UserDTO();
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
		this.middleName = TextHelper.applyTrim(middleName);
	}

	public String getFirstSurName() {
		return firstSurName;
	}

	public void setFirstSurName(String firstSurName) {
		this.firstSurName = TextHelper.applyTrim(firstSurName);
	}

	public String getSecondSurName() {
		return secondSurName;
	}

	public void setSecondSurName(String secondSurName) {
		this.secondSurName = TextHelper.applyTrim(secondSurName);
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = TextHelper.applyTrim(phoneNumber);
	}

	public String getEmergencyNumber() {
		return emergencyNumber;
	}

	public void setEmergencyNumber(String emergencyNumber) {
		this.emergencyNumber = TextHelper.applyTrim(emergencyNumber);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = TextHelper.applyTrim(email);
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = TextHelper.applyTrim(birthDate);
	}

	public IdentificationTypeDTO getIdentificationType() {
		return identificationType;
	}

	public void setIdentificationType(final IdentificationTypeDTO identificationType) {
		this.identificationType = ObjectHelper.getDefault(identificationType, IdentificationTypeDTO.create());
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = TextHelper.applyTrim(identification);
	}

	public EpsDTO getEps() {
		return eps;
	}

	public void setEps(final EpsDTO eps) {
		this.eps = ObjectHelper.getDefault(eps, EpsDTO.create());
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
		this.state = ObjectHelper.getDefault(state, StateDTO.create());
	}

	public CityDTO getCity() {
		return city;
	}

	public void setCity(CityDTO city) {
		this.city = ObjectHelper.getDefault(city, CityDTO.create());
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

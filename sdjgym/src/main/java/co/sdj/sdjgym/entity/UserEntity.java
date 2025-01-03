package co.sdj.sdjgym.entity;


import java.util.Date;
import java.util.UUID;

import co.sdj.crosscutting.helpers.DateHelper;
import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;

public class UserEntity extends DomainEntity {

	private String firstName;
	private String middleName;
	private String firstSurName;
	private String secondSurName;
	private String phoneNumber;
	private String emergencyNumber;
	private String email;
	private Date birthDate;
	private IdentificationTypeEntity identificationType;
	private String identification;
	private EpsEntity eps;
	private String address;
	private CityEntity city;
	
	public UserEntity() {
		super(UUIDHelper.getDefault());
		setFirstName(TextHelper.EMPTY);
		setMiddleName(TextHelper.EMPTY);
		setFirstSurName(TextHelper.EMPTY);
		setSecondSurName(TextHelper.EMPTY);
		setEmergencyNumber(TextHelper.EMPTY);
		setEmail(TextHelper.EMPTY);
		setBirthDate(DateHelper.DEFAULT_DATE);
		setIdentification(TextHelper.EMPTY);
		setEps(new EpsEntity());
		setAddress(TextHelper.EMPTY);
		setIdentificationType(new IdentificationTypeEntity());
		setIdentification(TextHelper.EMPTY);
		setCity(new CityEntity());
	}
	
	@Override
	public UUID getId() {
		return super.getId();
	}
	
	@Override
	public void setId(UUID id) {
		super.setId(id);
	}

	public CityEntity getCity() {
		return city;
	}

	public void setCity(CityEntity city) {
		this.city = ObjectHelper.getDefault(city, new CityEntity());
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


	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = DateHelper.getDefault(birthDate, DateHelper.getDefault());
	}

	public EpsEntity getEps() {
		return eps;
	}

	public void setEps(EpsEntity eps) {
		this.eps = ObjectHelper.getDefault(eps, new EpsEntity());
	}

	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = TextHelper.applyTrim(address);
	}

	public IdentificationTypeEntity getIdentificationType() {
		return identificationType;
	}

	public void setIdentificationType(IdentificationTypeEntity identificationType) {
		this.identificationType = ObjectHelper.getDefault(identificationType, new IdentificationTypeEntity());
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = TextHelper.applyTrim(identification);
	}

}

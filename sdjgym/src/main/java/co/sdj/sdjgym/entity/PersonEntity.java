package co.sdj.sdjgym.entity;

import java.util.Date;
import java.util.UUID;

import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.entity.basedata.CityEntity;
import co.sdj.sdjgym.entity.basedata.EpsEntity;
import co.sdj.sdjgym.entity.basedata.IdentificationTypeEntity;
import co.sdj.sdjgym.entity.basedata.StateEntity;

public class PersonEntity extends DomainEntity{
	
	private String firstName;
	private String middleName;
	private String firstSurName;
	private String secondSurName;
	private String phoneNumber;
	private String emergencyNumber;
	private String email;
	private String birthDate;
	private IdentificationTypeEntity identificationType;
	private String identification;
	private EpsEntity eps;
	private String address;
	private StateEntity state;
	private CityEntity city;
	

	protected PersonEntity() {
		super(UUIDHelper.getDefault());
		setFirstName(TextHelper.EMPTY);
		setMiddleName(TextHelper.EMPTY);
		setFirstSurName(TextHelper.EMPTY);
		setSecondSurName(TextHelper.EMPTY);
		setEmergencyNumber(TextHelper.EMPTY);
		setEmail(TextHelper.EMPTY);
		setBirthDate(TextHelper.EMPTY);
		setIdentification(TextHelper.EMPTY);
		setEps(new EpsEntity());
		setAddress(TextHelper.EMPTY);
		setIdentificationType(new IdentificationTypeEntity());
		setIdentification(TextHelper.EMPTY);
		setState(new StateEntity());
		setCity(new CityEntity());
		
		
	}


	


	public StateEntity getState() {
		return state;
	}





	public void setState(StateEntity state) {
		this.state = state;
	}





	public CityEntity getCity() {
		return city;
	}





	public void setCity(CityEntity city) {
		this.city = city;
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


	public String getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(String empty) {
		this.birthDate = empty;
	}


	

	public EpsEntity getEps() {
		return eps;
	}


	public void setEps(EpsEntity eps) {
		this.eps = eps;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	

	public IdentificationTypeEntity getIdentificationType() {
		return identificationType;
	}





	public void setIdentificationType(IdentificationTypeEntity identificationType) {
		this.identificationType = identificationType;
	}





	public String getIdentification() {
		return identification;
	}





	public void setIdentification(String identification) {
		this.identification = identification;
	}





	
	
	
	
}

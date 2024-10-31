package co.sdj.sdjgym.entity;

import java.util.Date;
import java.util.UUID;

import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;

public class PersonEntity extends DomainEntity{
	
	private String firstName;
	private String middleName;
	private String firstSurName;
	private String secondSurName;
	private int phoneNumber;
	private String emergencyNumber;
	private String email;
	private Date birthDate;
	private UUID identificadorTipoIdentificacion;
	private IdentificacionTypeEntity tipoIdentificacion;
	private int identificacion;
	private UUID identificadorEps;
	private Epsentity eps;
	private String address;
	private UUID identificatorState;
	private String state;
	private UUID identificadorCity;
	private String city;
	

	protected PersonEntity() {
		super(UUIDHelper.getDefault());
		setFirstName(TextHelper.EMPTY);
		
		
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


	public int getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(int phoneNumber) {
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


	public IdentificacionTypeEntity getTipoIdentificacion() {
		return tipoIdentificacion;
	}


	public void setTipoIdentificacion(IdentificacionTypeEntity tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}


	public int getIdentificacion() {
		return identificacion;
	}


	public void setIdentificacion(int identificacion) {
		this.identificacion = identificacion;
	}


	public UUID getIdentificadorEps() {
		return identificadorEps;
	}


	public void setIdentificadorEps(UUID identificadorEps) {
		this.identificadorEps = identificadorEps;
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


	public UUID getIdentificatorState() {
		return identificatorState;
	}


	public void setIdentificatorState(UUID identificatorState) {
		this.identificatorState = identificatorState;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public UUID getIdentificadorCity() {
		return identificadorCity;
	}


	public void setIdentificadorCity(UUID identificadorCity) {
		this.identificadorCity = identificadorCity;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}
	
	
	
	
}

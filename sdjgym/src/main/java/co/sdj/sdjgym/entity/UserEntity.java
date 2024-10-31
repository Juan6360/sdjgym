package co.sdj.sdjgym.entity;

import java.util.Date;
import java.util.UUID;

import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.domain.Eps;
import co.sdj.sdjgym.domain.TipoIdentificacion;

public class UserEntity extends DomainEntity {
	
	private String firstName;
	private String middleName;
	private String firstSurName;
	private String secondSurName;
	private String phoneNumber;
	private String emergencyNumber;
	private String email;
	private Date birthDate;
	private UUID identificadorTipoIdentificacion;
	private TipoIdentificacion tipoIdentificacion;
	private int identificacion;
	private UUID identificadorEps;
	private Eps eps;
	private String address;
	private UUID identificatorState;
	private String state;
	private UUID identificadorCity;
	private String city;
	// TODO atributo de especialidad
	
	
	


	
	
	protected UserEntity() {
		super(UUIDHelper.generate());
		
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public UUID getIdentificadorTipoIdentificacion() {
		return identificadorTipoIdentificacion;
	}

	public void setIdentificadorTipoIdentificacion(UUID identificadorTipoIdentificacion) {
		this.identificadorTipoIdentificacion = identificadorTipoIdentificacion;
	}

	public TipoIdentificacion getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
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

	public Eps getEps() {
		return eps;
	}

	public void setEps(Eps eps) {
		this.eps = eps;
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

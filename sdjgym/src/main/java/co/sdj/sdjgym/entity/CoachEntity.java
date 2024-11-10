package co.sdj.sdjgym.entity;

import co.sdj.crosscutting.helpers.UUIDHelper;

public class CoachEntity extends DomainEntity {
	
	private SpecialtyEntity specialty;
	
	public CoachEntity() {
		super(UUIDHelper.getDefault());
		setSpecialty(new SpecialtyEntity());
	}

	public SpecialtyEntity getSpecialty() {
		return specialty;
	}

	public void setSpecialty(SpecialtyEntity specialty) {
		this.specialty = specialty;
	}
	
	//HOLA
	
}

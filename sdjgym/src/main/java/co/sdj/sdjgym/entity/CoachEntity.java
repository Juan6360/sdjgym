package co.sdj.sdjgym.entity;

import co.sdj.sdjgym.entity.PersonEntity;

public class CoachEntity extends PersonEntity {
	
	private SpecialtyEntity specialty;
	
	public CoachEntity() {
		super();
		setSpecialty(new SpecialtyEntity());
	}

	public SpecialtyEntity getSpecialty() {
		return specialty;
	}

	public void setSpecialty(SpecialtyEntity specialty) {
		this.specialty = specialty;
	}
	
}

package co.sdj.sdjgym.domain;


import java.util.Date;
import java.util.UUID;

import co.sdj.crosscutting.helpers.DateHelper;
import co.sdj.crosscutting.helpers.NumericHelper;
import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;

public class SessionDomain extends Domain {
	
	private int capacity;
	private Date startDate;
	private Date  endDate;
	private SpaceDomain space;
	private SpecialtyDomain specialty;
	
	
	private SessionDomain(final UUID id, final int capacity, final Date startDate, final Date endDate, final SpaceDomain space, final SpecialtyDomain specialty){
		super(id);
		setCapacity(capacity);
		setStartDate(startDate);
		setEndDate(endDate);
		setSpace(space);
		setSpecialty(specialty);
		
	}



	public static final SessionDomain create(final UUID id, final int capacity, final Date startDate, final Date endDate, final SpaceDomain space, final SpecialtyDomain specialty){
		return new SessionDomain(id,capacity,startDate,endDate,space,specialty);
	}

	public static final SessionDomain create() {
		return new SessionDomain(UUIDHelper.getDefault(), NumericHelper.ZERO,DateHelper.getDefault(null),DateHelper.getDefault(null), SpaceDomain.create(),SpecialtyDomain.create());
	}

	public int getCapacity() {
		return capacity;
	}

	private void setCapacity(final int capacity) {
		this.capacity = NumericHelper.getDefault(capacity);
	}
	public Date getStartDate() {
		return startDate;
	}

	private void setStartDate(final Date startDate) {
		this.startDate = DateHelper.getDefault(startDate);
		
	}
	
	public Date getEndDate() {
		return endDate;
	}

	private void setEndDate(final Date endDate) {
		this.endDate = DateHelper.getDefault(endDate);
		
	}
	

	@Override
	public UUID getId() {
		return super.getId();
	}

	public SpaceDomain getSpace() {
		return space;
	}

	private void setSpace(final SpaceDomain space) {
		this.space = ObjectHelper.getDefault(space, SpaceDomain.create());
	}
	
	public SpecialtyDomain getSpecialty() {
		return specialty;
	}

	private void setSpecialty(final SpecialtyDomain specialty) {
		this.specialty = ObjectHelper.getDefault(specialty, SpecialtyDomain.create());
	}
	

}
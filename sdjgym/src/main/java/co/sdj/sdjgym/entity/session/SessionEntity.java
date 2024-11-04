package co.sdj.sdjgym.entity.session;

import java.util.Date;
import java.util.UUID;

import co.sdj.crosscutting.helpers.DateHelper;
import co.sdj.crosscutting.helpers.NumericHelper;
import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;

import co.sdj.sdjgym.entity.DomainEntity;
import co.sdj.sdjgym.entity.basedata.SpecialtyEntity;
import co.sdj.sdjgym.entity.space.SpaceEntity;



public class SessionEntity extends DomainEntity{

	private int capacity;
	private Date startDate;
	private Date  endDate;
	private SpaceEntity space;
	private SpecialtyEntity specialty;
	
	
	public SessionEntity(){
		super(UUIDHelper.getDefault());
		setCapacity(NumericHelper.getDefault(capacity));
		setStartDate(DateHelper.getDefault(startDate));
		setEndDate(DateHelper.getDefault(endDate));
		setSpace(new SpaceEntity());
		setEspecialty(new SpecialtyEntity());
		
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(final int capacity) {
		this.capacity = NumericHelper.getDefault(capacity);
		
	}
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(final Date startDate) {
		this.startDate = DateHelper.getDefault(startDate);
		
	}
	
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(final Date endDate) {
		this.endDate = DateHelper.getDefault(endDate);
	}
	

	@Override
	public void setId(final UUID id) {
		super.setId(id);
	}

	@Override
	public UUID getId() {
		return super.getId();
	}
	
	public SpaceEntity getSpace() {
		return space;
	}

	public void setSpace(final SpaceEntity space) {
		this.space = ObjectHelper.getDefault(space, new SpaceEntity());
	}
	
	public SpecialtyEntity getSpecialty() {
		return specialty;
	}

	public void setEspecialty(final SpecialtyEntity specialty) {
		this.specialty = ObjectHelper.getDefault(specialty, new SpecialtyEntity());

	}
	

}


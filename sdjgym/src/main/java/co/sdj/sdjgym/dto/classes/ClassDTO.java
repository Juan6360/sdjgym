package co.sdj.sdjgym.dto.classes;

import java.util.Date;
import co.sdj.crosscutting.helpers.DateHelper;
import co.sdj.crosscutting.helpers.NumericHelper;
import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;

import co.sdj.sdjgym.dto.DomainDTO;
import co.sdj.sdjgym.dto.basedata.SpecialtyDTO;
import co.sdj.sdjgym.dto.space.SpaceDTO;

public class ClassDTO extends DomainDTO {


	private int capacity;
	private Date startDate;
	private Date  endDate;
	private SpaceDTO space;
	private SpecialtyDTO specialty;
	
	
	public ClassDTO(){
		super(UUIDHelper.getDefaultAsString());
		setCapacity(NumericHelper.getDefault(capacity));
		setStartDate(DateHelper.getDefault(startDate));
		setEndDate(DateHelper.getDefault(endDate));
		setSpace(SpaceDTO.create());
		setEspecialty(SpecialtyDTO.create());
		
	}





	public static final ClassDTO create() {
		return new ClassDTO();
	}
	
	

	public int getCapacity() {
		return capacity;
	}

	private ClassDTO setCapacity(final int capacity) {
		this.capacity = NumericHelper.getDefault(capacity);
		return this;
	}
	public Date getStartDate() {
		return startDate;
	}

	private ClassDTO setStartDate(final Date startDate) {
		this.startDate = DateHelper.getDefault(startDate);
		return this;
		
	}
	
	public Date getEndDate() {
		return endDate;
	}

	private ClassDTO setEndDate(final Date endDate) {
		this.endDate = DateHelper.getDefault(endDate);
		return this;
	}
	

	@Override
	public String getId() {
		return super.getId();
	}

	public SpaceDTO getSpace() {
		return space;
	}

	public ClassDTO setSpace(final SpaceDTO space) {
		this.space = ObjectHelper.getDefault(space, SpaceDTO.create());
		return this;
	}
	
	public SpecialtyDTO getSpecialty() {
		return specialty;
	}

	private ClassDTO setEspecialty(final SpecialtyDTO specialty) {
		this.specialty = ObjectHelper.getDefault(specialty, SpecialtyDTO.create());
		return this;
	}
	

}


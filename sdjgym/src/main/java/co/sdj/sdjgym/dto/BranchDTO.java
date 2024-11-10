package co.sdj.sdjgym.dto;

import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;

public class BranchDTO extends DomainDTO {
	
	private String address;
	private CityDTO city;
	

	public BranchDTO() {
		super(UUIDHelper.getDefaultAsString());
		setAddress(TextHelper.EMPTY);
		setCity(CityDTO.create());
	}

	public static final BranchDTO create() {
		return new BranchDTO();
		
	}
	public String getAddress() {
		return address;
	}
	
	public BranchDTO setAddress(final String address) {
		this.address = TextHelper.applyTrim (address);
		return this;
		
	}
	
	
	public BranchDTO setId(final String id) {
		super.setIdentifier(id);
		return this;
	}
	
	@Override
	public String getId() {
		return super.getId();
	}

	public CityDTO getCity() {
		return city;
	}

	public BranchDTO setCity(final CityDTO city) {
		this.city = ObjectHelper.getDefault(city, CityDTO.create());
		return this;
	}
}

	
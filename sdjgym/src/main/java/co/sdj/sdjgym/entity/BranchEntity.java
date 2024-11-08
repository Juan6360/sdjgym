package co.sdj.sdjgym.entity;

import java.util.UUID;

import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;

public class BranchEntity extends DomainEntity {

	
	private String address;
	private CityEntity city;
	
	
	public BranchEntity () {
		super(UUIDHelper.getDefault());
		setAddress(TextHelper.EMPTY);
		setCity(new CityEntity());
    }
	public String getAddress() {
		return address;
	}
	
	public void setAddress(final String address) {
		this.address = TextHelper.applyTrim (address);
		
	}
	
	@Override
	public void setId(final UUID id) {
		super.setId(id);
		
	}
	
	@Override
	public UUID getId() {
		return super.getId();
	}

	public CityEntity getState() {
		return city;
	}

	public void setCity(final CityEntity state) {
		this.city = ObjectHelper.getDefault(state, new 	CityEntity());
	}


	
}

package co.sdj.sdjgym.domain.branch;

import java.util.UUID;

import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.domain.Domain;
import co.sdj.sdjgym.domain.basedata.CityDomain;


public class BranchDomain extends Domain {
	
	private String address;
	private CityDomain city;
	
	private BranchDomain(final UUID id,final String address, final CityDomain city) {
		super(id);
		setAddress (address);
		setCity(city);
		
	}
	
	public String getAddress() {
		return address;
	}
	
	static final BranchDomain create(final UUID id, final String address, final CityDomain city) {
		return new BranchDomain(id, address, city);
	}
	
	
	public static final BranchDomain create() {
		return new BranchDomain(UUIDHelper.getDefault(), TextHelper.EMPTY, CityDomain.create());
	}

	private void setAddress(final String address) {
		this.address = TextHelper.applyTrim(address);
	}

	@Override
	public UUID getId() {
		return super.getId();
	}

	public CityDomain getState() {
		return city;
	}
	

	private void setCity(CityDomain city) {
		this.city = ObjectHelper.getDefault(city, CityDomain.create());
		
		
	}
	

}

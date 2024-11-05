package co.sdj.sdjgym.entity.basedata;

import java.util.UUID;

import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.entity.DomainEntity;

public class StateEntity extends DomainEntity{	
	
	private String name;
	private CountryEntity country;
	
	public StateEntity() {
		super(UUIDHelper.getDefault());
		setName(TextHelper.EMPTY);
		setCountry(new CountryEntity());
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = TextHelper.applyTrim(name);
	}
	
	@Override
	public void setId(final UUID id) {
		super.setId(id);
	}
	
	@Override
	public UUID getId() {
		return super.getId();
	}

	public CountryEntity getCountry() {
		return country;
	}

	public void setCountry(CountryEntity country) {
		this.country = country;
	}
	
}

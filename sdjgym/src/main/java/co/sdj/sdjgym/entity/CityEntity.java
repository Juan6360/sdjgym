package co.sdj.sdjgym.entity;

import java.util.UUID;

import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;

public class CityEntity extends DomainEntity{	
	
	private String name;
	private StateEntity state;
	
	public CityEntity() {
		super(UUIDHelper.getDefault());
		setName(TextHelper.EMPTY);
		setState(new StateEntity());
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

	public StateEntity getState() {
		return state;
	}

	public void setState(StateEntity state) {
		this.state = state;
	}
	
}

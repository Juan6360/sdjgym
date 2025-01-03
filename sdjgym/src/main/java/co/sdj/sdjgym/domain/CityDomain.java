package co.sdj.sdjgym.domain;

import java.util.UUID;

import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;

public class CityDomain extends Domain{

	private String name;
	private StateDomain state;
	
	private CityDomain(final UUID id, final String name, final StateDomain state) {
		super(id);
		setName(name);
		setState(state);
	}
	
	public static final CityDomain create(final UUID id, final String name, final StateDomain state) {
		return new CityDomain(id, name, state);
	}
	
	public static final CityDomain create() {
		return new CityDomain(UUIDHelper.getDefault(), TextHelper.EMPTY, StateDomain.create());
	}
	
	public String getName() {
		return name;
	}

	private void setName(final String name) {
		this.name = TextHelper.applyTrim(name);
	}
	
	@Override
	public UUID getId() {
		return super.getId();
	}

	private void setState(StateDomain state) {
		this.state = ObjectHelper.getDefault(state, StateDomain.create());
	}

	public StateDomain getState() {
		return state;
	}
	
}

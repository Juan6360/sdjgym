package co.sdj.sdjgym.domain.basedata;

import java.util.UUID;

import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.domain.Domain;

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
	
	static final CityDomain create() {
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

	public StateDomain getCountry() {
		return state;
	}

	private void setState(StateDomain state) {
		this.state = ObjectHelper.getDefault(state, StateDomain.create());
	}

	public CityDomain getState() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
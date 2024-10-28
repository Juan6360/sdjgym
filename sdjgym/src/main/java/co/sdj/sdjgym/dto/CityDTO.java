package co.sdj.sdjgym.dto;

import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;

public class CityDTO extends DomainDTO{	
	
	private String name;
	private StateDTO state;
	
	public CityDTO() {
		super(UUIDHelper.getDefaultAsString());
		setName(TextHelper.EMPTY);
		setState(StateDTO.create());
	}
	
	public static final CityDTO create() {
		return new CityDTO();
	}

	public String getName() {
		return name;
	}

	public CityDTO setName(final String name) {
		this.name = TextHelper.applyTrim(name);
		return this;
	}
	
	public CityDTO setId(final String id) {
		super.setIdentifier(id);
		return this;
	}
	
	@Override
	public String getId() {
		return super.getId();
	}

	public StateDTO getState() {
		return state;
	}

	public CityDTO setState(final StateDTO state) {
		this.state = ObjectHelper.getDefault(state, StateDTO.create());
		return this;
	}
	
}

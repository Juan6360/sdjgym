package co.sdj.sdjgym.businesslogic.adapter.entity;

import java.util.List;

import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.businesslogic.adapter.Adapter;
import co.sdj.sdjgym.domain.basedata.StateDomain;
import co.sdj.sdjgym.dto.basedata.StateDTO;
import co.sdj.sdjgym.entity.basedata.StateEntity;

public final class StateEntityAdapter implements Adapter<StateDomain, StateEntity> {

private static final Adapter<StateDomain, StateEntity> instance = new StateEntityAdapter();
	
	private StateEntityAdapter() {
		
	}
	
	public static Adapter<StateDomain, StateEntity> getStateEntityAdapter(){
		return instance;
	}
	
	@Override
	public StateDomain adaptSource(final StateEntity data) {
		var entityToAdapt = ObjectHelper.getDefault(data, new StateEntity());
		return StateDomain.create(entityToAdapt.getId(), entityToAdapt.getName(), CountryEntityAdapter.getCountryEntityAdapter().adaptSource(entityToAdapt.getCountry()) );
	}

	@Override
	public StateEntity adaptTarget(StateDomain data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StateEntity> adaptTarget(List<StateDomain> data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StateDomain> adaptSource(List<StateEntity> data) {
		// TODO Auto-generated method stub
		return null;
	}
	

}

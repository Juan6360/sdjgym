package co.sdj.sdjgym.businesslogic.adapter.entity;


import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.businesslogic.adapter.Adapter;
import co.sdj.sdjgym.domain.basedata.CountryDomain;
import co.sdj.sdjgym.domain.basedata.StateDomain;
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
		return StateDomain.create(entityToAdapt.getId(),entityToAdapt.getName(),CountryDomain.create());
	}

	@Override
	public StateEntity adaptTarget(final StateDomain data) {
		var domainToAdapt = ObjectHelper.getDefault(data, StateDomain.create(UUIDHelper.getDefault(),TextHelper.EMPTY, CountryDomain.create()));
		var entityAdapted = new StateEntity();
		entityAdapted.setId(domainToAdapt.getId());
		entityAdapted.setName(domainToAdapt.getName());
		entityAdapted.setCountry(CountryEntityAdapter.getCountryEntityAdapter().adaptTarget(domainToAdapt.getCountry()));
		
		return entityAdapted;
	}

	

}

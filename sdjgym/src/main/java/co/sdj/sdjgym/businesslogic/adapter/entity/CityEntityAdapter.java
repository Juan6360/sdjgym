package co.sdj.sdjgym.businesslogic.adapter.entity;



import java.util.List;

import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.businesslogic.adapter.Adapter;
import co.sdj.sdjgym.domain.CityDomain;
import co.sdj.sdjgym.domain.StateDomain;
import co.sdj.sdjgym.entity.CityEntity;

public final class CityEntityAdapter implements Adapter<CityDomain,CityEntity> {

	private static final Adapter<CityDomain, CityEntity> instance = new CityEntityAdapter();
	
	private CityEntityAdapter() {
		
	}

	public static Adapter<CityDomain, CityEntity> getInstance() {
		return instance;
	}

	@Override
	public CityDomain adaptSource(final CityEntity data) {
		var entityToAdapt = ObjectHelper.getDefault(data, new CityEntity());
		return CityDomain.create(entityToAdapt.getId(),entityToAdapt.getName(),StateDomain.create());
	}

	@Override
	public CityEntity adaptTarget(final CityDomain data) {
		var domainToAdapt = ObjectHelper.getDefault(data, CityDomain.create(UUIDHelper.getDefault(),TextHelper.EMPTY, StateDomain.create()));
		var entityAdapted = new CityEntity();
		entityAdapted.setId(domainToAdapt.getId());
		entityAdapted.setName(domainToAdapt.getName());
		entityAdapted.setState(StateEntityAdapter.getStateEntityAdapter().adaptTarget(domainToAdapt.getState()));
		
		return entityAdapted;
	}

	@Override
	public List<CityEntity> adaptTarget(List<CityDomain> data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CityDomain> adaptSource(List<CityEntity> data) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

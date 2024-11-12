package co.sdj.sdjgym.businesslogic.adapter.entity;



import java.util.ArrayList;
import java.util.List;

import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.businesslogic.adapter.Adapter;
import co.sdj.sdjgym.domain.CityDomain;
import co.sdj.sdjgym.domain.StateDomain;
import co.sdj.sdjgym.entity.CityEntity;

public final class CityEntityAdapter implements Adapter<CityEntity,CityDomain> {

	private static final Adapter<CityEntity, CityDomain> instance = new CityEntityAdapter();
	
	private CityEntityAdapter() {
		
	}

	public static Adapter<CityEntity, CityDomain> getCityEntityAdapter() {
		return instance;
	}

	@Override
	public CityDomain adaptTarget(final CityEntity data) {
		var entityToAdapt = ObjectHelper.getDefault(data, new CityEntity());
		return CityDomain.create(entityToAdapt.getId(),entityToAdapt.getName(),StateDomain.create());
	}

	@Override
	public CityEntity adaptSource(final CityDomain data) {
		var domainToAdapt = ObjectHelper.getDefault(data, CityDomain.create(UUIDHelper.getDefault(),TextHelper.EMPTY, StateDomain.create()));
		var entityAdapted = new CityEntity();
		entityAdapted.setId(domainToAdapt.getId());
		entityAdapted.setName(domainToAdapt.getName());
		entityAdapted.setState(StateEntityAdapter.getStateEntityAdapter().adaptSource(domainToAdapt.getState()));
		
		return entityAdapted;
	}

	@Override
	public List<CityDomain> adaptTarget(final List<CityEntity> data) {
		var results = new ArrayList<CityDomain>();

		for (CityEntity entity : data) {
			results.add(adaptTarget(entity));
		}

		return results;
	}

	


}

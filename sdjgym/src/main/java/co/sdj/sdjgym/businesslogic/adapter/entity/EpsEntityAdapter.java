package co.sdj.sdjgym.businesslogic.adapter.entity;


import java.util.List;

import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.businesslogic.adapter.Adapter;
import co.sdj.sdjgym.domain.EpsDomain;
import co.sdj.sdjgym.entity.EpsEntity;



public class EpsEntityAdapter implements Adapter<EpsDomain,EpsEntity> {

	private static final Adapter<EpsDomain, EpsEntity> instance = new EpsEntityAdapter();
		
	private EpsEntityAdapter() {
		
	}
	
	public static Adapter<EpsDomain, EpsEntity> getEpsEntityAdapter() {
		return instance;
	}

	@Override
	public EpsDomain adaptSource(final EpsEntity data) {
		var entityToAdapt = ObjectHelper.getDefault(data, new EpsEntity());
		return EpsDomain.create(entityToAdapt.getId(),entityToAdapt.getName());
	}

	@Override
	public EpsEntity adaptTarget(final EpsDomain data) {
		var domainToAdapt = ObjectHelper.getDefault(data, EpsDomain.create(UUIDHelper.getDefault(),TextHelper.EMPTY));
		
		var entityAdapted = new EpsEntity();
		entityAdapted.setId(domainToAdapt.getId());
		entityAdapted.setName(domainToAdapt.getName());
		
		return entityAdapted;
	}

	@Override
	public List<EpsEntity> adaptTarget(List<EpsDomain> data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EpsDomain> adaptSource(List<EpsEntity> data) {
		// TODO Auto-generated method stub
		return null;
	}

	

}

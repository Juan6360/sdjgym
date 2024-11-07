package co.sdj.sdjgym.businesslogic.adapter.entity;

import java.util.List;

import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.businesslogic.adapter.Adapter;
import co.sdj.sdjgym.domain.basedata.EpsDomain;
import co.sdj.sdjgym.entity.basedata.EpsEntity;



public class EpsEntityAdapter implements Adapter<EpsDomain,EpsEntity> {

	@Override
	public EpsDomain adaptSource(EpsEntity data) {
		var entityToAdapt = ObjectHelper.getDefault(data, new EpsEntity());
		return EpsDomain.create(entityToAdapt.getId(), entityToAdapt.getName());
	}

	@Override
	public EpsEntity adaptTarget(EpsDomain data) {
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

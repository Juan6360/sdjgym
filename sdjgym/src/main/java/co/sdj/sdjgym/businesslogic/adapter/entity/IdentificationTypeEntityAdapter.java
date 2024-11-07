package co.sdj.sdjgym.businesslogic.adapter.entity;

import java.util.List;

import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.businesslogic.adapter.Adapter;
import co.sdj.sdjgym.domain.basedata.CountryDomain;
import co.sdj.sdjgym.domain.basedata.IdentificationTypeDomain;
import co.sdj.sdjgym.entity.basedata.CountryEntity;
import co.sdj.sdjgym.entity.basedata.IdentificationTypeEntity;

public class IdentificationTypeEntityAdapter implements Adapter<IdentificationTypeDomain,IdentificationTypeEntity> {
	
	private static final Adapter<IdentificationTypeDomain,IdentificationTypeEntity> instance = new IdentificationTypeEntityAdapter();
	
	private IdentificationTypeEntityAdapter() {
	}
	
	
	

	public static Adapter<IdentificationTypeDomain, IdentificationTypeEntity> getIdentificationTypeEntityAdapter() {
		return instance;
	}




	@Override
	public IdentificationTypeDomain adaptSource(final IdentificationTypeEntity data) {
		var entityToAdapt = ObjectHelper.getDefault(data, new IdentificationTypeEntity());
		return IdentificationTypeDomain.create(entityToAdapt.getId(), entityToAdapt.getName());
	}

	@Override
	public IdentificationTypeEntity adaptTarget(final IdentificationTypeDomain data) {
		var domainToAdapt = ObjectHelper.getDefault(data, IdentificationTypeDomain.create(UUIDHelper.getDefault(),TextHelper.EMPTY));
		var entityAdapted = new IdentificationTypeEntity();
		entityAdapted.setId(domainToAdapt.getId());
		entityAdapted.setName(domainToAdapt.getName());
		return entityAdapted;
		
	}

	@Override
	public List<IdentificationTypeEntity> adaptTarget(List<IdentificationTypeDomain> data) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public List<IdentificationTypeDomain> adaptSource(List<IdentificationTypeEntity> data) {
		// TODO Auto-generated method stub
		return null;
	}

}

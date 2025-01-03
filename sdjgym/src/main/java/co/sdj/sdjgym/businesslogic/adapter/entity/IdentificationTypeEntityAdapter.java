package co.sdj.sdjgym.businesslogic.adapter.entity;




import java.util.ArrayList;
import java.util.List;

import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.businesslogic.adapter.Adapter;
import co.sdj.sdjgym.domain.IdentificationTypeDomain;
import co.sdj.sdjgym.entity.IdentificationTypeEntity;

public class IdentificationTypeEntityAdapter implements Adapter<IdentificationTypeEntity,IdentificationTypeDomain> {
	
	private static final Adapter<IdentificationTypeEntity,IdentificationTypeDomain> instance = new IdentificationTypeEntityAdapter();
	
	private IdentificationTypeEntityAdapter() {
	}
	
	
	

	public static Adapter<IdentificationTypeEntity,IdentificationTypeDomain> getIdentificationTypeEntityAdapter() {
		return instance;
	}




	@Override
	public IdentificationTypeDomain adaptTarget(final IdentificationTypeEntity data) {
		var entityToAdapt = ObjectHelper.getDefault(data, new IdentificationTypeEntity());
		return IdentificationTypeDomain.create(entityToAdapt.getId(),entityToAdapt.getName());
	}


	@Override
	public IdentificationTypeEntity adaptSource(final IdentificationTypeDomain data) {
		var domainToAdapt = ObjectHelper.getDefault(data, IdentificationTypeDomain.create(UUIDHelper.getDefault(),TextHelper.EMPTY));
		
		var entityAdapted = new IdentificationTypeEntity();
		entityAdapted.setId(domainToAdapt.getId());
		entityAdapted.setName(domainToAdapt.getName());
		
		return entityAdapted;
	}




	@Override
	public List<IdentificationTypeDomain> adaptTarget(final List<IdentificationTypeEntity> data) {
		var results = new ArrayList<IdentificationTypeDomain>();

		for (IdentificationTypeEntity entity : data) {
			results.add(adaptTarget(entity));
		}

		return results;
	}




}

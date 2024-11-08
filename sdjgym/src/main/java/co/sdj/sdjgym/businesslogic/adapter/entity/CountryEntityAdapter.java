package co.sdj.sdjgym.businesslogic.adapter.entity;

import java.util.List;

import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.businesslogic.adapter.Adapter;
import co.sdj.sdjgym.domain.basedata.CountryDomain;
import co.sdj.sdjgym.entity.basedata.CountryEntity;


public final class CountryEntityAdapter implements Adapter<CountryDomain,CountryEntity> {
	
    private static final Adapter<CountryDomain,CountryEntity> instance = new CountryEntityAdapter();
	
	private CountryEntityAdapter() {
		
	}
	
	public static Adapter<CountryDomain,CountryEntity> getCountryEntityAdapter(){
		return instance;
	}

	@Override
	public CountryDomain adaptSource(final CountryEntity data) {
		var entityToAdapt = ObjectHelper.getDefault(data, new CountryEntity());
		return CountryDomain.create(entityToAdapt.getId(),entityToAdapt.getName()) ;
	}

	@Override
	public CountryEntity adaptTarget(final CountryDomain data) {
		var domainToAdapt = ObjectHelper.getDefault(data, CountryDomain.create(UUIDHelper.getDefault(), TextHelper.EMPTY));
		var entityAdapted = new CountryEntity(); entityAdapted.setId(domainToAdapt.getId()); entityAdapted.setName(domainToAdapt.getName());
		
		return entityAdapted;
	}





	
}

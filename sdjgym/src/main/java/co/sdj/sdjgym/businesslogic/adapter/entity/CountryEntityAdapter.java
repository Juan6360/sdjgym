package co.sdj.sdjgym.businesslogic.adapter.entity;



import java.util.List;

import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.businesslogic.adapter.Adapter;
import co.sdj.sdjgym.domain.CountryDomain;
import co.sdj.sdjgym.entity.CountryEntity;


public final class CountryEntityAdapter implements Adapter<CountryEntity, CountryDomain> {
	
    private static final Adapter<CountryEntity, CountryDomain> instance = new CountryEntityAdapter();
	
	private CountryEntityAdapter() {
		
	}
	
	public static Adapter<CountryEntity, CountryDomain> getCountryEntityAdapter(){
		return instance;
	}

	@Override
	public CountryDomain adaptTarget(final CountryEntity data) {
		var entityToAdapt = ObjectHelper.getDefault(data, new CountryEntity());
		return CountryDomain.create(entityToAdapt.getId(),entityToAdapt.getName()) ;
	}

	@Override
	public CountryEntity adaptSource(final CountryDomain data) {
		var domainToAdapt = ObjectHelper.getDefault(data, CountryDomain.create(UUIDHelper.getDefault(), TextHelper.EMPTY));
		var entityAdapted = new CountryEntity(); entityAdapted.setId(domainToAdapt.getId()); entityAdapted.setName(domainToAdapt.getName());
		
		return entityAdapted;
	}

	@Override
	public List<CountryDomain> adaptTarget(List<CountryEntity> data) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}

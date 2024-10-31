package co.sdj.sdjgym.businesslogic.adapter.entity;

import co.sdj.crosscutting.helpers.ObjectHelper;
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
		var entityToAdapt = ObjectHelper.getDefault(data,new CountryEntity());
		return CountryDomain.create(entityToAdapt.getId(), entityToAdapt.getName());
	}

	@Override
	public CountryEntity adaptTarget(final CountryDomain data) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

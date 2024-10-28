package co.edu.uco.ucobet.businesslogic.adapter.entity;

import co.edu.uco.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.businesslogic.adapter.Adapter;
import co.edu.uco.ucobet.domain.CountryDomain;

import co.edu.uco.ucobet.entity.CountryEntity;


public final class CountryEntityAdapter implements Adapter<CountryDomain,CountryEntity> {
	
private static final Adapter<CountryDomain,CountryEntity> instance = new CountryEntityAdapter();
	
	private CountryEntityAdapter() {
		
	}
	
	public static Adapter<CountryDomain,CountryEntity> getCountryEntityAdapter(){
		return instance;
	}
	
	@Override
	public CountryDomain adaptSource(final CountryEntity data) {
		var entityToAdapt = ObjectHelper.getDefault(data,new CountryEntityAdapter());
		return CountryDomain.create(entityToAdapt.getId(), entityToAdapt.getName());
	}

	@Override
	public CountryEntity adaptTarget(final CountryDomain data) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

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
	public CountryDomain adaptSource(CountryEntity data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CountryEntity adaptTarget(CountryDomain data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CountryEntity> adaptTarget(List<CountryDomain> data) {
		// TODO Auto-generated method stub
		return null;
	}

	
}

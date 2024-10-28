package co.edu.uco.ucobet.businesslogic.adapter.entity;

import co.edu.uco.ucobet.businesslogic.adapter.Adapter;
import co.edu.uco.ucobet.domain.CityDomain;
import co.edu.uco.ucobet.entity.CityEntity;

public final class CityEntityAdapter implements Adapter<CityDomain,CityEntity> {

	private static final Adapter<CityDomain,CityEntity> instance = new CityEntityAdapter();
	
	private CityEntityAdapter() {
		
	}
	
	public static Adapter<CityDomain,CityEntity> getCityEntityAdapter(){
		return instance;
	}
	
	@Override
	public CityDomain adaptSource(CityEntity data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CityEntity adaptTarget(CityDomain data) {
		// TODO Auto-generated method stub
		return null;
	}

}

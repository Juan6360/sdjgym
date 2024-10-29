package co.sdj.sdjgym.businesslogic.adapter.entity;

import co.sdj.sdjgym.businesslogic.adapter.Adapter;
import co.sdj.sdjgym.domain.CityDomain;
import co.sdj.sdjgym.entity.CityEntity;

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

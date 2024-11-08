package co.sdj.sdjgym.businesslogic.adapter.entity;

import java.util.List;

import co.sdj.sdjgym.businesslogic.adapter.Adapter;
import co.sdj.sdjgym.domain.basedata.CityDomain;
import co.sdj.sdjgym.entity.CityEntity;

public final class CityEntityAdapter implements Adapter<CityEntity,CityDomain> {

	private static final Adapter<CityEntity, CityDomain> instance = new CityEntityAdapter();
	
	private CityEntityAdapter() {
		
	}
	
	public static Adapter<CityEntity, CityDomain> getCityEntityAdapter(){
		return instance;
	}

	@Override
	public CityEntity adaptSource(CityDomain data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CityDomain adaptTarget(CityEntity data) {
		// TODO Auto-generated method stub
		return null;
	}



	


}

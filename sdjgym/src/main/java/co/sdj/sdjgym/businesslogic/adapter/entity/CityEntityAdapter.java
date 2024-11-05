package co.sdj.sdjgym.businesslogic.adapter.entity;

import java.util.List;

import co.sdj.sdjgym.businesslogic.adapter.Adapter;
import co.sdj.sdjgym.domain.basedata.CityDomain;
import co.sdj.sdjgym.entity.basedata.CityEntity;

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

	@Override
	public List<CityEntity> adaptTarget(List<CityDomain> data) {
		// TODO Auto-generated method stub
		return null;
	}

	


}

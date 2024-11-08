package co.sdj.sdjgym.businesslogic.adapter.dto;

import java.util.ArrayList;
import java.util.List;


import co.sdj.sdjgym.businesslogic.adapter.Adapter;
import co.sdj.sdjgym.domain.basedata.CityDomain;
import co.sdj.sdjgym.dto.basedata.CityDTO;



public final class CityDTOAdapter implements Adapter<CityDomain, CityDTO> {
	
	private static final Adapter<CityDomain, CityDTO> instance =  new CityDTOAdapter();
	
	private CityDTOAdapter() {
		
	}

	public static Adapter<CityDomain,CityDTO> getCityDTOAdapter(){
		return instance;
	}


	@Override
	public CityDTO adaptTarget(final CityDomain data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CityDTO> adaptTarget(final List<CityDomain> data) {
		
		var results = new ArrayList<CityDTO>();
		
		for (CityDomain domain : data) {
			results.add(adaptTarget(domain));
		}
		
		return results ;
	}

	@Override
	public CityDomain adaptSource(CityDTO data) {
		// TODO Auto-generated method stub
		return null;
	}


}

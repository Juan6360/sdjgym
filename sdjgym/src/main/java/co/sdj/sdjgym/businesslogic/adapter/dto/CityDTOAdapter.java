package co.sdj.sdjgym.businesslogic.adapter.dto;

import co.sdj.sdjgym.businesslogic.adapter.Adapter;
import co.sdj.sdjgym.dto.CityDTO;
import co.sdj.sdjgym.domain.CityDomain;


public final class CityDTOAdapter implements Adapter<CityDomain, CityDTO> {
	
	private static final Adapter<CityDomain, CityDTO> instance =  new CityDTOAdapter();
	
	private CityDTOAdapter() {
		
	}

	@Override
	public CityDomain adaptSource(CityDTO data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CityDTO adaptTarget(CityDomain data) {
		// TODO Auto-generated method stub
		return null;
	}
	


}

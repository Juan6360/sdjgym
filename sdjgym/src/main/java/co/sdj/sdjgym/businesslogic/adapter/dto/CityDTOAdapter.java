package co.sdj.sdjgym.businesslogic.adapter.dto;

import java.util.List;

import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.businesslogic.adapter.Adapter;
import co.sdj.sdjgym.domain.CityDomain;
import co.sdj.sdjgym.domain.StateDomain;
import co.sdj.sdjgym.dto.CityDTO;



public final class CityDTOAdapter implements Adapter<CityDomain, CityDTO> {
	
	private static final Adapter<CityDomain, CityDTO> instance =  new CityDTOAdapter();
	
	private CityDTOAdapter() {
		
	}

	public static Adapter<CityDomain,CityDTO> getCityDTOAdapter(){
		return instance;
	}

	@Override
	public CityDomain adaptSource(final CityDTO data) {
		var dtoToAdapt = ObjectHelper.getDefault(data, CityDTO.create());
		return CityDomain.create(UUIDHelper.convertToUUID(dtoToAdapt.getId()), data.getName(),StateDomain.create());
	}

	@Override
	public CityDTO adaptTarget(final CityDomain data) {
		var domainToAdapt = ObjectHelper.getDefault(data, CityDomain.create(UUIDHelper.getDefault(), TextHelper.EMPTY, StateDomain.create()));
		return CityDTO.create().setId(domainToAdapt.getId().toString()).setName(domainToAdapt.getName());
	}

	@Override
	public List<CityDTO> adaptTarget(List<CityDomain> data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CityDomain> adaptSource(List<CityDTO> data) {
		// TODO Auto-generated method stub
		return null;
	}




}

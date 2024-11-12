package co.sdj.sdjgym.businesslogic.adapter.dto;

import java.util.ArrayList;
import java.util.List;

import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.businesslogic.adapter.Adapter;
import co.sdj.sdjgym.domain.IdentificationTypeDomain;
import co.sdj.sdjgym.dto.IdentificationTypeDTO;

public final class IdentificationTypeDTOAdapter implements Adapter<IdentificationTypeDomain, IdentificationTypeDTO>  {
	
	private static final Adapter<IdentificationTypeDomain, IdentificationTypeDTO> instance = new IdentificationTypeDTOAdapter();
	
	private IdentificationTypeDTOAdapter() {
		
	}

	public static Adapter<IdentificationTypeDomain, IdentificationTypeDTO> getdentificationTypeDTOAdapter() {
		return instance;
	}

	@Override
	public IdentificationTypeDomain adaptSource(final IdentificationTypeDTO data) {
		var dtoToAdapt = ObjectHelper.getDefault(data, IdentificationTypeDTO.create());
		return IdentificationTypeDomain.create(UUIDHelper.convertToUUID(dtoToAdapt.getId()), data.getName());
	}
	@Override
	public IdentificationTypeDTO adaptTarget(final IdentificationTypeDomain data) {
		var domainToAdapt = ObjectHelper.getDefault(data, IdentificationTypeDomain.create(UUIDHelper.getDefault(), TextHelper.EMPTY));
		return IdentificationTypeDTO.create().setId((domainToAdapt.getId().toString())).setName(domainToAdapt.getName());
	}

	@Override
	public List<IdentificationTypeDTO> adaptTarget(final List<IdentificationTypeDomain> data) {
		var results = new ArrayList<IdentificationTypeDTO>();

		for (IdentificationTypeDomain domain : data) {
			results.add(adaptTarget(domain));
		}

		return results;
	}
	

	

	
}

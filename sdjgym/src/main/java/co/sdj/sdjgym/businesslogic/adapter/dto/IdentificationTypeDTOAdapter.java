package co.sdj.sdjgym.businesslogic.adapter.dto;

import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.businesslogic.adapter.Adapter;
import co.sdj.sdjgym.domain.basedata.IdentificationTypeDomain;
import co.sdj.sdjgym.dto.basedata.IdentificationTypeDTO;

public final class IdentificationTypeDTOAdapter implements Adapter<IdentificationTypeDomain, IdentificationTypeDTO>  {
	
	private static final Adapter<IdentificationTypeDomain, IdentificationTypeDTO> instance = new IdentificationTypeDTOAdapter();
	
	private IdentificationTypeDTOAdapter() {
		
	}

	public static Adapter<IdentificationTypeDomain, IdentificationTypeDTO> getInstance() {
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
		return IdentificationTypeDTO.create().setId("").setName(domainToAdapt.getName());
	}

}

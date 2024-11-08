package co.sdj.sdjgym.businesslogic.adapter.dto;

import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.businesslogic.adapter.Adapter;
import co.sdj.sdjgym.domain.basedata.EpsDomain;
import co.sdj.sdjgym.dto.basedata.EpsDTO;

public class EpsDTOAdapter implements Adapter<EpsDomain, EpsDTO> {
	
	private static final Adapter<EpsDomain, EpsDTO> instance = new EpsDTOAdapter();
	
	private EpsDTOAdapter() {
		
	}
	public static Adapter<EpsDomain, EpsDTO> getInstance() {
		return instance;
	}
	@Override
	public EpsDomain adaptSource(final EpsDTO data) {
		var dtoToAdapt = ObjectHelper.getDefault(data, EpsDTO.create());
		return EpsDomain.create(UUIDHelper.convertToUUID(dtoToAdapt.getId()), data.getName());
	}

	@Override
	public EpsDTO adaptTarget(final EpsDomain data) {
		var domainToAdapt = ObjectHelper.getDefault(data, EpsDomain.create(UUIDHelper.getDefault(), TextHelper.EMPTY));
		return EpsDTO.create().setId("").setName(domainToAdapt.getName());
	}

}
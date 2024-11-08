package co.sdj.sdjgym.businesslogic.adapter.dto;



import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.businesslogic.adapter.Adapter;
import co.sdj.sdjgym.domain.basedata.CountryDomain;
import co.sdj.sdjgym.domain.basedata.StateDomain;
import co.sdj.sdjgym.dto.basedata.StateDTO;

public final class StateDTOAdapter implements Adapter<StateDomain, StateDTO>{
	
	private static final Adapter<StateDomain, StateDTO> instance = new StateDTOAdapter();
	
	private StateDTOAdapter() {
		
	}
	
	public static Adapter<StateDomain, StateDTO> getStateDTOAdapter(){
		return instance;
	}

	@Override
	public StateDomain adaptSource(final StateDTO data) {
		var dtoToAdapt = ObjectHelper.getDefault(data, StateDTO.create());
		return StateDomain.create(UUIDHelper.convertToUUID(dtoToAdapt.getId()), data.getName(),CountryDomain.create());
		
	}

	@Override
	public StateDTO adaptTarget(final StateDomain data) {
		var domainToAdapt = ObjectHelper.getDefault(data, StateDomain.create(UUIDHelper.getDefault(), TextHelper.EMPTY, CountryDomain.create()));
		return StateDTO.create().setId("").setName(domainToAdapt.getName());
	}

}



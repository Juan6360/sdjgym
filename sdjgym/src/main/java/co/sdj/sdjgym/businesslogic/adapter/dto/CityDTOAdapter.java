package co.sdj.sdjgym.businesslogic.adapter.dto;




import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.businesslogic.adapter.Adapter;
import co.sdj.sdjgym.domain.basedata.CityDomain;
import co.sdj.sdjgym.domain.basedata.StateDomain;
import co.sdj.sdjgym.dto.basedata.CityDTO;



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
		return CityDTO.create().setId("").setName(domainToAdapt.getName());
	}




}

package co.sdj.sdjgym.businesslogic.adapter.dto;



import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.businesslogic.adapter.Adapter;
import co.sdj.sdjgym.domain.CountryDomain;
import co.sdj.sdjgym.dto.CountryDTO;

public final class CountryDTOAdapter implements Adapter<CountryDomain,CountryDTO> {

	private static final Adapter<CountryDomain, CountryDTO> instance =  new CountryDTOAdapter();
	
	private CountryDTOAdapter() {
		
	}
	
	public static Adapter<CountryDomain, CountryDTO> getCountryDTOAdapter(){
		return instance;
	}

	@Override
	public CountryDomain adaptSource(final CountryDTO data) {
		var dtoToAdapt = ObjectHelper.getDefault(data, CountryDTO.create());
		return CountryDomain.create(UUIDHelper.convertToUUID(dtoToAdapt.getId()), data.getName());
	}

	@Override
	public CountryDTO adaptTarget(final CountryDomain data) {
		var domainToAdapt = ObjectHelper.getDefault(data, CountryDomain.create(UUIDHelper.getDefault(), TextHelper.EMPTY));
		return CountryDTO.create().setId("").setName(domainToAdapt.getName());
	}



}

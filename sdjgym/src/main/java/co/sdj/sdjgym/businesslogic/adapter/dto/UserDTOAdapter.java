package co.sdj.sdjgym.businesslogic.adapter.dto;

import java.util.ArrayList;
import java.util.List;

import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.businesslogic.adapter.Adapter;
import co.sdj.sdjgym.domain.CityDomain;
import co.sdj.sdjgym.domain.EpsDomain;
import co.sdj.sdjgym.domain.IdentificationTypeDomain;
import co.sdj.sdjgym.domain.StateDomain;
import co.sdj.sdjgym.domain.UserDomain;
import co.sdj.sdjgym.dto.UserDTO;

public class UserDTOAdapter implements Adapter<UserDomain , UserDTO>{
	
	private static final Adapter<UserDomain, UserDTO> instance = new UserDTOAdapter();
	
	private UserDTOAdapter() {
		
	}

	public static Adapter<UserDomain, UserDTO> getUserDTOAdapter() {
		return instance;
	}

	@Override
	public UserDomain adaptSource(final UserDTO data) {
		var dtoToAdapt = ObjectHelper.getDefault(data, UserDTO.create());
		return UserDomain.create(UUIDHelper.convertToUUID(dtoToAdapt.getId()),data.getFirstName(), data.getMiddleName(), data.getFirstSurName(), data.getSecondSurName(), data.getPhoneNumber(), data.getEmergencyNumber(), data.getEmail(), data.getBirthDate(), IdentificationTypeDomain.create(), data.getIdentification(), EpsDomain.create(), data.getAddress(), StateDomain.create(), CityDomain.create());
		
		
	}

	@Override
	public UserDTO adaptTarget(final UserDomain data) {
		var domainToAdapt = ObjectHelper.getDefault(data, UserDomain.create(UUIDHelper.getDefault(), TextHelper.EMPTY, TextHelper.EMPTY, TextHelper.EMPTY, TextHelper.EMPTY, TextHelper.EMPTY, TextHelper.EMPTY, TextHelper.EMPTY, TextHelper.EMPTY, IdentificationTypeDomain.create(), TextHelper.EMPTY, EpsDomain.create(), TextHelper.EMPTY, StateDomain.create(), CityDomain.create()));
		return UserDTO.create().setId((domainToAdapt.getId().toString())).setFirstName(domainToAdapt.getFirstName()).setMiddleName(domainToAdapt.getMiddleName()).setFirstSurName(domainToAdapt.getFirstSurName()).setSecondSurName(domainToAdapt.getSecondSurName()).setPhoneNumber(domainToAdapt.getPhoneNumber()).setEmergencyNumber(domainToAdapt.getEmergencyNumber()).setEmail(domainToAdapt.getEmail()).setBirthDate(domainToAdapt.getBirthDate())
				.setIdentificationType(IdentificationTypeDTOAdapter.getdentificationTypeDTOAdapter().adaptTarget(domainToAdapt.getIdentificationType())).setIdentification(domainToAdapt.getIdentificacion()).setEps(EpsDTOAdapter.getEpsDTOAdapter().adaptTarget(domainToAdapt.getEps())).setState(StateDTOAdapter.getStateDTOAdapter().adaptTarget(domainToAdapt.getState()))
				.setCity(CityDTOAdapter.getCityDTOAdapter().adaptTarget(domainToAdapt.getCity()));
	}

	@Override
	public List<UserDTO> adaptTarget(List<UserDomain> data) {
		var results = new ArrayList<UserDTO>();

		for (UserDomain domain : data) {
			results.add(adaptTarget(domain));
		}

		return results;
	}
	




}



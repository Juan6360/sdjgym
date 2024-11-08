package co.sdj.sdjgym.businesslogic.adapter.dto;

import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.businesslogic.adapter.Adapter;
import co.sdj.sdjgym.domain.basedata.CityDomain;
import co.sdj.sdjgym.domain.basedata.EpsDomain;
import co.sdj.sdjgym.domain.basedata.IdentificationTypeDomain;
import co.sdj.sdjgym.domain.basedata.StateDomain;
import co.sdj.sdjgym.domain.user.UserDomain;
import co.sdj.sdjgym.dto.basedata.CityDTO;
import co.sdj.sdjgym.dto.basedata.IdentificationTypeDTO;
import co.sdj.sdjgym.dto.basedata.StateDTO;
import co.sdj.sdjgym.dto.user.UserDTO;

public class UserDTOAdapter implements Adapter<UserDomain , UserDTO>{
	
	private static final Adapter<UserDomain, UserDTO> instance = new UserDTOAdapter();
	
	private UserDTOAdapter() {
		
	}

	public static Adapter<UserDomain, UserDTO> getInstance() {
		return instance;
	}

	@Override
	public UserDomain adaptSource(final UserDTO data) {
		var dtoToAdapt = ObjectHelper.getDefault(data, UserDTO.create());
		return UserDomain.create(UUIDHelper.convertToUUID(dtoToAdapt.getId()),data.getFirstName(), data.getMiddleName(), data.getFirstSurName(), data.getSecondSurName(), data.getPhoneNumber(), data.getEmergencyNumber(), data.getEmail(), data.getBirthDate(), IdentificationTypeDomain.create(), data.getIdentification(), EpsDomain.create(), data.getAddress(), StateDomain.create(), CityDomain.create());
		
		
	}

	@Override
	public UserDTO adaptTarget(final UserDomain data) {
		var domainToAdapt = ObjectHelper.getDefault(data, UserDomain.create(),UUIDHelper.getDefault(), TextHelper.EMPTY, TextHelper.EMPTY, TextHelper.EMPTY, TextHelper.EMPTY, TextHelper.EMPTY, TextHelper.EMPTY, TextHelper.EMPTY,  TextHelper.EMPTY, IdentificationTypeDomain.create(),  TextHelper.EMPTY, EpsDomain.create(),  TextHelper.EMPTY,  StateDomain.create(), CityDomain.create());
		return UserDTO.create().setId("").setFirstName(domainToAdapt.getFirstName()).setMiddleName(domainToAdapt.getMiddleName()).setFirstSurName(domainToAdapt.getFirstSurName()).setSecondSurName(domainToAdapt.getSecondSurName()).setPhoneNumber(domainToAdapt.getPhoneNumber()).setEmergencyNumber(domainToAdapt.getEmergencyNumber()).setEmail(domainToAdapt.getEmail()).setBirthDate(domainToAdapt.getBirthDate()).setIdentificationType(IdentificationTypeDTO.create()) .setIdentification(domainToAdapt.getIdentification()).setEps(EpsDTO.create()) .setAddress(domainToAdapt.getAddress()).setState(StateDTO.create()) .setCity(CityDTO.create());
	    }
	}



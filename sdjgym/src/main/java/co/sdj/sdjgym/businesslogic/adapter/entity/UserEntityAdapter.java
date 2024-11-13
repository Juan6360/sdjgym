package co.sdj.sdjgym.businesslogic.adapter.entity;

import java.util.ArrayList;
import java.util.List;

import co.sdj.crosscutting.helpers.DateHelper;
import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.businesslogic.adapter.Adapter;
import co.sdj.sdjgym.businesslogic.adapter.dto.CityDTOAdapter;
import co.sdj.sdjgym.businesslogic.adapter.dto.EpsDTOAdapter;
import co.sdj.sdjgym.businesslogic.adapter.dto.IdentificationTypeDTOAdapter;
import co.sdj.sdjgym.domain.CityDomain;
import co.sdj.sdjgym.domain.EpsDomain;
import co.sdj.sdjgym.domain.IdentificationTypeDomain;
import co.sdj.sdjgym.domain.UserDomain;
import co.sdj.sdjgym.entity.UserEntity;

public class UserEntityAdapter implements Adapter<UserEntity,UserDomain>{
	
	
	private static final Adapter<UserEntity,UserDomain> instance = new UserEntityAdapter();
	
	public UserEntityAdapter() {
		
	}
	
	
	public static Adapter<UserEntity,UserDomain> getUserEntityAdapter(){
		return instance;
	}
	
	@Override
	public UserDomain adaptTarget(final UserEntity data) {
		var entityToAdapt = ObjectHelper.getDefault(data, new UserEntity ());
		var cityDomain = CityEntityAdapter.getCityEntityAdapter().adaptTarget(data.getCity());
		var identificationTypeDomain = IdentificationTypeEntityAdapter.getIdentificationTypeEntityAdapter().adaptTarget(data.getIdentificationType());
		var epsDomain = EpsEntityAdapter.getEpsEntityAdapter().adaptTarget(data.getEps());
		return UserDomain.create(entityToAdapt.getId(), entityToAdapt.getFirstName(), entityToAdapt.getMiddleName(), entityToAdapt.getFirstSurName(), entityToAdapt.getSecondSurName(), entityToAdapt.getPhoneNumber(), entityToAdapt.getEmergencyNumber(), entityToAdapt.getEmail(), entityToAdapt.getBirthDate(), identificationTypeDomain, entityToAdapt.getIdentification(), epsDomain, entityToAdapt.getAddress(), cityDomain);
	}

	@Override
	public UserEntity adaptSource(final UserDomain data) {
		var domainToAdapt = ObjectHelper.getDefault(data, UserDomain.create(UUIDHelper.getDefault(),TextHelper.EMPTY,TextHelper.EMPTY,TextHelper.EMPTY,TextHelper.EMPTY,TextHelper.EMPTY,TextHelper.EMPTY,TextHelper.EMPTY,DateHelper.DEFAULT_DATE,IdentificationTypeDomain.create(),TextHelper.EMPTY,EpsDomain.create(),TextHelper.EMPTY,CityDomain.create()));
		
		var entityToAdapt = new UserEntity();
		
		entityToAdapt.setId(domainToAdapt.getId());
		entityToAdapt.setFirstName(domainToAdapt.getFirstName());
		entityToAdapt.setMiddleName(domainToAdapt.getMiddleName());
		entityToAdapt.setFirstSurName(domainToAdapt.getFirstSurName());
		entityToAdapt.setSecondSurName(domainToAdapt.getSecondSurName());
		entityToAdapt.setPhoneNumber(domainToAdapt.getPhoneNumber());
		entityToAdapt.setEmergencyNumber(domainToAdapt.getEmergencyNumber());
		entityToAdapt.setEmail(domainToAdapt.getEmail());
		entityToAdapt.setBirthDate(domainToAdapt.getBirthDate());
		entityToAdapt.setIdentificationType(IdentificationTypeEntityAdapter.getIdentificationTypeEntityAdapter().adaptSource(domainToAdapt.getIdentificationType()));
		entityToAdapt.setIdentification(domainToAdapt.getIdentificacion());
		entityToAdapt.setEps(EpsEntityAdapter.getEpsEntityAdapter().adaptSource(domainToAdapt.getEps()));
		entityToAdapt.setAddress(domainToAdapt.getAddress());
		entityToAdapt.setCity(CityEntityAdapter.getCityEntityAdapter().adaptSource(domainToAdapt.getCity()));
		
		
		
		return entityToAdapt;
	}

	@Override
	public List<UserDomain> adaptTarget(final List<UserEntity> data) {
		var results = new ArrayList<UserDomain>();

		for (UserEntity entity : data) {
			results.add(adaptTarget(entity));
		}

		return results;
	}

}

package co.sdj.sdjgym.businesslogic.adapter.entity;

import java.util.ArrayList;
import java.util.List;

import co.sdj.crosscutting.helpers.DateHelper;
import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.businesslogic.adapter.Adapter;
import co.sdj.sdjgym.domain.CityDomain;
import co.sdj.sdjgym.domain.EpsDomain;
import co.sdj.sdjgym.domain.IdentificationTypeDomain;
import co.sdj.sdjgym.domain.StateDomain;
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
		return UserDomain.create(entityToAdapt.getId(), entityToAdapt.getFirstName(), entityToAdapt.getMiddleName(), entityToAdapt.getFirstSurName(), entityToAdapt.getSecondSurName(), entityToAdapt.getPhoneNumber(), entityToAdapt.getEmergencyNumber(), entityToAdapt.getEmail(), entityToAdapt.getBirthDate(), IdentificationTypeDomain.create(), entityToAdapt.getIdentification(), EpsDomain.create(), entityToAdapt.getAddress(), StateDomain.create(), CityDomain.create());
	}

	@Override
	public UserEntity adaptSource(final UserDomain data) {
		var domainToAdapt = ObjectHelper.getDefault(data, UserDomain.create(UUIDHelper.getDefault(),TextHelper.EMPTY,TextHelper.EMPTY,TextHelper.EMPTY,TextHelper.EMPTY,TextHelper.EMPTY,TextHelper.EMPTY,TextHelper.EMPTY,DateHelper.DEFAULT_DATE,IdentificationTypeDomain.create(),TextHelper.EMPTY,EpsDomain.create(),TextHelper.EMPTY,StateDomain.create(),CityDomain.create()));
		
		var entityToAdapted = new UserEntity();
		
		entityToAdapted.setId(domainToAdapt.getId());
		entityToAdapted.setFirstName(domainToAdapt.getFirstName());
		entityToAdapted.setMiddleName(domainToAdapt.getMiddleName());
		entityToAdapted.setFirstSurName(domainToAdapt.getFirstSurName());
		entityToAdapted.setSecondSurName(domainToAdapt.getSecondSurName());
		entityToAdapted.setPhoneNumber(domainToAdapt.getPhoneNumber());
		entityToAdapted.setEmergencyNumber(domainToAdapt.getEmergencyNumber());
		entityToAdapted.setEmail(domainToAdapt.getEmail());
		entityToAdapted.setBirthDate(domainToAdapt.getBirthDate());
		entityToAdapted.setIdentificationType(IdentificationTypeEntityAdapter.getIdentificationTypeEntityAdapter().adaptSource(domainToAdapt.getIdentificationType()));
		entityToAdapted.setIdentification(domainToAdapt.getIdentificacion());
		entityToAdapted.setEps(EpsEntityAdapter.getEpsEntityAdapter().adaptSource(domainToAdapt.getEps()));
		entityToAdapted.setAddress(domainToAdapt.getAddress());
		entityToAdapted.setState(StateEntityAdapter.getStateEntityAdapter().adaptSource(domainToAdapt.getState()));
		entityToAdapted.setCity(CityEntityAdapter.getCityEntityAdapter().adaptSource(domainToAdapt.getCity()));
		
		
		
		return null;
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

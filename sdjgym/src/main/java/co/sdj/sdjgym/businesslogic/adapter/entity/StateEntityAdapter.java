package co.sdj.sdjgym.businesslogic.adapter.entity;

import java.util.List;

import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.businesslogic.adapter.Adapter;
import co.sdj.sdjgym.domain.basedata.StateDomain;
import co.sdj.sdjgym.dto.basedata.StateDTO;
import co.sdj.sdjgym.entity.basedata.StateEntity;

public final class StateEntityAdapter implements Adapter<StateDomain, StateEntity> {

private static final Adapter<StateDomain, StateEntity> instance = new StateEntityAdapter();
	
	private StateEntityAdapter() {
		
	}
	
	public static Adapter<StateDomain, StateEntity> getStateEntityAdapter(){
		return instance;
	}
	
	@Override
	public StateDomain adaptSource(StateEntity data) {
		var dtoToAdapt = ObjectHelper.getDefault(data, StateDTO.create());
		return StateDomain.create(UUIDHelper.convertToUUID(dtoToAdapt.getId()), data.getName());
	}

	@Override
	public StateEntity adaptTarget(StateDomain data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StateEntity> adaptTarget(List<StateDomain> data) {
		// TODO Auto-generated method stub
		return null;
	}
	

}

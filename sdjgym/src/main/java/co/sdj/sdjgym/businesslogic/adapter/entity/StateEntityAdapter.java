package co.sdj.sdjgym.businesslogic.adapter.entity;

import co.sdj.sdjgym.businesslogic.adapter.Adapter;
import co.sdj.sdjgym.domain.basedata.StateDomain;
import co.sdj.sdjgym.entity.StateEntity;

public final class StateEntityAdapter implements Adapter<StateDomain, StateEntity> {

private static final Adapter<StateDomain, StateEntity> instance = new StateEntityAdapter();
	
	private StateEntityAdapter() {
		
	}
	
	public static Adapter<StateDomain, StateEntity> getStateEntityAdapter(){
		return instance;
	}
	
	@Override
	public StateDomain adaptSource(StateEntity data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StateEntity adaptTarget(StateDomain data) {
		// TODO Auto-generated method stub
		return null;
	}
	

}

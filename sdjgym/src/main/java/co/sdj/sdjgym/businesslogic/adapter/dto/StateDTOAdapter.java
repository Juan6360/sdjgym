package co.sdj.sdjgym.businesslogic.adapter.dto;

import java.util.List;

import co.sdj.sdjgym.businesslogic.adapter.Adapter;
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
	public StateDomain adaptSource(StateDTO data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StateDTO adaptTarget(StateDomain data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StateDTO> adaptTarget(List<StateDomain> data) {
		// TODO Auto-generated method stub
		return null;
	}
}



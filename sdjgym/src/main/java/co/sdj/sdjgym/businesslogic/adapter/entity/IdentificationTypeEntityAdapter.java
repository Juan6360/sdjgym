package co.sdj.sdjgym.businesslogic.adapter.entity;




import co.sdj.sdjgym.businesslogic.adapter.Adapter;
import co.sdj.sdjgym.domain.basedata.IdentificationTypeDomain;
import co.sdj.sdjgym.entity.IdentificationTypeEntity;

public class IdentificationTypeEntityAdapter implements Adapter<IdentificationTypeDomain,IdentificationTypeEntity> {
	
	private static final Adapter<IdentificationTypeDomain,IdentificationTypeEntity> instance = new IdentificationTypeEntityAdapter();
	
	private IdentificationTypeEntityAdapter() {
	}
	
	
	

	public static Adapter<IdentificationTypeDomain, IdentificationTypeEntity> getIdentificationTypeEntityAdapter() {
		return instance;
	}




	@Override
	public IdentificationTypeDomain adaptSource(IdentificationTypeEntity data) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public IdentificationTypeEntity adaptTarget(IdentificationTypeDomain data) {
		// TODO Auto-generated method stub
		return null;
	}






}

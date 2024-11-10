package co.sdj.sdjgym.businesslogic.adapter.entity;




import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.businesslogic.adapter.Adapter;
import co.sdj.sdjgym.domain.IdentificationTypeDomain;
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
		var entityToAdapt = ObjectHelper.getDefault(data, new IdentificationTypeEntity());
		return IdentificationTypeDomain.create(entityToAdapt.getId(),entityToAdapt.getName());
	}


	@Override
	public IdentificationTypeEntity adaptTarget(IdentificationTypeDomain data) {
		var domainToAdapt = ObjectHelper.getDefault(data, IdentificationTypeDomain.create(UUIDHelper.getDefault(),TextHelper.EMPTY));
		
		var entityAdapted = new IdentificationTypeEntity();entityAdapted.setId(domainToAdapt.getId());entityAdapted.setName(domainToAdapt.getName());
		
		return entityAdapted;
	}


}

package co.sdj.sdjgym.data.dao;

import java.util.UUID;

import co.sdj.sdjgym.entity.basedata.CityEntity;
import co.sdj.sdjgym.entity.basedata.IdentificationTypeEntity;

public interface IdentificationTypeDAO extends CreateDAO<IdentificationTypeEntity>, RetrieveDAO<IdentificationTypeEntity, UUID>, UpdateDAO<IdentificationTypeEntity>, DeleteDAO<UUID> {

}

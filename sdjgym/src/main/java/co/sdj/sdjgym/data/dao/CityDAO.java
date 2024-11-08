package co.sdj.sdjgym.data.dao;

import java.util.UUID;

import co.sdj.sdjgym.entity.basedata.CityEntity;


public interface CityDAO  extends RetrieveDAO<CityEntity, UUID>,UpdateDAO<CityEntity>,DeleteDAO<UUID>{


}

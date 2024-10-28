package co.sdj.sdjgym.data.dao.impl.sql.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.sdj.sdjgym.data.dao.CityDAO;
import co.sdj.sdjgym.data.dao.CountryDAO;
import co.sdj.sdjgym.data.dao.impl.sql.SqlDAO;
import co.sdj.sdjgym.entity.CityEntity;
import co.sdj.sdjgym.entity.CountryEntity;

public class CitySqlServerDAO extends SqlDAO implements CityDAO {
	
	public CitySqlServerDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public void create(CityEntity data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CityEntity findByID(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CityEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CityEntity> findByFilter(CityEntity filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(CityEntity data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UUID data) {
		// TODO Auto-generated method stub
		
	}
	


}

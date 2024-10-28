package co.sdj.sdjgym.data.dao.impl.sql.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import co.sdj.sdjgym.data.dao.CountryDAO;
import co.sdj.sdjgym.data.dao.impl.sql.SqlDAO;
import co.sdj.sdjgym.entity.CountryEntity;

public class CountrySqlServerDAO extends SqlDAO implements CountryDAO {
	
	public CountrySqlServerDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public CountryEntity findByID(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CountryEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CountryEntity> findByFilter(CountryEntity filter) {
		// TODO Auto-generated method stub
		return null;
	}


}

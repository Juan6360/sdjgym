package co.sdj.sdjgym.businesslogic.usecase.city;

import co.sdj.sdjgym.data.dao.DAOFactory;

public interface Rule<T> {
	void execute(T data, DAOFactory factory);
}

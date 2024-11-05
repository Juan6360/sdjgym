package co.sdj.sdjgym.businesslogic.usecase;

import co.sdj.sdjgym.data.dao.DAOFactory;

public interface RuleWithFactory<T> {
	void execute(T data, DAOFactory factory);

}

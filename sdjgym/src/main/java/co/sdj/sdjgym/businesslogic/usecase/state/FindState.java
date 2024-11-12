package co.sdj.sdjgym.businesslogic.usecase.state;

import java.util.List;

import co.sdj.sdjgym.businesslogic.usecase.UseWithReturn;

import co.sdj.sdjgym.domain.StateDomain;

public interface FindState extends UseWithReturn<StateDomain, List<StateDomain>> {

}

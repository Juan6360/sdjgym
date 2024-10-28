package co.sdj.sdjgym.businesslogic.usecase.city;

import java.util.List;

import co.sdj.sdjgym.businesslogic.usecase.UseWithReturn;
import co.sdj.sdjgym.domain.CityDomain;

public interface FindCity extends UseWithReturn<CityDomain,List<CityDomain>> {

}

package co.sdj.sdjgym.businesslogic.usecase.country;

import java.util.List;

import co.sdj.sdjgym.businesslogic.usecase.UseWithReturn;
import co.sdj.sdjgym.domain.CountryDomain;

public interface FindCountry extends UseWithReturn<CountryDomain, List<CountryDomain>> {

}

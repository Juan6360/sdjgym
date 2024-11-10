package co.sdj.sdjgym.businesslogic.usecase.identificationType;

import java.util.List;

import co.sdj.sdjgym.businesslogic.usecase.UseWithReturn;
import co.sdj.sdjgym.domain.IdentificationTypeDomain;

public interface FindIdentificationType extends UseWithReturn<IdentificationTypeDomain, List<IdentificationTypeDomain>> {
	
}

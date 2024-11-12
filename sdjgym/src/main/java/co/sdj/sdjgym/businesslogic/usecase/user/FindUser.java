package co.sdj.sdjgym.businesslogic.usecase.user;

import java.util.List;

import co.sdj.sdjgym.businesslogic.usecase.UseWithReturn;
import co.sdj.sdjgym.domain.UserDomain;

public interface FindUser extends UseWithReturn<UserDomain,List<UserDomain>> {

}

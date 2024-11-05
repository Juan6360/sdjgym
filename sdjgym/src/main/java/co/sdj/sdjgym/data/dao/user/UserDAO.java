package co.sdj.sdjgym.data.dao.user;

import java.util.UUID;

import co.sdj.sdjgym.data.dao.CreateDAO;
import co.sdj.sdjgym.data.dao.DeleteDAO;
import co.sdj.sdjgym.data.dao.RetrieveDAO;
import co.sdj.sdjgym.entity.user.UserEntity;

public interface UserDAO extends CreateDAO<UserEntity>, RetrieveDAO<UserEntity, UUID>, DeleteDAO<UUID>{
	
}

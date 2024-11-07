package co.sdj.sdjgym.data.dao;

import java.util.UUID;

import co.sdj.sdjgym.entity.user.UserEntity;

public interface UserDAO extends CreateDAO<UserEntity>, RetrieveDAO<UserEntity, UUID>, DeleteDAO<UUID>{
	
}

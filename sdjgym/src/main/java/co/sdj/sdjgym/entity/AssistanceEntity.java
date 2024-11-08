package co.sdj.sdjgym.entity;

import java.util.UUID;

import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;

public class AssistanceEntity extends DomainEntity {
    
	private SessionEntity session;
	private UserEntity user;
	

	public AssistanceEntity() {
		super(UUIDHelper.getDefault());
		setSession(new SessionEntity());
		setUser(new UserEntity());
	 }
	
		
	@Override
	public void setId(final UUID id) {
		super.setId(id);
		
	}
	@Override
	
	public UUID getId() {
		return super.getId();
	}
	
	
	public SessionEntity getSession() {
		return session;
	}

	public void setSession(final SessionEntity session) {
			this.session = ObjectHelper.getDefault(session,new  SessionEntity());
			
	}
	

	public UserEntity getUser() {
		return user;
	}

	public void setUser(final UserEntity user) {
		this.user = ObjectHelper.getDefault(user, new UserEntity());
			
		}
	

}

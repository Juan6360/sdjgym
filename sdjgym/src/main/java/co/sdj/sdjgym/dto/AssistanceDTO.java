package co.sdj.sdjgym.dto;

import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;

public class AssistanceDTO extends DomainDTO {
	
	private SessionDTO session;
	private UserDTO user;
	

	public AssistanceDTO() {
		super(UUIDHelper.getDefaultAsString());
		setSession(session);
		setUser(user);
	 }
		

		public static final AssistanceDTO create () {
			return new AssistanceDTO();
		}
		
		
		@Override
		public String getId() {
			return super.getId();
		}

		public SessionDTO getSession() {
			return session;
		}

		public AssistanceDTO setSession(final SessionDTO session) {
			this.session = ObjectHelper.getDefault(session, SessionDTO.create());
			return this;
		}
	

		public UserDTO getUser() {
			return user;
		}

		public AssistanceDTO setUser(final UserDTO user) {
			this.user = ObjectHelper.getDefault(user, UserDTO.create());
			return this;
		}
	

}


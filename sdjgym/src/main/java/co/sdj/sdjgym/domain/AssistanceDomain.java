package co.sdj.sdjgym.domain;

import java.util.UUID;

import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.domain.session.SessionDomain;
import co.sdj.sdjgym.domain.user.UserDomain;

public class AssistanceDomain extends Domain  {
	
	

	private SessionDomain session;
	private UserDomain user;
	

	private AssistanceDomain(final UUID id,final SessionDomain session, final UserDomain user) {
		super(id);
		setSession(session);
		setUser(user);
	 }
		

		public static final AssistanceDomain create (final UUID id, final SessionDomain session, final UserDomain user) {
			return new AssistanceDomain(id, session, user);
		}
		
		static final AssistanceDomain create() {
			return new AssistanceDomain(UUIDHelper.getDefault(),SessionDomain.create(), UserDomain.create());
		}
		
		@Override
		public UUID getId() {
			return super.getId();
		}

		public SessionDomain getSession() {
			return session;
		}

		private void setSession(final SessionDomain session) {
			this.session = ObjectHelper.getDefault(session, SessionDomain.create());
		}
	

		public UserDomain getUser() {
			return user;
		}

		private void setUser(final UserDomain user) {
			this.user = ObjectHelper.getDefault(user, UserDomain.create());
		}
	

}

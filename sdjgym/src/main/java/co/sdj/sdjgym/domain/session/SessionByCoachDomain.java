package co.sdj.sdjgym.domain.session;

import java.util.UUID;

import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.domain.Domain;
import co.sdj.sdjgym.domain.coach.CoachDomain;

public class SessionByCoachDomain extends Domain{
	
	private SessionDomain session;
	private CoachDomain coach;
	

	private SessionByCoachDomain(final UUID id,final SessionDomain session, final CoachDomain coach) {
		super(id);
		setSession(session);
		setCoach(coach);
	 }
		

		public static final SessionByCoachDomain create (final UUID id, final SessionDomain session, final CoachDomain coach) {
			return new SessionByCoachDomain(id, session, coach);
		}
		
		public static final SessionByCoachDomain create() {
			return new SessionByCoachDomain(UUIDHelper.getDefault(),SessionDomain.create(), CoachDomain.create());
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
	

		public CoachDomain getCoach() {
			return coach;
		}

		private void setCoach(final CoachDomain coach) {
			this.coach = ObjectHelper.getDefault(coach, CoachDomain.create());
		}
	}


package co.sdj.sdjgym.entity;

import java.util.UUID;

import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;

public class SessionByCoachEntity extends DomainEntity {

	    private SessionEntity session;
		private CoachEntity coach;
		

		public SessionByCoachEntity() {
			super(UUIDHelper.getDefault());
			setSession(new SessionEntity());
			setCoach(new CoachEntity());
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
		

		public CoachEntity getCoach() {
			return coach;
		}

		public void setCoach(final CoachEntity coach) {
			this.coach = ObjectHelper.getDefault(coach, new CoachEntity());
				
			}
		

}

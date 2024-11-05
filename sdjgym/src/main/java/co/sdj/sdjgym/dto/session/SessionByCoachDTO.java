package co.sdj.sdjgym.dto.session;


import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.dto.DomainDTO;
import co.sdj.sdjgym.dto.coach.CoachDTO;

public class SessionByCoachDTO extends DomainDTO{
	

	
	private SessionDTO session;
	private CoachDTO coach;
	

	public SessionByCoachDTO() {
		super(UUIDHelper.getDefaultAsString());
		setSession(session);
		setCoach(coach);
	 }
		

		public static final SessionByCoachDTO create () {
			return new SessionByCoachDTO();
		}
		
		
		@Override
		public String getId() {
			return super.getId();
		}

		public SessionDTO getSession() {
			return session;
		}

		public SessionByCoachDTO setSession(final SessionDTO session) {
			this.session = ObjectHelper.getDefault(session, SessionDTO.create());
			return this;
		}
	

		public CoachDTO getCoach() {
			return coach;
		}

		public SessionByCoachDTO setCoach(final CoachDTO coach) {
			this.coach = ObjectHelper.getDefault(coach, CoachDTO.create());
			return this;
		}
	

}

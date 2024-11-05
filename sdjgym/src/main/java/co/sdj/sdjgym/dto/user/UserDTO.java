package co.sdj.sdjgym.dto.user;

import co.sdj.sdjgym.dto.PersonDTO;

public class UserDTO extends PersonDTO{
	
	protected UserDTO() {
		super();
	}
	
	public static final UserDTO create() {
		return new UserDTO();
	}
}

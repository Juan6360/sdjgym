package co.sdj.sdjgym.dto.basedata;

import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.dto.DomainDTO;

	
public class SpecialtyDTO extends DomainDTO {
		
		private String name;

		private SpecialtyDTO() {
			super(UUIDHelper.getDefaultAsString());
			setName(TextHelper.EMPTY);
		}
		
		public static final SpecialtyDTO create() {
			return new SpecialtyDTO();
		}

		public String getName() {
			return name;
		}

		public SpecialtyDTO setName(final String name) {
			this.name = TextHelper.applyTrim(name);
			return this;
		}
		
}


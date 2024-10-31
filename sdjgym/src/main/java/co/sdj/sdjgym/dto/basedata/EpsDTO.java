package co.sdj.sdjgym.dto.basedata;

import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.dto.DomainDTO;

public class EpsDTO extends DomainDTO {
		
		private String name;

		private EpsDTO() {
			super(UUIDHelper.getDefaultAsString());
			setName(TextHelper.EMPTY);
		}
		
		public static final EpsDTO create() {
			return new EpsDTO();
		}

		public String getName() {
			return name;
		}

		public EpsDTO setName(final String name) {
			this.name = TextHelper.applyTrim(name);
			return this;
		}
		
}

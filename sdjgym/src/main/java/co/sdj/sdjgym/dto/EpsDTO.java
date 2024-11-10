package co.sdj.sdjgym.dto;

import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;

public class EpsDTO extends DomainDTO {
		
		private String name;

		public EpsDTO() {
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

		public EpsDTO setId(final String id) {
			super.setIdentifier(id);
			return this;
		}
		
		@Override
		public String getId() {
			return super.getId();
		}
		
}

package co.sdj.sdjgym.entity.subscription;

import java.util.UUID;

import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.entity.DomainEntity;

public class SubscriptionTypeEntity extends DomainEntity{
	
	private String name;

	protected SubscriptionTypeEntity(UUID id) {
		super(UUIDHelper.getDefault());
		setName(TextHelper.EMPTY);
	}

	@Override
	protected UUID getId() {
		return super.getId();
	}

	@Override
	protected void setId(UUID id) {
		super.setId(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = TextHelper.applyTrim(name);
	}
	
	
	
}

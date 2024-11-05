package co.sdj.sdjgym.entity.subscription;

import java.text.ParseException;
import java.util.Date;
import java.util.UUID;

import co.sdj.crosscutting.helpers.DateHelper;
import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;
import co.sdj.sdjgym.entity.DomainEntity;

public class SubscriptionTypeFeeEntity extends DomainEntity {
	
	private String fee; //fee es tarifa
	private Date activeSince;
	private String activeUntil;
	private boolean subscriptionState;
	private SubscriptionTypeEntity subscriptionType;

	protected SubscriptionTypeFeeEntity(String activeSince) {
		super(UUIDHelper.getDefault());
		
		setActiveSince(activeSince);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected UUID getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}

	@Override
	protected void setId(UUID id) {
		// TODO Auto-generated method stub
		super.setId(id);
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = TextHelper.applyTrim(fee);
	}

	public Date getActiveSince() {
		return activeSince;
	}

	public void setActiveSince(String activeSince){
		this.activeSince = DateHelper.changeStringToDate(TextHelper.applyTrim(activeSince));
	}

	public String getActiveUntil() {
		return activeUntil;
	}

	public void setActiveUntil(String activeUntil) {
		this.activeUntil = activeUntil;
	}

	public boolean isSubscriptionState() {
		return subscriptionState;
	}

	public void setSubscriptionState(boolean subscriptionState) {
		this.subscriptionState = subscriptionState;
	}

	public SubscriptionTypeEntity getSubscriptionType() {
		return subscriptionType;
	}

	public void setSubscriptionType(SubscriptionTypeEntity subscriptionType) {
		this.subscriptionType = subscriptionType;
	}
	
	
}

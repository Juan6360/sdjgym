package co.sdj.sdjgym.domain;

import java.util.UUID;

import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;


public class SpaceDomain extends Domain {
	
	private String name;
	private BranchDomain branch;
	
	private SpaceDomain(final UUID id,final String name, final BranchDomain branch) {
		super(id);
		setName(name);
		setBranch(branch);
		
	}
	
	public String getName() {
		return name;
	}
	
	public static final SpaceDomain create(final UUID id, final String name, final BranchDomain branch) {
		return new SpaceDomain(id, name, branch);
	}
	
	
	public static final SpaceDomain create() {
		return new SpaceDomain(UUIDHelper.getDefault(), TextHelper.EMPTY, BranchDomain.create());
	}

	private void setName(final String name) {
		this.name = TextHelper.applyTrim(name);
	}

	@Override
	public UUID getId() {
		return super.getId();
	}

	public BranchDomain getBranch() {
		return branch;
	}
	

	private void setBranch(BranchDomain branch) {
		this.branch = ObjectHelper.getDefault(branch, BranchDomain.create());
		
		
	}

}

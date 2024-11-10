package co.sdj.sdjgym.dto;

import co.sdj.crosscutting.helpers.ObjectHelper;
import co.sdj.crosscutting.helpers.TextHelper;
import co.sdj.crosscutting.helpers.UUIDHelper;

public class SpaceDTO extends DomainDTO{	
	
	private String name;
	private BranchDTO branch;
	
	public SpaceDTO() {
		super(UUIDHelper.getDefaultAsString());
		setName(TextHelper.EMPTY);
		setBranch(BranchDTO.create());
	}
	
	public static final SpaceDTO create() {
		return new SpaceDTO();
	}

	public String getName() {
		return name;
	}

	public SpaceDTO setName(final String name) {
		this.name = TextHelper.applyTrim(name);
		return this;
	}
	
	public SpaceDTO setId(final String id) {
		super.setIdentifier(id);
		return this;
	}
	
	@Override
	public String getId() {
		return super.getId();
	}

	public BranchDTO getState() {
		return branch;
	}

	public SpaceDTO setBranch(final BranchDTO branch) {
		this.branch = ObjectHelper.getDefault(branch, BranchDTO.create());
		return this;
	}
	
}

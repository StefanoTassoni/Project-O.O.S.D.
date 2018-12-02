package model;

public class UserGroup {
	
	private Integer fkUser;
	private Integer fkGroup;

	
	public Integer getFkUser() {
		return fkUser;
	}
	public void setFkUser(Integer fkUser) {
		this.fkUser = fkUser;
	}
	public Integer getFkGroup() {
		return fkGroup;
	}
	public void setFkGroup(Integer fkGroup) {
		this.fkGroup = fkGroup;
	}
	
	@Override
	public String toString() {
		return "UserGroup [fk_user=" + fkUser + ", fk_group=" + fkGroup + " ]";
	}
	
}
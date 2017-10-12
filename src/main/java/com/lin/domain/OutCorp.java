package com.lin.domain;

public class OutCorp {

	private Integer	id;
	private String corpCode;
	private Integer healthCompanyId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCorpCode() {
		return corpCode;
	}
	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}
	public Integer getHealthCompanyId() {
		return healthCompanyId;
	}
	public void setHealthCompanyId(Integer healthCompanyId) {
		this.healthCompanyId = healthCompanyId;
	}

	
	@Override
	public String toString() {
		return "OutCorp [id=" + id + ", corpCode=\'" + corpCode
				+ "\', healthCompanyId=" + healthCompanyId 
				+ "]";
	}
	
}

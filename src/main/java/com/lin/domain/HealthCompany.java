package com.lin.domain;

public class HealthCompany {
	private Integer id;
	private String name;
	private Integer companyType;
	private String corpId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCompanyType() {
		return companyType;
	}
	public void setCompanyType(Integer companyType) {
		this.companyType = companyType;
	}
	public String getCorpId() {
		return corpId;
	}
	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}
	
	@Override
	public String toString(){
		return "HealthCompany [id=" + id + ", name=\'" + name
				+ "\', companyType=" + companyType + ",corpId=\'" + corpId 
				+ "\']";
	}
	
}

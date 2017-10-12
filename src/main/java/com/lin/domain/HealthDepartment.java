package com.lin.domain;

public class HealthDepartment {

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHeadImg() {
		return headImg;
	}
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	public String getBgImg() {
		return bgImg;
	}
	public void setBgImg(String bgImg) {
		this.bgImg = bgImg;
	}
	public String getOutDeptId() {
		return outDeptId;
	}
	public void setOutDeptId(String outDeptId) {
		this.outDeptId = outDeptId;
	}
	
	private Integer id;
	private Integer companyId;
	private String name;
	private String headImg;
	private String bgImg;
	private String outDeptId;
	
	@Override
	public String toString(){
		return "HealthCompany [id=" + id + ", name=\'" + name
				+ "\', companyId=" + companyId + ",headImg=\'" + headImg + ",bgImg=\'" + bgImg+ ",outDeptId=\'" + outDeptId
				+ "\']";
	}
	
}

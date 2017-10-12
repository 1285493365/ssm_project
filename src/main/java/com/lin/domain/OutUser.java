package com.lin.domain;

public class OutUser {
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOutUserCode() {
		return outUserCode;
	}
	public void setOutUserCode(String outUserCode) {
		this.outUserCode = outUserCode;
	}
	public Integer getOutDeptmentId() {
		return outDeptmentId;
	}
	public void setOutDeptmentId(Integer outDeptmentId) {
		this.outDeptmentId = outDeptmentId;
	}
	public String getCorpId() {
		return corpId;
	}
	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}
	private String outUserCode;
	private Integer outDeptmentId;
	private String corpId;
	
	@Override
	public String toString() {
		return "OutUser [id=" + id + ", outUserCode=\'" + outUserCode
				+ "\', outDeptmentId=" + outDeptmentId + ",corpId=\'" + corpId 
				+ "\']";
	}
	
}

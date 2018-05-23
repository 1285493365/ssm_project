package com.lin.domain;

public class HealthUser {
	private Integer id;
	private String uname;
	private String pwd;
	private String tel;
	private String headImg;
	private String lastLoginIp;
	private String lastLoginTime;
	private String expireTime;
	private Integer departmentId;
	private Integer isDelete;
	private String outDepartmentIds;
	private String staffId;
	
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public String getOutDepartmentIds() {
		return outDepartmentIds;
	}
	public void setOutDepartmentIds(String outDepartmentIds) {
		this.outDepartmentIds = outDepartmentIds;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getHeadImg() {
		return headImg;
	}
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	public String getLastLoginIp() {
		return lastLoginIp;
	}
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	public String getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public String getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(String expireTime) {
		this.expireTime = expireTime;
	}
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public String toString(){
		return "HealthCompany [id=" + id 
				+ ",uname=\'" + uname + "\'"
				+ ",pwd=\'" + pwd + "\'"
				+ ",tel=\'" + tel + "\'" 
				+ ", headImg=\'" + headImg + "\'"
				+ ", lastLoginIp=\'" + lastLoginIp + "\'"
				+ ", lastLoginTime=\'" + lastLoginTime + "\'"
				+ ", expireTime=\'" + expireTime + "\'"
				+ ", expireTime=\'" + expireTime + "\'"
				+ ", departmentId=" + departmentId 
				+ ", isDelete=" + isDelete
				+ ", staffId=\'" + staffId + "\'"
				+ "]";
	}
	
}

package com.lin.dao;
import com.lin.domain.HealthCompany;
public interface HealthCompanyDao {
	public HealthCompany selectHealthCompanyById(Integer id);
	public HealthCompany selectHealthCompanyByCorpId(String corpId);
	public void saveOrUpdateHealthCompany(HealthCompany healthCompany);
}

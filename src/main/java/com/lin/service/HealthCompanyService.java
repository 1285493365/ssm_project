package com.lin.service;
import com.lin.domain.HealthCompany;
import org.springframework.stereotype.Service;

public interface HealthCompanyService {
	HealthCompany selectHealthCompanyById(Integer id);
	HealthCompany selectHealthCompanyByCorpId(String corpId);
	void saveOrUpdateHealthCompany(HealthCompany healthCompany);
}

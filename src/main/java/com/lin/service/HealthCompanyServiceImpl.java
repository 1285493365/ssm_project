package com.lin.service;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.lin.domain.HealthCompany;
import com.lin.dao.HealthCompanyDao;

@Service
public class HealthCompanyServiceImpl implements HealthCompanyService {

	@Resource
	private HealthCompanyDao healthCompanyDao;
	@Override
	public HealthCompany selectHealthCompanyById(Integer id) {
		// TODO Auto-generated method stub
		
		return healthCompanyDao.selectHealthCompanyById(id);
	}

	@Override
	public void saveOrUpdateHealthCompany(HealthCompany healthCompany) {
		// TODO Auto-generated method stub
		healthCompanyDao.saveOrUpdateHealthCompany(healthCompany);
	}
	
	@Override
	public HealthCompany selectHealthCompanyByCorpId(String corpId){
		return healthCompanyDao.selectHealthCompanyByCorpId(corpId);
	}

}

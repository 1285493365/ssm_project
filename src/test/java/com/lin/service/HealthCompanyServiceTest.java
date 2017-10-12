package com.lin.service;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.lin.baseTest.SpringTestCase;
import com.lin.domain.HealthCompany;

public class HealthCompanyServiceTest extends SpringTestCase{
	@Resource
	private HealthCompanyService HealthCompanyService;
	Logger logger = Logger.getLogger(HealthCompanyServiceTest.class);
	
	@Test
	public void selectOutCorpById(){
		HealthCompany healthCompany = HealthCompanyService.selectHealthCompanyById(1);
		logger.debug("查询结果" + healthCompany);
		
	}
	
	@Test
	public void selectOutCorpByCorpId(){
		HealthCompany healthCompany = HealthCompanyService.selectHealthCompanyByCorpId("compxxx");
		logger.debug("查询结果" + healthCompany);
		
	}
	
	@Test
	public void saveOrUpdateHealthCompany(){
		HealthCompany healthCompany = new HealthCompany();
		healthCompany.setName("test corp 2");
		healthCompany.setCompanyType(1);
		healthCompany.setCorpId("XXX corp");
		HealthCompanyService.saveOrUpdateHealthCompany(healthCompany);
		logger.debug("插入结果" + healthCompany);
	}
	
}

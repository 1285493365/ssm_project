package com.lin.service;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.lin.baseTest.SpringTestCase;
import com.lin.domain.OutCorp;

public class OutCorpServiceTest  extends SpringTestCase{
	@Resource
	private OutCorpService outCorpService;
	Logger logger = Logger.getLogger(OutCorpServiceTest.class);
	
	@Test
	public void selectOutCorpByIdTest(){
		OutCorp outCorp = outCorpService.selectOutCorpById(1);
        logger.debug("查找结果" + outCorp);
	}
	
	@Test
	public void saveOrUpdateOutCorpTest(){
		OutCorp outCorp = new OutCorp();
		outCorp.setCorpCode("AAA");
		outCorp.setHealthCompanyId(23);
		outCorpService.saveOrUpdateOutCorp(outCorp);
		logger.debug("插入结果" + outCorp);
	}
	
}

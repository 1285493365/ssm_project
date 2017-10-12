package com.lin.service;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.lin.baseTest.SpringTestCase;
import com.lin.domain.OutUser;
public class OutUserServiceTest extends SpringTestCase {
	@Resource
	private OutUserService outUserService;
	Logger logger = Logger.getLogger(OutUserServiceTest.class);
	
	@Test
	public void saveOrUpdateOutUser() {
		OutUser outUser= new OutUser();
		outUser.setOutUserCode("XXX");
		outUser.setOutDeptmentId(12);
		outUser.setCorpId("YYY");
		outUserService.saveOrUpdateOutUser(outUser);
		logger.debug("插入结果" + outUser);
		
		
		
	}
}

package com.lin.service;
import com.lin.domain.*;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.lin.baseTest.SpringTestCase;

public class HealthUserServiceTest extends SpringTestCase {
	
	Logger logger = Logger.getLogger(HealthUserServiceTest.class);
	
	@Resource
	HealthUserService healthUserService;
	
	@Test
	public void selectHealthUserById(){
		HealthUser h =  healthUserService.selectHealthUserById(1);
		logger.debug("查询结果" + h);
	}
	
	@Test
	public void saveOrUpdateHealthUser(){
		HealthUser healthUser = new HealthUser();
		healthUser.setUname("测试");
		healthUser.setPwd("e10adc3949ba59abbe56e057f20f883e");
		healthUser.setTel("18721978589");
		healthUser.setDepartmentId(1);
		healthUser.setIsDelete(0);
		healthUser.setOutDepartmentIds("[1,2]");
		healthUser.setStaffId("02393");
		healthUserService.saveOrUpdateHealthUser(healthUser);
		logger.debug("插入结果：" + healthUser);
	}
}

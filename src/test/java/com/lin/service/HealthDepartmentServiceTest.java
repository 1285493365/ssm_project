package com.lin.service;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.lin.baseTest.SpringTestCase;
import com.lin.domain.HealthDepartment;
public class HealthDepartmentServiceTest extends SpringTestCase {
	@Resource
	private HealthDepartmentService healthDepartmentService;
	Logger logger = Logger.getLogger(HealthDepartmentServiceTest.class);
	
	@Test
	public void selectHealthDepartmentById(){
		HealthDepartment healthDepartment = healthDepartmentService.selectHealthDepartmentById(1);
		logger.debug("查询结果" + healthDepartment);
		
	}
	
	@Test
	public void selectHealthDepartmentByOutDeptId(){
		HealthDepartment healthDepartment = healthDepartmentService.selectHealthDepartmentByOutDeptId("XXX");
		logger.debug("查询结果 2 " + healthDepartment);
		
	}
	
	@Test
	public void saveOrUpdateHealthDepartment(){
		HealthDepartment healthDepartment = new HealthDepartment();
		healthDepartment.setCompanyId(1);
		healthDepartment.setName("X");
		healthDepartment.setHeadImg("/1/1.jpg");
		healthDepartment.setBgImg("/1/1.jpg");
		healthDepartment.setOutDeptId("XXX");
		//healthDepartmentService.saveOrUpdateHealthDepartment(healthDepartment);
		logger.debug("插入结果" + healthDepartment);
	}
}

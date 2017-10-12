package com.lin.service;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.lin.baseTest.SpringTestCase;
import com.lin.domain.User;

/**
 * 功能概要：UserService单元测试
 */
public class UserServiceTest extends SpringTestCase	{
	@Resource
	private UserService userService;
	Logger logger = Logger.getLogger(UserServiceTest.class);
	
	@Test
	public void selectUserByIdTest(){
		User user = userService.selectUserById(11);
        logger.debug("查找结果" + user);
	}
	

}

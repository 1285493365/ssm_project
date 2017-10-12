package com.lin.service;
import javax.annotation.Resource;
import javax.annotation.Resources;
import org.springframework.stereotype.Service;

import com.lin.dao.*;
import com.lin.domain.*;

@Service
public class HealthUserServiceImpl implements  HealthUserService{
	
	@Resource
	private HealthUserDao healthUserDao;
	
	@Override
	public HealthUser selectHealthUserById(Integer id) {
		return healthUserDao.selectHealthUserById(id);
		
	}

	@Override
	public void saveOrUpdateHealthUser(HealthUser healthUser) {
		healthUserDao.saveOrUpdateHealthUser(healthUser);
		
	}
	
}

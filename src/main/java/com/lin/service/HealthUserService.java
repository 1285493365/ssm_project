package com.lin.service;
import com.lin.domain.HealthUser;


public interface HealthUserService {
	public HealthUser selectHealthUserById(Integer id);
	public void saveOrUpdateHealthUser(HealthUser healthUser);	
}

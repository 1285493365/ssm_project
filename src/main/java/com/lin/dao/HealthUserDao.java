package com.lin.dao;
import com.lin.domain.HealthUser;

public interface HealthUserDao {
	public HealthUser selectHealthUserById(Integer id);
	public void saveOrUpdateHealthUser(HealthUser healthUser);
}

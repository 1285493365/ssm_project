package com.lin.dao;
import com.lin.domain.HealthDepartment;
public interface HealthDepartmentDao {
	public HealthDepartment selectHealthDepartmentById(Integer id);
	public HealthDepartment selectHealthDepartmentByOutDeptId(String outDeptId);
	public void saveOrUpdateHealthDepartment(HealthDepartment healthDepartment);
}

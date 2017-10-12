package com.lin.service;
import com.lin.domain.HealthDepartment;
import org.springframework.stereotype.Service;
public interface HealthDepartmentService {
	public HealthDepartment selectHealthDepartmentById(Integer id);
	public HealthDepartment selectHealthDepartmentByOutDeptId(String outDeptId);
	public void saveOrUpdateHealthDepartment(HealthDepartment healthDepartment);
}

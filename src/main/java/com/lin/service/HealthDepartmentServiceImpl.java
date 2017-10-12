package com.lin.service;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.lin.domain.HealthDepartment;
import com.lin.dao.HealthDepartmentDao;
@Service
public class HealthDepartmentServiceImpl implements HealthDepartmentService {

	@Resource
	private HealthDepartmentDao healthDepartmentDao;
	
	@Override
	public HealthDepartment selectHealthDepartmentById(Integer id) {
		return healthDepartmentDao.selectHealthDepartmentById(id);
	}
	@Override
	public HealthDepartment selectHealthDepartmentByOutDeptId(String outDeptId){
		return healthDepartmentDao.selectHealthDepartmentByOutDeptId(outDeptId);
	}

	@Override
	public void saveOrUpdateHealthDepartment(HealthDepartment healthDepartment) {
		healthDepartmentDao.saveOrUpdateHealthDepartment(healthDepartment);
	}

}

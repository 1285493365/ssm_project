package com.lin.controller;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.lin.domain.*;
import com.lin.service.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.ArrayList;
@Controller
public class SystemController {
	
	private static final Logger    logger = LoggerFactory.getLogger(SystemController.class);
	
	@Resource
	private OutCorpService outCorpService;
	@Resource
	private OutUserService outUserService;
	
	@Resource 
	private HealthCompanyService healthCompanyService;
	
	@Resource
	private HealthDepartmentService healthDepartmentService;
	
	@Resource
	private HealthUserService healthUserService;	
	@RequestMapping("/outcorp") 
	@ResponseBody
	public String getOutCorp(){
		OutCorp outCorp = outCorpService.selectOutCorpById(1);
		return "OutCorp is : " + outCorp;
	}
	
	@RequestMapping("/adduser") 
	@ResponseBody
	public String addUser(@RequestBody String  str_json){
		System.err.println(str_json);
		JSONObject callbackMsgJson = JSONObject.parseObject(str_json);
		String userId = callbackMsgJson.getString("userId");
		String department = callbackMsgJson.getString("department");
		String uname = callbackMsgJson.getString("name");
		String tel = callbackMsgJson.getString("tel");
		String outDeptId = "-1";
		
		
		List<String> listUsers = JSON.parseObject(userId,ArrayList.class);
		if(listUsers!=null)
			userId = listUsers.get(0);
		
		List<Integer> listDepartment = JSON.parseObject(department,ArrayList.class);
		if(listDepartment!=null)
			outDeptId = listDepartment.get(0).toString();
		HealthDepartment healthDepartment = healthDepartmentService.selectHealthDepartmentByOutDeptId(outDeptId);
		
		//写入数据到health_user
		HealthUser healthUser = new HealthUser();
		healthUser.setUname(uname.substring(1,uname.length()-1));
		healthUser.setPwd("e10adc3949ba59abbe56e057f20f883e");
		healthUser.setTel(tel);
		healthUser.setDepartmentId(healthDepartment.getId());
		healthUser.setIsDelete(0);
		healthUser.setOutDepartmentIds(department);
		healthUser.setStaffId(userId);
		healthUserService.saveOrUpdateHealthUser(healthUser);		
		return JSON.toJSONString(healthUser);
	}
	
	@RequestMapping("/adduserList") 
	@ResponseBody
	public String addUserList(@RequestBody String  str_json){
		JSONObject callbackMsgJson = JSONObject.parseObject(str_json);
		logger.debug("ssm_project addUser List input :" + str_json);
		String corpId =callbackMsgJson.getString("CorpId");
		String userIds =callbackMsgJson.getString("StaffVOList");
		List<String> listUser = JSON.parseObject(userIds,ArrayList.class);
		String rtn_str= "";
		if(listUser!=null)
		{
			for(Object item : listUser){
				try{
					JSONObject user_json = JSONObject.parseObject(item.toString());
					String staff_id =user_json.getString("staffId");
					String uname =user_json.getString("name");
					String tel = callbackMsgJson.getString("tel");
					String out_department_ids = user_json.getString("department");
					JSONArray out_department_arr =user_json.getJSONArray("department");
					//根据部门ID，取部门信息
					HealthDepartment healthDepartment = healthDepartmentService.selectHealthDepartmentByOutDeptId(out_department_arr.getString(0));
					if(healthDepartment!=null){
						//写入数据到health_user
						HealthUser healthUser = new HealthUser();
						healthUser.setUname(uname);
						healthUser.setPwd("e10adc3949ba59abbe56e057f20f883e");
						healthUser.setTel(tel);
						healthUser.setDepartmentId(healthDepartment.getId());
						healthUser.setIsDelete(0);
						healthUser.setOutDepartmentIds(out_department_ids);
						healthUser.setStaffId(staff_id);
						healthUserService.saveOrUpdateHealthUser(healthUser);		
						rtn_str += healthUser.getId() + ",";
					}
				}
				catch(Exception ex){
					logger.error(ex.toString());
				}
				
				
			}
		}
		return rtn_str;
	}
	
	
	@RequestMapping("/createcorp") 
	@ResponseBody
	public String createCorp(@RequestBody String  str_json){
		JSONObject callbackMsgJson = JSONObject.parseObject(str_json);
		HealthCompany healthCompany = new HealthCompany();
		healthCompany.setName(callbackMsgJson.getString("CorpName"));
		healthCompany.setCompanyType(1);
		healthCompany.setCorpId(callbackMsgJson.getString("CorpId"));
		healthCompanyService.saveOrUpdateHealthCompany(healthCompany);
		return JSON.toJSONString(healthCompany);
	}
	
	@RequestMapping("/adddept") 
	@ResponseBody	
	public String CreateDept(@RequestBody String  str_json){
		logger.debug("ssm_project CreateDept input :" + str_json);
		JSONObject callbackMsgJson = JSONObject.parseObject(str_json);
		String corpId =callbackMsgJson.getString("CorpId");
		String deptId= callbackMsgJson.getString("DeptId");
		String deptName = callbackMsgJson.getString("DeptName");

		HealthCompany healthCompany = healthCompanyService.selectHealthCompanyByCorpId(corpId);
		if(healthCompany!=null){
			HealthDepartment healthDepartment = new HealthDepartment();
			healthDepartment.setCompanyId(healthCompany.getId());
			healthDepartment.setName(deptName);
			healthDepartment.setOutDeptId(deptId);
			healthDepartmentService.saveOrUpdateHealthDepartment(healthDepartment);
			return JSON.toJSONString(healthDepartment);
		}
		return "error:HealthCompany is null";
	}
	
	@RequestMapping("/adddeptList") 
	@ResponseBody	
	public String CreateDeptList(@RequestBody String  str_json){
		JSONObject callbackMsgJson = JSONObject.parseObject(str_json);
		logger.debug("ssm_project adddeptList input :" + str_json);
		String corpId =callbackMsgJson.getString("CorpId");
		String deptIds =callbackMsgJson.getString("DeptIds");
		List<String> listDept = JSON.parseObject(deptIds,ArrayList.class);
		HealthCompany healthCompany = healthCompanyService.selectHealthCompanyByCorpId(corpId);
		String rtn_str = "";
		if(healthCompany!=null&&listDept!=null){
			for(Object dept : listDept){
				try{
					JSONObject dept_json = JSONObject.parseObject(dept.toString());
					String deptId =dept_json.getString("id");
					String name =dept_json.getString("name");
					String parentid =dept_json.getString("parentid");
					logger.debug("deptId one:" +  dept_json);
					HealthDepartment healthDepartment = new HealthDepartment();
					//读取是否有相同的部门存在，若存在，则执行更新操作
					HealthDepartment hd = healthDepartmentService.selectHealthDepartmentByOutDeptId(deptId);
					if(hd!=null){
						healthDepartment.setId(hd.getId());
					}
					healthDepartment.setCompanyId(healthCompany.getId());
					healthDepartment.setName(name);
					healthDepartment.setOutDeptId(deptId);
					healthDepartmentService.saveOrUpdateHealthDepartment(healthDepartment);
					rtn_str += deptId + ",";
				}
				catch(Exception ex){
					logger.error(ex.toString());
				}
				
				
			}
		}
//		String corpId =callbackMsgJson.getString("CorpId");
//		String deptId= callbackMsgJson.getString("DeptId");
//		if(deptId.indexOf('[')>-1)
//			deptId = deptId.substring(1,deptId.length()-1);
//		System.err.println("corpId:" + corpId);
//		System.err.println("deptId:" + deptId);
//		HealthCompany healthCompany = healthCompanyService.selectHealthCompanyByCorpId(corpId);
//		if(healthCompany!=null){
//			HealthDepartment healthDepartment = new HealthDepartment();
//			healthDepartment.setCompanyId(healthCompany.getId());
//			healthDepartment.setName(deptId);
//			healthDepartment.setOutDeptId(deptId);
//			healthDepartmentService.saveOrUpdateHealthDepartment(healthDepartment);
//			return JSON.toJSONString(healthDepartment);
//		}
//		return "error:HealthCompany is null";
		return rtn_str;
	}

}

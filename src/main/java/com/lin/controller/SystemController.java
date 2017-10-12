package com.lin.controller;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.lin.domain.*;
import com.lin.service.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.List;
import java.util.ArrayList;
@Controller
public class SystemController {
	@Resource
	private UserService userService;
	
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
		healthUser.setTel(tel);
		healthUser.setDepartmentId(healthDepartment.getId());
		healthUser.setIsDelete(0);
		healthUser.setOutDepartmentIds(department);
		healthUserService.saveOrUpdateHealthUser(healthUser);
		
		//传入格式为  ["000000"],需截取
//		if(userId.indexOf('[')>-1)
//			userId = userId.substring(2,userId.length()-2);	
//		String corpId = callbackMsgJson.getString("corpId");
//		OutUser outUser = new OutUser();
//		outUser.setOutUserCode(userId);
//		outUser.setOutDeptmentId(0);
//		outUser.setCorpId(corpId);
//		outUserService.saveOrUpdateOutUser(outUser);
		
		//查询关联表 out_user_health_user 是否有数据，如果有数据，更新health_user表，否则插入数据到到health_user ,插入关联表
		
		
		
		
		
		return JSON.toJSONString(healthUser);
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
		JSONObject callbackMsgJson = JSONObject.parseObject(str_json);
		String corpId =callbackMsgJson.getString("CorpId");
		String deptId= callbackMsgJson.getString("DeptId");
		if(deptId.indexOf('[')>-1)
			deptId = deptId.substring(1,deptId.length()-1);
		System.err.println("corpId:" + corpId);
		System.err.println("deptId:" + deptId);
		HealthCompany healthCompany = healthCompanyService.selectHealthCompanyByCorpId(corpId);
		if(healthCompany!=null){
			HealthDepartment healthDepartment = new HealthDepartment();
			healthDepartment.setCompanyId(healthCompany.getId());
			healthDepartment.setName(deptId);
			healthDepartment.setOutDeptId(deptId);
			healthDepartmentService.saveOrUpdateHealthDepartment(healthDepartment);
			return JSON.toJSONString(healthDepartment);
		}
		return "error:HealthCompany is null";
	}
	
	
}

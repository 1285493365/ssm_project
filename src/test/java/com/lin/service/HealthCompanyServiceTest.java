package com.lin.service;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.lin.baseTest.SpringTestCase;
import com.lin.domain.HealthCompany;
import java.util.List;
import java.util.ArrayList;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public class HealthCompanyServiceTest extends SpringTestCase{
	@Resource
	private HealthCompanyService HealthCompanyService;
	Logger logger = Logger.getLogger(HealthCompanyServiceTest.class);
	
	@Value("${public.corpId}")
	private String token;
	


	//@Test
	public void selectOutCorpById(){
		HealthCompany healthCompany = HealthCompanyService.selectHealthCompanyById(1);
		logger.debug("查询结果" + healthCompany);
		
	}
	
	//@Test
	public void selectOutCorpByCorpId(){
		HealthCompany healthCompany = HealthCompanyService.selectHealthCompanyByCorpId("compxxx");
		logger.debug("查询结果" + healthCompany);
		
	}
	
	@Test
	public void saveOrUpdateHealthCompany(){
		HealthCompany healthCompany = new HealthCompany();
		healthCompany.setName("test corp 2");
		healthCompany.setCompanyType(1);
		healthCompany.setCorpId("XXX corp");
		HealthCompanyService.saveOrUpdateHealthCompany(healthCompany);
		logger.debug("插入结果" + healthCompany);
	}
	
	@Test
	public void toJsonTest(){
		//String json_str = "{\"DeptIds\":\"[{\"User\":true,\"Id\":1},{\"User\":true,\"Id\":2}]\",\"CorpId\":\"1231231\"}";
		String json_str = "{\"DeptIds\":\"[{'id':123,'name':'bob'},{'id':111,'name':'joe'}]\",\"CorpId\":\"1231231\"}";
		JSONObject callbackMsgJson = JSONObject.parseObject(json_str);
		String deptIds =callbackMsgJson.getString("DeptIds");
		logger.debug("deptIds:" + deptIds);
		List<String> listDept = JSON.parseObject(deptIds,ArrayList.class);
		for(Object dept : listDept){
			JSONObject dept_json = JSONObject.parseObject(dept.toString());
			String id =dept_json.getString("id");
			String name =dept_json.getString("name");
			logger.debug("deptId one:" + id + " " + name);
			
			//部门写入数据库操作
			
		}
			//logger.debug("deptId one:" + tem.toString());
		//JSONObject deptJson = JSONObject.parseObject(deptIds);
		//logger.debug("deptId one:" + listUsers.get(0));
		
	}
	
	@Test
	public void stringToArrayTest(){
		
		logger.debug("token: " + token);
//		String temp = "{\"userName\":123,\"Array\":[123,33]}";
//		
//		JSONObject user_json = JSONObject.parseObject(temp);
//		JSONArray arr = user_json.getJSONArray("Array");
//		for(int i=0;i<arr.size();i++){
//			logger.debug(arr.getString(i) + " - ");
//		}
		
	}
	
	
	
}

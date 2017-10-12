package com.lin.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.lin.domain.User;
import com.lin.service.UserService;

/**
 * 功能概要：UserController 
 */
@Controller
public class UserController {
	@Resource
	private UserService userService;
	
	@RequestMapping("/")  
    public ModelAndView getIndex(){    
		ModelAndView mav = new ModelAndView("index"); 
		User user = userService.selectUserById(11);
	    mav.addObject("user", user); 
	    if(user!=null)
	    	System.err.println(user.toString());
	    else
	    	System.err.println("user为空");	    	
        return mav;  
    } 
	
	@RequestMapping("/user") 
	@ResponseBody
	public String user(@RequestBody String  userId){
		return "userId is"  + userId;
	}
	
	
}

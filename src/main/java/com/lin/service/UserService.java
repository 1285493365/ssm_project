package com.lin.service;

import org.springframework.stereotype.Service;

import com.lin.domain.User;

/**
 * 功能概要：UserService接口类

 */
public interface UserService {
	User selectUserById(Integer userId);

}

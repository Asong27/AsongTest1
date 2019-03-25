package com.idea.spring.test.springtest.service;

import com.idea.spring.test.springtest.common.PageInfoTest;
import com.idea.spring.test.springtest.pojo.User;


public interface UserService {
	
	public User selectUserById(Integer id);
	
	public void deleteUserById(Integer id);
	
	public void updateUser(User user);
	
	public void insertUser(User user);
	
	public PageInfoTest getPage(Integer pageNo, Integer size);
}

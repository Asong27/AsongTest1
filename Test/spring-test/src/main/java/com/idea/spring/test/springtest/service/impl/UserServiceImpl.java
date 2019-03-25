package com.idea.spring.test.springtest.service.impl;

import java.util.List;

import com.idea.spring.test.springtest.common.PageInfoTest;
import com.idea.spring.test.springtest.mapper.UserMapper;
import com.idea.spring.test.springtest.pojo.User;
import com.idea.spring.test.springtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	
	
	@Override
	public User selectUserById(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public void deleteUserById(Integer id) {
		userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void updateUser(User user) {
		userMapper.updateByPrimaryKey(user);
	}

	@Override
	public void insertUser(User user) {
		userMapper.insert(user);
	}

	@Override
	public PageInfoTest getPage(Integer pageNo, Integer size) {
		PageHelper.startPage(pageNo,size);
		List<User> list = userMapper.selectByExample(null);
		PageInfo<User> info = new PageInfo<>(list);
		PageInfoTest page = new PageInfoTest();
		page.setList(list);
		page.setPageCount(info.getPageNum());
		page.setPageSize(size);
		page.setRows(info.getTotal());
		
		return page;
	}

}

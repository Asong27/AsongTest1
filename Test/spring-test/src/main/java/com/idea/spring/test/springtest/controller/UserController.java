package com.idea.spring.test.springtest.controller;

import com.idea.spring.test.springtest.common.PageInfoTest;
import com.idea.spring.test.springtest.service.UserService;
import com.idea.spring.test.springtest.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/test")
	public String test(){
		return "HELLO WORLD";
	}
	
	
	@RequestMapping("/find/{id}")
	public User findUserById(@PathVariable("id")Integer id){
		return userService.selectUserById(id);
	}
	
	
	@RequestMapping("/delete/{id}")
	public String deleteUserById(@PathVariable("id")Integer id){
		try {
			userService.deleteUserById(id);
			return "DELETE_SUCCESS";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "DELETE_FAIL";
	}
	
	@RequestMapping("/insert")
	public String insertUser(User user){
		try {
			userService.insertUser(user);
			return "INSERT_SUCCESS";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "INSERT_FAIL";
	}
	
	@RequestMapping("/update")
	public String updateUser(User user){
		try {
			userService.updateUser(user);
			return "UPDATE_SUCCESS";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "UPDATE_FAIL";
	}
	
	
	@RequestMapping("/page")
	public PageInfoTest findPage(@RequestParam(name="pageNo",defaultValue="1")Integer pageNo,
								 @RequestParam(name="size",defaultValue="5")Integer size){
		
		return userService.getPage(pageNo, size);
	}
	
	
	
	
	
	
	
	
	
	
	
}

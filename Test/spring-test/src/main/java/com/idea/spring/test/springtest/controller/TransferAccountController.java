package com.idea.spring.test.springtest.controller;

import com.idea.spring.test.springtest.service.TransferAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/account")
public class TransferAccountController {
	
	@Autowired
	private TransferAccountService transferService;
	@RequestMapping("/transfer")
	public String transferAccount(Integer inId,Integer outId,Integer money){
		
		try {
			transferService.transferAccount(inId, outId, money);
			return "TRANSFER_ACCOUNT_SUCCESS";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "TRANSFER_ACCOUNT_FAIL";
	}
	
	
}

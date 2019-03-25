package com.idea.spring.test.springtest.service;

public interface TransferAccountService {
	
	
	public void transferAccount(Integer inId, Integer outId, Integer money);
	
	public void transferIn(Integer uId, Integer money);
	
	public void transferOut(Integer uId, Integer money);
	
}

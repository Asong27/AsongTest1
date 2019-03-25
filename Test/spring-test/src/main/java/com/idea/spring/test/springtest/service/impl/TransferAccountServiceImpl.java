package com.idea.spring.test.springtest.service.impl;

import com.idea.spring.test.springtest.mapper.AccountMapper;
import com.idea.spring.test.springtest.pojo.Account;
import com.idea.spring.test.springtest.pojo.AccountExample;
import com.idea.spring.test.springtest.pojo.AccountExample.Criteria;
import com.idea.spring.test.springtest.service.TransferAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class TransferAccountServiceImpl implements TransferAccountService {

	@Autowired
	private AccountMapper accountMapper;
	
	@Override
	@Transactional
	public void transferAccount(Integer inId, Integer outId, Integer money) {
		transferIn(inId, money);
		int a = 1/0;
		transferOut(outId, money);

	}
	@Override
	public void transferIn(Integer uId, Integer money) {

		Account accountIn = findAccountByUid(uId);
		accountIn.setMoney(accountIn.getMoney()+money);
		accountMapper.updateByPrimaryKey(accountIn);
		
		
		
	}
	@Override
	public void transferOut(Integer uId, Integer money) {
		Account accountOut = findAccountByUid(uId);
		accountOut.setMoney(accountOut.getMoney()-money);
		accountMapper.updateByPrimaryKey(accountOut);
	}

	private Account findAccountByUid(Integer uId){
		AccountExample example = new AccountExample();
		Criteria criteria = example.createCriteria();
		criteria.andUidEqualTo(uId);
		Account account = accountMapper.selectByExample(example).get(0);
		return account;
	}

}

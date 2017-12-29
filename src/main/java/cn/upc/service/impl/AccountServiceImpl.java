package cn.upc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.upc.mapper.AccountMapper;
import cn.upc.pojo.Account;
import cn.upc.pojo.AccountExample;
import cn.upc.pojo.AccountExample.Criteria;
import cn.upc.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountMapper accountMapper;
	
	public Account findAccountByNameAndPwd(Account account) {
		AccountExample example = new AccountExample();
		Criteria criteria = example.createCriteria();
		criteria.andPasswordEqualTo(account.getPassword());
		criteria.andUnameEqualTo(account.getUname());
		List<Account> resList = accountMapper.selectByExample(example );
		if(resList != null && resList.size() > 0) {
			return resList.get(0);
		}
		return null;
	}

	public void updateAccountPwd(Account acc) {
		accountMapper.updateByPrimaryKey(acc);
	}

	
}

package cn.upc.service;

import cn.upc.pojo.Account;

public interface AccountService {

	public Account findAccountByNameAndPwd(Account account);

	public void updateAccountPwd(Account acc);
	
}

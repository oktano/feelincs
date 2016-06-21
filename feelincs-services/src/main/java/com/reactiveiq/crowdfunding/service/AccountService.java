package com.reactiveiq.crowdfunding.service;

import java.util.List;

import com.reactiveiq.crowdfunding.domain.Account;
import com.reactiveiq.crowdfunding.domain.UserRole;

public interface AccountService extends PersistenceService<Account> {
	

	public Account getAccountByUserName(String userName);
	
	public List<UserRole>getUserRoles(Long accountId);
	
	public boolean isUserNameExist(String userName);
	
	public Long getAccountId(String userName);
	
	public List<Account>search(AccountSearchDto searchDto);
				
	public long getTotalUsers();

}
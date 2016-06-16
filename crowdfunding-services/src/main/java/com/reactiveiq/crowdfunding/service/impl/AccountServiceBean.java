package com.reactiveiq.crowdfunding.service.impl;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import javax.validation.ValidationException;

import com.reactiveiq.crowdfunding.domain.Account;
import com.reactiveiq.crowdfunding.domain.AccountStatus;
import com.reactiveiq.crowdfunding.domain.Role;
import com.reactiveiq.crowdfunding.domain.UserRole;
import com.reactiveiq.crowdfunding.service.AccountSearchDto;
import com.reactiveiq.crowdfunding.service.AccountService;
import com.reactiveiq.crowdfunding.service.BaseService;
import com.reactiveiq.crowdfunding.service.ReferenceDataService;
import com.reactiveiq.crowdfunding.service.ServiceConstants;
import com.reactiveiq.crowdfunding.service.validation.AccountCreationValidation;


@Singleton
@Transactional
public class AccountServiceBean extends BaseService implements AccountService{
	
	@Inject
	private AccountCreationValidation accountCreationValidation;
	
	@Inject
	private ReferenceDataService referenceDataService;
	
	
	public Account getAccountByUserName(String userName) {
		try{
			Account account=getEntityManager().
					createQuery("Select account from Account account " +
						"where account.userName=:userName",Account.class)
										.setParameter("userName", userName)
											.getSingleResult();		
			
			return account;
		}
		catch(NoResultException ex){
			
		}
		return null;
	}	


	public List<UserRole>getUserRoles(Long accountId){
		return getEntityManager().createQuery("Select userRole from UserRole userRole"
				+ " where userRole.account.id=:accountId",UserRole.class)
				.setParameter("accountId", accountId)
				.getResultList();
	}
	
	public Account findById(Long accountId) {
		try{
			return getEntityManager().
					createQuery("Select account from Account account " +
						"where account.id=:accountId",Account.class)
										.setParameter("accountId", accountId)
											.getSingleResult();			
		}
		catch(NoResultException ex){
			
		}
		return null;
	}	
	
	
	/**
	 * Checks if suername exist in database
	 */
	public boolean isUserNameExist(String userName) {
	
		return getAccountByUserName(userName)!=null;
	}


	public Long getAccountId(String userName) {
		
		Account account=getAccountByUserName(userName);	
		if(account!=null){
			return account.getId();
		}
		return null;
	}
		
	public void save(Account account)throws ValidationException {
		
		/*
		 *Update if it is already persisted before 
		 */
		if(account.getId()!=null){
			update(account);
			return;
		}
		accountCreationValidation.validate(account);
		
		if(isUserNameExist(account.getUserName())){
			throw new ValidationException("validation.account.usernamealreadyexists"); 
		}
		
		/*
		 * Add User Role
		 */
		List<Role>roles=referenceDataService.getRoles();
		for(Role role:roles){
			if(role.getRoleName().equals(ServiceConstants.ROLE_USER)){
				UserRole userRole=new UserRole();
				userRole.setRole(role);
				userRole.setAccount(account);
				account.getCurrentRoles().add(userRole);
				
			}
		}
				
				
		
		AccountStatus accountStatus=new AccountStatus();
		accountStatus.setAccountEnabled(false);	
		account.setAccountStatus(accountStatus);
		account.setRegistrationDate(Calendar.getInstance().getTime());
		account.setComfirmationCode(UUID.randomUUID().toString());

		getEntityManager().persist(account);
		
	}
	

	private void update(Account account) throws ValidationException {
		
		account.setModifiedDate(Calendar.getInstance().getTime());		
		getEntityManager().merge(account);
	}

	

	public List<Account> search(AccountSearchDto searchDto) {
	
		return null;
	}


	
	/*  Return Total Registered Users
	 * (non-Javadoc)
	 * @see com.reactiveiq.crowdfunding.service.AccountService#getTotalUsers()
	 */
	public long getTotalUsers() {
		return getEntityManager().
				createQuery("Select count(*)  from Account account ",Long.class)
						.getSingleResult();			
	}
		
}